package org.example;

import org.example.abstratfactory.FactionFactory;
import org.example.abstratfactory.HumanFactionFactory;
import org.example.abstratfactory.Jeu;
import org.example.abstratfactory.OrcFactionFactory;

public class Main {
    public static void main(String[] args) {

      Jeu jeu1 = new Jeu(new HumanFactionFactory());
        jeu1.jouer();
 Jeu jeu2 = new Jeu(new OrcFactionFactory());
        jeu2.jouer();
    }
}
