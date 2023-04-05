package org.example.salarie;

public class Commercial extends Salarie {

    private int distance;

    private double chiffreAffaire;
    private float commission;

    public Commercial(String matricule, String categorie, String service, String nom, double salaire, int distance, double chiffreAffaire, float commission) {
        super("S001", "A", "Commercial", "Jean", 1500.0);
        this.distance = this.distance;
        this.chiffreAffaire = this.chiffreAffaire;
        this.commission = this.commission;
    }

    public Commercial(String jean, String m001, String a, String comptabilité, double salaire, int distance, double chiffreAffaire) {
        super("S001", "A", "Commercial", "Jean", 1500.0);
    }

    public Commercial() {

        super("S001", "A", "Commercial", "Jean", 1500.0);
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public double calculerSalaireCom() {
        System.out.println("Le salaire avec comission est de : " + Salarie.getNom() + " est de : " + String.format("%.2f" , salaire + (chiffreAffaire * commission)));
        return salaire + (chiffreAffaire * commission);
    }

    public void afficher() {
        System.out.println("Je suis un commercial");
    }

    public void seDeplacer() {
        System.out.println("Je me déplace en voiture et ai parcouru : " + distance + " km");
    }

    public void retour() {
        System.out.println("Retour");

    }


}
