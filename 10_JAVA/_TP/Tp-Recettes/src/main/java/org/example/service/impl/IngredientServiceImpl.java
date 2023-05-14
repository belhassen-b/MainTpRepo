package org.example.service.impl;

import org.example.dao.impl.IngredientDaoImpl;
import org.example.entity.Ingredient;
import org.example.service.IIngredientService;

import java.sql.SQLException;

import java.util.List;

public class IngredientServiceImpl implements IIngredientService {

    private final IngredientDaoImpl ingredientDao;

    public IngredientServiceImpl() throws SQLException {
        this.ingredientDao = new IngredientDaoImpl();
    }

    @Override
    public Ingredient save(Ingredient ingredient) throws SQLException {
        return ingredientDao.save(ingredient);
    }


    @Override
    public Ingredient update(Ingredient ingredient) throws SQLException {
        return ingredientDao.update(ingredient);
    }

    @Override
    public void delete(int id) throws SQLException {
        ingredientDao.delete(id);

    }

    @Override
    public Ingredient get(int id) throws SQLException {
        return ingredientDao.findById(id);
    }

    @Override
    public Ingredient getByName(String name) throws SQLException {
        return null;
    }

    @Override
    public List<Ingredient> getAllIngredients() throws SQLException {
        return ingredientDao.findAll();
    }

    public int getLastId() {
        return ingredientDao.getLastId();
    }
}

