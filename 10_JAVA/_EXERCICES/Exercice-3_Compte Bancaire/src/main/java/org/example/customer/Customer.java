package org.example.customer;

import org.example.utils.BaseJDBC;

import java.sql.SQLException;
import java.sql.Statement;

public class Customer extends BaseJDBC {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Customer(int id, String firstName, String lastName, String phone) {
        this(firstName, lastName, phone);
        this.id = id;
    }

    public boolean save(){
        request = "INSERT INTO customer (firstName, lastName, phone) VALUES (?, ?, ?)";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, this.firstName);
            statement.setString(2, this.lastName);
            statement.setString(3, this.phone);
            int affectedRows = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                this.id = resultSet.getInt(1);
            }
            return affectedRows == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Customer getById(int id) throws SQLException {
        Customer customer = null;
        connection = getConnection();
        statement = connection.prepareStatement("SELECT * FROM customer WHERE id = ?");
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone")
            );
        }
        return customer;
    }
}
