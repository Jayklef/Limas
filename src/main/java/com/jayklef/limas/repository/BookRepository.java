package com.jayklef.limas.repository;

import com.jayklef.limas.model.Book;
import com.jayklef.limas.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public Book findBookByTitle(String title);

    public Book findBookByAuthor(String author);

    public List<Book> findAllByGenreName(Genre genre);
}
