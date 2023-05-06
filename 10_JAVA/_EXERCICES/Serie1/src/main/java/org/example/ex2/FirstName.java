package org.example.ex2;

import java.util.Scanner;

public class FirstName {

    public static void firstName() {
        System.out.println("**************** Hello ****************");
        System.out.println("Merci de saisir votre prénom : ");
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        System.out.println("Bonjour " + firstName);
    }

}
