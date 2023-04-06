package org.example.gestionHotel;

import org.example.gestionHotel.enums.Statut;

public class Chambre {
    private int idChambre;
    private double tarif;
    private int capacite;

    private Statut statut;

    public Chambre() {
    }

    public Chambre(int idChambre, double tarif, int capacite) {
        this.idChambre = idChambre;
        this.tarif = tarif;
        this.capacite = capacite;
        this.statut = Statut.STATUT_LIBRE;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }


    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void afficherDetail(){
        System.out.println("Chambre " + idChambre + " (" + statut + ") : " + capacite + " personne(s) - " + tarif + " €/nuit");
    }

    public boolean estLibre(){
        return statut.equals(Statut.STATUT_LIBRE);
    }

    public void occuper(){
        statut = Statut.STATUT_OCCUPE;
    }

    public void liberer(){
        statut = Statut.STATUT_LIBRE;
    }

    @Override
    public String toString() {
        return "Chambre{" +
                "idChambre=" + idChambre +
                ", tarif=" + tarif +
                ", capacite=" + capacite +
                '}';
    }
}
