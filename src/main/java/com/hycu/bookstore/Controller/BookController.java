package com.hycu.bookstore.Controller;

import com.hycu.bookstore.dto.BookDto;
import com.hycu.bookstore.dto.UserDto;
import com.hycu.bookstore.entity.Book;
import com.hycu.bookstore.service.BookService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookDto savedBook = bookService.createBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long id) {
       BookDto bookDto = bookService.getBookById(id);
       if(ObjectUtils.isEmpty(bookDto)){
           new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
            BookDto updatedBook = bookService.updateBook(bookDto);
            if(!ObjectUtils.isEmpty(updatedBook)) {
                return new ResponseEntity<>(updatedBook, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
            BookDto bookDto = bookService.deleteBook(id);
            if(!ObjectUtils.isEmpty(bookDto)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
}
