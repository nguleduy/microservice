package com.example.joseph.springmicroservicefornecedor.service;

import com.example.joseph.springmicroservicefornecedor.dto.OrderItemDTO;
import com.example.joseph.springmicroservicefornecedor.entity.Order;

import java.util.List;

public interface IOrderService {

  public Order placeOrder(List<OrderItemDTO> items);

  public Order getOrderById(Long id);
}
