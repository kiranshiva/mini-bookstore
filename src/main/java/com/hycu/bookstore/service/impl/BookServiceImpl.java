package com.hycu.bookstore.service.impl;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.hycu.bookstore.dto.BookDto;
import com.hycu.bookstore.entity.Book;
import com.hycu.bookstore.exception.InvalidInputException;
import com.hycu.bookstore.exception.ResourceNotFoundException;
import com.hycu.bookstore.mapper.BookMapper;
import com.hycu.bookstore.repository.BookRepository;
import com.hycu.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookRepository bookRepository;

    @Override
    public BookDto createBook(BookDto bookDto) {
        if(bookDto.getTitle() == null || bookDto.getTitle().isEmpty()){
            throw new InvalidInputException("Book title cannot be empty");
        }
        if(bookDto.getPrice() == 0 || bookDto.getTitle().isEmpty()){
            throw new InvalidInputException("Book Price cannot be empty");
        }
        Book book = bookRepository.save(bookMapper.toEntity(bookDto));
        return getBookDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDtoList(books);
    }

    @Override
    public BookDto getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        BookDto bookDto = null;
        if(book.isPresent()){
            bookDto = getBookDto(book.get());
        }else{
            throw new ResourceNotFoundException("Book Is Not Available");
        }
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Optional<Book> bookOptional = bookRepository.findById(bookDto.getBookId());
        BookDto updatedBook = null;
        if(bookOptional.isPresent()){
            Book book = bookOptional.get();
            // Update the book details
            book.setTitle(bookDto.getTitle());
            book.setDescription(bookDto.getDescription());
            book.setAuthor(bookDto.getAuthor());
            book.setPublisher(bookDto.getPublisher());
            book.setPublicationDate(bookDto.getPublicationDate());
            book.setGenre(bookDto.getGenre());
            book.setFormat(bookDto.getFormat());
            book.setPages(bookDto.getPages());
            book.setLanguage(bookDto.getLanguage());
            book.setInventoryQty(bookDto.getInventoryQty());
            book.setPrice(bookDto.getPrice());
            book.setCoverImage(bookDto.getCoverImage());
            book.setUpdatedDate(new Date());

            Book updatedBookEntity =  bookRepository.save(book);
            updatedBook = getBookDto(updatedBookEntity);
        }else{
            throw new ResourceNotFoundException("Book Is Not Available");
        }
        return updatedBook;
    }

    @Override
    public BookDto deleteBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        BookDto deletedBook = null;
        if(bookOptional.isPresent()){
            bookRepository.deleteById(id);
            deletedBook = getBookDto(bookOptional.get());
        }else {
            throw new ResourceNotFoundException("Book Is Not Available");
        }
        return deletedBook;
    }

    public BookDto getBookDto(Book book) {
        return bookMapper.toDto(book);
    }

    public Book getBookEntity(BookDto bookDto) {
        return bookMapper.toEntity(bookDto);
    }

    public List<BookDto> convertToBookDtoList(List<Book> books) {
        return bookMapper.toDtoList(books);
    }

    public List<Book> convertToBookEntityList(List<BookDto> bookDtos) {
        return bookMapper.toEntityList(bookDtos);
    }
}
