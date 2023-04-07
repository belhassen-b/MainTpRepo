package org.example.ex113;

import org.example.ex113.enums.Etat;
import org.example.ex113.enums.Unite;

import java.util.Objects;

public class Ingredient {

    private int id;
    private String nom_aliment;
    private Etat etat;
    private Unite unite;
    private int quantite;


    public Ingredient() {
    }

    public Ingredient(int id,String nom_aliment, Etat etat, Unite unite, int quantite) {
        this.id = id;
        this.nom_aliment = nom_aliment;
        this.etat = etat;
        this.unite = unite;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_aliment() {
        return nom_aliment;
    }

    public void setNom_aliment(String nom_aliment) {
        this.nom_aliment = nom_aliment;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient that)) return false;
        return Objects.equals(getNom_aliment(), that.getNom_aliment()) && getEtat() == that.getEtat();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom_aliment(), getEtat(), getUnite(), getQuantite());
    }
    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                "nom_aliment='" + nom_aliment + '\'' +
                ", etat=" + etat +
                ", unite=" + unite +
                ", quantite=" + quantite +
                '}';
    }
    public void cuire() {
        if (this.etat == Etat.CRU) {
            this.etat = Etat.CUIT;
        }
    }
    public void decouper() {
        if (this.etat == Etat.ENTIER) {
            this.etat = Etat.DECOUPE;
        }
    }
}