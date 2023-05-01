package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Billeterie {

    private String nom;

    private static List<Evenement> evenementList;

    private static List<Client> clientList;

    private static List<Lieu> lieuList;

    public Billeterie(String nom) {
        this.nom = nom;
        this.evenementList = new ArrayList<>();
        this.clientList = new ArrayList<>();
        this.lieuList = new ArrayList<>();
    }


    public static void addClient(Client client) {
        clientList.add(client);
    }

    public static List<Client> getClientList() {
        return clientList;
    }




    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static List<Evenement> getEvenementList() {
        return evenementList;
    }

    public void setEvenementList(List<Evenement> evenementList) {
        this.evenementList = evenementList;
    }

    public static void setClientList(List<Client> clientList) {
        Billeterie.clientList = clientList;
    }

    public static List<Lieu> getLieuList() {
        return lieuList;
    }

    public void setLieuList(List<Lieu> lieuList) {
        this.lieuList = lieuList;
    }


    public static void getLieu() {
        for (Lieu lieu : Billeterie.getLieuList()) {
            System.out.println("******************");
            System.out.println("Id Lieu : " + lieu.getId());
            System.out.println("Nom Lieu : " + lieu.getNom());
            System.out.println("Adresse Lieu : " + lieu.getAdresse());
            System.out.println("******************");
        }
    }
    public static void showEvenementList() {
        System.out.println("Liste des évènements :");
        for (Evenement evenement : Billeterie.getEvenementList()) {
            System.out.println("******************");
            System.out.println("Id Evenement : " + evenement.getId());
            System.out.println("Nom Evenement : " + evenement.getNomEvenement());
            System.out.println("Date Evenement : " + evenement.getDateEvenement());
            System.out.println("Heure Evenement : " + evenement.getHeureEvenement());
            System.out.println("Lieu Evenement : " + evenement.getLieuEvenement().getNom());
            System.out.println("******************");
        }
    }

    public static void showClientList() {
        System.out.println("Liste des clients :");
        for (Client client : Billeterie.getClientList()) {
            System.out.println("******************");
            System.out.println("Id Client : " + client.getId());
            System.out.println("Nom Client : " + client.getNom());
            System.out.println("Prenom Client : " + client.getPrenom());
            System.out.println("Email Client : " + client.getEmail());
            System.out.println("******************");
            }
        }
    }

