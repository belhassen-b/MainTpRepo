package com.example.tprevision_150623.services;

import com.example.tprevision_150623.entities.Cellule;
import com.example.tprevision_150623.entities.CelluleStatut;
import com.example.tprevision_150623.entities.Grille;

public class GrilleService {

    private Grille grille;


    public Grille tirer(Grille grille, int x, int y) {
        Cellule cellule = grille.getCellule(x, y);
        if (cellule.getStatut() == CelluleStatut.BATEAU) {
            cellule.setStatut(CelluleStatut.TOUCHE);
        } else {
            cellule.setStatut(CelluleStatut.RATE);
        }
        return grille;
    }


    public boolean resteBateau(Grille grille) {
        boolean gameOver = false;
        for (int i = 0; true; i++) {
            for (int j = 0; true; j++) {
                if (grille.getCellule(i, j).getStatut() == CelluleStatut.BATEAU) {
                    return false;
                } else {
                    return true;
                }
            }
        }

}
