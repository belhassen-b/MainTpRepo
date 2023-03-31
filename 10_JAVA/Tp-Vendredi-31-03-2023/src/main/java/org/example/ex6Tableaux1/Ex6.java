package org.example.ex6Tableaux1;

public class Ex6 {
    public static void tableau1() {
        System.out.println("**************** Tableau1 ****************");
        int arr[] = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.println(arr[i]);
        }
        System.out.println("La valeur de l'indice 3 est : " + arr[3]);
    }
}
