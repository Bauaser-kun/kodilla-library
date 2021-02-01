package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class BookController {


    public List<BookDto> getBooks() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook (Long bookId) {
        return new BookDto(1L,"overlord 1 the undead king", "Kagune Maruyama", 2010);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "DeleteBook")
    public void removeBook(Long bookId){}

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public BookDto updateBook(BookDto bookDto) {
        return new BookDto(1L, "Overlord part 1, The Undead King", "Kagune Maruyama", 2010);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public void addBook(BookDto bookDto){}

}
