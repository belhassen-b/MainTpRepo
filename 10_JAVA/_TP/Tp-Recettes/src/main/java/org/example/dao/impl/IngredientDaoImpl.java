package org.example.dao.impl;

import org.example.config.DataBaseSingleton;
import org.example.dao.IIngredientDao;
import org.example.entity.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class IngredientDaoImpl implements IIngredientDao<Ingredient> {

    private Connection connection;

    public IngredientDaoImpl() throws SQLException {
        this.connection =  DataBaseSingleton.getInstance().getConnection();
    }


    @Override
    public Ingredient save(Ingredient type) throws SQLException {
        String request = "INSERT INTO recettes.ingredient (name, unity) VALUES (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            statement.setString(1, type.getName());
            statement.setString(2, type.getUnity());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return Ingredient.builder()
                        .idIngredient(generatedKeys.getInt(1))
                        .name(type.getName())
                        .unity(type.getUnity())
                        .build();
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
                    .unity(resultSet.getString("unity"))
                    .build();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }


    @Override
    public void  delete(int id)  throws SQLException{
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
        List<Ingredient> res = new ArrayList<>();
        String request = "SELECT * FROM recettes.ingredient";
    try {
        PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
             res.add(Ingredient.builder()
                    .idIngredient(resultSet.getInt("idIngredient"))
                    .name(resultSet.getString("name"))
                    .unity(resultSet.getString("unity"))
                    .build());
        }
        return res;
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }


    @Override
    public Ingredient update(Ingredient type) throws SQLException {
        String request = "UPDATE recettes.ingredient SET name = ?,  unity = ? = ? WHERE idIngredient = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
        statement.setString(1, type.getName());
        statement.setString(2, type.getUnity());
        statement.setInt(3, type.getIdIngredient());
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

    public int getLastId() {
        String request = "SELECT MAX(idIngredient) FROM recettes.ingredient";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
