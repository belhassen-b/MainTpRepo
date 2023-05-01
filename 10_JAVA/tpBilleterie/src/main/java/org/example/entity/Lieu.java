package org.example.entity;

public class Lieu {

    private static int idLieu = 0;
    private String nom;
    private String adresse;
    private int capacite;

    private int id;
    public Lieu() {
    }

    public Lieu(String nom, String adresse, int capacite) {
        this.nom = nom;
        this.adresse = adresse;
        this.capacite = capacite;
        this.id = idLieu++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Lieu{" +
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", capacite=" + capacite +
                ", id=" + id +
                '}';
    }
}
