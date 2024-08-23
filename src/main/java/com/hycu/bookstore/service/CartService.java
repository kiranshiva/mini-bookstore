package com.hycu.bookstore.service;

import com.hycu.bookstore.dto.CartDto;
import com.hycu.bookstore.dto.UserCartDto;

import java.util.List;

public interface CartService {

    CartDto addProduct(CartDto cartDto);

    UserCartDto getAllProducts(Long userId);

    CartDto deleteProduct(Long id);

    CartDto updateCart(CartDto cartDto);
}
