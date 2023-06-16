package com.example.tprevision_150623.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bateau {

    private Cellule cellule;
    private boolean touche;

    public void toucher() {
        this.touche = true;
        cellule.setStatut(CelluleStatut.TOUCHE);
    }

}
