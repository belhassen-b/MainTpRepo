package org.example.exercice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DemoCercle{
    public static DemoCercle demoCercle;
    public int  x;
    public int y;
    public double rayon;
    public DemoCercle() {

    }

    public DemoCercle(int x, int y, double rayon) {
        this.x = x;
        this.y = y;
        this.rayon = rayon;
    }

    Cercle cercle1 = new Cercle(1, 1, 1);
    Cercle cercle2 = new Cercle(2, 2, 2);
    Cercle cercle3 = new Cercle(3, 3, 3);
    Cercle cercle4 = new Cercle(4, 4, 4);
    Cercle cercle5 = new Cercle(5, 5, 5);
    List<Cercle> liste = new ArrayList<>(Arrays.asList(cercle1, cercle2, cercle3, cercle4, cercle5));

    public static void addCercle(List<DemoCercle>liste){
        for (DemoCercle r : liste){
            System.out.println();
            System.out.println(r);
            System.out.println();
            System.out.println( "  ------ ----- ***** ----- -------");
        }
    }
    public static void afficheCercle(List<DemoCercle>liste){
        for (DemoCercle r : liste){
            System.out.println();
            System.out.println(r);
            System.out.println();
            System.out.println( "  ------ ----- ***** ----- -------");
        }
    }

}
