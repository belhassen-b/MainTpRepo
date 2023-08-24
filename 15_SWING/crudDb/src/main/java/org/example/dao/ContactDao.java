package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContactDao {

    private PreparedStatement preparedStatement;

    private Connection connection;


    public int  addContact(Contact contact){
        connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO contact (name, number) VALUES (?,?)");
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getNumber());
            int nb = preparedStatement.executeUpdate();
            return nb;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int updateContact(Contact contact){
        connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE contact SET name = ?, number = ? WHERE id = ?");
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getNumber());
            preparedStatement.setLong(3, contact.getId());
            int nb = preparedStatement.executeUpdate();
            return nb;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int deleteContact(Contact contact){
        connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM contact WHERE id = ?");
            preparedStatement.setLong(1, contact.getId());
            int nb = preparedStatement.executeUpdate();
            return nb;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public Contact getContactById(long l) {
        connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM contact WHERE id = ?");
            preparedStatement.setLong(1, l);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            Contact contact = new Contact();
            while (resultSet.next()) {
                contact.setId(resultSet.getLong("id"));
                contact.setName(resultSet.getString("name"));
                contact.setNumber(resultSet.getString("number"));
            }
            return contact;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
