package com.example.joseph.springmicroservicefornecedor.service;

import com.example.joseph.springmicroservicefornecedor.entity.InfoProvider;

public interface IInfoProviderService {

  InfoProvider getInfoByState(String state);
}
