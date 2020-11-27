package com.example.joseph.springmicroservicefornecedor.repository;

import com.example.joseph.springmicroservicefornecedor.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

  List<Product> findByState(String state);

  List<Product> findByIdIn(List<Long> ids);
}
