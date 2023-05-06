package org.example.ex8;

public class Ex8 {
    public static void triBulles() {
        System.out.printf("*********** Tri à bulles    ***********%n");
        int[] array = {11,96,7,15,1,369,71,77,99,6,16,30,59,62,82,23};
        System.out.println("Tableau avant le tri:");

        // Affichage du tableau avant le tri
        for (int i = 0; i < array.length; i++) {
            System.out.printf( " %d ", array[i]);
        }
        System.out.printf("%n");
        System.out.println("Tableau après le tri:");

        int temp = 0; // Variable temporaire pour le tri
        for (int i = 0; i < array.length; i++) { // Boucle pour le nombre de tours
            for (int j = 1; j < (array.length - i); j++) { // Boucle pour le nombre de comparaisons
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf( " %d ", array[i]);
        }
        System.out.printf("%n");
    }
}