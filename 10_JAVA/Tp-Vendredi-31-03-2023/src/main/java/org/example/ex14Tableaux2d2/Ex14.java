package org.example.ex14Tableaux2d2;

public class Ex14 {
    public static void Tableau2d2() {
        System.out.println("**************** Tableau2d2 ****************");
        int a[][] = {{2, 2, 3}, {8, 4, 5, 9}, {9, 4, 5}};
        int tailleMax = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].length > tailleMax) {
                tailleMax = a[i].length;
            }
        }
        System.out.println("Le tableau n'est pas régulier car la taille de la ligne la plus grande est de : " + tailleMax);
    }


}


