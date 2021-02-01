package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.domain.BookCopyDto;
import com.kodilla.kodillalibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCopyMapper {
    @Autowired
    private BookRepository bookRepository;

    public BookCopy mapToBookCopies(final BookCopyDto bookCopyDto) {
        return new BookCopy(
                bookCopyDto.getId(),
                bookRepository.findById(bookCopyDto.getBookId()).get(),
                bookCopyDto.getStatus()
        );
    }

    public BookCopyDto mapToBookCopiesDto(final BookCopy bookCopy) {
        return new BookCopyDto(
          bookCopy.getId(),
          bookCopy.getBook().getId(),
          bookCopy.getStatus()
        );
    }

    public List<BookCopyDto> mapToBookCopiesDtoList(final List<BookCopy> copies) {
        return copies.stream()
                .map(this::mapToBookCopiesDto)
                .collect(Collectors.toList());
    }
}
