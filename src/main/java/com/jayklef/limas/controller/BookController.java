package com.jayklef.limas.controller;

import com.jayklef.limas.exception.BookNotFoundException;
import com.jayklef.limas.model.Book;
import com.jayklef.limas.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public Book saveBook(Book book){
        logger.info("Inside saveBook of BookController");
        return bookService.saveBook(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        logger.info("Inside getAllBooks of BookController");
       return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("bookId") Long bookId) throws BookNotFoundException {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable("bookId") Long bookId, Book book){
        return bookService.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable("/books/{id}") Long bookId){
        bookService.deleteBook();
        return "Book removed successfully";
    }
}
