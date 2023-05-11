package org.example.service;

import org.example.entity.Recipe;

import java.sql.SQLException;
import java.util.List;

public interface IRecipeService {

    Recipe save(Recipe recipe);

    Recipe updateRecipe(Recipe recipe);

    void deleteRecipe(int id);

    Recipe getRecipe(int id);

    List<Recipe> getAllRecipes() throws SQLException;

    void save(String nameRecipe, int nbPerson, int preparationTime, int cookingTime, int difficulty, String description);
}
