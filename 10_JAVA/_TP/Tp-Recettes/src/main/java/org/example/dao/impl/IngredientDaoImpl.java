package org.example.dao.impl;

import org.example.config.DataBaseSingleton;
import org.example.dao.IGenericDao;
import org.example.entity.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class IngredientDaoImpl implements IGenericDao<Ingredient> {

    private Connection connection;

    public IngredientDaoImpl() throws SQLException {
        this.connection =  DataBaseSingleton.getInstance().getConnection();
    }

    @Override
    public Ingredient save(Ingredient type) {
        String request = "INSERT INTO recettes.ingredient (name) VALUES (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            statement.setString(1, type.getName());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                type.setIdIngredient(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public Ingredient findById(int id) throws SQLException {
        String request = "SELECT * FROM recettes.ingredient WHERE idIngredient = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return Ingredient.builder()
                    .idIngredient(resultSet.getInt("idIngredient"))
                    .name(resultSet.getString("name"))
                    .quantity(resultSet.getInt("quantity"))
                    .unit(resultSet.getString("unit"))
                    .idRecipe(resultSet.getInt("idRecipe"))
                    .build();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }


    @Override
    public void delete(int id)  throws SQLException{
        String request = "DELETE FROM recettes.ingredient WHERE idIngredient = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ingredient> findAll() throws SQLException {
        String request = "SELECT * FROM recettes.ingredient";
    try {
        PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            return List.of(Ingredient.builder()
                    .idIngredient(resultSet.getInt("idIngredient"))
                    .name(resultSet.getString("name"))
                    .quantity(resultSet.getInt("quantity"))
                    .unit(resultSet.getString("unit"))
                    .idRecipe(resultSet.getInt("idRecipe"))
                    .build());
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }


    @Override
    public Ingredient update(Ingredient type) throws SQLException {
        String request = "UPDATE recettes.ingredient SET name = ?, quantity = ?, unity = ?, idRecipe = ? WHERE idIngredient = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
        statement.setString(1, type.getName());
        statement.setInt(2, type.getQuantity());
        statement.setString(3, type.getUnit());
        statement.setInt(4, type.getIdRecipe());
        statement.setInt(5, type.getIdIngredient());
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            type.setIdIngredient(generatedKeys.getInt(1));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return type;
    }
    }
