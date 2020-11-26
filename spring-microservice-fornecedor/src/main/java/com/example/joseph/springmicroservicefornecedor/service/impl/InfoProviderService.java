package com.example.joseph.springmicroservicefornecedor.service.impl;

import com.example.joseph.springmicroservicefornecedor.entity.InfoProvider;
import com.example.joseph.springmicroservicefornecedor.repository.InfoProviderRepository;
import com.example.joseph.springmicroservicefornecedor.service.IInfoProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoProviderService implements IInfoProviderService {

  @Autowired
  private InfoProviderRepository providerRepository;

  @Override
  public InfoProvider getInfoByState(String state) {
    return this.providerRepository.findByState(state);
  }
}
