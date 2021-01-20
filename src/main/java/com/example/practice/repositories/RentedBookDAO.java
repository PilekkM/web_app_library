package com.example.practice.repositories;

import com.example.practice.entities.RentedBook;

import java.util.List;

public interface RentedBookDAO {

    List<RentedBook> getRentedBooks();

    RentedBook getRentedBookById(int rentedBookId);

    Integer addRentedBook(RentedBook rentedBook);

    boolean deleteRentedBook(int rentedBookId);
}
