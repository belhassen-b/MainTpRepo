package org.example.ex12Tableaux7;

import java.util.Random;


public class Ex12 {
    public static void Tableau7() {
        System.out.println("**************** Tableau7 ****************");
        int arr[] = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        System.out.println("Le plus grand élément du tableau est : " + maxValue);
    }
}
