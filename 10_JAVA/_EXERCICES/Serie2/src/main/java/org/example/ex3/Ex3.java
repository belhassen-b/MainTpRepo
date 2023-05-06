package org.example.ex3;

import java.util.Scanner;

public class Ex3 {
    public static void Photocopie() {

        System.out.println("********** Photocopies *********");
        System.out.println("Merci de saisir le nombre de photocopies :");
        Scanner sc = new Scanner(System.in);
        int nmbre = sc.nextInt();
        double prix = 0;
        if (nmbre < 10)
            prix = nmbre * 0.15;
        else if (nmbre <= 20)
            prix = nmbre * 0.10;
        else if (nmbre > 20)
            prix = nmbre * 0.05;
        System.out.println("Le prix est de : " + prix + "€");


    }
}
