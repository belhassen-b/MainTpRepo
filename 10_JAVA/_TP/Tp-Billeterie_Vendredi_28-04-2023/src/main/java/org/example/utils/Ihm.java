package org.example.utils;

import org.example.dao.LieuDAO;
import org.example.entity.Billeterie;
import org.example.entity.Client;
import org.example.entity.Evenement;
import org.example.entity.Lieu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Ihm {
    Scanner sc = new Scanner(System.in);
    private Billeterie billeterie;
    private boolean continuer;
    private Evenement evenement;
    private LocalDate dateEvenement;

    public Ihm() {   }

    public Ihm(Billeterie billeterie) {
        this.billeterie = new Billeterie("Billeterie");
        this.continuer = true;
    }

    public void run() {
        System.out.println("**************  Bienvenue ***************");
        System.out.println("Application de gestion de billetterie");
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
        int choix = sc.nextInt();
        switch (choix) {
            case 1:
                menuLieu();
                break;
            case 2:
                menuEvenement();
                break;
            case 3:
                menuClient();
                break;
            case 4:
                menuBillet();
                break;
            case 5:
                menuAnnulerBillet();
                break;
            case 6:
                menuAfficherEvenement();
                break;
            case 7:
                menuAfficherBilletsClient();
                break;
            case 9:
                System.out.println("Quitter");
                break;
            default:
                System.out.println("Veuillez saisir un chiffre entre 1 et 9");
                break;
        }
    }



    private void menuAfficherBilletsClient() {
        System.out.println("Afficher la liste des billets achetés par un client");
        Client.showClientList();
        run();
    }

    private void menuAfficherEvenement() {
        System.out.println("Afficher la liste des événements disponibles");
        billeterie.showEvenementList();
        run();
    }

    public void menuLieu() {
        System.out.println("Ajouter, modifier et supprimer des lieux");
        System.out.println("1.Ajouter un lieu");
        System.out.println("2.Modifier un lieu");
        System.out.println("3.Supprimer un lieu");
        System.out.println("4.Retour au menu");
        System.out.println("5.Quitter");
        int choixLieu = sc.nextInt();
        sc.nextLine();
        switch (choixLieu) {
            case 1:
                System.out.println("Ajouter un lieu");
                System.out.println("Veuillez saisir le nom du lieu");
                String nomLieu = sc.nextLine();
                System.out.println("Veuillez saisir l'adresse du lieu");
                String adresseLieu = sc.nextLine();
                System.out.println("Veuillez saisir la capacité du lieu");
                try {
                    int capaciteLieu = sc.nextInt();
                    if (capaciteLieu < 0) {
                        System.out.println("Veuillez saisir un nombre positif");
                        run();
                    }
                    sc.nextLine();
                    Lieu lieu = new Lieu(nomLieu, adresseLieu, capaciteLieu);
                    try {
                        connection = new DataBaseManager().getConnection();
                        connection.setAutoCommit(false);
                        LieuDAO lieuDAO = new LieuDAO(connection);
                        if(lieuDAO.create(lieu)){
                            connection.commit();
                            System.out.println("Le lieu a bien été ajouté");
                    }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Le lieu n'a pas été ajouté");
                        try {
                            connection.rollback();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                break;
            case 2:
                System.out.println("Modifier un lieu");
                System.out.println("Veuillez saisir le lieu à modifier");
                if (billeterie.getLieuList().isEmpty()) {
                    System.out.println("Il n'y a pas de lieu à modifier");
                    run();
                }
                billeterie.getLieu();
                int lieuAModifier = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez saisir le nouveau nom du lieu");
                String nouveauNomLieu = sc.nextLine();
                System.out.println("Veuillez saisir la nouvelle adresse du lieu");
                String nouvelleAdresseLieu = sc.nextLine();
                System.out.println("Veuillez saisir la nouvelle capacité du lieu");
                int nouvelleCapaciteLieu = sc.nextInt();
                Lieu lieuModifie = new Lieu(nouveauNomLieu, nouvelleAdresseLieu, nouvelleCapaciteLieu);
                billeterie.getLieuList().set(lieuAModifier, lieuModifie);
                System.out.println("Le lieu a bien été modifié");
                run();
                break;
            case 3:
                System.out.println("Supprimer un lieu");
                System.out.println("Veuillez saisir le lieu à supprimer");
                if (billeterie.getLieuList().isEmpty()) {
                    System.out.println("Il n'y a pas de lieu à supprimer");
                    run();
                }
                billeterie.getLieu();
                int lieuASupprimer = sc.nextInt();
                sc.nextLine();
                billeterie.getLieuList().remove(lieuASupprimer);
                System.out.println("Le lieu a bien été supprimé");
                run();
                break;
            case 4:
                System.out.println("Retour au menu");
                run();
                break;
            case 5:
                System.out.println("Quitter");
                break;
            default:
                System.out.println("Veuillez saisir un chiffre entre 1 et 5");
                break;
        }
    }

    public void menuEvenement() {
        System.out.println("Ajouter, modifier et supprimer des événements");
        System.out.println("1.Ajouter un événement");
        System.out.println("2.Modifier un événement");
        System.out.println("3.Supprimer un événement");
        System.out.println("4.Retour au menu");
        System.out.println("5.Quitter");
        int choixEvenement = sc.nextInt();
        sc.nextLine();
        switch (choixEvenement) {
            case 1:
                System.out.println("Ajouter un événement");
                System.out.println("Veuillez saisir le nom de l'événement");
                String nomEvenement = sc.nextLine();
                System.out.println("Veuillez saisir la date de l'événement (format : dd/MM/yyyy)");
                LocalDate dateEvenement =  LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                try {
//                    LocalDate dateEvenement =  LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                } catch (Exception e) {
//                    System.out.println("Veuillez saisir une date valide");
//                    menuEvenement();
//                }
                System.out.println("Veuillez saisir l'heure de l'événement (format : HH:mm)");

                LocalTime heureEvenement = LocalTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
//                try {
//                    LocalTime heureEvenement = LocalTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
//                } catch (Exception e) {
//                    System.out.println("Veuillez saisir une heure valide");
//                    menuEvenement();
//                }

                System.out.println("Veuillez saisir le lieu de l'événement");
                System.out.println("Liste des lieux disponibles : ");
                billeterie.getLieu();
                int idlieuEvenement = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez saisir le tarif de l'événement");
                double tarifEvenement = sc.nextDouble();
                sc.nextLine();
                Evenement evenement = new Evenement(nomEvenement, dateEvenement, heureEvenement, billeterie.getLieuList().get(idlieuEvenement), tarifEvenement);
                billeterie.getEvenementList().add(evenement);
                System.out.println("L'événement a bien été ajouté");
                run();
                break;
            case 2:
                System.out.println("Modifier un événement");
                System.out.println("Veuillez saisir l'Id de l'événement à modifier");
                billeterie.getEvenementList().forEach(System.out::println);
                billeterie.showEvenementList();
                int indexEvenement = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez saisir le nouveau nom de l'événement");
                String nouveauNomEvenement = sc.nextLine();
                System.out.println("Veuillez saisir la nouvelle date de l'événement");
                LocalDate nouvelleDateEvenement = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.println("Veuillez saisir la nouvelle heure de l'événement");
                LocalTime nouvelleHeureEvenement = LocalTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
                System.out.println("Veuillez saisir le nouveau lieu de l'événement");
                billeterie.getLieuList().forEach(System.out::println);
                int nouveauIDLieuEvenement = sc.nextInt();
                System.out.println("Veuillez saisir le nouveau tarif de l'événement");
                double nouveauTarifEvenement = sc.nextDouble();
                Evenement evenementModifie = new Evenement(nouveauNomEvenement, nouvelleDateEvenement, nouvelleHeureEvenement, billeterie.getLieuList().get(nouveauIDLieuEvenement), nouveauTarifEvenement);
                billeterie.getEvenementList().set(indexEvenement, evenementModifie);
                System.out.println("L'événement a bien été modifié");
                run();
                break;
            case 3:
                System.out.println("Supprimer un événement");
                System.out.println("Veuillez saisir l'id de l'événement à supprimer");
                billeterie.showEvenementList();
                billeterie.getEvenementList().remove(sc.nextLine());
                System.out.println("L'événement a bien été supprimé");
                run();
                break;
            case 4:
                System.out.println("Retour au menu");
                run();
                break;
            case 5:
                System.out.println("Quitter");
                break;
        }
    }

    public void menuClient() {
        System.out.println("Ajouter, modifier et supprimer des clients");
        System.out.println("1.Ajouter un client");
        System.out.println("2.Modifier un client");
        System.out.println("3.Supprimer un client");
        System.out.println("4.Retour au menu");
        System.out.println("5.Quitter");
        int choixClient = sc.nextInt();
        sc.nextLine();
        switch (choixClient) {
            case 1:
                System.out.println("Ajouter un client");
                System.out.println("Veuillez saisir le nom du client");
                String nomClient = sc.nextLine();
                System.out.println("Veuillez saisir le prénom du client");
                String prenomClient = sc.nextLine();
                System.out.println("Veuillez saisir l'adresse mail du client");
                String emailClient = sc.nextLine();
                Client client = new Client(nomClient, prenomClient, emailClient);
                Billeterie.getClientList().add(client);
                System.out.println("Le client a bien été ajouté");
                run();
                break;
            case 2:
                System.out.println("Modifier un client");
                System.out.println("Veuillez saisir l'Id du client à modifier");
                if (Billeterie.getClientList().isEmpty()) {
                    System.out.println("Il n'y a pas de client à modifier");
                    run();
                }
                billeterie.showClientList();
                int indexClient = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez saisir le nouveau nom du client");
                String nouveauNomClient = sc.nextLine();
                System.out.println("Veuillez saisir le nouveau prénom du client");
                String nouveauPrenomClient = sc.nextLine();
                System.out.println("Veuillez saisir la nouvelle adresse mail du client");
                String nouveauEmailClient = sc.nextLine();
                Client clientModifie = new Client(nouveauNomClient, nouveauPrenomClient, nouveauEmailClient);
                Billeterie.getClientList().set(indexClient, clientModifie);
                System.out.println("Le client a bien été modifié");
                run();
                break;
            case 3:
                System.out.println("Supprimer un client");
                System.out.println("Veuillez saisir l'id du client à supprimer");
                if (Billeterie.getClientList().isEmpty()) {
                    System.out.println("Il n'y a pas de client à supprimer");
                    run();
                }else {
                Billeterie.showClientList();
                int indexClientSupprime = sc.nextInt();
                sc.nextLine();
                Billeterie.getClientList().remove(indexClientSupprime);
                System.out.println("Le client a bien été supprimé");
                run();
                }
                break;
            case 4:
                System.out.println("Retour au menu");
                run();
                break;
            case 5:
                System.out.println("Quitter");
                break;
            default:
                System.out.println("Veuillez saisir un chiffre entre 1 et 5");
                break;
        }

    }

    public void menuBillet() {
        System.out.println("Acheter des billets pour un événement");
        System.out.println("1.Acheter un billet");
        System.out.println("2.Retour au menu");
        System.out.println("3.Quitter");
        int choixBillet = sc.nextInt();
        switch (choixBillet) {
            case 1:
                System.out.println("Acheter un billet");
                System.out.println("Veuillez saisir l'id de l'événement");
                billeterie.showEvenementList();
                int indexEvenementTicket = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez saisir l'id du client");
                Billeterie.showClientList();
                int indexClientTicket = sc.nextInt();
                sc.nextLine();
                Client clientTicket = Billeterie.getClientList().get(indexClientTicket);
                Evenement evenementTicket = billeterie.getEvenementList().get(indexEvenementTicket);
                Evenement.sellTicket(evenementTicket, clientTicket);
                run();
                break;
            case 2:
                System.out.println("Retour au menu");
                run();
                break;
            case 3:
                System.out.println("Quitter");
                break;
            default:
                System.out.println("Veuillez saisir un chiffre entre 1 et 4");
                break;
        }
    }

    public void menuAnnulerBillet() {
        System.out.println("Annuler un achat de billet");
        System.out.println("1.Annuler un achat de billet");
        System.out.println("2.Retour au menu");
        System.out.println("3.Quitter");
        int choixAnnuler = sc.nextInt();
        switch (choixAnnuler) {
            case 1:
                System.out.println("Annuler un achat de biller");
                System.out.println("Veuillez saisir l'id de l'événement");
                billeterie.showEvenementList();
                int indexEvenementAnnuler = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez saisir l'id du client");
                billeterie.showClientList();
                int indexClientAnnuler = sc.nextInt();
                sc.nextLine();
                Billeterie.getClientList().get(indexClientAnnuler).getBillets().remove(indexEvenementAnnuler);
            System.out.println("Le billet a bien été annulé");
                break;
            case 2:
                System.out.println("Retour au menu");
                run();
                break;
            case 3:
                System.out.println("Quitter");
                break;
            default:
                System.out.println("Veuillez saisir un chiffre entre 1 et 3");
                break;
        }
    }
}
