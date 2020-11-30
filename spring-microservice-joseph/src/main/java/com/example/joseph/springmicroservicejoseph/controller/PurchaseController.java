package com.example.joseph.springmicroservicejoseph.controller;

import com.example.joseph.springmicroservicejoseph.dto.PurchaseDTO;
import com.example.joseph.springmicroservicejoseph.model.Purchase;
import com.example.joseph.springmicroservicejoseph.service.IPurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {

  private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

  @Autowired
  private IPurchaseService iPurchaseService;

  @GetMapping("/{id}")
  public Purchase getPurchaseById(@PathVariable("id") Long id) {
    return this.iPurchaseService.findPurchaseById(id);
  }

  @PostMapping
  public Purchase makePurchase(@RequestBody PurchaseDTO purchaseDTO) {
    logger.info("Make Purchase");
    return this.iPurchaseService.makePurchase(purchaseDTO);
  }

}
