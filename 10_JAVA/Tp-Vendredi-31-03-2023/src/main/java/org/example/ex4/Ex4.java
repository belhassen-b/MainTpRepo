package org.example.ex4;

import java.util.Scanner;

public class Ex4 {

    public static void temperature() {
        System.out.println("**************** Temperature ****************");
        System.out.println("Merci de saisir la température à convertir :");
        Scanner sc = new Scanner(System.in);
        Float temp1 = sc.nextFloat();
        System.out.println("Vous avez saisi : " + temp1 + " ° Celsius" );
        Float temp2 = temp1 * 9/5 +32;
        System.out.println("L'équivalent en degrés Fahrenheit est : " + temp2 + " ° Fahrenheit" );


    }

}

