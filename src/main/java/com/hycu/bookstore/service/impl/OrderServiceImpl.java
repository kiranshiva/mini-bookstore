package com.hycu.bookstore.service.impl;

import com.hycu.bookstore.dto.BookDto;
import com.hycu.bookstore.dto.OrderBookDto;
import com.hycu.bookstore.dto.OrderDto;
import com.hycu.bookstore.entity.*;
import com.hycu.bookstore.exception.ResourceNotFoundException;
import com.hycu.bookstore.mapper.BookMapper;
import com.hycu.bookstore.mapper.UserMapper;
import com.hycu.bookstore.repository.*;
import com.hycu.bookstore.service.OrderService;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderBookRepository orderBookRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    BookMapper bookMapper;

    @Override
    public OrderDto preOrderSummary(Long userId) {
        OrderDto orderDto = getCartToOrder(userId);
        if (orderDto == null) return null;
        return orderDto;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        LocalDate purchasedDate = LocalDate.now();
        LocalDate deliveryDate = purchasedDate.plusDays(2);
        LocalDate shippingDate = purchasedDate.plusDays(1);
        Date date = Date.from(purchasedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date deliveryDateFormat = Date.from(deliveryDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date shippingDateFormat = Date.from(shippingDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Order newOrder = new Order();
        newOrder.setOrderDate(date);
        newOrder.setOrderStatus("Processing");
        newOrder.setUser(userMapper.toEntity(orderDto.getUserDto()));
        newOrder.setDeliveryDate(deliveryDateFormat);
        newOrder.setPaymentMethod(orderDto.getPaymentMethod());
        newOrder.setShippingAddress(orderDto.getShippingAddress());
        newOrder.setShippingDate(shippingDateFormat);
        newOrder.setTotalPrice(orderDto.getTotalPrice());

        newOrder = orderRepository.save(newOrder);
        for(OrderBookDto orderBookDto : orderDto.getOrderBookList()){
            OrderBook orderBook = new OrderBook();
            orderBook.setCustomerOrder(newOrder);
            Book currentBook = bookMapper.toEntity(orderBookDto.getBookDto());
            orderBook.setBook(currentBook);
            orderBook.setPrice(currentBook.getPrice() * orderBookDto.getQuantity());
            orderBook.setQuantity(orderBookDto.getQuantity());
            orderBookRepository.save(orderBook);
        }
        orderDto.setCustomerOrderId(newOrder.getCustomerOrderId());
        orderDto.setDeliveryDate(deliveryDateFormat);
        orderDto.setOrderStatus(newOrder.getOrderStatus());
        orderDto.setShippingDate(newOrder.getShippingDate());
        orderDto.setOrderDate(newOrder.getOrderDate());

        //remove items from cart
        cartRepository.deleteCartByUserID(orderDto.getUserDto().getUserId());

        return orderDto;
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("details not found"));
        OrderDto orderDto = new OrderDto();
        if(!ObjectUtils.isEmpty(order)){
            orderDto.setCustomerOrderId(order.getCustomerOrderId());
            orderDto.setOrderDate(order.getOrderDate());
            orderDto.setOrderStatus(order.getOrderStatus());
            orderDto.setDeliveryDate(order.getDeliveryDate());
            orderDto.setShippingDate(order.getShippingDate());
            orderDto.setPaymentMethod(order.getPaymentMethod());
            orderDto.setTotalPrice(order.getTotalPrice());
            orderDto.setShippingAddress(order.getShippingAddress());
            List<OrderBookDto> orderBookDtos = new ArrayList<>();
            for(OrderBook orderBook : order.getOrderBookList()){
                OrderBookDto tmp = new OrderBookDto();
                tmp.setBookDto(bookMapper.toDto(orderBook.getBook()));
                tmp.setOrderBookId(orderBook.getOrderBookId());
                tmp.setPrice(orderBook.getPrice());
                tmp.setQuantity(orderBook.getQuantity());
                orderBookDtos.add(tmp);
            }
            orderDto.setOrderBookList(orderBookDtos);

        }
        return  orderDto;
    }

    private OrderDto getCartToOrder(Long userId) {
        OrderDto orderDto = new OrderDto();
        User user = userRepository.findById(userId).orElse(null);
        List<Cart> cartList = cartRepository.findByUser(user);
        if(cartList.isEmpty()){
            return null;
        }
        List<OrderBookDto> orderBooks = new ArrayList<>();
        Float totalPrice = 0.0f;
        for(Cart cart : cartList){
            OrderBookDto orderBook = new OrderBookDto();
            orderBook.setBookDto(bookMapper.toDto(cart.getBook()));
            orderBook.setQuantity(cart.getQty());
            Book book = bookRepository.findById(cart.getBook().getBookId()).orElse(null);
            if(ObjectUtils.isEmpty(book)){
                continue;
            }
            float currentPrice = book.getPrice();
            float currentBookPrice = cart.getQty() * currentPrice;
            totalPrice += currentBookPrice;
            orderBook.setPrice(currentBookPrice);
            orderBooks.add(orderBook);
        }
        orderDto.setOrderBookList(orderBooks);
        orderDto.setTotalPrice(totalPrice);
        orderDto.setUserDto(userMapper.toDto(user));
        return orderDto;
    }

}
