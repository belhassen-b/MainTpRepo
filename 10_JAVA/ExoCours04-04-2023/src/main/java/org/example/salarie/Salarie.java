package org.example.salarie;

public class Salarie implements Commun{
    public static tabSalarie[] tabSalarie = new tabSalarie[10];
    public String matricule;
    public String categorie;
    public String service;
    public static String nom;

    public Double salaire;

    public static int distance = 0;

    private static int i = 0;

    public static Double sommeSalaire = 0.0;

    public Salarie(String nom, String matricule, String categorie, String service, double salaire) {
        this.nom = nom;
        this.matricule = matricule;
        this.categorie = categorie;
        this.service = service;
        this.salaire = salaire;
    }

    public Salarie() {

    }

//    static int compteur = 0;
//
//    {
//        compteur++;
//        matricule = compteur;
//    }



    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public static String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }


    public void afficherSalaire() {
        System.out.println("Le salaire de " + nom + " matricule " + matricule +" est de " + salaire + " euros");
    }
    public void forEach(Object o) {
        System.out.println("Le salaire de " + nom + " est de " + salaire + " euros");
    }

    @Override
    public void afficher() {

    }

    @Override
    public void seDeplacer() {

    }

    @Override
    public void retour() {

    }
}




