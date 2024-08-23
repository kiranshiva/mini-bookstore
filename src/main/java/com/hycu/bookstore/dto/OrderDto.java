package com.hycu.bookstore.dto;


import com.hycu.bookstore.entity.OrderBook;

import java.util.Date;
import java.util.List;

public class OrderDto {
    private Long customerOrderId;
    private UserDto userDto;
    private List<OrderBookDto> orderBookList;
    private Date orderDate;
    private String shippingAddress;
    private String orderStatus;
    private float totalPrice;
    private String paymentMethod;
    private Date shippingDate;
    private Date deliveryDate;

    public OrderDto() {
    }

    public OrderDto(Long customerOrderId, UserDto userDto, List<OrderBookDto> orderBookList, Date orderDate, String shippingAddress, String orderStatus, float totalPrice, String paymentMethod, Date shippingDate, Date deliveryDate) {
        this.customerOrderId = customerOrderId;
        this.userDto = userDto;
        this.orderBookList = orderBookList;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.shippingDate = shippingDate;
        this.deliveryDate = deliveryDate;
    }

    public Long getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<OrderBookDto> getOrderBookList() {
        return orderBookList;
    }

    public void setOrderBookList(List<OrderBookDto> orderBookList) {
        this.orderBookList = orderBookList;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}

