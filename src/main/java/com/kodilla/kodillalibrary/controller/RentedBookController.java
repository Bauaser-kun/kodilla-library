package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.RentedBookDto;
import com.kodilla.kodillalibrary.mapper.RentedBookMapper;
import com.kodilla.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rentedBooks")
public class RentedBookController {
    @Autowired
    DbService service;

    @Autowired
    RentedBookMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getRentedBooks")
    public List<RentedBookDto> getRentedBooks() {
        return mapper.mapToRentedBookDtoList(service.getAllRentedBooks());
    }

    @RequestMapping(method = RequestMethod.POST, value = "rentBook")
    public void rentBook(@RequestBody RentedBookDto rentedBookDto) {
        mapper.mapToRentedBookDto(service.rentBook(mapper.mapToRentedBook(rentedBookDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public void returnBook(@RequestParam Long rentedBookId) {
        service.returnBook(rentedBookId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReturnDate")
    public LocalDate getReturnDate (@RequestParam Long rentedBookId) {
        return service.getReturnTill(rentedBookId);
    }

}
