package com.example.tprevision_150623.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
@Builder
public class Grille {

    private static final int TAILLE = 10;
    private Cellule[][] cellules;
    private Grille grille;

    public Grille() {
        init();
    }

    public void init() {
        cellules = new Cellule[TAILLE][TAILLE];
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                cellules[i][j] = new Cellule(i, j);
            }
        }

        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            int x;
            int y;
            do {
                x = random.nextInt(10);
                y = random.nextInt(10);
            } while (getCellule(x, y).getStatut() != CelluleStatut.VIDE);
            getCellule(x, y).setStatut(CelluleStatut.BATEAU);
        }
    }
    public Cellule getCellule(int x, int y) {
        return cellules[x][y];
    }


}
