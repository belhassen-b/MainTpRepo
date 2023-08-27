package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {


    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String database = "employees";
            String URL = "jdbc:mysql://localhost:3306/";
            return DriverManager.getConnection(URL + database, "root", "password");
        } catch (ClassNotFoundException | java.sql.SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}