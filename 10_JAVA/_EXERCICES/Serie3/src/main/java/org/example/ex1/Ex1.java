package org.example.ex1;

import java.util.Scanner;

public class Ex1 {
    public static void CompteMot() {
        System.out.println("******** Nombre de mot dans une phrase  **********");
        System.out.println("Saisir une phrase : ");
        Scanner sc = new Scanner(System.in);
        String phrase = sc.nextLine();
        int nbreMot = 0;
        nbreMot = phrase.split(" ").length;
        System.out.println("Le nombre de mot dans la phrase est : " + nbreMot);




    }

}
