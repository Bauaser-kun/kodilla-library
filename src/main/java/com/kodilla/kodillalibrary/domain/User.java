package com.kodilla.kodillalibrary.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "first name")
    private String name;

    @Column(name = "family name")
    private String surname;

    @Column(name = "registered on")
    private LocalDate accountCreated;
}
