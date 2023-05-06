package org.example.ex4;

import java.util.Scanner;

public class Ex4 {
    public static void Palindrome() {
        System.out.println("*********  Palindrome   ************");
        System.out.println("Merci de saisir un  mot :");
        Scanner sc = new Scanner(System.in);
        String mot = sc.nextLine();
        String isPalindrome = "Le mot " + mot + " est un palindrome";
        String isNotPalindrome = "Le mot " + mot + " n'est pas un palindrome";
        System.out.println(mot.equals(new StringBuilder(mot).reverse().toString()) ? isPalindrome : isNotPalindrome);
    }
}