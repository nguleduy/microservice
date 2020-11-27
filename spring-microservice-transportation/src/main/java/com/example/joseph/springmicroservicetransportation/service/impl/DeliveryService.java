package com.example.joseph.springmicroservicetransportation.service.impl;

import com.example.joseph.springmicroservicetransportation.dto.DeliveryDTO;
import com.example.joseph.springmicroservicetransportation.dto.VoucherDTO;
import com.example.joseph.springmicroservicetransportation.model.Delivery;
import com.example.joseph.springmicroservicetransportation.repository.DeliveryRepository;
import com.example.joseph.springmicroservicetransportation.service.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService implements IDeliveryService {

  @Autowired
  private DeliveryRepository deliveryRepository;

  @Override
  public VoucherDTO bookDelivery(DeliveryDTO deliveryDTO) {
    Delivery delivery = new Delivery();
    delivery.setSearchDate(deliveryDTO.getDeliveryDate());
    delivery.setDeliveryForecast(deliveryDTO.getDeliveryDate().plusDays(1l));
    delivery.setDestinationAddress(deliveryDTO.getDestinationAddress());
    delivery.setOriginAddress(deliveryDTO.getOriginAddress());
    delivery.setOrderId(deliveryDTO.getOrderId());

    deliveryRepository.save(delivery);

    VoucherDTO voucher = new VoucherDTO();
    voucher.setNumber(delivery.getId());
    voucher.setDeliveryForecast(delivery.getDeliveryForecast());
    return voucher;
  }
}
