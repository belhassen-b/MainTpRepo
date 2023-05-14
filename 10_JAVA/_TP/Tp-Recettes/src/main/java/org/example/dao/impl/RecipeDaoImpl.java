package org.example.dao.impl;

import org.example.config.DataBaseSingleton;
import org.example.dao.IRecipeDao;
import org.example.entity.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class RecipeDaoImpl implements IRecipeDao<Recipe> {
    private Connection connection;

    public RecipeDaoImpl(){
        this.connection = DataBaseSingleton.getInstance().getConnection();
    }


    @Override
    public Recipe save(Recipe type) {
        String request = "INSERT INTO recettes.recipe ( nameRecipe, nbPerson, preparationTime, cookingTime, difficulty, description) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS)) {
            statement.setString(1, type.getNameRecipe());
            statement.setInt(2, type.getNbPerson());
            statement.setInt(3, type.getPreparationTime());
            statement.setInt(4, type.getCookingTime());
            statement.setInt(5, type.getDifficulty());
            statement.setString(6, type.getDescription());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return Recipe.builder()
                        .idRecipe(generatedKeys.getInt(1))
                        .nameRecipe(type.getNameRecipe())
                        .nbPerson(type.getNbPerson())
                        .preparationTime(type.getPreparationTime())
                        .cookingTime(type.getCookingTime())
                        .difficulty(type.getDifficulty())
                        .description(type.getDescription())
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public Recipe findById(int id) {
        String request = "SELECT * FROM recettes.recipe WHERE idRecipe = ?";
        try ( PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Recipe.builder()
                        .idRecipe(resultSet.getInt("idRecipe"))
                        .nameRecipe(resultSet.getString("nameRecipe"))
                        .nbPerson(resultSet.getInt("nbPerson"))
                        .preparationTime(resultSet.getInt("preparationTime"))
                        .cookingTime(resultSet.getInt("cookingTime"))
                        .difficulty(resultSet.getInt("difficulty"))
                        .description(resultSet.getString("description"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String request = "DELETE FROM recettes.recipe WHERE idRecipe = ?";
        try (PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Recipe> findAll() throws SQLException {
        List<Recipe> res = new ArrayList<>();
        String request = "SELECT idRecipe as id, nameRecipe as Nom, nbPerson as Nombre_Convive, preparationTime as Temps_Préparation, cookingTime as Temps_Cuisson, difficulty as Difficulté, description as Description FROM recettes.recipe";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                res.add(Recipe.builder()
                        .idRecipe(resultSet.getInt("id"))
                        .nameRecipe(resultSet.getString("Nom"))
                        .nbPerson(resultSet.getInt("Nombre_Convive"))
                        .preparationTime(resultSet.getInt("Temps_Préparation"))
                        .cookingTime(resultSet.getInt("Temps_Cuisson"))
                        .difficulty(resultSet.getInt("Difficulté"))
                        .description(resultSet.getString("Description"))
                        .build());
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

        @Override
    public Recipe update(Recipe type) {
        String request = "UPDATE recettes.recipe SET nameRecipe = ?, nbPerson = ?, preparationTime = ?, cookingTime = ?, difficulty = ?, description = ? WHERE idRecipe = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            statement.setString(1, type.getNameRecipe());
            statement.setInt(2, type.getNbPerson());
            statement.setInt(3, type.getPreparationTime());
            statement.setInt(4, type.getCookingTime());
            statement.setInt(5, type.getDifficulty());
            statement.setString(6, type.getDescription());
            statement.setInt(7, type.getIdRecipe());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public int getLastId() {
        String request = "SELECT idRecipe FROM recettes.recipe ORDER BY idRecipe DESC LIMIT 1";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("idRecipe");
            }
} catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
