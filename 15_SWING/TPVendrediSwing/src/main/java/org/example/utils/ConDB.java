package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class ConDB {

    private static final String ERROR_MESSAGE = "An exception occurred";


    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String database = "employeestp";
            String URL = "jdbc:mysql://localhost:3306/";
            return DriverManager.getConnection(URL + database, "root", "password");
        } catch (ClassNotFoundException | java.sql.SQLException e) {
            Logger logger = Logger.getLogger(ConDB.class.getName());
            logger.severe(ERROR_MESSAGE);
            return null;
        }
    }

    public static void closeConnection() {
        try {
            getConnection().close();
        } catch (java.sql.SQLException e) {
            Logger logger = Logger.getLogger(ConDB.class.getName());
            logger.severe(ERROR_MESSAGE);        }
    }
}