package com.example.joseph.springmicroservicefornecedor.service.impl;

import com.example.joseph.springmicroservicefornecedor.dto.OrderItemDTO;
import com.example.joseph.springmicroservicefornecedor.entity.Order;
import com.example.joseph.springmicroservicefornecedor.entity.OrderItem;
import com.example.joseph.springmicroservicefornecedor.entity.Product;
import com.example.joseph.springmicroservicefornecedor.repository.OrderRepository;
import com.example.joseph.springmicroservicefornecedor.repository.ProductRepository;
import com.example.joseph.springmicroservicefornecedor.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Order placeOrder(List<OrderItemDTO> items) {
    if (items == null) {
      return null;
    }

    List<OrderItem> orderItems = toOrderItem(items);
    Order order = new Order(orderItems);
    order.setPreparationTime(items.size());
    return orderRepository.save(order);
  }

  @Override
  public Order getOrderById(Long id) {
    return this.orderRepository.findById(id).orElse(new Order());
  }

  private List<OrderItem> toOrderItem(List<OrderItemDTO> items) {
    List<Long> idsProduct = items
            .stream()
            .map(item -> item.getId())
            .collect(Collectors.toList());

    List<Product> orderProducts = productRepository.findByIdIn(idsProduct);

    List<OrderItem> orderItems = items
            .stream()
            .map(item -> {
              Product product = orderProducts
                      .stream()
                      .filter(p -> p.getId() == item.getId())
                      .findFirst().get();

              OrderItem orderItem = new OrderItem();
              orderItem.setProduct(product);
              orderItem.setAmount(item.getAmount());
              return orderItem;
            })
            .collect(Collectors.toList());
    return orderItems;
  }
}
