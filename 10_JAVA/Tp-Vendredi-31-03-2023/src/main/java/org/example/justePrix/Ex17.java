package org.example.justePrix;

import java.util.Random;
import java.util.Scanner;

public class Ex17 {
    public static void justePrix() {
        System.out.println("**************** justePrix ****************");
        Scanner sc = new Scanner(System.in);
        int nombre = 0;
        int nombreAleatoire = 0;
        int compteur = 0;
        boolean gagne = false;
        Random rand = new Random();
        nombreAleatoire = rand.nextInt(1000) + 1;
        while (!gagne) {
            System.out.println("Merci de saisir un nombre entre 1 et 1000 : ");
            nombre = sc.nextInt();
            if (nombre == nombreAleatoire) {
                System.out.println("Bravo, vous avez gagné en " + compteur + " coups");
                gagne = true;
            } else if (nombre < nombreAleatoire) {
                System.out.println("Le nombre est plus grand");
                compteur++;
            } else if (nombre > nombreAleatoire) {
                System.out.println("Le nombre est plus petit");
                compteur++;
            }
        }


    }
}
