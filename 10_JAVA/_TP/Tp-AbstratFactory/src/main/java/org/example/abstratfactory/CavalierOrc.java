package org.example.abstratfactory;

public class CavalierOrc implements Cavalier{

    public Cavalier creerCavalier(){
        return new CavalierOrc();
    }

    @Override
    public void afficherCavalier() {
        System.out.println("Cavalier Orc");
    }
}
