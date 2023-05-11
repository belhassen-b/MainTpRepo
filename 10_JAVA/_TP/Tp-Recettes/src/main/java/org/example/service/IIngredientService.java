package org.example.service;

import org.example.entity.Ingredient;

import java.util.List;

public interface IIngredientService {

    Ingredient createIngredient(Ingredient ingredient);

    Ingredient updateIngredient(Ingredient ingredient);

    void deleteIngredient(int id);

    Ingredient getIngredient(int id);

    Ingredient getIngredientByName(String name);

    List<Ingredient> getAllIngredients();

}
