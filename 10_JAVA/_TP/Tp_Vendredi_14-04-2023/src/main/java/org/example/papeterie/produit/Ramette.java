package org.example.papeterie.produit;

import org.example.papeterie.article.ArticleUnitaire;

public class Ramette extends ArticleUnitaire {

    private int grammage;

    public Ramette(int refArt, String name, double price, int grammage) {
        super(refArt, name, price);
        this.grammage = grammage;
    }

    public int getGrammage() {
        return grammage;
    }

    public void setGrammage(int grammage) {
        this.grammage = grammage;
    }

    @Override
    public String toString() {
        return "Ramette{" +
                "grammage=" + grammage +
                '}';
    }
}
