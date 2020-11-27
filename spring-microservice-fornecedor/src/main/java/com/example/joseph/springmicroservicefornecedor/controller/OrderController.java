package com.example.joseph.springmicroservicefornecedor.controller;

import com.example.joseph.springmicroservicefornecedor.dto.OrderItemDTO;
import com.example.joseph.springmicroservicefornecedor.entity.Order;
import com.example.joseph.springmicroservicefornecedor.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private IOrderService orderService;

  @RequestMapping(method = RequestMethod.POST)
  public Order placeOrder(@RequestBody List<OrderItemDTO> items) {
    return orderService.placeOrder(items);
  }

  @RequestMapping("/{id}")
  public Order getOrderById(@PathVariable Long id) {
    return orderService.getOrderById(id);
  }
}
