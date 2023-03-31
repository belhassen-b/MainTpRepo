package org.example.ex5;

import java.util.Scanner;

public class Ex5 {
    public static void moyenne() {
        System.out.println("******************  Moyenne  *******************");
        System.out.println("Merci de saisir des nombres");
        Scanner sc = new Scanner(System.in);
        float nombre = sc.nextFloat();
        float somme = 0;
        int i = 0;
        while (nombre >= 0) {
            somme = somme + nombre;
            i++;
            nombre = sc.nextFloat();
        }
        float moyenne = somme / i;
        System.out.println("La moyenne est : " + moyenne);
    }
}
