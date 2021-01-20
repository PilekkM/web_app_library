package com.example.practice.repositories;

import com.example.practice.entities.Author;

import java.util.List;

public interface AuthorDAO {

    List<Author> getAuthors();

    Author getAuthorById(int authorId);

    Integer addAuthor(Author author);

    boolean deleteAuthor(int authorId);

    boolean updateAuthor(Author author);
}
