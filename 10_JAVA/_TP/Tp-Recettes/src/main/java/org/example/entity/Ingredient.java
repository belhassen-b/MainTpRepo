package org.example.entity;

import lombok.*;

@Builder
@ToString
@AllArgsConstructor
@Setter
@Getter
public class Ingredient {
private int idIngredient;
private String name;
private int quantity;
private String unit;
private int idRecipe;
}
