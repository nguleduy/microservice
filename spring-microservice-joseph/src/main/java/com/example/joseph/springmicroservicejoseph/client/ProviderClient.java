package com.example.joseph.springmicroservicejoseph.client;

import com.example.joseph.springmicroservicejoseph.dto.InfoOrderDTO;
import com.example.joseph.springmicroservicejoseph.dto.InfoProviderDTO;
import com.example.joseph.springmicroservicejoseph.dto.PurchaseItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("fornecedor") //name-id that eureka server
public interface ProviderClient {

  @GetMapping("/info/{state}")
  InfoProviderDTO getInfoProviderByState(@PathVariable String state);

  @PostMapping(value = "/order")
  InfoOrderDTO placeOrder(List<PurchaseItemDTO> items);
}
