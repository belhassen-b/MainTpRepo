package ihm;

import dao.ClientDAO;
import dao.EvenementDAO;
import dao.LocationDAO;
import dao.TicketDAO;
import entity.Client;
import entity.Evenement;
import entity.Location;
import entity.Ticket;
import jdk.jshell.spi.ExecutionControl;
import utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class IHM {
    Scanner scanner;
    String choix;

    private Connection connection;

    private ClientDAO clientDAO;
    private LocationDAO locationDAO;
    private EvenementDAO evenementDAO;

    private TicketDAO ticketDAO;


    public IHM() {
        scanner = new Scanner(System.in);
    }

    public void start() throws SQLException, ExecutionControl.NotImplementedException {
        do {
              menu();
                choix = scanner.nextLine();
                switch (choix) {
                    case "1":
                        crudLieu();
                        break;
                    case "2":
                        crudEvenement();
                        break;
                    case "3":
                        crudClient();
                        break;
                    case "4":
                        buyTicketAction();
                        break;
                    case "5":
                        cancelTicketAction();
                        break;
                    case "6":
                        showAllEventAction();
                        break;
                    case "7":
                        showAllTicketAction();
                        break;
                    case "9":
                        System.out.println("Au revoir");
                        break;
                    default:
                        System.out.println("Choix non valide");
                }
            } while (!choix.equals("9"));
    }

    private void menu() {
        System.out.println("-------------------------------");
        System.out.println(" TP Billeterie DAO JDBC");
        System.out.println("-------------------------------");
        System.out.println("***************************************");
        System.out.println("Veuillez choisir une option :");
        System.out.println("***************************************");
        System.out.println("1.Ajouter, modifier et supprimer des lieux");
        System.out.println("2.Ajouter, modifier et supprimer des événements");
        System.out.println("3.Ajouter, modifier et supprimer des clients");
        System.out.println("4.Acheter des billets pour un événement");
        System.out.println("5.Annuler un achat de billet");
        System.out.println("6.Afficher la liste des événements disponibles");
        System.out.println("7.Afficher la liste des billets achetés par un client");
        System.out.println("9. Quitter");
        System.out.println("***************************************");
    }

    // 1 - CRUD Lieu
    private void crudLieu() throws SQLException, ExecutionControl.NotImplementedException {
        do {
            menuLieu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    createLieuAction();
                    break;
                case "2":
                    showAllLieuAction();
                    break;
                case "3":
                    updateLieuAction();
                    break;
                case "4":
                    deleteLieuAction();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Choix non valide");
            }
        } while (!choix.equals("5"));
    }


    // Sous Menu Lieu
    private void menuLieu() {
        System.out.println("-------------------------------");
        System.out.println(" TP Billeterie DAO JDBC");
        System.out.println("-------------------------------");
        System.out.println("***************************************");
        System.out.println("Veuillez choisir une option :");
        System.out.println("***************************************");
        System.out.println("1.Ajouter un lieu");
        System.out.println("2.Afficher la liste des lieux");
        System.out.println("3.Modifier un lieu");
        System.out.println("4.Supprimer un lieu");
        System.out.println("5.Retour");
        System.out.println("***************************************");
    }

    // 1 - Creation lieu
    private void createLieuAction() throws SQLException, ExecutionControl.NotImplementedException {
        System.out.println("Saississez le nom du lieu");
        String name = scanner.nextLine();
        System.out.println("Saisisissez l'adresse du lieu");
        String address = scanner.nextLine();
        System.out.println("Saississez la capacité du lieu");
        int capacity = scanner.nextInt();
        scanner.nextLine();
        Location location = new Location(name, address, capacity);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            locationDAO = new LocationDAO(connection);
            if (locationDAO.save(location)) {
                System.out.println("Le lieu a été enregistré avec succès");
                connection.commit();
            } else {
                System.out.println("Le lieu n'a pas été enregistré");
                location = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 2 - Afficher tous les lieux
private void showAllLieuAction() throws SQLException, ExecutionControl.NotImplementedException{
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            locationDAO = new LocationDAO(connection);
            System.out.println("Liste des lieux enregistrés :");
            System.out.println("-------------------------------");
            for (Location location : locationDAO.getAll()) {
                System.out.println("Id : " + location.getId() + " - Nom :" + location.getName() + " - Adresse : " + location.getAddress() + " - Capacité : " + location.getCapacity());
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 3 - Modifier un lieu
    private void updateLieuAction() throws SQLException, ExecutionControl.NotImplementedException {

        System.out.println("Saississez l'id du lieu à modifier");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez le nom du lieu");
        String name = scanner.nextLine();
        System.out.println("Saisisissez l'adresse du lieu");
        String address = scanner.nextLine();
        System.out.println("Saississez la capacité du lieu");
        int capacity = scanner.nextInt();
        scanner.nextLine();
        Location location = new Location(id, name, address, capacity);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            locationDAO = new LocationDAO(connection);
            if (locationDAO.update(location)) {
                System.out.println("Le lieu a été modifié avec succès");
                connection.commit();
            } else {
                System.out.println("Le lieu n'a pas été modifié");
                location = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 4 - Supprimer un lieu
    private void deleteLieuAction() throws SQLException, ExecutionControl.NotImplementedException {
        System.out.println("Saississez l'id du lieu à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            locationDAO = new LocationDAO(connection);
            if (locationDAO.deleteById(id)) {
                System.out.println("Le lieu a été supprimé avec succès");
                connection.commit();
            } else {
                System.out.println("Le lieu n'a pas été supprimé");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 2 - CRUD Evenement

    private void crudEvenement() throws SQLException, ExecutionControl.NotImplementedException {
        do {
            menuEvenement();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    createEvenementAction();
                    break;
                case "2":
                    showAllEvenementAction();
                    break;
                case "3":
                    updateEvenementAction();
                    break;
                case "4":
                    deleteEvenementAction();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Choix non valide");
            }
        } while (!choix.equals("5"));
    }

    //  Sous Menu Evenement

    private void menuEvenement() {
        System.out.println("-------------------------------");
        System.out.println(" TP Billeterie DAO JDBC");
        System.out.println("-------------------------------");
        System.out.println("***************************************");
        System.out.println("Veuillez choisir une option :");
        System.out.println("***************************************");
        System.out.println("1.Ajouter un evenement");
        System.out.println("2.Afficher la liste des evenements");
        System.out.println("3.Modifier un evenement");
        System.out.println("4.Supprimer un evenement");
        System.out.println("5.Retour");
        System.out.println("***************************************");
    }

    // 1 - Creation evenement

    private void createEvenementAction() throws SQLException, ExecutionControl.NotImplementedException {
        System.out.println("Saississez le nom de l'evenement");
        String nameEvent = scanner.nextLine();
        System.out.println("Saississez la date de l'evenement");
        String date = scanner.nextLine();
        System.out.println("Saississez l'heure de l'evenement");
        String time = scanner.nextLine();
        System.out.println("Saississez l'id du lieu de l'evenement");
        int location = scanner.nextInt();
        System.out.println("Saississez le prix de l'evenement");
        int price = scanner.nextInt();
        System.out.println("Saississez le nombre de tickets vendus");
        int ticketsSold = scanner.nextInt();
        scanner.nextLine();
        Evenement evenement = new Evenement(nameEvent, date, time, location, price, ticketsSold);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            evenementDAO = new EvenementDAO(connection);
            if (evenementDAO.save(evenement)) {
                System.out.println("L'evenement a été enregistré avec succès");
                connection.commit();
            } else {
                System.out.println("L'evenement n'a pas été enregistré");
                evenement = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // 2 - Afficher tous les evenements

    private void showAllEvenementAction() throws SQLException, ExecutionControl.NotImplementedException {
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            evenementDAO = new EvenementDAO(connection);
            System.out.println("Liste des evenements :");
            System.out.println("----------------------");
            for (Evenement evenement : evenementDAO.getAll()) {
                System.out.println("Id : " + evenement.getIdEvent() + " - Nom : " + evenement.getNameEvent() + " - Date : " + evenement.getDate() + " - Heure : " + evenement.getTime() + " - Lieu : " + evenement.getLocation() + " - Prix : " + evenement.getPrice() + " - Tickets vendus : " + evenement.getTicketsSold());
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 3 - Modifier un evenement

    private void updateEvenementAction() throws SQLException, ExecutionControl.NotImplementedException {
        System.out.println("Saississez l'id de l'evenement à modifier");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez le nom de l'evenement");
        String name = scanner.nextLine();
        System.out.println("Saississez la date de l'evenement");
        String date = scanner.nextLine();
        System.out.println("Saississez l'heure de l'evenement");
        String time = scanner.nextLine();
        System.out.println("Saississez l'id du lieu de l'evenement");
        int location = scanner.nextInt();
        System.out.println("Saississez le prix de l'evenement");
        int price = scanner.nextInt();
        System.out.println("Saississez le nombre de tickets vendus");
        int ticketsSold = scanner.nextInt();
        scanner.nextLine();
        Evenement evenement = new Evenement(id, name, date, time, location, price, ticketsSold);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            evenementDAO = new EvenementDAO(connection);
            if (evenementDAO.update(evenement)) {
                System.out.println("L'evenement a été modifié avec succès");
                connection.commit();
            } else {
                System.out.println("L'evenement n'a pas été modifié");
                evenement = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 4 - Supprimer un evenement

    private void deleteEvenementAction() throws SQLException, ExecutionControl.NotImplementedException {
        System.out.println("Liste des evenements :");
        showAllEvenementAction();
        System.out.println("Saississez l'id de l'evenement à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            evenementDAO = new EvenementDAO(connection);
            if (evenementDAO.deleteById(id)) {
                System.out.println("L'evenement a été supprimé avec succès");
                connection.commit();
            } else {
                System.out.println("L'evenement n'a pas été supprimé");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 3 - CRUD Client

    private void crudClient() throws SQLException, ExecutionControl.NotImplementedException {
        do {
            menuClient();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    createClientAction();
                    break;
                case "2":
                    showAllClientAction();
                    break;
                case "3":
                    updateClientAction();
                    break;
                case "4":
                    deleteClientAction();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Choix non valide");
            }
        } while (!choix.equals("5"));
    }

    //  Sous Menu Client

    private void menuClient() {
        System.out.println("-------------------------------");
        System.out.println(" TP Billeterie DAO JDBC");
        System.out.println("-------------------------------");
        System.out.println("***************************************");
        System.out.println("Veuillez choisir une option :");
        System.out.println("***************************************");
        System.out.println("1.Ajouter un client");
        System.out.println("2.Afficher la liste des clients");
        System.out.println("3.Modifier un client");
        System.out.println("4.Supprimer un client");
        System.out.println("5.Retour");
        System.out.println("***************************************");
    }

    // 1 - Creation client

    private void createClientAction() throws SQLException, ExecutionControl.NotImplementedException {
        System.out.println("Saississez le nom du client");
        String name = scanner.nextLine();
        System.out.println("Saississez le prenom du client");
        String firstname = scanner.nextLine();
        System.out.println("Saississez l'email du client");
        String email = scanner.nextLine();
        Client client = new Client(name, firstname, email);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            clientDAO = new ClientDAO(connection);
            if (clientDAO.save(client)) {
                System.out.println("Le client a été enregistré avec succès");
                connection.commit();
            } else {
                System.out.println("Le client n'a pas été enregistré");
                client = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 2 - Afficher la liste des clients

    private void showAllClientAction() throws SQLException, ExecutionControl.NotImplementedException {
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            clientDAO = new ClientDAO(connection);
            System.out.println("Liste des clients :");
            for (Client client : clientDAO.getAll()) {
            if (clientDAO.getAll().isEmpty()) {
                System.out.println("Il n'y a pas de client");
            } else {
                System.out.println("Id : " + client.getIdclient() + " - Nom : " + client.getLastname() + " - Prenom : " + client.getFirstname() + " - Email : " + client.getEmail());
            }
            connection.commit();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 3 - Modifier un client

    private void updateClientAction() throws SQLException, ExecutionControl.NotImplementedException {
        System.out.println("Saississez l'id du client à modifier");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez le nom du client");
        String name = scanner.nextLine();
        System.out.println("Saississez le prenom du client");
        String firstname = scanner.nextLine();
        System.out.println("Saississez l'email du client");
        String email = scanner.nextLine();
        Client client = new Client(id, name, firstname,email);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            clientDAO = new ClientDAO(connection);
            if (clientDAO.update(client)) {
                System.out.println("Le client a été modifié avec succès");
                connection.commit();
            } else {
                System.out.println("Le client n'a pas été modifié");
                client = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 4 - Supprimer un client

    private void deleteClientAction() throws SQLException, ExecutionControl.NotImplementedException {
        System.out.println("Saississez l'id du client à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            clientDAO = new ClientDAO(connection);
            if (clientDAO.deleteById(id)) {
                System.out.println("Le client a été supprimé avec succès");
                connection.commit();
            } else {
                System.out.println("Le client n'a pas été supprimé");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //  3 - Achat de billet pour un événement

    private void buyTicketAction() throws SQLException, ExecutionControl.NotImplementedException {
        showAllClientAction();
        System.out.println("Saississez l'id du client");
        int idClient = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Liste des événements");
        showAllEventAction();
        System.out.println("Saississez l'id de l'événement");
        int idEvent = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez le nombre de billets");
        int nbTickets = scanner.nextInt();
        scanner.nextLine();
        Ticket ticket = new Ticket(idClient, idEvent, nbTickets);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            ticketDAO = new TicketDAO(connection);
            if (ticketDAO.save(ticket)) {

                System.out.println("Le ticket a été enregistré avec succès");
                connection.commit();
            } else {
                System.out.println("Le ticket n'a pas été enregistré");
                ticket = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 5 - Annuler un achat de billet
    private void cancelTicketAction() throws SQLException, ExecutionControl.NotImplementedException {
        showAllTicketAction();
        System.out.println("Saississez l'id du ticket à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            ticketDAO = new TicketDAO(connection);
            if (ticketDAO.deleteById(id)) {
                System.out.println("Le ticket a été supprimé avec succès");
                connection.commit();
            } else {
                System.out.println("Le ticket n'a pas été supprimé");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 6 - Afficher la liste des événemennts disponibles
    private void showAllEventAction() throws SQLException, ExecutionControl.NotImplementedException {
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            evenementDAO = new EvenementDAO(connection);
            locationDAO = new LocationDAO(connection);
            for (Evenement evenement : evenementDAO.getAll()) {
                Location location = locationDAO.getById(evenement.getIdLocation());
                System.out.println("Id Evenement : " + evenement.getIdEvent() + " - Nom de l'évenement :  " + evenement.getNameEvent() + " -  Date et heure de l'évenement  : " + evenement.getDate() + " - " + evenement.getTime() +  " - Lieu de l'évenement : " + location.getName() + " - Nb de billets mis en vente : " + evenement.getTicketsSold() + " - Prix du billet : " + evenement.getPrice() +"€");
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // 7 - Afficher la liste des billes achetés par un client

    private void showAllTicketAction() throws SQLException, ExecutionControl.NotImplementedException {
        showAllClientAction();
        System.out.println("Saississez l'id du client");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            ticketDAO = new TicketDAO(connection);
            evenementDAO = new EvenementDAO(connection);
            System.out.println("Voici la liste des tickets achetés par le client : " + clientDAO.getById(id).getFirstname() + " - " + clientDAO.getById(id).getFirstname());
            for (Ticket ticket : ticketDAO.getAll()) {
                if (ticket.getIdClient() == id) {
                    for (Evenement evenement : evenementDAO.getAll()) {
                        if (evenement.getIdEvent() == ticket.getIdEvent()) {
                            System.out.println("Id vente : " + ticket.getId()+ " - Id Client :" + ticket.getIdClient() + " -  Nom de l'évenement : " + evenement.getNameEvent() + " -  nombre de billets achetes : " + ticket.getNbTickets() + "- Prix du billet : " + ticket.getNbTickets() * (evenement.getPrice()) + "€");
                        }
                    }
                }
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
