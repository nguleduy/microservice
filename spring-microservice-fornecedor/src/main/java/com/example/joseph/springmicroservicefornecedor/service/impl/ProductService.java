package com.example.joseph.springmicroservicefornecedor.service.impl;

import com.example.joseph.springmicroservicefornecedor.entity.Product;
import com.example.joseph.springmicroservicefornecedor.repository.ProductRepository;
import com.example.joseph.springmicroservicefornecedor.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> getProductsByState(String state) {
    return productRepository.findByState(state);
  }
}
