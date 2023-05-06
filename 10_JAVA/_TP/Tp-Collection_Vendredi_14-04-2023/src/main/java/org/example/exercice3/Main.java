package org.example.exercice3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(Arrays.asList(            "Alain", "Benoit", "Catherine", "David", "Emilie", "Fabrice", "Gilles", "Hélène", "Isabelle", "Jean", "Karine", "Laurent", "Marie", "Nicolas", "Olivier", "Pierre", "Quentin", "Romain", "Sébastien", "Thierry", "Ursule", "Victor", "William", "Xavier", "Yves", "Zoé"));
        System.out.println(list);


        String nom;
        System.out.println("Entrez un nom à ajouter à la liste");
        Scanner sc = new Scanner(System.in);
        nom = sc.nextLine();
        ListeTriee.ajouter(list, nom);
        ListeTriee.afficher(list);


    }
}
