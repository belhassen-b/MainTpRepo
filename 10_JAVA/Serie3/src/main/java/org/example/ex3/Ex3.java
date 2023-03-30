package org.example.ex3;

import java.util.Scanner;

public class Ex3 {
    public static void  Anagramme() {
        System.out.println("*******   Anagramme  *******");
        System.out.println("Merci de saisir un premier mot : ");
        Scanner sc = new Scanner(System.in);
        String mot1 = sc.nextLine();
        System.out.println("Merci de saisir le deuxième mot : ");
        String mot2 = sc.nextLine();
        if (mot1.length() != mot2.length()) {
            System.out.println("Les deux mots ne sont pas des anagrammes");
        } else {
            System.out.println("Les deux mots sont des anagrammes");
        }

    }
}
