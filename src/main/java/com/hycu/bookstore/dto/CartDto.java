package com.hycu.bookstore.dto;


public class CartDto {
    private Long itemId;
    private UserDto userDto;
    private BookDto bookDto;
    private int qty;

    public CartDto() {
    }

    public CartDto(Long itemId, UserDto userDto, BookDto bookDto, int qty) {
        this.itemId = itemId;
        this.userDto = userDto;
        this.bookDto = bookDto;
        this.qty = qty;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

