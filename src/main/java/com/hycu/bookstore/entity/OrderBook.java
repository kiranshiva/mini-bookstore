package com.hycu.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_book")
public class OrderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderBookId;
    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    private Order customerOrder;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private int quantity;
    private float price;

    public OrderBook() {
    }

    public OrderBook(Long orderBookId, Order customerOrder, Book book, int quantity, float price) {
        this.orderBookId = orderBookId;
        this.customerOrder = customerOrder;
        this.book = book;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getOrderBookId() {
        return orderBookId;
    }

    public void setOrderBookId(Long orderBookId) {
        this.orderBookId = orderBookId;
    }

    public Order getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(Order customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

