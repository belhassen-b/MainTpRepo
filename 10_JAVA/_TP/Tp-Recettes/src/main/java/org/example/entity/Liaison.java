package org.example.entity;


import lombok.*;

@Builder
@ToString
@AllArgsConstructor
@Setter
@Getter
public class Liaison {
    private int idLiaison;
    private int idRecipe;
    private int idIngredient;

}
