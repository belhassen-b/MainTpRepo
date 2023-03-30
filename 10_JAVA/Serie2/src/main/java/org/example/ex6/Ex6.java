package org.example.ex6;

import java.util.Scanner;

public class Ex6 {
    public static void Noms() {
        System.out.println("**************** Noms ****************");
        Scanner sc = new Scanner(System.in);
        System.out.println("Merci de saisir le 1er nom :");
        String nomA = sc.nextLine();
        System.out.println("Merci de saisir le 2e nom :");
        String nomB = sc.nextLine();
        System.out.println("Merci de saisir le 3e nom:");
        String nomC = sc.nextLine();

        if (nomA.compareTo(nomB) < 0 && nomB.compareTo(nomC) < 0) {
            System.out.println("Les noms sont dans l'ordre alphabétique");
        } else {
            System.out.println("Les noms ne sont pas dans l'ordre alphabétique");
        }

    }
}

