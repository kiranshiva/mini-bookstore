package com.hycu.bookstore.Controller;

import com.hycu.bookstore.dto.OrderDto;
import com.hycu.bookstore.dto.UserDto;
import com.hycu.bookstore.entity.Order;
import com.hycu.bookstore.service.OrderService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/preOrder/{id}")
    public ResponseEntity<OrderDto> preOrder(@PathVariable("id") Long userId){
        OrderDto orderDto = orderService.preOrderSummary(userId);
        return new ResponseEntity<>(orderDto,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto savedOrder = orderService.createOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getAllOrders(@PathVariable("id") Long id) {
        OrderDto order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
