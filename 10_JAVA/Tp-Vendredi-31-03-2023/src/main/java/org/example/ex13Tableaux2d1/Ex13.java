package org.example.ex13Tableaux2d1;

import java.util.Scanner;

public class Ex13 {
    public static void Tableau2d1() {
        System.out.println("**************** Tableau2d1 ***************");

        Scanner sc = new Scanner(System.in);
        int somme = 0;
        int taille = 0;

        System.out.println("Merci de saisir la taille de la matrice : ");
        taille = sc.nextInt();
        int[][] matrice = new int[taille][taille];

        System.out.println("Merci de saisir les valeurs de la matrice : ");

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                System.out.println("Valeur de la ligne " + i + " et de la colonne " + j + " : ");
                matrice[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < matrice.length; i++) {
            {
                somme += matrice[i][i];
            }
        }
        System.out.println("La somme des éléments de la matrice est : " + somme);
    }
}
