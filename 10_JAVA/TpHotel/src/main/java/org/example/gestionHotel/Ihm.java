package org.example.gestionHotel;

import java.util.Scanner;

public class Ihm {
    Scanner sc = new Scanner(System.in);
    private Hotel hotel;
    private boolean continuer;

    public Ihm(Hotel hotel) {
        this.hotel = hotel;
        this.continuer = true;
    }

    public void afficherMenu() {
        System.out.println("==============================");
        System.out.println("Hôtel " + hotel.getNomHotel() + " - Gestion des réservations");
        System.out.println("==============================");
        System.out.println("1- Ajouter un client");
        System.out.println("2- Afficher la liste des clients");
        System.out.println("3- Afficher les réservations d'un client");
        System.out.println("4- Ajouter une réservation");
        System.out.println("5- Annuler une réservation");
        System.out.println("6- Afficher la liste des réservations");
        System.out.println("0- Quitter");
        System.out.println("==============================");
        System.out.print("Votre choix : ");
    }

    private void ajouterClient() {
        System.out.println("==== Ajouter un client ====");
        System.out.println();
        System.out.println("Merci de saisir le nom : ");
        sc.nextLine();
        String nomClient = sc.nextLine();
        System.out.println("Merci de saisir le prénom : ");
        String prenomClient = sc.nextLine();
        System.out.println("Merci de saisir le numéro de téléphone : ");
        String numTel = sc.nextLine();
        hotel.ajouterClient(nomClient, prenomClient, numTel);
        System.out.println("Le client a bien été ajouté");
    }

    private void listeClient() {
        System.out.println("==== Afficher la liste des clients ====");
        hotel.afficherListeClients();
    }

    private void afficherResaClient() {
        System.out.println("==== Afficher les réservations d'un client ====");
        System.out.println();
        System.out.println("Merci de saisir le numéro de téléphone du client : ");
        sc.nextLine();
        String numTel = sc.nextLine();
        hotel.afficherResaClient(numTel);
    }

    private void ajouterResa() {
        System.out.println("==== Ajouter une réservation ====");
        System.out.println();
        System.out.println("Merci de saisir le numéro de téléphone du client : ");
        sc.nextLine();
        String numTel = sc.nextLine();
        System.out.println("Merci de saisir le nombre de personnes : ");
        int capacite = sc.nextInt();
        hotel.ajouterResa(numTel, capacite);
    }

    private void annulerResa() {
        System.out.println("==== Annuler une réservation ====");
        System.out.println();
        System.out.println("Merci de saisir le numéro de réservation : ");
        int idReservation = sc.nextInt();
        hotel.annulerReservation(idReservation);
    }

    private void afficherResa(){
        System.out.println("==== Afficher la liste des réservations ====");
        hotel.afficherResa();
    }

    public void lancer(){
        System.out.println("==== Gestion de l'Hôtel ====");
        while (continuer){
            afficherMenu();
        int choix = sc.nextInt();
        switch (choix){
            case 0 :
                continuer = false;
                break;
            case 1 :
                ajouterClient();
                break;
            case 2 :
                listeClient();
                break;
            case 3 :
                afficherResaClient();
                break;
            case 4 :
                ajouterResa();
                break;
            case 5 :
                annulerResa();
                break;
            case 6 :
                afficherResa();
                break;
            default:
                System.out.println("Choix invalide !");
        }
        }

    }


}

