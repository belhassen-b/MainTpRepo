package com.example.tprevision_150623.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cellule {

    private int x;
    private int y;

    private CelluleStatut statut;

    public Cellule(int i, int j) {
        this.x = i;
        this.y = j;
        this.statut = CelluleStatut.VIDE;
    }
}
