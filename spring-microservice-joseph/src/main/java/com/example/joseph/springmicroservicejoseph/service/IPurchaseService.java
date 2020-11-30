package com.example.joseph.springmicroservicejoseph.service;

import com.example.joseph.springmicroservicejoseph.dto.PurchaseDTO;
import com.example.joseph.springmicroservicejoseph.model.Purchase;

public interface IPurchaseService {

  public Purchase makePurchase(PurchaseDTO purchaseDTO);

  public Purchase reprocessPurchase(PurchaseDTO purchase);

  public Purchase cancelPurchase(PurchaseDTO purchase);

  public Purchase findPurchaseById(Long id);
}
