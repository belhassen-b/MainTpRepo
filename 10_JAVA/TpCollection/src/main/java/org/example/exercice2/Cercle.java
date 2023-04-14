package org.example.exercice2;

import java.util.ArrayList;
import java.util.List;

public class Cercle {
    private final int x;
    private final int y;
    private final double rayon;

    public Cercle(int x, int y, int rayon) {
        this.x = x;
        this.y = y;
        this.rayon = rayon;
    }

    public void affiche() {
        System.out.println("Coordonnées du centre : " + x + "," + y + " Rayon : " + rayon);
    }

    public double getRayon() {
        return rayon;
    }

    public int getX() {
        return x;
    }

}


