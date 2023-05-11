package org.example.abstratfactory;

public class InfanterieOrc implements Infanterie {

    public Infanterie creerInfanterie(){
        return new InfanterieOrc();
    }

    @Override
    public void afficherInfanterie() {
        System.out.println("Infanterie Orc");
    }
}
