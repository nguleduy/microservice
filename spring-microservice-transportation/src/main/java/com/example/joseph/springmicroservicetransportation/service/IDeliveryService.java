package com.example.joseph.springmicroservicetransportation.service;

import com.example.joseph.springmicroservicetransportation.dto.DeliveryDTO;
import com.example.joseph.springmicroservicetransportation.dto.VoucherDTO;

public interface IDeliveryService {

  public VoucherDTO bookDelivery(DeliveryDTO deliveryDTO);
}
