package org.example.pendu;

import java.util.Scanner;

public class Ex18 {
    public static void pendu() {
        System.out.println("**************** Pendu ****************");
        String arr[] = {"Pendu", "Voiture", "Ordinateur", "Bateau", "Avion", "Maison", "Chien", "Chat", "Poisson", "Pomme", "Banane", "Orange", "Fraise", "Cerise", "Pomme de terre", "Tomate", "Poire", "Poireau", "Carotte", "Pomme} ;"};

        String mot = arr[(int) (Math.random() * arr.length)];
        String motCache = "";

        for (int i = 0; i < mot.length(); i++) {
            motCache += "*";
        }

        System.out.println(motCache);

        Scanner sc = new Scanner(System.in);
        System.out.println("Merci de saisir un nombre de tentative : ");

        int nbTentative = sc.nextInt();
    }}
//        int nbTentativeRestante = nbTentative;

//        for (int k = 0; k < nbTentative; k++) {
//            while (nbTentativeRestante > 0) {
//                System.out.println("Merci de saisir une lettre : ");
//                String lettre = sc.nextLine();
//                String motCache2 = "";
//
//                for (int i = 0; i < mot.length(); i++) {
//                    if (mot.charAt(i) == lettre.charAt(0)) {
//                        motCache2 += lettre;
//                    } else {
//                        motCache2 += motCache.charAt(i);
//                    }
//                }
//                System.out.println(motCache2);
//                nbTentativeRestante--;
//            }
//            System.out.println("Vous avez perdu");
//        }
//    }
//}
//
