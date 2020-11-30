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
import com.example.joseph.springmicroservicejoseph.model.enums.PurchaseState;
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

    // Step 0 - New
    Purchase purchaseSave = new Purchase();
    purchaseSave.setState(PurchaseState.RECEIVED);
    purchaseSave.setDestinationAddress(purchaseDTO.getAddress().toString());
    this.purchaseRepository.save(purchaseSave);

    // purchaseId for fallback
    purchaseDTO.setPurchaseId(purchaseSave.getId());

    // Step 1 - Information Fornecedor
    logger.info("seeking information from the {} " + state);
    InfoProviderDTO infoProviderByState = this.providerClient.getInfoProviderByState(state);

    logger.info("placing an order");
    InfoOrderDTO order = this.providerClient.placeOrder(purchaseDTO.getItems());

    purchaseSave.setState(PurchaseState.ORDER_REQUESTED);
    purchaseSave.setOrderId(order.getId());
    purchaseSave.setPreparationTime(order.getPreparationTime());
    this.purchaseRepository.save(purchaseSave);

    // Step 2 - Information Voucher/Delivery
    logger.info("generating voucher");
    InfoDeliveryDTO infoDeliveryDTO = new InfoDeliveryDTO(
            order.getId(),
            LocalDate.now().plusDays(order.getPreparationTime()),
            infoProviderByState.getAddress(),
            purchaseDTO.getAddress().toString());

    VoucherDTO voucher = this.voucherClient.bookDelivery(infoDeliveryDTO);
    purchaseSave.setState(PurchaseState.RESERVE_DELIVERED);
    purchaseSave.setDeliveryDate(voucher.getDeliveryForecast());
    purchaseSave.setVoucher(voucher.getNumber());
    logger.info("Purchase: " + purchaseSave);

    this.purchaseRepository.save(purchaseSave);

    return purchaseSave;
  }

  @Override
  public Purchase reprocessPurchase(PurchaseDTO purchase) {
    return null;
  }

  @Override
  public Purchase cancelPurchase(PurchaseDTO purchase) {
    return null;
  }

  // Method for Fallback and Circuit Breaker
  public Purchase makePurchaseFallback(PurchaseDTO purchase) {
    // Returns purchase with last status captured by fallback
    if (purchase.getPurchaseId() != null) {
      return this.purchaseRepository.findById(purchase.getPurchaseId()).get();
    }
    Purchase purchaseFallback = new Purchase();
    purchaseFallback.setDestinationAddress(purchase.getAddress().toString());
    return purchaseFallback;
  }
}
