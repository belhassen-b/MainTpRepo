package org.example.ex6;

import java.util.Scanner;

public class Ex6 {
    public static void tableauCroissant() {
        System.out.println("*********** Tableau croissant ?    ***********");
        System.out.println("Merci de saisir la longueur du tableau : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int i;
        System.out.println("Merci de saisir les valeurs du tableau : ");
        for (i = 0; i < array.length; i++) {
            System.out.println("Entrez la valeur n°" + (i + 1) + " : " );
            array[i] = sc.nextInt();
        }
        boolean croissant = true;
        for (i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
             croissant = false;
                System.out.println("Le tableau n'est pas croissant");
            }
            System.out.printf("Le tableau est croissant");
            break;
        }
    }
}
