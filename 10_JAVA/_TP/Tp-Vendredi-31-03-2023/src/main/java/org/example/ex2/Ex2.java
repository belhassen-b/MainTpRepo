package org.example.ex2;

import java.util.Scanner;

public class Ex2 {
    public static void nombreCaract() {
        System.out.println("**************** NombreCaract ****************");
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer un mot: ");
        String mot = sc.nextLine();
        System.out.println("Le mot " + mot + " contient " + mot.length() + " caractères");
    }
}
