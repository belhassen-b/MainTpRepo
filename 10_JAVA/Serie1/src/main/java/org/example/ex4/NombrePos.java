package org.example.ex4;

import java.util.Scanner;

public class NombrePos {
    public static void  nombrePos() {
        int a;
        System.out.println("**************** Nombre Positif ****************");
        System.out.println("Merci de saisir un nombre entier : ");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        if (a > 0) {
            System.out.println("Le nombre saisi est positif");
        } else {
            System.out.println("Le nombre saisi est négatif");
        }
    }


}
