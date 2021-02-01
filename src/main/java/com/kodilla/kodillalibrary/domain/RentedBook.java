package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RentedBooks")
public class RentedBook {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_copy_id")
    private BookCopy copy;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Column(name = "rentedOnDate")
    private LocalDate rentedOn;

    @NotNull
    @Column(name = "returnTill")
    private LocalDate returnTill;

    public RentedBook(BookCopy copy, User user, LocalDate rentedOn,
                      LocalDate returnTill) {
        this.copy = copy;
        this.user = user;
        this.rentedOn = rentedOn;
        this.returnTill = returnTill;
    }
}
