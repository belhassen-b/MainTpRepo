package com.example.tprevision_150623.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class Bateau {

    private Cellule cellule;
    private boolean touche;

}
