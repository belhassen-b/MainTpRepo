package org.example.entity;

import lombok.*;

@Builder
@ToString
@AllArgsConstructor
@Setter
@Getter
public class Recipe {
private int idRecipe;
private String nameRecipe;
private int nbPerson;
private int preparationTime;
private int cookingTime;
private int difficulty;
private String description;
}

