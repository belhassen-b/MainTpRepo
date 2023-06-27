package com.example.tp_spring_annonces.service;

import com.example.tp_spring_annonces.entity.User;

import java.util.List;

public interface IUserService {
    boolean save(User user);

    boolean update(User user);


    User findByEmailAndPassword(String email, String password);

    List<User> findAll();

    boolean deleteById(Long id);

    User findById(Long id);
}
