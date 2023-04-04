package org.example.salarie;

public class Salarie {
    public int matricule = 0;
    public String categorie;
    public String service;
    public String nom;

    public Double salaire;

    private static int i = 0;

    public static Double sommeSalaire = 0.0;

    public Salarie(int matricule, String categorie, String service, String nom, Double salaire) {
        this.matricule = matricule;
        this.categorie = categorie;
        this.service = service;
        this.nom = nom;
        this.salaire = salaire;
    }

    static int compteur = 0;

    {
        compteur++;
        matricule = compteur;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
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

    public String getNom() {
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
}



