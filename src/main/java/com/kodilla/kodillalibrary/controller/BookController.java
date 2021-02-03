package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.mapper.BookMapper;
import com.kodilla.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/library")
public class BookController {
    @Autowired
    private DbService service;

    @Autowired
    private BookMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        return mapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook (@RequestParam Long bookId) {
        return mapper.mapToBookDto(service.getBookById(bookId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "DeleteBook")
    public void removeBook(@RequestParam Long bookId){
        service.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public void updateBook(@RequestBody BookDto bookDto) {
        mapper.mapToBookDto(service.saveBook(mapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBook", consumes = APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookDto bookDto){
        mapper.mapToBookDto(service.saveBook(mapper.mapToBook(bookDto)));
    }

}
