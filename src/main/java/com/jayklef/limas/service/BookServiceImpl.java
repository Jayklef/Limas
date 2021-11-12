package com.jayklef.limas.service;

import com.jayklef.limas.exception.BookNotFoundException;
import com.jayklef.limas.exception.GenreNotFoundException;
import com.jayklef.limas.model.Book;
import com.jayklef.limas.model.Genre;
import com.jayklef.limas.repository.BookRepository;
import com.jayklef.limas.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;
    private GenreRepository genreRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
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
    public List<Book> getListOfBooksByGenreName(String genreName) {
        Genre genre = this.genreRepository.findAll().listIterator().next();
        return bookRepository.findAllByGenreName(genre);
    }

    @Override
    public Book getBookById(Long bookId) throws BookNotFoundException {
        Optional<Book> book = bookRepository.findById(bookId);

        if (!book.isPresent()){
            throw new BookNotFoundException("Book Not Found");
        }
        return book.get();
    }

    @Override
    public Book getBookByTitle(String title) throws BookNotFoundException {
        Optional<Book> book = Optional.ofNullable(bookRepository.findBookByTitle(title));

        if (!book.isPresent()){
            throw new BookNotFoundException("Book Not Found");
        }
        return book.get();
    }

    @Override
    public Book getBookByAuthor(String author) throws BookNotFoundException {
        Optional<Book> book = Optional.ofNullable(bookRepository.findBookByAuthor(author));

        if (!book.isPresent()){
            throw new BookNotFoundException("Book Not Found");
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
