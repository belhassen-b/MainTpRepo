package org.example.dao;

import org.example.entity.Billeterie;
import org.example.entity.Client;

import java.sql.Connection;
import java.sql.SQLException;

public class ClientDAO extends BaseDAO<Client>{

    public ClientDAO(Connection connection) {
        super(connection);
    }

    public boolean save(Client element) throws SQLException {
        request = "INSERT INTO client (nom, prenom, email, password) VALUES (?, ?, ?, ?)";
        statement = _connection.prepareStatement(request);
        statement.setString(1, element.getNom());
        statement.setString(2, element.getPrenom());
        statement.setString(3, element.getEmail());



    }

    public Client getById(int id) {
        return null;
    }

    public boolean update(Client element) {
        return false;
    }

    public boolean deleteById(int id) {
        return false;
    }
}
