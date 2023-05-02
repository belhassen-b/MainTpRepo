package org.example.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
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

    public static void displayAll() {
        try {
            connection = DataBaseManager.getConnection();
            request = "SELECT * FROM contact";
            statement = connection.prepareStatement(request);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Id : " + resultSet.getInt("id" ) + " " + "Nom : " +  resultSet.getString("lastName") + " " + "Prenom :" + resultSet.getString("firstName") + " " + "Téléphone : " + resultSet.getString("phoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public static void searchByIdWithLastname(String lastName) {
        try {
            connection = DataBaseManager.getConnection();
            request = "SELECT * FROM contact WHERE lastName = ?";
            statement = connection.prepareStatement(request);
            statement.setString(1, lastName);
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

    public static void searchByIdWithFirstname(String firstName) {
        try {
            connection = DataBaseManager.getConnection();
            request = "SELECT * FROM contact WHERE firstName = ?";
            statement = connection.prepareStatement(request);
            statement.setString(1, firstName);
            statement.executeQuery();
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

    public static void searchByIdWithPhone(String phoneNumber) {
        try {
            connection = DataBaseManager.getConnection();
            request = "SELECT * FROM contact WHERE phoneNumber = ?";
            statement = connection.prepareStatement(request);
            statement.setString(1, phoneNumber);
            statement.executeQuery();
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

    public static void deleteWithLastName(String lastName) {
        try {
            connection = DataBaseManager.getConnection();
            request = "DELETE FROM contact WHERE lastName = ?";
            statement = connection.prepareStatement(request);
            statement.setString(1, lastName);
            int rowNb = statement.executeUpdate();
            if (rowNb == 0) {
                System.out.println("Aucun contact trouvé");
            } else {
                System.out.println("Le contact" + lastName + " a été supprimé");
                System.out.println("Nombre de ligne supprimée : " + rowNb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void deleteWithFirstName(String firstName) {
        try {
            connection = DataBaseManager.getConnection();
            request = "DELETE FROM contact WHERE firstName = ?";
            statement = connection.prepareStatement(request);
            statement.setString(1, firstName);
            int rowNb = statement.executeUpdate();
            if (rowNb == 0) {
                System.out.println("Aucun contact trouvé");
            } else {
                System.out.println("Le contact" + firstName + " a été supprimé");
                System.out.println("Nombre de ligne supprimée : " + rowNb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteWithPhone(String phoneNumber) {
        try {
            connection = DataBaseManager.getConnection();
            request = "DELETE FROM contact WHERE phoneNumber = ?";
            statement = connection.prepareStatement(request);
            statement.setString(1, phoneNumber);
            int rowNb = statement.executeUpdate();
            if (rowNb == 0) {
                System.out.println("Aucun contact trouvé");
            } else {
                System.out.println("Le contact" + phoneNumber + " a été supprimé");
                System.out.println("Nombre de ligne supprimée : " + rowNb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateContact(int id, String lastName, String firstName, String phoneNumber){
      try(
                Connection connection = DataBaseManager.getConnection();
                PreparedStatement statement = connection.prepareStatement
                        ("UPDATE contact SET lastName = ?, firstName = ?, phoneNumber = ? WHERE id = ?")
        ){
            statement.setInt(1, id);
            statement.setString(2, lastName);
            statement.setString(3, firstName);
            statement.setString(4, phoneNumber);


            int rowNb = statement.executeUpdate();

            System.out.println("Nombre de ligne modifiée : " + rowNb);

    } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    }
}
