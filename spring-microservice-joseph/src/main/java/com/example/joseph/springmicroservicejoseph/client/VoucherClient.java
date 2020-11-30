package com.example.joseph.springmicroservicejoseph.client;

import com.example.joseph.springmicroservicejoseph.dto.InfoDeliveryDTO;
import com.example.joseph.springmicroservicejoseph.dto.VoucherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("transportation") //name-id that eureka server
public interface VoucherClient {

  @PostMapping("/delivery")
  public VoucherDTO bookDelivery(@RequestBody InfoDeliveryDTO infoDeliveryDTO);
}
