package org.example.gestionHotel;

public class Chambre {

    private int idChambre;

    private boolean statut;

    private double tarif;

    private int capacite;

    public Chambre(){

    }

    public Chambre(int idChambre, boolean statut, double tarif, int capacite) {
        this.idChambre = idChambre;
        this.statut = statut;
        this.tarif = tarif;
        this.capacite = capacite;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
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

    @Override
    public String toString() {
        return "Chambre{" +
                "idChambre=" + idChambre +
                ", statut=" + statut +
                ", tarif=" + tarif +
                ", capacite=" + capacite +
                '}';
    }
}
