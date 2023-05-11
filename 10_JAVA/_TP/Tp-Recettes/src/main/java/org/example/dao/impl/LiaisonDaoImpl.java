package org.example.dao.impl;

import org.example.config.DataBaseSingleton;
import org.example.dao.IGenericDao;
import org.example.entity.Liaison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class LiaisonDaoImpl implements IGenericDao<Liaison> {

    private Connection connection;

    public LiaisonDaoImpl() throws SQLException {
        this.connection = DataBaseSingleton.getInstance().getConnection();
    }

    @Override
    public Liaison save(Liaison type) {
        String request = "INSERT INTO recettes.liaison (idRecipe, idIngredient) VALUES (?,?)";
    try {
        PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
        statement.setInt(1, type.getIdRecipe());
        statement.setInt(2, type.getIdIngredient());
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            type.setIdLiaison(generatedKeys.getInt(1));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return type;
    }


    @Override
    public Liaison findById(int id) {
        String request = "SELECT * FROM recettes.liaison WHERE idLiaison = ?";
        try (
                PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Liaison.builder()
                        .idLiaison(resultSet.getInt("idLiaison"))
                        .idRecipe(resultSet.getInt("idRecipe"))
                        .idIngredient(resultSet.getInt("idIngredient"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
            String request = "DELETE FROM recettes.liaison WHERE idLiaison = ?";
            try (PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    @Override
    public List<Liaison> findAll() {
        String request = "SELECT * FROM recettes.liaison";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Liaison update(Liaison type) {
        String request = "UPDATE recettes.liaison SET idRecipe = ?, idIngredient = ? WHERE idLiaison = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
        statement.setInt(1, type.getIdRecipe());
        statement.setInt(2, type.getIdIngredient());
        statement.setInt(3, type.getIdLiaison());
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            type.setIdLiaison(generatedKeys.getInt(1));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return type;
    }
    }
