package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentedBookDto {
    private Long id;
    private Long copyId;
    private Long userid;
    private LocalDate rentedOn;
    private LocalDate returnTill;
}
