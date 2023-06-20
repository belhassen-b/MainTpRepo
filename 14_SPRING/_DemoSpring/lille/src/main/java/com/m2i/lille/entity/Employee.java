package com.m2i.lille.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

    private Long id;
    private String nom;
    private Double salaire;
    private Boolean disponible;

}
