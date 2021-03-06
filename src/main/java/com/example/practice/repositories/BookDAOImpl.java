package com.example.practice.repositories;

import com.example.practice.entities.Book;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Book> getBooks() {

        return (List<Book>) sessionFactory.getCurrentSession().createQuery("from Book order by title").list();
    }

    @Override
    public Book getBookById(int id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    public Integer addBook(Book book) {
        Integer id;
        try{
            id = (Integer) sessionFactory.getCurrentSession().save(book);
        }catch (HibernateException e){
            e.printStackTrace();
            return -1;
        }
        return id;
    }

    @Override
    public boolean deleteBook(int id) {
        try {
            Book book = getBookById(id);
            sessionFactory.getCurrentSession().delete(book);
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBook(Book book){
        try{
            Book dbBook = getBookById(book.getId());
            dbBook.setTitle(book.getTitle());
            dbBook.setAuthor(book.getAuthor());
            dbBook.setQuantity(book.getQuantity());
            dbBook.setInRental(book.getInRental());
            sessionFactory.getCurrentSession().update(dbBook);
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
