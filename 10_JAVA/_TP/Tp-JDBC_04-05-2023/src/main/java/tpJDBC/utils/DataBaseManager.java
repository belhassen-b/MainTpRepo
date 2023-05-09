package tpJDBC.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {

    private static final String URI = "jdbc:mysql://localhost:3306/exercice-jdbc";
    private static final String USER = "test";
    private static final String PASSWORD = "paswword";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}
