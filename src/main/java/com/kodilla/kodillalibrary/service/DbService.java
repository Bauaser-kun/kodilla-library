package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.domain.RentedBook;
import com.kodilla.kodillalibrary.repository.BookCopyRepository;
import com.kodilla.kodillalibrary.repository.BookRepository;
import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.repository.RentedBookRepository;
import com.kodilla.kodillalibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentedBookRepository rentedBookRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;


}
