package org.example.ex4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Ex4 {
    public static void Random() {
        System.out.println("*********** Random      ***********");
        System.out.println("Merci de saisir la longueur du tableau : ");
        Scanner sc = new Scanner(System.in);
        int longueur = sc.nextInt();
        int[] array = generateRandomArray(longueur);
        System.out.println("Tableau généré : " + Arrays.toString(array));
        System.out.println("Tableau étendu : " + Arrays.toString(extendArray(array)));
    }
        public static int [] generateRandomArray (int longueur){
            int[] array = new int[longueur];
            for (int i = 0; i < array.length; i++) {
                Random serie = new Random();
                array[i] = serie.nextInt(10);
            }
            return array;
        }
    public static int[] extendArray(int[] arr){
        int[] extendedArray = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            extendedArray[i] = arr[i];
            Random serie2 = new Random();
            extendedArray[i + arr.length] = serie2.nextInt(10);
        }
        return extendedArray;
    }
}
