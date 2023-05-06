package org.example.ex2;

import java.util.Scanner;

public class Ex2 {
    public static void Divisible3 () {
        System.out.println("*********** Divisible3  ********** " );
        System.out.println("Merci de saisir un nombre entier :");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a % 3 == 0)
            System.out.println("Ce nombre est divisible par 3!");
        else
            System.out.println("Ce nombre n'est pas divisible par 3!");
    }

}
