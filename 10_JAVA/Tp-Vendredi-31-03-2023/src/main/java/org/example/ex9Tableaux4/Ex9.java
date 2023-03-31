package org.example.ex9Tableaux4;

import java.util.Scanner;

public class Ex9 {
    public static void Tableau4() {
        System.out.println("**************** Tableau4 ****************");
        System.out.println("Saisir la taille du tableau : ");
        Scanner sc = new Scanner(System.in);
        int taille = sc.nextInt();
        int compteur = 1;

        int arr[] = new int[taille];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Saisir le nombre " + compteur + " : ");
            arr[i] = sc.nextInt();
            compteur++;
        }

        boolean pair = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                pair = false;
            }
        }
        if (!pair) {
            System.out.println("Au moins un élément est impair");
        } else {
            System.out.println("Tous les éléments sont pairs");
        }
    }
}