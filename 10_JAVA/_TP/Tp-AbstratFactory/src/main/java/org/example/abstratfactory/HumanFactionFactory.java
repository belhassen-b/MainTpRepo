package org.example.abstratfactory;

public class HumanFactionFactory implements FactionFactory {
    public Infanterie creerInfanterie() {
        return new InfanterieHumain();
    }
    public Cavalier creerCavalier() {
        return new CavalierHumain();
    }

    public Archer creerArcher() {
        return new ArcherHumain();
    }
}
