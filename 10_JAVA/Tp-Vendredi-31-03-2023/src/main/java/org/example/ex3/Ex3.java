package org.example.ex3;

import java.util.Scanner;

public class Ex3 {
    public static void motDePasse() {
        System.out.println("**************** Mot de Passe ****************");
        System.out.println("Merci de saisir un mot de passe : ");
        System.out.println(" min 8 caractères, 1 majuscule, 1 minuscule, 1 chiffre");
        Scanner sc = new Scanner(System.in);
        String motDePasse = sc.nextLine();
        boolean majuscule = false;
        boolean minuscule = false;
        boolean chiffre = false;
//        boolean longueur = false;
//        boolean valide = false;

        while (motDePasse.length() < 8) {
            System.out.println("Le mot de passe doit contenir au moins 8 caractères");
            motDePasse = sc.nextLine();
        }
        while (!majuscule) {
            for (int i = 0; i < motDePasse.length(); i++) {
                if (Character.isUpperCase(motDePasse.charAt(i))) {
                    majuscule = true;
                }
            }
            if (!majuscule) {
                System.out.println("Le mot de passe doit contenir au moins 1 majuscule");
                motDePasse = sc.nextLine();
            }
        }
        while (!minuscule) {
            for (int i = 0; i < motDePasse.length(); i++) {
                if (Character.isLowerCase(motDePasse.charAt(i))) {
                    minuscule = true;
                }
            }
            if (!minuscule) {
                System.out.println("Le mot de passe doit contenir au moins 1 minuscule");
                motDePasse = sc.nextLine();
            }
        }
        while (!chiffre) {
            for (int i = 0; i < motDePasse.length(); i++) {
                if (Character.isDigit(motDePasse.charAt(i))) {
                    chiffre = true;
                }
            }
            if (!chiffre) {
                System.out.println("Le mot de passe doit contenir au moins 1 chiffre");
                motDePasse = sc.nextLine();
            }
        }
        System.out.println("Mot de passe valide");
    }
}


