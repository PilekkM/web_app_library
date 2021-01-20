package com.example.practice.repositories;

import com.example.practice.entities.RentedBook;

import java.util.List;

public interface RentedBookDAO {

    public List<RentedBook> getRentedBooks();

    public Integer addRentedBook(RentedBook rentedBook);

}
