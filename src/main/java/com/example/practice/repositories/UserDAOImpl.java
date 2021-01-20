package com.example.practice.repositories;

import com.example.practice.entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        List<User> users = sessionFactory.getCurrentSession().createQuery("from User").list();
        return users;
    }

    @Override
    public User getUserById(int userId) {
        User user = sessionFactory.getCurrentSession().get(User.class, userId);
        return user;
    }

    @Override
    public Integer addUser(User user) {
        Integer id;
        try{
            id = (Integer) sessionFactory.getCurrentSession().save(user);
        }catch(HibernateException e){
            e.printStackTrace();
            return -1;
        }

        return id;
    }

    @Override
    public boolean deleteUser(int userId) {
        try{
            Session session = sessionFactory.getCurrentSession();
            User user = session.get(User.class, userId);
            session.delete(user);
        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public boolean updateUser(User user) {
        try{
            User dbUser = getUserById(user.getId());
            dbUser.setName(user.getName());
            dbUser.setSurname(user.getSurname());
            dbUser.setAge(user.getAge());
            dbUser.setPersonalId(user.getPersonalId());
            sessionFactory.getCurrentSession().update(dbUser);
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
