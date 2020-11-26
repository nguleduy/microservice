package com.example.joseph.springmicroservicejoseph.service.impl;

import com.example.joseph.springmicroservicejoseph.client.ProviderClient;
import com.example.joseph.springmicroservicejoseph.controller.PurchaseController;
import com.example.joseph.springmicroservicejoseph.dto.InfoOrderDTO;
import com.example.joseph.springmicroservicejoseph.dto.InfoProviderDTO;
import com.example.joseph.springmicroservicejoseph.dto.PurchaseDTO;
import com.example.joseph.springmicroservicejoseph.model.Purchase;
import com.example.joseph.springmicroservicejoseph.service.IPurchaseService;
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
  public Purchase makePurchase(PurchaseDTO purchaseDTO) {

    InfoProviderDTO infoProviderByState = this.providerClient.getInfoProviderByState(purchaseDTO.getAddress().getState());
    InfoOrderDTO order = this.providerClient.placeOrder(purchaseDTO.getItems());

    Purchase purchaseSave = new Purchase(order.getId(), order.getPreparationTime(), purchaseDTO.getAddress().toString());
    logger.info("Address: " + infoProviderByState.getAddress());
    logger.info("Purchase: " + purchaseSave);

    return purchaseSave;
  }
}
