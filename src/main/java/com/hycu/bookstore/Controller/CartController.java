package com.hycu.bookstore.Controller;

import com.hycu.bookstore.dto.BookDto;
import com.hycu.bookstore.dto.CartDto;
import com.hycu.bookstore.dto.UserCartDto;
import com.hycu.bookstore.dto.UserDto;
import com.hycu.bookstore.entity.Cart;
import com.hycu.bookstore.service.CartService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> addProduct(@RequestBody CartDto cartDto) {
        CartDto addedProduct = cartService.addProduct(cartDto);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserCartDto> getAllProducts(@PathVariable("userId") Long userId) {
        UserCartDto cartDtos = cartService.getAllProducts(userId);
        return new ResponseEntity<>(cartDtos, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CartDto> updateCart(@RequestBody CartDto cartDto) {
        CartDto updatedCart = cartService.updateCart(cartDto);
        if(!ObjectUtils.isEmpty(updatedCart)) {
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        CartDto cartDto = cartService.deleteProduct(id);
        if(!ObjectUtils.isEmpty(cartDto)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
