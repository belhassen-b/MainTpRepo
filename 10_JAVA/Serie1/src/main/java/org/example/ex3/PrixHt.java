package org.example.ex3;

import java.util.Scanner;

public class PrixHt {
    public static void prixht() {
        System.out.println("***********Calcul TVA***********");
        System.out.println("Saisir le prix HT : ");
        Scanner sc = new Scanner(System.in);
        double  prixArticle = sc.nextDouble();
        System.out.println("Saisir la quantité : ");
        int quantite = sc.nextInt();
        System.out.println("Saisir la TVA (ex 19,6  ou 5,5 ...) ");
        double  tva = sc.nextDouble();
        double prixTtc = (prixArticle * quantite) * (1 + tva / 100);
        System.out.println("Le prix TTC est : " + prixTtc);
    }
}
