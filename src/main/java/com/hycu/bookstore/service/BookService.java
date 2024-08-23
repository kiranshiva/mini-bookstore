package com.hycu.bookstore.service;

import com.hycu.bookstore.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto createBook(BookDto bookDto);

    List<BookDto> getAllBooks();

    BookDto getBookById(Long id);

    BookDto updateBook(BookDto bookDto);

    BookDto deleteBook(Long id);
}
