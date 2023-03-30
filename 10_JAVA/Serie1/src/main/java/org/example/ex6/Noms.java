package org.example.ex6;

import java.util.Scanner;

public class Noms {
    public static void Noms() {
        System.out.println("Merci de saisir le 1er nom :");
        Scanner sc = new Scanner(System.in);
        String nomA = sc.nextLine();
        System.out.println("Merci de saisir le 2e nom :");
        String nomB = sc.nextLine();
        System.out.println("Merci de saisir le 3e nom:");
        String nomC = sc.nextLine();

        // verif de la valeuur des String
        System.out.println(nomA.compareTo(nomB) );
        System.out.println(nomA.compareTo(nomC) );
        System.out.println(nomB.compareTo(nomC) );

        if (nomA.compareTo(nomB) < 0 && nomB.compareTo(nomC) < 0) {
            System.out.println("Les noms sont dans l'ordre alphabétique");
        } else {
            System.out.println("Les noms ne sont pas dans l'ordre alphabétique");
        }



    }

}
