package org.example.abstratfactory;

public class ArcherHumain implements Archer {

    public Archer creerArcher(){
        return new ArcherHumain();
    }

    @Override
    public void afficherArcher() {
        System.out.println("Archer Humain");

    }
}
