package com.example.joseph.springmicroservicejoseph.controller;

import com.example.joseph.springmicroservicejoseph.dto.PurchaseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/purchase")
public class PurchaseController {

  private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

  @PostMapping
  public void makePurchase(@RequestBody PurchaseDTO purchase) {
    logger.info("Make Purchase");
  }

}
