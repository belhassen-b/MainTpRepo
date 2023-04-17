package org.example.execption;

import java.util.Scanner;


public class Tableau {
    static int[] tab = null;

    public static void afficher() {
       try {
               if(tab.length == 0) {
                   System.out.println("Le tableau est vide");
               } else {
                   for (int i = 0; i < tab.length; i++) {
                       System.out.println(tab[i]);
                   }
               }
              } catch (NullPointerException e) {
                  System.out.println("Le tableau est vide");
              }
       }


    public static void ajouter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez la taille du tableau");
        int taille = sc.nextInt();
        tab = new int[taille];
        String saisie;
        int i = 0;
        while (i < tab.length) {
            for (i = 0; i < tab.length; i++) {
                if (tab[i] == 0) {
                    System.out.println("Entrez le " + (i + 1) + "eme nombre");

                    saisie = sc.nextLine();
                    if (saisie.matches("[0-9]+")) {
                        tab[i] = Integer.parseInt(saisie);
                        break;
                    } else {
                        tab[i] = 0;
                    }
                }
            }
        }
    }

    public static void calcul() {

        try {
            int somme = 0;
            for (int i = 0; i < tab.length; i++) {
                somme += tab[i];
            }
            System.out.println("La somme des nombres est : " + somme);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Le tableau est vide");
        }
    }
}