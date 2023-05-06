package org.example.dao;

import org.example.entity.Lieu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LieuDAO extends BaseDAO<Lieu>{

    public LieuDAO(Connection connection) {
        super(connection);
    }

    // public boolean save(Lieu element) {
    public boolean save(Lieu lieu) throws SQLException {
        request = "INSERT INTO lieu (nom, adresse, capacite) VALUES (?,?,?)";
        try {
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, lieu.getNom());
        statement.setString(2, lieu.getAdresse());
        statement.setInt(3, lieu.getCapacite());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            lieu.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
        }
    }

    // public Lieu getById(int id) {

    public Lieu getById(int id) {
        return null;
    }

    // public boolean update(Lieu element) {

    public boolean update(Lieu element) {
        return false;
    }

    // public boolean deleteById(int id) {

    public boolean deleteById(int id) {
        return false;
    }


}
