package com.example.tp1spring.service;

import com.example.tp1spring.entity.Category;
import com.example.tp1spring.entity.Priority;
import com.example.tp1spring.entity.Todo;

import java.util.List;

public interface ITodoService {

    boolean create(Todo t);
    boolean update(Todo t);

    boolean delete(Todo t);

    Todo findById(int id);

    List<Todo> findAll();

//    Category findAllCategory();

    List<Category> findAllCategoryList();

//    Priority findAllPriority();

    List<Priority> findAllPriorityList();

    Category findAllCategory();

    Priority findAllPriority();
}
