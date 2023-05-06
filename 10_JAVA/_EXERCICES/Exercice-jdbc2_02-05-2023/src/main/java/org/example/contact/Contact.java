package org.example.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.utils.DataBaseManager;


public class Contact {

    private int id;
    private static String lastName;
    private static String firstName;
    private static String phoneNumber;

    private static String request;

    private static PreparedStatement statement;

    private static Connection connection;

    public Contact(String lastName, String firstName, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void save() {
        try {
            connection = DataBaseManager.getConnection();
            request = "INSERT INTO contact (lastName, firstName, phoneNumber) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(request);
            statement.setString(1, this.lastName);
            statement.setString(2, this.firstName);
            statement.setString(3, this.phoneNumber);
            int rowNb = statement.executeUpdate();
            System.out.println("Nombre de ligne ajoutée  : " + rowNb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayAll() {
        try {
            connection = DataBaseManager.getConnection();
            request = "SELECT * FROM contact";
            statement = connection.prepareStatement(request);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Id : " + resultSet.getInt("id") + " " + "Nom : " + resultSet.getString("lastName") + " " + "Prenom :" + resultSet.getString("firstName") + " " + "Téléphone : " + resultSet.getString("phoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchWithsearchWord(String searchWord) {
        try {
            connection = DataBaseManager.getConnection();
            request = "SELECT * FROM contact WHERE lastName like ? OR firstName like ? OR phoneNumber like ?     ";
            statement = connection.prepareStatement(request);
            statement.setString(1, "%" + searchWord + "%");
            statement.setString(2, "%" + searchWord + "%");
            statement.setString(3, "%" + searchWord + "%");
            ResultSet resultset = statement.executeQuery();
            if (resultset.next()) {
                System.out.println("id : " + resultset.getInt("id"));
                System.out.println("lastName : " + resultset.getString("lastName"));
                System.out.println("firstName : " + resultset.getString("firstName"));
                System.out.println("phoneNumber : " + resultset.getString("phoneNumber"));
                System.out.println("============================================");
            } else {
                System.out.println("Aucun contact trouvé");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean delete() throws SQLException {
        request = "DELETE FROM contact  where id = ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setInt(1, getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    public boolean update() throws SQLException {
        request = "UPDATE  contact set firstName = ?, lastName = ?, phoneNumber = ? where id = ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setString(1, getFirstName());
        statement.setString(2, getLastName());
        statement.setString(3, getPhoneNumber());
        statement.setInt(4, getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }
}
