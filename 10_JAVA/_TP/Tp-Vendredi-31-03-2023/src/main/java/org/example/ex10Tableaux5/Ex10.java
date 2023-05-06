package org.example.ex10Tableaux5;

import java.util.Random;

public class Ex10 {
    public static void Tableau5() {
        System.out.println("**************** Tableau5 ****************");
        int arr[] = new int[10];
        int compteur = 1;
        for (int i = 0; i < arr.length; i++) {
            Random rand = new Random();
            arr[i] = rand.nextInt(100) + 1;
            System.out.println("La valeur " + compteur + " de l'indice " + i + " est : " + arr[i]);
            compteur++;
            }

    }

}
