package org.example.ex1;

import java.util.Scanner;

public class Ex1 {
    public static void RenduMonnaie() {
        System.out.println("**********  RenduMonnaie  **********");
        Scanner sc = new Scanner(System.in);
        System.out.println("Le nombre de prix à saisir : ? ");
        int nbPrix = sc.nextInt();
        float[] tabPrix = new float[nbPrix];
        for (int i = 0; i < nbPrix; i++) {
            System.out.println("Prix n°" + (i + 1) + " : ? ");
            tabPrix[i] = sc.nextFloat();
        }
        int sommePrix = 0;
        for (int i = 0; i < nbPrix; i++) {
            sommePrix += tabPrix[i];
        }
        System.out.println("La somme des prix est : " + sommePrix + " € ");
        System.out.println("Entrez le montant versé : ");
        int montantVerse = sc.nextInt();
        System.out.println("Le montant versé est de  " + montantVerse + " € ");
        int renduMonnaie = montantVerse - sommePrix;
        int compteur = 0;
        int n = 1;

        // Test si rendu supérieur à 10€
        while (renduMonnaie >= 10) {
            renduMonnaie -= 10;
            compteur = compteur + 1;
        }
        // Itération nombre de billets
        for (int i = 0; i < compteur; i++, n++)
            System.out.println(n + " x Billet de 10 Euros");
        compteur = 0;
        n = 1;

        // Test si rendu supérieur à 5€
        while (renduMonnaie >= 5) {
            renduMonnaie -= 5;
            compteur = compteur + 1;
        }
        for (int i = 0; i < compteur; i++, n++)
            System.out.println(n + " x Billet de 5 Euros");
        if (renduMonnaie > 0)
            System.out.println("Reste à rendre  :" + renduMonnaie + " € ");
        else
            System.out.println("Have nice day ! ");
        compteur = 0;
        n = 1;

        // Test si rendu supérieur à 1€
        while (renduMonnaie >= 1) {
            renduMonnaie -= 1;
            compteur = compteur + 1;
        }
        for (int i = 0; i < compteur; i++, n++)
            System.out.println(n + " x Pièce de 1 Euro");
    }
}
