package org.example.abstratfactory;

public class InfanterieHumain implements Infanterie{

    public Infanterie creerInfanterie(){
        return new InfanterieHumain();
    }

    @Override
    public void afficherInfanterie() {
        System.out.println("Infanterie Humain");
    }
}
