package com.example.tp_spring_annonces.service.impl;

import com.example.tp_spring_annonces.entity.Category;
import com.example.tp_spring_annonces.repository.CategoryRepository;
import com.example.tp_spring_annonces.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository _categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        _categoryRepository = categoryRepository;
    }


    @Override
    public boolean save(Category category) {
        _categoryRepository.save(category);
        return category.getId() > 0;
    }

    @Override
    public List<Category> findAll() {
        return _categoryRepository.findAll();
    }

    @Override
    public boolean update(Category category) {
        _categoryRepository.save(category);
        return true;
    }

    @Override
    public Category findById(Long id) {
        return _categoryRepository.findById(id).get();
    }

    @Override
    public boolean delete(Category category) {
        _categoryRepository.delete(category);
        return true;
    }


}

