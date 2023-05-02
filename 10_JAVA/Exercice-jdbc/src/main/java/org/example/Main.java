package org.example;

import org.example.utils.DataBaseConnector;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        Scanner scanner = new Scanner(System.in);
        try    {
            Connection connection = dataBaseConnector.getConnection();
            System.out.println("Connection established");
            System.out.println("Merci de faire votre choix : ");
            System.out.println("1 - Ajouter un etudiant");
            System.out.println("2 - Afficher les etudiants");
            System.out.println("3 - Afficher les etudiants d'une classe");
            System.out.println("4 - Supprimer un etudiant");
            int choix = scanner.nextInt();
            scanner.nextLine();

switch (choix) {
                case 1:
                    ajouterEtudiant(connection, scanner);
                    break;
                case 2:
                    afficherEtudiants(connection);
                    break;
                case 3:
                    afficherEtudiantsClasse(connection, scanner);
                    break;
                case 4:
                    supprimerEtudiant(connection, scanner);
                    break;
                default:
                    System.out.println("Choix invalide");
            }



//           Statement statement = connection.createStatement();






        } catch(
                SQLException e)

        {
            System.out.println(e.getMessage());
        }
    }

    private static void supprimerEtudiant(Connection connection, Scanner scanner) {
        System.out.println("Merci de saisir l'id de l'etudiant a supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String request = "DELETE FROM etudiant WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("Etudiant supprimé avec succes");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void afficherEtudiantsClasse(Connection connection, Scanner scanner) throws SQLException {

        String request3 = "SELECT * FROM etudiant WHERE numClasse = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet2 = preparedStatement.executeQuery(request3);
        while (resultSet2.next()){
            System.out.println("Merci de saisir le numero de classe : ");
            int numClasse2 = scanner.nextInt();
            scanner.nextLine();
            preparedStatement.setInt(1, numClasse2);
            preparedStatement.execute();

            System.out.println("============================================");
            System.out.println("id : " + resultSet2.getInt("id"));
            System.out.println("nom : " + resultSet2.getString("nom"));
            System.out.println("prenom : " + resultSet2.getString("prenom"));
            System.out.println("numClasse : " + resultSet2.getInt("numClasse"));
            System.out.println("dateDiplome : " + resultSet2.getString("dateDiplome"));
            System.out.println("============================================");
        }
    }

    private static void afficherEtudiants(Connection connection) throws SQLException {
        String request2 = "SELECT * FROM etudiant";
        Statement preparedStatement = null;
        ResultSet resultSet = preparedStatement.executeQuery(request2);
        while (resultSet.next()){
            System.out.println("============================================");
            System.out.println("id : " + resultSet.getInt("id"));
            System.out.println("nom : " + resultSet.getString("nom"));
            System.out.println("prenom : " + resultSet.getString("prenom"));
            System.out.println("numClasse : " + resultSet.getInt("numClasse"));
            System.out.println("dateDiplome : " + resultSet.getString("dateDiplome"));
            System.out.println("============================================");
        }

    }

    private static void ajouterEtudiant(Connection connection, Scanner scanner) throws SQLException {

        System.out.println("Merci de saisir le nom : ");
        String nom = scanner.nextLine();
        System.out.println("Merci de saisir le prenom : ");
        String prenom = scanner.nextLine();
        System.out.println("Merci de saisir le numero de classe : ");
        int numClasse = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de saisir la date de diplome : (dd/mm/yyyy)");
        String dateDiplome = scanner.nextLine();

        String request = "INSERT INTO etudiant (nom, prenom, numClasse, dateDiplome) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setString(1, nom);
        preparedStatement.setString(2, prenom);
        preparedStatement.setInt(3, numClasse);
        preparedStatement.setString(4, dateDiplome);
        preparedStatement.execute();
        int nbLigne = preparedStatement.executeUpdate();



        System.out.println("requete executée avec succes");
        System.out.println("Nombre de ligne ajoutées : " + nbLigne);

    }

}