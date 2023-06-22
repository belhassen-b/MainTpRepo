package com.example.tp1spring.service;

import com.example.tp1spring.entity.Todo;

import java.util.List;

public interface ITodoService {

    boolean create(Todo t);
    boolean update(Todo t);

    boolean delete(Todo t);

    Todo findById(int id);

    List<Todo> findAll();

    Object findAllCategory();

    Object findAllPriority();
}
