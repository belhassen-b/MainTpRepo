package org.example;

import org.example.util.DataBaseManager;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBaseManager dataBaseManager = new DataBaseManager();
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = dataBaseManager.getConnection();
            System.out.println("Connection established");
//            System.out.println("Merci de saisir le nom : ");
//            String nom = scanner.nextLine();
//            System.out.println("Merci de saisir le prenom : ");
//            String prenom = scanner.nextLine();
            // requete pour l'insertion des données
           // String request = "INSERT INTO personne (nom, prenom) VALUES ('" + nom + "', '" + prenom + "')";
//            String request = "INSERT INTO personne (nom, prenom) VALUES (?, ?)";
//            // un objet qui respecte l'interface statement est un objet qui permet l'execution des requetes sql
//            Statement statement = connection.createStatement();
            //Facon 1 => execution de requet sans retour
//            boolean result = statement.execute(request);
//            System.out.println("requete executée avec succes");
//            if (result) {
//                System.out.println("la requete a retourné un resultat");
//            } else {
//                System.out.println("la requete n'a pas retourné de resultat");
//            }
            //Facon 2 => execution avec requete preparée
//            PreparedStatement preparedStatement = connection.prepareStatement(request) ;
//            preparedStatement.setString(1, nom);
//            preparedStatement.setString(2, prenom);
////            preparedStatement.execute();
//            int nbLigne = preparedStatement.executeUpdate();
//            System.out.println("requete executée avec succes");
//            System.out.println("Nombre de ligne  : " + nbLigne);

            // Facon 3 requete de lecture (iteration)
//

            IHM ihm = new IHM();
            ihm.start();

    } catch (SQLException e)
        {
            System.out.println(e.getMessage());
}
    }
}