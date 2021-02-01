package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BookCopies")
public class BookCopy {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "status")
    private RentalState status;

    @OneToMany(
            targetEntity = RentedBook.class,
            mappedBy = "copy",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<RentedBook> rentedBooks = new ArrayList<>();

    public BookCopy(Long id, Book book, RentalState status) {
        this.id = id;
        this.book = book;
        this.status = status;
    }

    public BookCopy(Book book, RentalState status) {
        this.book = book;
        this.status = status;
    }

    public BookCopy(RentalState status) {
        this.status = status;
    }
}
