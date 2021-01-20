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

    private RentedBookDAO repository;

    @Autowired
    @Qualifier("rentedBookDAOImpl")
    public void setRentedBookDAO(RentedBookDAO dao){
        this.repository = dao;
    }

    public List<RentedBook> getRentedBooks(){
        return repository.getRentedBooks();
    }

    public RentedBook getRentedBookById(int rentedBookId){
        return repository.getRentedBookById(rentedBookId);
    }

    public Integer addRentedBook(RentedBook rentedBook){
        return repository.addRentedBook(rentedBook);
    }

    public boolean deleteRentedBook(RentedBook rentedBook){
        return repository.deleteRentedBook(rentedBook.getId());
    }
}
