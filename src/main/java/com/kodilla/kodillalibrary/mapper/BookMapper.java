package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Book mapToBook(final BookDto bookDto){
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear()
        );
    }

    public BookDto mapToBookDto(final Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear()
        );
    }

    public List<BookDto> mapToBookDtoList(final List<Book> books){
        return books.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
