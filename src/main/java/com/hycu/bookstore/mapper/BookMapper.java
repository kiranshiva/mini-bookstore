package com.hycu.bookstore.mapper;
import com.hycu.bookstore.dto.BookDto;
import com.hycu.bookstore.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    // Mapping from entity to DTO
    BookDto toDto(Book book);

    // Mapping from DTO to entity
    Book toEntity(BookDto bookDto);
    // Mapping a list of UserEntity to a list of UserDTO
    List<BookDto> toDtoList(List<Book> books);

    // Optionally, mapping a list of UserDTO to a list of UserEntity
    List<Book> toEntityList(List<BookDto> bookDtos);
}
