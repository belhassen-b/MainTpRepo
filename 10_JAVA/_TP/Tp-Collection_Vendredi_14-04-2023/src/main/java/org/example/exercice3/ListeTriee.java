package org.example.exercice3;

import java.util.*;

public class ListeTriee {

    public static void ajouter(List<String> list, String element) {
        list.add(element);
        Collections.sort(list);
    }

    public static void afficher(List<String> list) {
        System.out.println(list);
    }



}