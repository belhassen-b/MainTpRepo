package tp_car.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
    private static DatabaseSingleton instance = null;

    private Connection connection;

    // Constructeur privé pour empêcher la création d'instances en dehors de la classe

    private DatabaseSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tpCar";
            String username = "root";
            String password = "root";
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer l'instance unique de la classe
    public static DatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    // Méthode pour récupérer la connexion à la base de données
    public Connection getConnection() {
        return connection;
    }
}
