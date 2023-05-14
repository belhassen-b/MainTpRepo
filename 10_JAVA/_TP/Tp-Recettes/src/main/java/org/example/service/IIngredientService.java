package org.example.service;

import org.example.entity.Ingredient;

import java.sql.SQLException;
import java.util.List;

public interface IIngredientService {

    Ingredient save(Ingredient ingredient) throws SQLException;

    Ingredient update(Ingredient ingredient) throws SQLException;

    void delete(int id) throws SQLException;

    Ingredient get(int id) throws SQLException;

    Ingredient getByName(String name) throws SQLException;

    List<Ingredient> getAllIngredients() throws SQLException;

}
