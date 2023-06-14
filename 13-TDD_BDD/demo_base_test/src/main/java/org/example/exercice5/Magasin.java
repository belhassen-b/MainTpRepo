package org.example.exercice5;

public class Magasin {

    public void update(Produit produit) throws QualityException {

        if (produit.getQuality() <= 0) {
            throw new QualityException();
        } else
        if (produit.getSellIn() > 0) {
            produit.setQuality(produit.getQuality()-1);
        } else {
            produit.setQuality(produit.getQuality()-2);
        }
        produit.setSellIn(produit.getSellIn()-1);

    }






}
