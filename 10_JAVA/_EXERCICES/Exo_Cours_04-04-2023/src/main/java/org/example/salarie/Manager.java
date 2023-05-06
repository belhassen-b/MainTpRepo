package org.example.salarie;

public class Manager extends Salarie{


    public Manager(String matricule, String categorie, String service, String nom, Double salaire, int distance, double chiffreAffaire, double commission) {
        super("S001", "A", "Commercial", "Jean", 1500.0);
    }

    public void afficher() {
        System.out.println("Je suis un manager");
    }



    public void gerer() {
        System.out.println("Je gère mon équipe");
    }
}
