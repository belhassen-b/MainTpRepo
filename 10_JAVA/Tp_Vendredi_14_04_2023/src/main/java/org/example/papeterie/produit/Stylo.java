package org.example.papeterie.produit;

import org.example.papeterie.article.ArticleUnitaire;

public class Stylo extends ArticleUnitaire {

    private String couleur;

    public Stylo(int refArt, String name, double price, String couleur) {
        super(refArt, name, price);
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override

    public String toString() {
        return "Stylo{" +
                "couleur='" + couleur + '\'' +
                '}';
    }
}
