package com.example.joseph.springmicroservicefornecedor.service;

import com.example.joseph.springmicroservicefornecedor.entity.Product;

import java.util.List;

public interface IProductService {

  public List<Product> getProductsByState(String state);
}
