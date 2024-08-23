package com.hycu.bookstore.service;

import com.hycu.bookstore.dto.OrderDto;
import com.hycu.bookstore.entity.Order;

import java.util.List;

public interface OrderService {

    OrderDto preOrderSummary(Long userId);

    OrderDto createOrder(OrderDto orderDto);

    OrderDto getOrderById(Long id);
}
