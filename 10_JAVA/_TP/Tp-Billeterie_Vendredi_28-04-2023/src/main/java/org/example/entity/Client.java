package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class Client {

    private static int idClient = 0;
    private String nom;
    private String prenom;
    private String email;
    private  List<Evenement> billets;

    private int id;
    public Client(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.billets = new ArrayList<>();
        this.id = idClient++;
    }

    public static void showClientList() {
        System.out.println("Liste des clients :");
        for (Client client : Billeterie.getClientList()) {
            System.out.println(client);
            System.out.println("Billets :");
            for (Evenement evenement : client.getBillets()) {
                System.out.println(evenement);
            }
        }
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Evenement> getBillets() {
        return billets;
    }

    public void setBillets(List<Evenement> billets) {
        this.billets = billets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", billets=" + billets +
                ", id=" + id +
                '}';
    }

    public  static void buyTicket(Evenement evenement, Client client){
        if (evenement.isAvailable()){
            client.getBillets().add(evenement);
            evenement.isAvailable();
        }

  }



    public static  void cancelBuyingTicket(Evenement evenement, Client client){
    if(Evenement.cancelTicket(evenement)){
        client.getBillets().remove(evenement);
    }
    }


}
