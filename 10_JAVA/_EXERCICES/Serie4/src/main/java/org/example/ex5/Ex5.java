package org.example.ex5;

import java.util.Random;
import java.util.Scanner;

public class Ex5 {
    public static void OccurenceTableau() {
        System.out.println("*********** OccurenceTableau    ***********");
        System.out.println("Merci de saisir la longueur du tableau : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] array = new int[n];
        int[] array2 = new int[n];
        int tmp = 0;
        int i = 0;

        for (i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * n);
            tmp = array[i];
            array2[tmp]++;
        }
        for (i = 0; i < array2.length; i++) {
            System.out.println("La valeur " + i + " est présente " + array2[i] + " fois");
        }



    }
}
