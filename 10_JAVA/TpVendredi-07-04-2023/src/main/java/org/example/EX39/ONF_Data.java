package org.example.EX39;

public class ONF_Data {
    private int typeArbre;
    private int resineux = 0;
    private int feuillus = 0;
    private int hauteur, diametre;

    public ONF_Data() {
        this.typeArbre = typeArbre;
        this.resineux = resineux;
        this.feuillus = feuillus;
        this.hauteur = hauteur;
        this.diametre = diametre;
    }

    public int getTypeArbre() {
        return typeArbre;
    }

    public void setTypeArbre(int typeArbre) {
        this.typeArbre = typeArbre;
    }

    public int getResineux() {
        return resineux;
    }

    public void setResineux(int resineux) {
        this.resineux = resineux;
    }

    public int getFeuillus() {
        return feuillus;
    }

    public void setFeuillus(int feuillus) {
        this.feuillus = feuillus;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    @Override
    public String toString() {
        return "ONF_Data{" +
                "typeArbre=" + typeArbre +
                ", resineux=" + resineux +
                ", feuillus=" + feuillus +
                ", hauteur=" + hauteur +
                ", diametre=" + diametre +
                '}';
    }

    public void afficher(int parcelle) {
        System.out.println("Nombre d'arbres résineux: " + resineux);
        System.out.println("Nombre d'arbres feuillus: " + feuillus);
    }


}
