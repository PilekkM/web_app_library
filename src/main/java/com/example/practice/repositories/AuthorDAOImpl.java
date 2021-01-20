package com.example.practice.repositories;

import com.example.practice.entities.Author;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Author> getAuthors() {
        List<Author> authors = sessionFactory.getCurrentSession().createQuery("from Author").list();
        return authors;
    }

    @Override
    public Author getAuthorById(int id) {
        Author author = sessionFactory.getCurrentSession().get(Author.class, id);
        return author;
    }

    @Override
    public Integer addAuthor(Author author) {
        Integer id;
        try {
            id = (Integer) sessionFactory.getCurrentSession().save(author);
        }catch(HibernateException e) {
            e.printStackTrace();
            return -1;
        }
        return id;
    }

    @Override
    public boolean deleteAuthor(int id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            Author auth = session.get(Author.class, id);
            session.delete(auth);
        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAuthor(Author author) {
        try{
            Author dbAuthor = getAuthorById(author.getId());
            dbAuthor.setNames(author.getNames());
            dbAuthor.setSurname(author.getSurname());
            sessionFactory.getCurrentSession().update(dbAuthor);
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
