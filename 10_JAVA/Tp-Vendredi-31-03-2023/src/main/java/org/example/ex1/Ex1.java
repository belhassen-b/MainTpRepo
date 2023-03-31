package org.example.ex1;

import java.util.Scanner;

public class Ex1 {
    public static void nombrePair() {
        System.out.println("**************** Nombre Pair ****************");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer un nombre: ");
        int nombre = sc.nextInt();
        if (nombre % 2 == 0) {
            System.out.println("Le nombre est pair");
        } else {
            System.out.println("Le nombre est impair");
        }
    }
}
