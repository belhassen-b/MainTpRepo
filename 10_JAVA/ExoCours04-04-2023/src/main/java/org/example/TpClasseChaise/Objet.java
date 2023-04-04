package org.example.TpClasseChaise;

public class Objet {

    private int id;
    private String couleur;
    private int nbrePieds;
    private String materiaux;

    public Objet(String couleur, int nbrePieds, String materiaux) {
        this.couleur = couleur;
        this.nbrePieds = nbrePieds;
        this.materiaux = materiaux;
    }

    public Objet() {
    }


    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getNbrePieds() {
        return nbrePieds;
    }

    public void setNbrePieds(int nbrePieds) {
        this.nbrePieds = nbrePieds;
    }

    public String getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(String materiaux) {
        this.materiaux = materiaux;
    }

    @Override
    public String toString() {
        return "Objet{" +
                "couleur='" + couleur + '\'' +
                ", nbrePieds=" + nbrePieds +
                ", materiaux='" + materiaux + '\'' +
                '}';
    }
}
