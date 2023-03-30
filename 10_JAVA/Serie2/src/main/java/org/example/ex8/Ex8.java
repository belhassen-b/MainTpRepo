package org.example.ex8;

import java.util.Scanner;

public class Ex8 {
    public static void NombreCompris() {
        System.out.println("Merci de saisir un nombre entre 1  et 3 :");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while(a<1 || a>3){
            System.out.println("Merci de respecter la consigne et saisir un nombre entre 1 et 3");
            a = sc.nextInt();
        }
    }
}
