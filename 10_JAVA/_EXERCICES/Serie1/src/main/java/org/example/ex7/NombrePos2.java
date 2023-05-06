package org.example.ex7;

import java.util.Scanner;

public class NombrePos2 {

    public static void NombrePos2(){
        System.out.println("Merci de saisir un nombre : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a>0)
            System.out.println("Le nombre est positif");
        else if (a<0)
            System.out.println("le nombre est négatif ");
        System.out.println("Le nombre tapé est 0 ! ");

    }
}
