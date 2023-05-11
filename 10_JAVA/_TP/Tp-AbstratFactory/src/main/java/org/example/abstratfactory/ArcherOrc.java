package org.example.abstratfactory;

public class ArcherOrc implements Archer {

    @Override
    public void afficherArcher() {
        System.out.println("Archer Orc");

    }

    public Archer creerArcher(){
            return new ArcherOrc();
        }
}
