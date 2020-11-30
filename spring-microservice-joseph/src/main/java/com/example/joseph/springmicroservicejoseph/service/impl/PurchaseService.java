package com.example.joseph.springmicroservicejoseph.service.impl;

import com.example.joseph.springmicroservicejoseph.client.ProviderClient;
import com.example.joseph.springmicroservicejoseph.controller.PurchaseController;
import com.example.joseph.springmicroservicejoseph.dto.InfoOrderDTO;
import com.example.joseph.springmicroservicejoseph.dto.InfoProviderDTO;
import com.example.joseph.springmicroservicejoseph.dto.PurchaseDTO;
import com.example.joseph.springmicroservicejoseph.model.Purchase;
import com.example.joseph.springmicroservicejoseph.service.IPurchaseService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService implements IPurchaseService {

  private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

  @Autowired
  private ProviderClient providerClient;

  @Override
  @HystrixCommand
  public Purchase makePurchase(PurchaseDTO purchaseDTO) {
    final String state = purchaseDTO.getAddress().getState();

    logger.info("seeking information from the {} " + state);
    InfoProviderDTO infoProviderByState = this.providerClient.getInfoProviderByState(state);
    logger.info("placing an order");
    InfoOrderDTO order = this.providerClient.placeOrder(purchaseDTO.getItems());

    Purchase purchaseSave = new Purchase(order.getId(), order.getPreparationTime(), infoProviderByState.getAddress().toString());
    logger.info("Purchase: " + purchaseSave);

    return purchaseSave;
  }
}
