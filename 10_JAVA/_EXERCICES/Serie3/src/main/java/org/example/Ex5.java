package org.example;

import java.util.Scanner;

public class Ex5 {
    public static void Pyramide() {
        System.out.println("*********  Pyramide   ************");
        System.out.println("Merci de saisir la hauteur de la pyramide :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tab[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j < n - i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}