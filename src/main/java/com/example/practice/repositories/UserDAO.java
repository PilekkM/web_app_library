package com.example.practice.repositories;

import com.example.practice.entities.User;

import java.util.List;

public interface UserDAO {

    public List<User> getUsers();

    public User getUserById(int userId);

    public Integer addUser(User user);

    public boolean deleteUser(int userId);

    public boolean updateUser(User user);
}
