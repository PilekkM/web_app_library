package com.example.practice.services;

import com.example.practice.entities.Book;
import com.example.practice.repositories.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private BookDAO repository;

    @Autowired
    @Qualifier("bookDAOImpl")
    public void setBookDAO(BookDAO dao){
        this.repository = dao;
    }

    public List<Book> getBooks(){
        return repository.getBooks();
    }

    public Book getBookById(int id){
        return repository.getBookById(id);
    }

    public Integer addBook(Book book){
        return repository.addBook(book);
    }

    public boolean deleteBook(Book book){
        return repository.deleteBook(book.getId());
    }

    public boolean updateBook(Book book){
        return repository.updateBook(book);
    }
}
