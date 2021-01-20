package com.example.practice.services;

import com.example.practice.entities.User;
import com.example.practice.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private UserDAO repository;

    @Autowired
    @Qualifier("userDAOImpl")
    public void setUserDAO(UserDAO dao){
        this.repository = dao;
    }

    public List<User> getUsers(){
        return repository.getUsers();
    }

    public User getUserById(int userId){
        return repository.getUserById(userId);
    }

    public Integer addUser(User user){
        return repository.addUser(user);
    }

    public boolean deleteUser(User user){
        return repository.deleteUser(user.getId());
    }

    public boolean updateUser(User user){
        return repository.updateUser(user);
    }
}
