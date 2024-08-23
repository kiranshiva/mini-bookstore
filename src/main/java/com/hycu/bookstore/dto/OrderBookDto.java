package com.hycu.bookstore.dto;

public class OrderBookDto {
    private Long orderBookId;
    private OrderDto customerOrder;
    private BookDto bookDto;
    private int quantity;
    private float price;

    public OrderBookDto() {
    }

    public OrderBookDto(Long orderBookId, OrderDto orderDto, BookDto bookDto, int quantity, float price) {
        this.orderBookId = orderBookId;
        this.customerOrder = orderDto;
        this.bookDto = bookDto;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getOrderBookId() {
        return orderBookId;
    }

    public void setOrderBookId(Long orderBookId) {
        this.orderBookId = orderBookId;
    }

    public OrderDto getOrderDto() {
        return customerOrder;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.customerOrder = orderDto;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
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

