package org.example.abstratfactory;

public class CavalierHumain implements Cavalier{

    public Cavalier creerCavalier(){
        return new CavalierHumain();
    }

    @Override
    public void afficherCavalier() {
        System.out.println("Cavalier Humain");

    }
}
