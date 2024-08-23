package com.hycu.bookstore.mapper;
import com.hycu.bookstore.dto.BookDto;
import com.hycu.bookstore.dto.CartDto;
import com.hycu.bookstore.entity.Book;
import com.hycu.bookstore.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    // Mapping from entity to DTO
    @Mapping(source = "user", target = "userDto")
    @Mapping(source = "book", target = "bookDto")
    CartDto toDto(Cart cart);

    // Mapping from DTO to entity
    @Mapping(source = "userDto", target = "user")
    @Mapping(source = "bookDto", target = "book")
    Cart toEntity(CartDto cartDto);
    // Mapping a list of UserEntity to a list of UserDTO
    List<CartDto> toDtoList(List<Cart> carts);

    // Optionally, mapping a list of UserDTO to a list of UserEntity
    List<Cart> toEntityList(List<CartDto> cartDtos);
}
