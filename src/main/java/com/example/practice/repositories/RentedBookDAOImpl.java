package com.example.practice.repositories;

import com.example.practice.entities.RentedBook;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RentedBookDAOImpl implements RentedBookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<RentedBook> getRentedBooks() {
        List<RentedBook> rentedBooks = sessionFactory.getCurrentSession().createQuery("from RentedBook").list();
        return rentedBooks;
    }

    @Override
    public Integer addRentedBook(RentedBook rentedBook) {
        Integer id;
        try{
            id = (Integer) sessionFactory.getCurrentSession().save(rentedBook);
        }catch (HibernateException e){
            e.printStackTrace();
            return -1;
        }

        return id;
    }
}
