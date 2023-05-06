package org.example.ex1;

import java.util.Scanner;

public class Ex1 {
    public static void Categorie(){
        System.out.println("*********  Categorie *********");
        System.out.println("Merci d'entrer l'âge de votre enfant :");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if (age >= 6 && age <=7 )
            System.out.println("Votre enfant est en catégorie Poussin !");
        else if (age >=8 && age <=9)
            System.out.println("Votre enfant est en catégorie Pupille !");
        else if (age >=10 && age <=11)
            System.out.println("Votre enfant est en catégorie Minime !");
        else if (age >=12 )
            System.out.println("Votre enfant est en catégorie Cadet !");
        else
            System.out.println("Hors catégorie !");

    }
}
