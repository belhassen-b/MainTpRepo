package org.example.ex5;

import java.util.Scanner;

public class Ex5 {
    public static void Produit(){
        System.out.println("************  Produit Négatif ou Positif  ************");
        System.out.println("Merci de saisir un nombre A : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Merci de saisir un nombre B :");
        int b = sc.nextInt();
        if (a>0 && b>0 || a<0 && b<0)
            System.out.println("le produit est positif!");
        else if (a>0 && b<0 || a<0 && b>0)
            System.out.println("le produit est négatif!");
    }
}
