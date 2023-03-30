package org.example.ex7;

public class Ex7 {
    public static void TableauInverse() {
        System.out.println("*********** Tableau inverse    ***********");
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Tableau avant l'inversion:");
        for (int i = 0; i < array.length; i++) {
            System.out.printf( " %d ", array[i]);
        }
        System.out.printf("%n");
        System.out.println("Tableau après l'inversion:");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.printf( " %d ", array[i]);
        }
        System.out.printf("%n");

    }

}
