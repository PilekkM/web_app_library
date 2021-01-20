package com.example.practice.repositories;

import com.example.practice.entities.Book;

import java.util.List;

public interface BookDAO {

    List<Book> getBooks();

    Book getBookById(int bookId);

    Integer addBook(Book book);

    boolean deleteBook(int bookId);

    boolean updateBook(Book book);
}
