package org.example.utils;

import java.sql.*;

public class BaseJDBC {
    protected static Connection connection;
    protected static String request;
    protected static PreparedStatement statement;

    protected static ResultSet resultSet;

    private static final String URI = "jdbc:mysql://localhost:3306/exercice-jdbc";

    private static final String USER = "root";
    private static final String PASSWORD = "Jelassi.230582";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI, USER, PASSWORD);
    }
}
