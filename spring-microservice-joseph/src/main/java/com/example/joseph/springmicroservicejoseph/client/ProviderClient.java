package com.example.joseph.springmicroservicejoseph.client;

import com.example.joseph.springmicroservicejoseph.dto.InfoOrderDTO;
import com.example.joseph.springmicroservicejoseph.dto.InfoProviderDTO;
import com.example.joseph.springmicroservicejoseph.dto.PurchaseItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor") //name-id that eureka server
public interface ProviderClient {

  @RequestMapping("/info/{state}")
  InfoProviderDTO getInfoProviderByState(@PathVariable String state);

  @RequestMapping(value = "/order", method = RequestMethod.POST)
  InfoOrderDTO placeOrder(List<PurchaseItemDTO> items);
}
