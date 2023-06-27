package com.example.tp_spring_annonces.service;

import com.example.tp_spring_annonces.entity.Category;

import java.util.List;

public interface ICategoryService {
    boolean save(Category category);

    List<Category> findAll();


    boolean update(Category category);

    Category findById(Long id);

    boolean delete(Category category);
}
