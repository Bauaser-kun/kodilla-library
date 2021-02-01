package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.BookRepository;
import com.kodilla.kodillalibrary.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
private final BookRepository repository;

public List<Book> getAllBooks() {
    return repository.findAll();
}
}
