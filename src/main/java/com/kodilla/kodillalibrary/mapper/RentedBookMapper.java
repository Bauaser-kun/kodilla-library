package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.RentedBook;
import com.kodilla.kodillalibrary.domain.RentedBookDto;
import com.kodilla.kodillalibrary.repository.BookCopyRepository;
import com.kodilla.kodillalibrary.repository.RentedBookRepository;
import com.kodilla.kodillalibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentedBookMapper {
    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private UserRepository userRepository;

    public RentedBook mapToRentedBook(final RentedBookDto rentedBookDto){
        return new RentedBook(
                rentedBookDto.getId(),
                bookCopyRepository.findById(rentedBookDto.getCopyId()).get(),
                userRepository.findById(rentedBookDto.getUserid()).get(),
                rentedBookDto.getRentedOn(),
                rentedBookDto.getReturnTill()
        );
    }

    public RentedBookDto mapToRentedBookDto(final RentedBook rentedBook){
        return new RentedBookDto(
                rentedBook.getId(),
                rentedBook.getCopy().getId(),
                rentedBook.getUser().getId(),
                rentedBook.getRentedOn(),
                rentedBook.getReturnTill()
        );
    }

    public List<RentedBookDto> mapToRentedBookDtoList(final List<RentedBook> rentedBooks){
    return rentedBooks.stream()
            .map(this::mapToRentedBookDto)
            .collect(Collectors.toList());
    }
}
