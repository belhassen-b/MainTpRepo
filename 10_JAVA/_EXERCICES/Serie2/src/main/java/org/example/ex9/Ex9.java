package org.example.ex9;

import java.util.Scanner;

public class Ex9 {
    public static void TableMultiplication() {
        System.out.println("***********  Table de multiplication  *************");
        System.out.println("Merci de saisir un nombre entre 1 et 10 :");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = 1;
        while (i <= 10) {
            while (j <= 10) {
                System.out.println(i + " x " + j + " = " + i * j);
                j++;
            }
        }
    }
}
