package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "firstName")
    private String name;

    @Column(name = "familyName")
    private String surname;

    @Column(name = "registeredOn")
    private LocalDate accountCreated;

    @OneToMany(
            targetEntity = RentedBook.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<RentedBook> rentedBooks = new ArrayList<>();

    public User(String name, String surname, LocalDate accountCreated) {
        this.name = name;
        this.surname = surname;
        this.accountCreated = accountCreated;
    }

    public User(Long id, String name, String surname, LocalDate accountCreated) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.accountCreated = accountCreated;
    }
}
