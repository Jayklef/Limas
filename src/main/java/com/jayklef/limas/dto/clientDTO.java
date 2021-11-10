package com.jayklef.limas.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class clientDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
}
