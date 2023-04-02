package org.example.ex16Tableau2d4;

public class Ex16 {
    public static void Tableau2d4() {
        System.out.println("**************** Tableau2d4 ****************");
        int a[][] = {{2, 2, 3}, {8, 4, 5}, {9, 4, 5}};
        int somme[] = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
                somme[i] += a[i][j];
            }
            System.out.println();
        }
        for (int i = 0; i < somme.length; i++) {
            System.out.println("La somme de la ligne " + i + " est de : " + somme[i]);
        }
        if (somme[0] == somme[1] && somme[1] == somme[2]) {
            System.out.println("Le carré est magique ");
        } else {
            System.out.println("Le carré n'est pas magique ");
        }
    }
}
