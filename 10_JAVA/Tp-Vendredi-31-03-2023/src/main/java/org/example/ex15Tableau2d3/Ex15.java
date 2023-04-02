package org.example.ex15Tableau2d3;

public class Ex15 {
    public static void Tableau2d3() {
        System.out.println("**************** Tableau2d3 ****************");
        int a[][] = {{2, 2, 3}, {8, 4, 5}, {9, 4, 5}};
        int b[][] = {{2, 2, 3}, {8, 4, 5,9}, {9, 4, 5}};
//        int b[][] = {{2, 2, 3}, {8, 4, 5}, {9, 4, 5}};
        int tailleMaxA = 0;
        int tailleMaxB = 0;
        int sommeTableau = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].length > tailleMaxA) {
                tailleMaxA = a[i].length;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i].length > tailleMaxB) {
                tailleMaxB = b[i].length;
            }
        }
        if (tailleMaxA == tailleMaxB) {
            sommeTableau(a, b);

            System.out.println("Les tableaux sont réguliers car la taille de la ligne la plus grande est de : " + tailleMaxA);
        } else {
            System.out.println("Les tableaux ne sont pas réguliers car la taille de la ligne la plus grande est de : " + tailleMaxA + " pour le tableau A et de : " + tailleMaxB + " pour le tableau B");
        }
    }

    private static void sommeTableau(int[][] a, int[][] b) {
        int sommeTableau = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sommeTableau += a[i][j];
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                sommeTableau += b[i][j];
            }
        }
        System.out.println("La somme des éléments des deux tableaux est de : " + sommeTableau);

    }
}
