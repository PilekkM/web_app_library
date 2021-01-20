package com.example.practice.repositories;

import com.example.practice.entities.Book;

import java.util.List;

public interface BookDAO {
    public List<Book> getBooks();

    public Book getBookById(int id);

    public Integer addBook(Book book);

    public boolean deleteBook(int id);

    public boolean updateBook(Book book);
}
