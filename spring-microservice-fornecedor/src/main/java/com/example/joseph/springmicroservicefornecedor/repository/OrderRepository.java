package com.example.joseph.springmicroservicefornecedor.repository;

import com.example.joseph.springmicroservicefornecedor.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
