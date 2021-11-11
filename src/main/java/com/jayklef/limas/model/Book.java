package com.jayklef.limas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String title;
    private String author;
    private LocalDate dateAdded;
    private Long numberInStock;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "genre_Id",
            referencedColumnName = "genreId"
    )
    private Genre genre;
}
