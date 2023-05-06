package org.example.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evenement {

    private static int idEvenement = 0;
    private String nomEvenement;
    private LocalDate dateEvenement;
    private LocalTime heureEvenement;
    private Lieu lieuEvenement;
    private double tarifEvenement;
    private int nbPlacesVendues;

    private int id;




    public Evenement(String nomEvenement, LocalDate dateEvenement, LocalTime heureEvenement, Lieu lieuEvenement, double tarifEvenement) {
        this.nomEvenement = nomEvenement;
        this.dateEvenement = dateEvenement;
        this.heureEvenement = heureEvenement;
        this.lieuEvenement = lieuEvenement;
        this.tarifEvenement = tarifEvenement;
        this.id = idEvenement++;
    }



    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public LocalDate getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(LocalDate dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public LocalTime getHeureEvenement() {
        return heureEvenement;
    }

    public void setHeureEvenement(LocalTime heureEvenement) {
        this.heureEvenement = heureEvenement;
    }

    public Lieu getLieuEvenement() {
        return lieuEvenement;
    }

    public void setLieuEvenement(Lieu lieuEvenement) {
        this.lieuEvenement = lieuEvenement;
    }

    public double getTarifEvenement() {
        return tarifEvenement;
    }

    public void setTarifEvenement(double tarifEvenement) {
        this.tarifEvenement = tarifEvenement;
    }

    public int getNbPlacesVendues() {
        return nbPlacesVendues;
    }

    public void setNbPlacesVendues(int nbPlacesVendues) {
        this.nbPlacesVendues = nbPlacesVendues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "nomEvenement='" + nomEvenement + '\'' +
                ", dateEvenement=" + dateEvenement +
                ", heureEvenement='" + heureEvenement + '\'' +
                ", lieuEvenement=" + lieuEvenement +
                ", tarifEvenement=" + tarifEvenement +
                ", nbPlacesVendues=" + nbPlacesVendues +
                ", id=" + id +
                '}';
    }


    public boolean isAvailable() {
        return this.lieuEvenement.getCapacite() > this.nbPlacesVendues;
    }

    public static void sellTicket(Evenement event, Client client) {
        if (event.isAvailable()) {
            event.nbPlacesVendues++;
           client.getBillets().add(event);
        } else {
            System.out.println("Plus de place disponible!");
        }
    }

    public static boolean cancelTicket(Evenement event) {
        if (event.getDateEvenement().isAfter(LocalDate.now())) {
            event.nbPlacesVendues--;
            return true;
        } else {
            System.out.println("Impossible d'annuler le billet");
            return false;
        }
    }
}
