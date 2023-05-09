package org.example.ihm;

import jdk.jshell.spi.ExecutionControl;
import org.example.dao.CarDAO;
import org.example.dao.PersonDAO;
import org.example.dao.SellDAO;
import org.example.models.Car;
import org.example.models.Person;
import org.example.models.Sell;
import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class IHM {
    Scanner scanner;
    String choix;

    private Connection connection;

    private CarDAO carDAO;

    private PersonDAO personDAO;

    private SellDAO sellDAO;


    public IHM() {
        scanner = new Scanner(System.in);
    }

    public void start() throws SQLException {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1" -> createCarAction();
                case "2" -> showAllCarAction();
                case "3" -> deleteCarAction();
                case "4" -> updateCarAction();
                case "5" -> createPersonAction();
                case "6" -> showAllPersonAction();
                case "7" -> deletePersonAction();
                case "8" -> updatePersonByIdAction();
                case "9" -> createSellAction();
                case "10" -> showAllSellAction();
                case "11" -> showSellByIdAction();
                default -> System.out.println("Choix non valide");
            }
        } while (!choix.equals("12"));
    }


    private void menu() {
        System.out.println("-------------------------------");
        System.out.println(" TP 2 VOITURE  ");
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("1 - Enregistrer la voiture ");
        System.out.println("2 - Lister toutes les voitures ");
        System.out.println("3 - Supprimer la voiture ");
        System.out.println("4 - Modifier une voiture ");
        System.out.println("5 - Inscrire un acheteur");
        System.out.println("6 - Lister toutes les acheteur");
        System.out.println("7 - Supprimer une personne");
        System.out.println("8 - Modifier un acheteur");
        System.out.println("9 - Faire la vente");
        System.out.println("10 - Afficher les ventes de voiture ");
        System.out.println("11 - Afficher la liste des ventes d'un véhicule pour un acheteur");
        System.out.println("12 - Quitter");
    }

    // 1 - Creation voiture
    private void createCarAction() {
        System.out.println("Saississez le nom de la voiture");
        String name = scanner.nextLine();
        System.out.println("Saississez l'année de construction de la voiture");
        String year = scanner.nextLine();
        System.out.println("Saississez la puissance de la voiture");
        int power = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez le prix de vente de la voiture");
        int price = scanner.nextInt();
        scanner.nextLine();
        Car car = new Car(name, year, power, price);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            carDAO = new CarDAO(connection);
            if (carDAO.create(car)) {
                System.out.println("La voiture a été enregistrée avec succès");
                connection.commit();
            } else {
                System.out.println("La voiture n'a pas été enregistrée");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // 2 - Afficher toutes les voitures
    private void showAllCarAction() {
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            carDAO = new CarDAO(connection);
           carDAO.findAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 3 - Supprimer une voiture

    private void deleteCarAction() {
        System.out.println("Saississez l'id de la voiture à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            carDAO = new CarDAO(connection);
            if (carDAO.delete(id)) {
                System.out.println("La voiture a été supprimée avec succès");
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 4 - Modifier une voiture
    private void updateCarAction() throws SQLException {
       Car car;
        System.out.println("Saississez l'id de la voiture à modifier");
        int id = scanner.nextInt();
        scanner.nextLine();
        connection = new DataBaseManager().getConnection();
        carDAO = new CarDAO(connection);
        car = carDAO.findById(id);
        System.out.println("Saississez le nom de la voiture");
        System.out.println("Nom actuel : " + car.getName());
        String name = scanner.nextLine();
        System.out.println("Saississez l'année de construction de la voiture");
        System.out.println("Année actuelle : " + car.getYear());
        String year = scanner.nextLine();
        System.out.println("Saississez la puissance de la voiture");
        System.out.println("Puissance actuelle : " + car.getPower());
        int power = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez le prix de vente de la voiture");
        System.out.println("Prix actuel : " + car.getPrice());
        int price = scanner.nextInt();
        scanner.nextLine();
        car = new Car(id,name, year, power, price);
        carDAO.update(car);
    }


    // 5 - Inscription personne
    private void createPersonAction(){
        System.out.println("Saississez le nom de l'acheteur");
        String name = scanner.nextLine();
        System.out.println("Saississez le prénom de l'acheteur");
        String firstname = scanner.nextLine();
        System.out.println("Saississez l'âge de l'acheteur");
        int age = scanner.nextInt();
        scanner.nextLine();
        Person person = new Person(name, firstname, age);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            personDAO = new PersonDAO(connection);
            if (personDAO.create(person)) {
                System.out.println("La personne a été enregistrée avec succès");
                connection.commit();
            } else {
                System.out.println("La personne n'a pas été enregistrée");
                 }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    // 6 - Afficher toutes les personnes
    private void showAllPersonAction(){
        System.out.println("Liste des personnes");
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            personDAO = new PersonDAO(connection);
            personDAO.findAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 7 - Supprimer une personne
    private void deletePersonAction(){
        System.out.println("Saississez l'id de la personne à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            personDAO = new PersonDAO(connection);
            if (personDAO.delete(id)) {
                System.out.println("La personne a été supprimée avec succès");
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 8 - Modifier une personne
    private void updatePersonByIdAction() throws SQLException{
        Person person ;
        System.out.println("Saississez l'id de la personne à modifier");
        int id = scanner.nextInt();
        scanner.nextLine();
        connection = new DataBaseManager().getConnection();
        personDAO = new PersonDAO(connection);
        person = personDAO.findById(id);
        System.out.println("Saississez le nom de la personne");
        System.out.println("Nom actuel : " + person.getLastName());
        String name = scanner.nextLine();
        System.out.println("Saississez le prénom de la personne");
        System.out.println("Prénom actuel : " + person.getFirstName());
        String firstname = scanner.nextLine();
        System.out.println("Saississez l'âge de la personne");
        System.out.println("Age actuel : " + person.getAge());
        int age = scanner.nextInt();
        scanner.nextLine();
        person = new Person(id, name, firstname, age);
        personDAO.update(person);
    }

    // 9 - Faire la vente
    private void createSellAction() {
        System.out.println("Saississez l'id de la personne");
        int idPerson = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez l'id de la voiture");
        int idCar = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez la date de la vente");
        String date = scanner.nextLine();
        Sell sell = new Sell(idPerson, idCar, date);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            sellDAO = new SellDAO(connection);
            if (sellDAO.create(sell)) {
                System.out.println("La vente a été enregistrée avec succès");
                connection.commit();
            } else {
                System.out.println("La vente n'a pas été enregistrée");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 10 - Afficher les ventes de voiture
    private void showAllSellAction() throws SQLException{
        System.out.println("Liste des ventes");
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            sellDAO = new SellDAO(connection);
            sellDAO.getAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ExecutionControl.NotImplementedException e) {
            throw new SQLException(e);
        }
    }

    // 11 - Afficher la liste des ventes d'un véhicule pour une personne
    private void showSellByIdAction() {
        showAllPersonAction();
        System.out.println("Saississez l'id de la personne");
        int idPerson = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            sellDAO = new SellDAO(connection);
            sellDAO.getByPerson(idPerson);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


}
}
