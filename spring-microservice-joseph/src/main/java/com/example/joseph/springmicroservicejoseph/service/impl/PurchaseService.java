package com.example.joseph.springmicroservicejoseph.service.impl;

import com.example.joseph.springmicroservicejoseph.controller.PurchaseController;
import com.example.joseph.springmicroservicejoseph.dto.InfoProviderDTO;
import com.example.joseph.springmicroservicejoseph.dto.PurchaseDTO;
import com.example.joseph.springmicroservicejoseph.service.IPurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PurchaseService implements IPurchaseService {

  private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

  @Autowired
  private RestTemplate client;

  @Override
  public void makePurchase(PurchaseDTO purchaseDTO) {

    ResponseEntity<InfoProviderDTO> exchange = client.exchange("http://fornecedor/info/" + purchaseDTO.getAddress().getState(),
            HttpMethod.GET, null, InfoProviderDTO.class);

    logger.info("Address: " + exchange.getBody().getAddress());

  }
}
