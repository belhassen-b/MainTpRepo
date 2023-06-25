package com.example.tp1spring.service;

import com.example.tp1spring.entity.User;

import java.util.List;

public interface IUserService {

    boolean create(User u);

    boolean update(User u);

    boolean delete(User u);

    User findById(int id);

    List<User> findAll();

    User findByUsernameAndPassword(String username, String password);

}
