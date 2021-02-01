package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "author")
    private String author;

    @NotNull
    @Column(name = "published")
    private int publicationYear;

    @NotNull
    @OneToMany(
            targetEntity = BookCopies.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BookCopies> bookCopiesList = new ArrayList<>();

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Book(long id, String title,String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Book(String title, String author, int publicationYear,
                List<BookCopies> bookCopiesList) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.bookCopiesList = bookCopiesList;
    }
}
