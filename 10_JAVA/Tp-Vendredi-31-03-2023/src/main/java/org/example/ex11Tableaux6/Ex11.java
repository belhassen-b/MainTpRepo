package org.example.ex11Tableaux6;

import java.util.Random;
import java.util.Scanner;

public class Ex11 {
    public static void Tableau6() {
        System.out.println("**************** Tableau6 ****************");
        System.out.println("Merci de saisir la taille des tableaux : ");
           Scanner sc = new Scanner(System.in);
              int taille = sc.nextInt();
        int arr1[] = new int[taille];
        int arr2[] = new int[taille];
    for (int i = 0; i < arr1.length; i++) {
        Random rand = new Random();
        arr1[i] = rand.nextInt(100) + 1;
        arr2[i] = rand.nextInt(100) + 1;
    }
    int somme1 = 0;
    int somme2 = 0;
    for (int i = 0; i < arr1.length; i++) {
        somme1 += arr1[i];
        somme2 += arr2[i];

    }
    int total = somme1 + somme2;
    System.out.println("La somme des éléments du tableau 1 est : " + somme1);
    System.out.println("La somme des éléments du tableau 2 est : " + somme2);
    System.out.println("La somme des éléments des deux tableaux est : " + total);
    }
}
