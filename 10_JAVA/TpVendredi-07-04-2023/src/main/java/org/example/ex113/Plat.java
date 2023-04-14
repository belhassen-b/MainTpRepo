package org.example.ex113;

import java.util.Arrays;
import java.util.Scanner;

public class Plat {

    private int idPlat;
    private String nomPlat;
    private Ingredient[] ingredients;

    public Plat() {
    }

    public Plat(int idPlat, String nomPlat, Ingredient[] ingredients) {
        this.idPlat = idPlat;
        this.nomPlat = nomPlat;
        this.ingredients = ingredients;
    }

    public int getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(int id) {
        this.idPlat = idPlat;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plat plat)) return false;
        return Arrays.equals(getIngredients(), plat.getIngredients());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getIngredients());
    }

}
