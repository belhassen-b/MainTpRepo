package org.example.ex10;

import java.util.Scanner;

public class Ex10 {
    public static void SommeEntiers() {
        System.out.println("***********  SommeEntiers  *************");
        System.out.println("Merci de saisir un nombre entier: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int somme = 0;
        for (int i = 0; i <= a; i++) {
            somme = somme + i;
        }
        System.out.println("La somme des entiers de 1 à " + a + " est : " + somme);
    }
}
