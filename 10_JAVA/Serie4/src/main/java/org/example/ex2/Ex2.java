package org.example.ex2;

import java.util.Scanner;

public class Ex2 {
    public static void TabNotes() {
        System.out.println("*********** Tableau de notes *******");
        int[] array = new int[20];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            System.out.println("Entrez la note n°" + (i + 1) + " : ");
            array[i] = sc.nextInt();
        }
        int maxVal = Integer.MAX_VALUE;
        int minVal = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            if(array[i] < maxVal)
                maxVal = array[i];
            if(array[i] > minVal)
                minVal = array[i];
        }

        int somme = 0;
        for (int i = 0; i < array.length; i++) {
            somme += array[i];
        }
        System.out.println("La moyenne des notes est de : " + (somme / array.length));
        System.out.println("La note maximale est de : " + minVal);
        System.out.println("La note minimale est de : " + maxVal);
    }
}