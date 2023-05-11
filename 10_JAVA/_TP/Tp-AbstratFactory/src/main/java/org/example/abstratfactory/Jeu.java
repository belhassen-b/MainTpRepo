package org.example.abstratfactory;

public class Jeu {

    FactionFactory factionFactory;

    public Jeu(FactionFactory factionFactory){
        this.factionFactory = factionFactory;
    }

    public void jouer(){
        Cavalier cavalier = factionFactory.creerCavalier();
        Archer archer = factionFactory.creerArcher();
        Infanterie infanterie = factionFactory.creerInfanterie();
        cavalier.afficherCavalier();
        archer.afficherArcher();
        infanterie.afficherInfanterie();
    }
}
