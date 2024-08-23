package com.hycu.bookstore.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerOrderId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL},mappedBy = "customerOrder")
    private List<OrderBook> orderBookList;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    private String shippingAddress;
    private String orderStatus;
    private float totalPrice;
    private String paymentMethod;
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippingDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;

    public Order() {
    }

    public Order(Long customerOrderId, User user, List<OrderBook> orderBookList, Date orderDate, String shippingAddress, String orderStatus, float totalPrice, String paymentMethod, Date shippingDate, Date deliveryDate) {
        this.customerOrderId = customerOrderId;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderBook> getOrderBookList() {
        return orderBookList;
    }

    public void setOrderBookList(List<OrderBook> orderBookList) {
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

