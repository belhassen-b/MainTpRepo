package org.example.service.impl;

import org.example.dao.impl.RecipeDaoImpl;
import org.example.entity.Recipe;
import org.example.service.IRecipeService;

import java.sql.SQLException;
import java.util.List;


public class RecipeServiceImpl implements IRecipeService {
 private final RecipeDaoImpl  recipeDao;

    public RecipeServiceImpl() throws SQLException {
            this.recipeDao = new RecipeDaoImpl();
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeDao.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return recipeDao.update(recipe);
    }

    @Override
    public void deleteRecipe(int id) {
        recipeDao.delete(id);
    }

    @Override
    public Recipe getRecipe(int id) {
        return recipeDao.findById(id);
    }

    @Override
    public List<Recipe> getAllRecipes() throws SQLException {
        return recipeDao.findAll();
    }

    @Override
    public void save(String nameRecipe, int nbPerson, int preparationTime, int cookingTime, int difficulty, String description) {

    }

}
