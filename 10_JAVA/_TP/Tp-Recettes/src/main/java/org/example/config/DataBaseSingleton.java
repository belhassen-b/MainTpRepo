package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseSingleton {

        private static DataBaseSingleton instance;
    private Connection connection;

    // Constructeur privé pour empêcher la création d'instances en dehors de la classe
    private DataBaseSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/recettes";
            String username = "test";
            String password = "password";
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer l'instance unique de la classe
    public static DataBaseSingleton getInstance() {
        if (instance == null) {
            instance = new DataBaseSingleton();
        }
        return instance;
    }

    // Méthode pour récupérer la connexion à la base de données
    public Connection getConnection() {
        return connection;
    }
    }

