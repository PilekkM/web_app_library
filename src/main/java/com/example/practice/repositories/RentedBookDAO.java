package com.example.practice.repositories;

import com.example.practice.entities.RentedBook;

import java.util.List;

public interface RentedBookDAO {

    public List<RentedBook> getRentedBooks();

    public RentedBook getRentedBookById(int rentedBookId);

    public Integer addRentedBook(RentedBook rentedBook);

    public boolean deleteRentedBook(int rentedBookId);
}
