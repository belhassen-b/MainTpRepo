package org.example.ex2;

import java.util.Scanner;

public class Ex2 {
    public static void Occurence() {

        System.out.println("*************  OCCURENCE  *************");
        System.out.println("Merci de saisir un mot :");
        Scanner sc = new Scanner(System.in);
        String mot = sc.nextLine();
        System.out.println();
        System.out.println("Saisir une lettre :");
        int nbreOccurence = 0;
        String letter = sc.nextLine();
 for (int i = 0; i < mot.length(); i++) {
        if (mot.charAt(i) == letter.charAt(0) ) {
            nbreOccurence++;
              }
 }
        System.out.println("La lettre " + letter + " est présente " + nbreOccurence + " fois dans le mot " );

    }


}
