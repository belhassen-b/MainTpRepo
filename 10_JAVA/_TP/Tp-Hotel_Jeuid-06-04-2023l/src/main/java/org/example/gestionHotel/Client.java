package org.example.gestionHotel;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String nomClient;
    private String prenomClient;
    private String numTel;

    private List<Reservation> reservations;

    public Client() {
    }

    public Client(String nomClient, String prenomClient, String numTel) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.numTel = numTel;
        this.reservations = new ArrayList<>();
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void afficherDetail(){
        System.out.println(nomClient + " " + prenomClient + " (" + numTel + ")");
        if (reservations.size() == 0) {
            System.out.println("Aucune réservation");
        } else {
            System.out.println("Réservations :");
            for (Reservation res : reservations) {
                res.afficherDetail();
            }
        }
    }

    public void ajouterResaClient(Reservation reservation){
        reservations.add(reservation);
    }

    @Override
    public String toString() {
        return "Client{" +
                ", nomClient='" + nomClient + '\'' +
                ", prenomClient='" + prenomClient + '\'' +
                ", numTel='" + numTel + '\'' +
                '}';
    }
}
