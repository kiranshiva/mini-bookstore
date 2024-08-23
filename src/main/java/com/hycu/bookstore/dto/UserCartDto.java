package com.hycu.bookstore.dto;

import com.hycu.bookstore.entity.User;

import java.util.List;

public class UserCartDto {
    User user;
   List<CartDto> cartDto;

    public UserCartDto() {
    }

    public UserCartDto(User user, List<CartDto> cartDto) {
        this.user = user;
        this.cartDto = cartDto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartDto> getCartDto() {
        return cartDto;
    }

    public void setCartDto(List<CartDto> cartDto) {
        this.cartDto = cartDto;
    }
}
