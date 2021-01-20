package com.example.practice.repositories;

import com.example.practice.entities.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    User getUserById(int userId);

    Integer addUser(User user);

    boolean deleteUser(int userId);

    boolean updateUser(User user);
}
