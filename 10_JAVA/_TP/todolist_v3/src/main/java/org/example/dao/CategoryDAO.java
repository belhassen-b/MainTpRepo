package org.example.dao;


import org.example.model.Category;

import java.util.List;

public interface CategoryDAO {
        boolean addCategory(Category category);

    List<Category> getAll();

    boolean update(Category category);

    boolean delete(Long categoryId);

    Category getById(Long id);
}
