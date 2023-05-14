package org.example.dao.impl;

import org.example.config.DataBaseSingleton;
import org.example.dao.IAssociationDao;
import org.example.entity.Association;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AssociationDaoImpl implements IAssociationDao<Association> {

    private Connection connection;


    public AssociationDaoImpl() {
        this.connection =  DataBaseSingleton.getInstance().getConnection();;
    }


    @Override
    public Association save(Association type) throws SQLException {
        String sql = "INSERT INTO association (idRecipe, idIngredient, quantity) VALUES (?, ?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, type.getIdRecipe());
            preparedStatement.setInt(2, type.getIdIngredient());
            preparedStatement.setInt(3, type.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }
}
