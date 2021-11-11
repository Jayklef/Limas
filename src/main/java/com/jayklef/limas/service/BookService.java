package com.jayklef.limas.service;

import com.jayklef.limas.exception.BookNotFoundException;
import com.jayklef.limas.model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long bookId) throws BookNotFoundException;

    Book getBookByTitle(String title) throws BookNotFoundException;

    Book getBookByAuthor(String author) throws BookNotFoundException;

    Book updateBook(Long bookId, Book book);

    void deleteBook();

}
