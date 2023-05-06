package org.example.ex3;

import java.util.Arrays;


public class Ex3 {
    public static void Decalage() {
        System.out.println("*********** Decalage    ***********");
        String array[] = {"D", "E", "C", "A", "L", "A", "G", "E"};
        System.out.println("Tableau avant l'inversion: " + Arrays.toString(array));

        for(int i=0; i< array.length-1; i++){
            String tmp = array[i];
            array[i] = array[i+1];
            array[i+1] = tmp;
        }
        System.out.println("Tableau après l'inversion: " + Arrays.toString(array));
        System.out.println();

    }
}
