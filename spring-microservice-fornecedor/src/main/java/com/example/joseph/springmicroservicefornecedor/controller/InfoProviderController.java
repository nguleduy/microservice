package com.example.joseph.springmicroservicefornecedor.controller;

import com.example.joseph.springmicroservicefornecedor.entity.InfoProvider;
import com.example.joseph.springmicroservicefornecedor.service.IInfoProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoProviderController {

  @Autowired
  private IInfoProviderService infoProviderService;

  @GetMapping("/{state}")
  public InfoProvider getInfoProviderByState(@PathVariable String state) {
    return this.infoProviderService.getInfoByState(state);
  }
}
