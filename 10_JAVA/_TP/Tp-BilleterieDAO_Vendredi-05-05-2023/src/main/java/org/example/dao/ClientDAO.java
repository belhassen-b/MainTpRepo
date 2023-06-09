package org.example.dao;

import org.example.entity.Client;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientDAO extends BaseDAO<Client> {
    public ClientDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Client element) throws SQLException {
        request = "INSERT INTO client ( firstname, lastname, email) VALUES (?,?,?)";
        try {
            statement = _connection.prepareStatement(request);
            statement.setString(1, element.getFirstname());
            statement.setString(2, element.getLastname());
            statement.setString(3, element.getEmail());
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Client> get() throws  SQLException {
        List<Client> client = new ArrayList<>();
        request = "SELECT * FROM client";
        try {
            statement = _connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                client.add(new Client(
                        resultSet.getInt("idClient"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email")
                ));
            }
            return client;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Client get(int id) throws  SQLException {
        Client client = null;
        request = "SELECT * FROM client WHERE idClient = ?";
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                client = new Client(
                        resultSet.getInt("idClient"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email")
                );
            }
            return client;
    }

    @Override
    public boolean update(Client element) throws SQLException {
        request = "UPDATE client SET firstname = ?, lastname = ?, email = ? WHERE idClient = ?";
            statement = _connection.prepareStatement(request);
            statement.setString(1, element.getFirstname());
            statement.setString(2, element.getLastname());
            statement.setString(3, element.getEmail());
            statement.setInt(4, element.getIdclient());
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
    }


    @Override
    public boolean delete(Client element) throws SQLException {
        request = "DELETE FROM client WHERE idClient = ?";
            statement = _connection.prepareStatement(request);
            statement.setInt(1, element.getIdclient());
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
    }
}
