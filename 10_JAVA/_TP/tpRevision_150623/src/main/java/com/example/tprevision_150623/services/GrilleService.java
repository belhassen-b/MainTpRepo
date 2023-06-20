package com.example.tprevision_150623.services;

import com.example.tprevision_150623.entities.Cellule;
import com.example.tprevision_150623.entities.CelluleStatut;
import com.example.tprevision_150623.entities.Grille;

public class GrilleService {


    public void tirer(Grille grille, int x, int y) {
        Cellule cellule = grille.getCellule(x, y);
        if (cellule.getStatut() == CelluleStatut.BATEAU) {
            cellule.setStatut(CelluleStatut.TOUCHE);
        } else {
            cellule.setStatut(CelluleStatut.RATE);
        }
    }


    public boolean resteBateau(Grille grille) {
        for(Cellule[] ligne : grille.getCellules()){
            for(Cellule cellule : ligne){
                if(cellule.getStatut() == CelluleStatut.BATEAU){
                    return false;
                }
            }
        }
        return true;
    }
//        boolean gameOver = false;
//        for (int i = 0; i < grille.getTaille(); i++) {
//            for (int j = 0; j < grille.getTaille(); j++) {
//                if (grille.getCellule(i, j).getStatut() == CelluleStatut.BATEAU) {
//                    gameOver = true;
//                }
//            }
//        }
//        return gameOver;
//    }
}
