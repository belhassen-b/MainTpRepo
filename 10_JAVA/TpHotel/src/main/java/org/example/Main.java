package org.example;

import org.example.gestionHotel.Chambre;
import org.example.gestionHotel.Client;
import org.example.gestionHotel.Reservation;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Client> listeClients = new ArrayList<>();
        Client client0 = new Client("MichMich", "Polo", "0606060606");
        Client client1 = new Client("Chantal", "Tor", "0606060607");
        Client client2 = new Client("Toto", "Titi", "0606060608");
        List<Reservation> listeReservations = new ArrayList<>();
        Reservation reservation0 = new Reservation(1, true, "0606060606", 1, 1, 1, true);
        Reservation reservation1 = new Reservation( 2, true, "0606060607", 2, 2, 2, true);
        List< Chambre> listeChambres = new ArrayList<>();
        Chambre chambre = new Chambre(1, true, 100, 2);
        Chambre chambre1 = new Chambre(2, true, 200, 4);
        Chambre chambre2 = new Chambre(3, true, 300, 6);
        Chambre chambre3 = new Chambre(4, true, 400, 8);



            listeClients.add(client0);
            listeClients.add(client1);
            listeClients.add(client2);
            listeReservations.add(reservation0);
            listeReservations.add(reservation1);
            listeChambres.add(chambre);
            listeChambres.add(chambre1);
            listeChambres.add(chambre2);
            listeChambres.add(chambre3);

            Scanner sc = new Scanner(System.in);
            System.out.println("==== Gestion de l'Hôtel ====");
            System.out.println();

            String[] propositions = {"1- Ajouter un client", "2- Afficher la liste des clients", "3. Afficher les réservations d'un client ",
                    "4- Ajouter une réservation", "5- Annuler une réservation", "6- Afficher la liste des réservations" ,
                    "0- Quitter", "Entrez votre choix : "};

            for (String prop : propositions) {
                System.out.println(prop);
            }

            String answer = sc.next();

            switch (answer) {
                case "1":
                    System.out.println("==== Ajouter un client ====");
                    System.out.println();
                    System.out.println("Merci de saisir le nom : ");
                    sc.nextLine();
                    String nomClient = sc.nextLine();
                    System.out.println("Merci de saisir le prénom : ");
                    String prenomClient = sc.nextLine();
                    System.out.println("Merci de saisir le numéro de téléphone : ");
                    String telephone = sc.nextLine();
                    String numTelClientReservation = null;
                    Client client = new Client(nomClient, prenomClient, numTelClientReservation);
                    listeClients.add(client);
                    System.out.println("Le client a bien été ajouté");

//                    proposition();

                case "2":
                    System.out.println("==== Afficher la liste des clients ====");
                    System.out.println();
                    for (Client c : listeClients) {
                        System.out.println(c);
                    }

//                    proposition();

                case "3":
                    System.out.println("==== Afficher les réservations d'un client ====");
                    System.out.println();
                    System.out.println("Merci de saisir le numéro de téléphone du client : ");
                    sc.nextLine();
                    String numTelClient = sc.nextLine();
                    for (Reservation r : listeReservations) {
                        if (r.getNumTelClientReservation().equals(numTelClient)) {
                            System.out.println(r);
                        }
                    }
//                    proposition();

                case "4":
                    System.out.println("==== Ajouter une réservation ====");
                    System.out.println();
                    System.out.println("Merci de saisir le numéro de téléphone du client : ");
                    sc.nextLine();
                    numTelClientReservation = sc.nextLine();
                    System.out.println("Merci de saisir le numéro de la chambre : ");
                    int numChambreReservation = sc.nextInt();
                    System.out.println("Merci de saisir le nombre de personnes : ");
                    int nbPersonnes = sc.nextInt();
                    Reservation reservation = new Reservation(1, true, numTelClientReservation, numChambreReservation, nbPersonnes, 1, true);
                    listeReservations.add(reservation);
                    System.out.println("La réservation a bien été ajoutée");
//                    proposition();

                case "5":
                    System.out.println("==== Annuler une réservation ====");
                    System.out.println();
                    System.out.println("Merci de saisir le numéro de téléphone du client : ");
                    sc.nextLine();
                    String numTelClientReservationAnnulation = sc.nextLine();
                    System.out.println("Merci de saisir le numéro de la chambre : ");
                    int numChambreReservationAnnulation = sc.nextInt();
                    for (Reservation r : listeReservations) {
                        if (r.getNumTelClientReservation().equals(numTelClientReservationAnnulation) && r.getNumChambreReservation() == numChambreReservationAnnulation) {
                            r.isStatutReservation();
                            System.out.println("La réservation a bien été annulée");
                        }
                    }
//                    proposition();

                case "6":
                    System.out.println("==== Afficher la liste des réservations ====");
                    System.out.println();
                    for (Reservation r : listeReservations) {
                        System.out.println(r);
                    }
//                    proposition();


                case "0":
                    break;

                default:
                    System.out.println("Je n'ai pas compris votre demande ");
//                    proposition();
            }
        }
}