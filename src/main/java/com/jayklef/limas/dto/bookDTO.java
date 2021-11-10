package com.jayklef.limas.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class bookDTO {
    private String title;
    private String author;
    private LocalDate dateAdded;
    private Long numberInStock;
}
