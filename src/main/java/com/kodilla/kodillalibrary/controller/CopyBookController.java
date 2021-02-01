package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.domain.BookCopyDto;
import com.kodilla.kodillalibrary.domain.RentalState;
import com.kodilla.kodillalibrary.mapper.BookCopyMapper;
import com.kodilla.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/bookCopies")
public class CopyBookController {
    @Autowired
    private DbService service;

    @Autowired
    private BookCopyMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBookCopies")
    public List<BookCopyDto> getBookCopies() {
        return mapper.mapToBookCopiesDtoList(service.getAllCopies());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBookCopy")
    public BookCopyDto getBookCopy(@RequestParam Long bookCopyId) {
        return mapper.mapToBookCopiesDto(service.getCopyById(bookCopyId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBookCopy", consumes = APPLICATION_JSON_VALUE)
    public void addBookCopy(@RequestBody BookCopyDto bookCopyDto) {
        mapper.mapToBookCopiesDto(service.saveBookCopy(mapper.mapToBookCopies(bookCopyDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBookCopy")
    public void updateBookCopy (@RequestBody BookCopyDto bookCopyDto){
        mapper.mapToBookCopiesDto(service.saveBookCopy(mapper.mapToBookCopies(bookCopyDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBookCopy")
    public void deleteBookCopy(@RequestParam Long bookCopyId){
    service.deleteBookCopy(bookCopyId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateStatus")
    public void updateStatus(@RequestParam Long bookCopyId, @RequestParam RentalState status){
    service.updateBookRentalState(bookCopyId, status);
    }

    @RequestMapping(method = RequestMethod.GET, value = "countAvailableCopies")
    public Long countAvailableCopies(@RequestParam String title){
    return service.countAvailableCopies(title);
    }
}
