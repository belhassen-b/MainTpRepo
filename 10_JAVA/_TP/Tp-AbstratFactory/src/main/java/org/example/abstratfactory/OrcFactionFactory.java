package org.example.abstratfactory;

public class OrcFactionFactory implements FactionFactory {

    public Cavalier creerCavalier(){
        return new CavalierOrc();
    }

    public Archer creerArcher(){
        return new ArcherOrc();
    }

    public Infanterie creerInfanterie(){
        return new InfanterieOrc();
    }
}
