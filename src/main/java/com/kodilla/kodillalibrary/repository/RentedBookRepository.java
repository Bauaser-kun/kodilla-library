package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.RentedBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentedBookRepository extends CrudRepository<RentedBook, Long> {
    @Override
    List<RentedBook> findAll();

    @Override
    RentedBook save(RentedBook rentedBook);
}
