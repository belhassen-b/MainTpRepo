package org.example.heritage;

public class CompteBancaire {

    private int codeBanc;
    private double solde;
    private static int compteur = 0;

    private static double versement;
    private static double retrait;

    {
        ++compteur;
    }

    public CompteBancaire() {
        this.codeBanc = compteur;
    }

    public CompteBancaire(double solde) {
        this.codeBanc = compteur;
        this.solde = solde;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        CompteBancaire.compteur = compteur;
    }

    public int getCodeBanc() {
        return codeBanc;
    }

    public void setCodeBanc(int codeBanc) {
        this.codeBanc = codeBanc;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public static double getVersement() {
        return versement;
    }

    public static void setVersement(double versement) {
        CompteBancaire.versement = versement;
    }

    public static double getRetrait() {
        return retrait;
    }

    public static void setRetrait(double retrait) {
        CompteBancaire.retrait = retrait;
    }

    public void versement(double montant) {
        this.solde += montant;
    }

    public void retrait(double montant) {
        this.solde -= montant;
    }



    @Override
    public String toString() {
        return "CompteBancaire{" +
                "codeBanc=" + codeBanc +
                ", solde=" + solde +
                '}';
    }
}
