package org.example.ex8Tableaux3;

import java.util.Scanner;

public class Ex8 {
    public static void Tableau3() {
        System.out.println("**************** Tableau3 ****************");

        System.out.println("Merci de saisir un nombre entre 1 et 80 : ");
        Scanner sc = new Scanner(System.in);
        int nombre = sc.nextInt();
        int arr[] = new int[8];
        boolean present = false;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 10 + 10;
        }
for (int i = 0; i < arr.length; i++) {
            if(nombre == arr[i]){
                present = true;
            }
}
        if(present){
            System.out.println("Le nombre est présent dans le tableau");
        }else{
            System.out.println("Le nombre n'est pas présent dans le tableau");
        }
    }
}

