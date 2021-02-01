package com.kodilla.kodillalibrary.repository;


import com.kodilla.kodillalibrary.domain.BookCopy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {
    @Override
    List<BookCopy> findAll();

    @Override
    BookCopy save(BookCopy bookCopy);

    @Override
    Optional<BookCopy> findById(Long id);

    @Override
    void deleteById(Long id);

}
