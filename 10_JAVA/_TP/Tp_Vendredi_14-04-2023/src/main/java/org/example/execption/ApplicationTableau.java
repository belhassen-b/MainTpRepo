package org.example.execption;

import java.util.Scanner;

public class ApplicationTableau {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        do {
            System.out.println("1. Afficher le tableau");
            System.out.println("2. Ajouter un nombre");
            System.out.println("3. Afficher la somme des nombres");
            System.out.println("4. Quitter");
            System.out.println("Choix : ");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    Tableau.afficher();
                    break;
                case 2:
                    Tableau.ajouter();
                    break;
                case 3:
                    Tableau.calcul();
                    break;
                case 4:
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Choix incorrect");
            }
        } while (choix != 4);

    }
}
