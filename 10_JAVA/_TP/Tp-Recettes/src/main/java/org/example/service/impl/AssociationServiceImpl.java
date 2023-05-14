package org.example.service.impl;

import org.example.config.DataBaseSingleton;
import org.example.entity.Association;
import org.example.entity.Recipe;
import org.example.service.IAssociationService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AssociationServiceImpl implements IAssociationService {

    private Connection connection;

    public AssociationServiceImpl() {
        this.connection =   DataBaseSingleton.getInstance().getConnection();;
    }

    @Override
    public Association save(Association type) throws SQLException {
    String sql = "INSERT INTO association (idRecipe, idIngredient, quantity) VALUES (?, ?, ?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setInt(1, type.getIdRecipe());
        preparedStatement.setInt(2, type.getIdIngredient());
        preparedStatement.setInt(3, type.getQuantity());
        preparedStatement.executeUpdate();
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
    return type;
    }
}
