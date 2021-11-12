package com.jayklef.limas.controller;

import com.jayklef.limas.exception.BookNotFoundException;
import com.jayklef.limas.model.Book;
import com.jayklef.limas.service.BookService;
import com.jayklef.limas.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;
    private GenreService genreService;
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
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

    @GetMapping("/books/genres/{genreName}")
    public List<Book> getListOfBooksByGenreName(@PathVariable("genreName") String genreName){
        return bookService.getListOfBooksByGenreName(genreName);
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("bookId") Long bookId) throws BookNotFoundException {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/books/{title}")
    public Book getBookByTitle(@PathVariable("title") String title) throws BookNotFoundException {
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/books/{author}")
    public Book getBookByAuthor(@PathVariable("author") String author) throws BookNotFoundException {
        return bookService.getBookByAuthor(author);
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
