package com.example.practice.repositories;

import com.example.practice.entities.Author;

import java.util.List;

public interface AuthorDAO {

    public List<Author> getAuthors();

    public Author getAuthorById(int id);

    public Integer addAuthor(Author author);

    public boolean deleteAuthor(int id);

    public boolean updateAuthor(Author author);
}
