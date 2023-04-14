package org.example.ex113;

import org.example.ex113.enums.Etat;
import org.example.ex113.enums.Unite;

import java.util.Objects;

public class Ingredient {

    private int idIngredient;
    private String nomIngredient;
    private Etat etat;
    private Unite unite;
    private int quantite;


    public Ingredient(int idIngredient, String nomIngredient, String etat, String unite, int quantite) {
    }

    public Ingredient(int idIngredient, String nomIngredient, Etat etat, Unite unite, int quantite) {
        this.idIngredient = idIngredient;
        this.nomIngredient = nomIngredient;
        this.etat = etat;
        this.unite = unite;
        this.quantite = quantite;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
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
        return Objects.equals(getNomIngredient(), that.getNomIngredient()) && getEtat() == that.getEtat();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNomIngredient(), getEtat(), getUnite(), getQuantite());
    }

    @Override
    public String toString() {
        return "Ingredient{" + "idIngredient=" + idIngredient + "nomIngredient='" + nomIngredient + '\'' + ", etat=" + etat + ", unite=" + unite + ", quantite=" + quantite + '}';
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