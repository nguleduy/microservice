package com.example.joseph.springmicroservicejoseph.service.impl;

import com.example.joseph.springmicroservicejoseph.client.ProviderClient;
import com.example.joseph.springmicroservicejoseph.client.VoucherClient;
import com.example.joseph.springmicroservicejoseph.controller.PurchaseController;
import com.example.joseph.springmicroservicejoseph.dto.InfoDeliveryDTO;
import com.example.joseph.springmicroservicejoseph.dto.InfoOrderDTO;
import com.example.joseph.springmicroservicejoseph.dto.InfoProviderDTO;
import com.example.joseph.springmicroservicejoseph.dto.PurchaseDTO;
import com.example.joseph.springmicroservicejoseph.dto.VoucherDTO;
import com.example.joseph.springmicroservicejoseph.model.Purchase;
import com.example.joseph.springmicroservicejoseph.repository.PurchaseRepository;
import com.example.joseph.springmicroservicejoseph.service.IPurchaseService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PurchaseService implements IPurchaseService {

  private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

  @Autowired
  private ProviderClient providerClient;

  @Autowired
  private VoucherClient voucherClient;

  @Autowired
  private PurchaseRepository purchaseRepository;

  @Override
  @HystrixCommand(threadPoolKey = "findPurchaseByIdThreadPool")
  public Purchase findPurchaseById(Long id) {
    return this.purchaseRepository.findById(id).orElse(new Purchase());
  }

  @Override
  @HystrixCommand(fallbackMethod = "makePurchaseFallback", threadPoolKey = "makePurchaseThreadPool")
  public Purchase makePurchase(PurchaseDTO purchaseDTO) {
    final String state = purchaseDTO.getAddress().getState();

    logger.info("seeking information from the {} " + state);
    InfoProviderDTO infoProviderByState = this.providerClient.getInfoProviderByState(state);

    logger.info("placing an order");
    InfoOrderDTO order = this.providerClient.placeOrder(purchaseDTO.getItems());

    logger.info("generating voucher");
    InfoDeliveryDTO infoDeliveryDTO = new InfoDeliveryDTO(
            order.getId(),
            LocalDate.now().plusDays(order.getPreparationTime()),
            infoProviderByState.getAddress(),
            purchaseDTO.getAddress().toString());

    VoucherDTO voucher = this.voucherClient.bookDelivery(infoDeliveryDTO);

    Purchase purchaseSave = new Purchase(order.getId(), order.getPreparationTime(), infoProviderByState.getAddress().toString(), voucher.getDeliveryForecast(), voucher.getNumber());
    logger.info("Purchase: " + purchaseSave);

    this.purchaseRepository.save(purchaseSave);

    return purchaseSave;
  }

  // Method for Fallback and Circuit Breaker
  public Purchase makePurchaseFallback(PurchaseDTO purchase) {
    Purchase purchaseFallback = new Purchase();
    purchaseFallback.setDestinationAddress(purchase.getAddress().toString());
    return purchaseFallback;
  }
}
