package org.example.exercice1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Exercice1 {
    public static void first() {


    ArrayList<Integer> tab;
    tab = new ArrayList<Integer>();
    tab.add(2);
    tab.add(13);
    tab.add(5);
    tab.add(29);
    tab.add(214);
    tab.add(-2);
    tab.add(-3);
    tab.add(-5);
        System.out.println(tab);

        System.out.println("Affichage dans l'ordre naturel, Solution 1");

        System.out.println("*************");
        Collections.sort(tab);
        System.out.println(tab);

        System.out.println("Affichage dans l'ordre naturel, Solution 2");
        for (Integer i : tab) {
        System.out.println(i);
    }

        System.out.println("*************");

        System.out.println("Affichage dans l'ordre naturel, Solution 3");
    int i = 0;
        while (i < tab.size()) {
        System.out.println(tab.get(i));
        i++;
    }
        System.out.println("*************");

        System.out.println("Affichage dans l'ordre naturel, Solution 4");
    i = 0;
        do {
        System.out.println(tab.get(i));
        i++;
    } while (i < tab.size());

        System.out.println("-----------------------------------------------");
        System.out.println("Affichage dans l'ordre inverse, Solution 1");
        for (int j = tab.size() - 1; j >= 0; j--) {
        System.out.println(tab.get(j));
    }
        System.out.println("*************");

        System.out.println("Affichage dans l'ordre inverse, Solution 2");
    int j = tab.size() - 1;
        while (j >= 0) {
        System.out.println(tab.get(j));
        j--;
    }

        System.out.println("-----------------------------------------------");
        System.out.println("Affichage des éléments de rang pair (0,2,4...), Solution 1");
        for (int k = 0; k < tab.size(); k++) {
        if (k % 2 == 0) {
            System.out.println(tab.get(k));
        }
    }
        System.out.println("*************");
        System.out.println("Affichage des éléments de rang pair (0,2,4...), Solution 2");
        for (int l = 0; l < tab.size(); l += 2) {
        System.out.println(tab.get(l));
    }
        System.out.println("-----------------------------------------------");
        System.out.println("Mise à zéro des élements de valeurs négative, Solution 1");
        for (int m = 0; m < tab.size(); m++) {
        if (tab.get(m) < 0) {
            tab.set(m, 0);
        }
    }
        System.out.println(tab);
        System.out.println("*************");
        System.out.println("Mise à zéro des élements de valeurs négative, Solution 2");
        for (int n = 0; n < tab.size(); n++) {
        if (tab.get(n) < 0) {
            tab.remove(n);
            tab.add(n, 0);
        }
    }
        System.out.println(tab);
}
}
