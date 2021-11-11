package com.jayklef.limas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;

    @NotBlank(message = "Please enter firstName")
    private String firstName;
    private String lastName;

    @Email(message = "Please enter a valid email address")
    private String email;

    @NotBlank(message = "Please enter a valid PhoneNumber")
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;

    @Lob
    private byte[] clientPassport;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "mc_Id",
            referencedColumnName = "mcId"
    )
    private MembershipCategory membershipCategory;
}
