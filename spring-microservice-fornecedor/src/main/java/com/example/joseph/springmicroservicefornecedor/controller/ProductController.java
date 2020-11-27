package com.example.joseph.springmicroservicefornecedor.controller;

import com.example.joseph.springmicroservicefornecedor.entity.Product;
import com.example.joseph.springmicroservicefornecedor.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private IProductService productService;

  @RequestMapping("/{state}")
  public List<Product> getProductsByState(@PathVariable("state") String state) {
    return productService.getProductsByState(state);
  }
}
