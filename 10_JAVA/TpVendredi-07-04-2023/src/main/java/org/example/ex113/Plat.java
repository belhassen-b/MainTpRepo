package org.example.ex113;

import java.util.Arrays;

public class Plat {

    private int id;
    private String nom;
    private Ingredient[] ingredients;

    public Plat() {
    }

    public Plat(int id, String nom, Ingredient[] ingredients) {
        this.id = id;
        this.nom = nom;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public void afficher() {
        System.out.println("Plat: " + nom);
        System.out.println("Ingredients: ");
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getNom_aliment() + " " + ingredient.getEtat() + " " + ingredient.getQuantite() + " " + ingredient.getUnite());
        }
    }
}
