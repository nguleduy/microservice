package com.example.joseph.springmicroservicetransportation.controller;

import com.example.joseph.springmicroservicetransportation.dto.DeliveryDTO;
import com.example.joseph.springmicroservicetransportation.dto.VoucherDTO;
import com.example.joseph.springmicroservicetransportation.service.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

  @Autowired
  private IDeliveryService deliveryService;

  @PostMapping
  public VoucherDTO bookDelivery(@RequestBody DeliveryDTO deliveryDTO) {
    return deliveryService.bookDelivery(deliveryDTO);
  }
}
