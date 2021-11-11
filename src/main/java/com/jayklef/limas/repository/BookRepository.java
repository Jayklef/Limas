package com.jayklef.limas.repository;

import com.jayklef.limas.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public Book findBookByTitle(String title);

    public Book findBookByAuthor(String author);
}
