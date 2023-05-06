package org.example.gestionHotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hotel {

    private String nomHotel;

    List<Chambre> listeChambres;

    List<Reservation> listeReservations;
    List<Client> listeClients;


    public Hotel() {
    }

    public Hotel(String nomHotel) {
        this.nomHotel = nomHotel;
        this.listeChambres = new ArrayList<>();
        this.listeReservations = new ArrayList<>();
        this.listeClients = new ArrayList<>();

        Random rdm = new Random();
        for (int i = 1; i <= 20; i++) {
            double tarif = 50.0 + 50.0 * rdm.nextFloat();
            int capacite = 1 + rdm.nextInt(3);
            listeChambres.add(new Chambre(i, tarif, capacite));
        }

    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public List<Chambre> getListeChambres() {
        return listeChambres;
    }

    public void setListeChambres(List<Chambre> listeChambres) {
        this.listeChambres = listeChambres;
    }

    public List<Reservation> getListeReservations() {
        return listeReservations;
    }

    public void setListeReservations(List<Reservation> listeReservations) {
        this.listeReservations = listeReservations;
    }

    public List<Client> getListeClients() {
        return listeClients;
    }

    public void setListeClients(List<Client> listeClients) {
        this.listeClients = listeClients;
    }

    public void ajouterClient(String nom, String prenom, String numTel) {
        this.listeClients.add(new Client(nom, prenom, numTel));
    }

    public void afficherListeClients() {
        if (listeClients.size() == 0) {
            System.out.println("Aucun client enregistré !");
        } else {
            System.out.println("La liste des clients : ");
            for (Client client : listeClients) {
                client.afficherDetail();
            }
        }
    }

    public void afficherResaClient(String numTel) {
        Client client = rechercherClient(numTel);
        if (client == null) {
            System.out.println("Aucun client trouvé avec l'identifiant ! " + numTel);
        } else {
            client.afficherDetail();
        }
    }

    public void ajouterResa(String numTel, int capacite) {
        Client client = rechercherClient(numTel);
        if (client == null) {
            System.out.println("Aucun client trouvé avec l'identifiant ! " + numTel);
            return;
        }
        Chambre chambre = rechercherChambre(capacite);
        if (chambre == null) {
            System.out.println("Aucune chambre libre pour cette capacité ! " + capacite);
            return;
        }
        int idReservation = listeReservations.size() + 1;
        Reservation reservation = new Reservation(idReservation, chambre, client);
        listeReservations.add(reservation);
        client.ajouterResaClient(reservation);
        System.out.println("Réservation effectuée ! ");
    }

    public void annulerReservation(int idReservation){
        Reservation reservation = rechercherResa(idReservation);
        if(reservation == null){
            System.out.println("Aucune réservation trouvée !");
            return;
        }
        reservation.annuler();
        listeReservations.remove(reservation);
        reservation.getClient().ajouterResaClient(reservation);
        System.out.println("La réservation a été annulé ! ");
    }

    public void afficherResa(){
        if(listeReservations.size() == 0){
            System.out.println("Aucune réservation enregistrée !");
        }
        else {
            for (Reservation reservation : listeReservations) {
                reservation.afficherDetail();
            }
        }
    }

    private Client rechercherClient(String numTel) {
        for (Client client : listeClients) {
            if (client.getNumTel().equals(numTel)) {
                return client;
            }
        }
        return null;
    }

    private Chambre rechercherChambre(int capacite){
        for(Chambre chambre : listeChambres){
            if (chambre.getCapacite() >= capacite && chambre.estLibre()){
                return chambre;
            }
        }
        return null;
    }

    private Reservation rechercherResa(int idReservation){
        for(Reservation reservation : listeReservations){
            if(reservation.getIdReservation() == idReservation){
                return reservation;
            }
        }
        return null;
    }

}
