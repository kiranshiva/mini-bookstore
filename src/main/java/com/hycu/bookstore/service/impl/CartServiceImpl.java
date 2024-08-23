package com.hycu.bookstore.service.impl;

import com.hycu.bookstore.dto.CartDto;
import com.hycu.bookstore.dto.UserCartDto;
import com.hycu.bookstore.entity.Book;
import com.hycu.bookstore.entity.Cart;
import com.hycu.bookstore.entity.User;
import com.hycu.bookstore.exception.ResourceNotFoundException;
import com.hycu.bookstore.mapper.CartMapper;
import com.hycu.bookstore.repository.BookRepository;
import com.hycu.bookstore.repository.CartRepository;
import com.hycu.bookstore.repository.UserRepository;
import com.hycu.bookstore.service.CartService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public CartDto addProduct(CartDto cartDto) {
        Cart cart = new Cart();
        User user = userRepository.findById(cartDto.getUserDto().getUserId()).orElse(null);
        Book book = bookRepository.findById(cartDto.getBookDto().getBookId()).orElse(null);
        if(ObjectUtils.isEmpty(book)){
            throw new ResourceNotFoundException("Book ID is Invalid");
        }
        cart.setUser(user);
        cart.setBook(book);
        Cart checkExistBook = cartRepository.findByUserAndBook(user,book);
        if(!ObjectUtils.isEmpty(checkExistBook)){
            cart.setItemId(checkExistBook.getItemId());
        }
        cart.setQty(cartDto.getQty());
        CartDto savedProduct = getCartDto(cartRepository.save(cart));
        return savedProduct;
    }

    @Override
    public UserCartDto getAllProducts(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        List<Cart> carts = cartRepository.findByUser(user);
        List<CartDto> cartDtos = convertToCartDtoList(carts);
        UserCartDto userCartDto = new UserCartDto();
        userCartDto.setUser(user);
        for(CartDto cartDto : cartDtos){
            cartDto.setUserDto(null);
        }
        userCartDto.setCartDto(cartDtos);
        return  userCartDto;
    }

    @Override
    public CartDto deleteProduct(Long id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        CartDto cartDto = null;
        if(!ObjectUtils.isEmpty(cart)){
            cartRepository.delete(cart);
            cartDto = getCartDto(cart);
        }
        return cartDto;
    }

    @Override
    public CartDto updateCart(CartDto cartDto) {
        Cart updatedCart = getCartEntity(cartDto);
        updatedCart = cartRepository.save(updatedCart);
        return getCartDto(updatedCart);
    }

    public CartDto getCartDto(Cart cart) {
        return cartMapper.toDto(cart);
    }

    public Cart getCartEntity(CartDto cartDto) {
        return cartMapper.toEntity(cartDto);
    }

    public List<CartDto> convertToCartDtoList(List<Cart> carts) {
        return cartMapper.toDtoList(carts);
    }

    public List<Cart> convertToCartEntityList(List<CartDto> cartDtoList) {
        return cartMapper.toEntityList(cartDtoList);
    }

}
