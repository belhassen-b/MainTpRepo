package org.example.salarie;

import static org.example.salarie.Salarie.*;

public class Application {


    public static void main(String[] args) {



        Salarie salarie1 = new Salarie(1, "A", "Comptabilite", "Newton", 1000.0);
        Salarie salarie2 = new Salarie(2, "B", "Physique", "Einstein", 2000.0);
        Salarie salarie3 = new Salarie(3, "C", "Mathematique", "Euler", 3000.0);
        Salarie salarie4 = new Salarie(4, "D", "Informatique", "Turing", 4000.0);
        Salarie salarie5 = new Salarie(5, "E", "Electronique", "Tesla", 5000.0);
        Salarie salarie6 = new Salarie(6, "F", "Astronomie", "Copernic", 6000.0);

        Salarie[] tabSalarie = {salarie1, salarie2, salarie3, salarie4, salarie5, salarie6};

for (Salarie salarie : tabSalarie) {
            System.out.println("Le salaire fixe de  " + salarie.getNom() + " est  de " + salarie.getSalaire() + " euros");
        }


        System.out.println("Le nombre de salariés est de : " + compteur );

for (Salarie salarie : tabSalarie) {
            sommeSalaire += salarie.getSalaire();
        }
        System.out.println("La somme des salaires est de " + sommeSalaire + " euros");
    }
}

