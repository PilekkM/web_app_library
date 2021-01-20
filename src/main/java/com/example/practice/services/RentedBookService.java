package com.example.practice.services;

import com.example.practice.entities.RentedBook;
import com.example.practice.repositories.RentedBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentedBookService {

    @Autowired
    @Qualifier("rentedBookDAO")
    private RentedBookDAO repository;

    public List<RentedBook> getRentedBooks(){
        return repository.getRentedBooks();
    }

    public Integer addRentedBook(RentedBook rentedBook){
        return repository.addRentedBook(rentedBook);
    }
}
