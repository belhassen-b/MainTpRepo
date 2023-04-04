package org.example.employe;

public class Application {
    public static void main(String[] args) {

        Employe employe = new Employe("Doe", 28, 1000);
        Employe employe1 = new Employe("Didi", 48, 1800);
        Employe technicien = new Technicien("Toto", 28, 1050, 2);
        Employe technicien1 = new Technicien("Titi", 29, 1700, 3);

        Employe[] employes = new Employe[4];
        employes[0] = employe;
        employes[1] = employe1;
        employes[2] = technicien;
        employes[3] = technicien1;

        for (int i = 0; i < employes.length; i++) {
            System.out.println("Employe " + (i + 1) + " :");
            employes[i].Afficher();
            employes[i].calculerSalaire();
            System.out.println();
        }
    }
}
