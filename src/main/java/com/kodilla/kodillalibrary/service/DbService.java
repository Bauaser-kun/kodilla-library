package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.*;
import com.kodilla.kodillalibrary.repository.BookCopyRepository;
import com.kodilla.kodillalibrary.repository.BookRepository;
import com.kodilla.kodillalibrary.repository.RentedBookRepository;
import com.kodilla.kodillalibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(final Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteUser(final Long userId) {
        userRepository.deleteById(userId);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(final Long bookId) {
        return  bookRepository.findById(bookId).orElse(null);
    }

    public void deleteBook(final Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public List<RentedBook> getAllRentedBooks() {
        return rentedBookRepository.findAll();
    }

    public RentedBook rentBook(final RentedBook rentedBook) {
        rentedBook.getCopy().setStatus(RentalState.RENTED);
        bookCopyRepository.save(rentedBook.getCopy());
        return rentedBookRepository.save(rentedBook);
    }

    public void returnBook(Long rentedBookId) {
        Optional<RentedBook> rentedBook = rentedBookRepository.findById(rentedBookId);
        RentedBook returnedBook = rentedBook.get();
        returnedBook.getCopy().setStatus(RentalState.AVAILABLE);
        bookCopyRepository.save(returnedBook.getCopy());
        rentedBookRepository.save(returnedBook);
    }

    public List<BookCopy> getAllCopies() {
        return bookCopyRepository.findAll();
    }

    public BookCopy getCopyById(final Long bookCopyId) {
        return bookCopyRepository.findById(bookCopyId).orElse(null);
    }

    public BookCopy saveBookCopy(final BookCopy bookCopy) {
        return bookCopyRepository.save(bookCopy);
    }

    public void deleteBookCopy(final Long bookCopyId) {
        bookCopyRepository.deleteById(bookCopyId);
    }

    public void updateBookRentalState(Long bookCopyId, RentalState status) {
        Optional<BookCopy> bookCopy = bookCopyRepository.findById(bookCopyId);
        BookCopy rentalStateToChangeBook = bookCopy.get();
        rentalStateToChangeBook.setStatus(status);
        bookCopyRepository.save(rentalStateToChangeBook);
    }

    public Long countAvailableCopies(String title){
        return bookCopyRepository.findAll().stream()
                .filter(t -> t.getBook().getTitle().equals(title))
                .filter(t -> t.getStatus().equals(RentalState.AVAILABLE))
                .count();
    }
}
