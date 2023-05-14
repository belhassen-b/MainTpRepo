package org.example.entity;

import lombok.*;

@Builder
@ToString
@AllArgsConstructor
@Setter
@Getter
public class Association {
    private int idRecipe;
    private int idIngredient;
    private int quantity;
}
