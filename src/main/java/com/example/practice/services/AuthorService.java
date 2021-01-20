package com.example.practice.services;

import com.example.practice.entities.Author;
import com.example.practice.repositories.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private AuthorDAO repository;

    @Autowired
    @Qualifier("authorDAOImpl")
    public void setAuthorDAO(AuthorDAO dao){
        this.repository = dao;
    }

    public List<Author> getAuthors(){ return repository.getAuthors(); }

    public Author getAuthorById(int id){ return repository.getAuthorById(id); }

    public Integer addAuthor(Author author){
        return repository.addAuthor(author);
    }

    public boolean deleteAuthor(Author author){
        return repository.deleteAuthor(author.getId());
    }

    public boolean updateAuthor(Author author){
        return repository.updateAuthor(author);
    }

}
