package org.example.ex4;

import java.util.Scanner;

public class EX4 {

    public static void PosNeg(){

        System.out.println("***********  PosNeg  *************");
        System.out.println("Merci de saidir un nombre : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a>0)
            System.out.println("Le nombre est positif");
        else if (a<0)
            System.out.println("le nombre est négatif ");
            }
}
