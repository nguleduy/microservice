package com.example.joseph.springmicroservicejoseph.client;

import com.example.joseph.springmicroservicejoseph.dto.InfoProviderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("fornecedor") //name-id that eureka server
public interface ProviderClient {

  @RequestMapping("/info/{state}")
  InfoProviderDTO getInfoProviderByState(@PathVariable String state);
}
