package com.jayklef.limas.service;

import com.jayklef.limas.exception.BookNotFoundException;
import com.jayklef.limas.model.Book;
import com.jayklef.limas.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) throws BookNotFoundException {
        Optional<Book> book = bookRepository.findById(bookId);

        if (!book.isPresent()){
            throw new BookNotFoundException();
        }
        return book.get();
    }

    @Override
    public Book updateBook(Long bookId, Book book) {
        Book bookInDb = bookRepository.findById(bookId).get();

        if (!book.getTitle().isBlank()){
            bookInDb.setTitle(book.getTitle());
            bookInDb.setAuthor(book.getAuthor());
            bookInDb.setDateAdded(book.getDateAdded());
            bookInDb.setNumberInStock(book.getNumberInStock());
        }
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook() {
    }

}
