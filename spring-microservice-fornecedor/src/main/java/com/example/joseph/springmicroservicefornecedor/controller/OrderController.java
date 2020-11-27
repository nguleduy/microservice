package com.example.joseph.springmicroservicefornecedor.controller;

import com.example.joseph.springmicroservicefornecedor.dto.OrderItemDTO;
import com.example.joseph.springmicroservicefornecedor.entity.Order;
import com.example.joseph.springmicroservicefornecedor.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

  @RequestMapping(method = RequestMethod.POST)
  public Order placeOrder(@RequestBody List<OrderItemDTO> items) {
    logger.info("request order received");
    return orderService.placeOrder(items);
  }

  @RequestMapping("/{id}")
  public Order getOrderById(@PathVariable Long id) {
    return orderService.getOrderById(id);
  }
}
