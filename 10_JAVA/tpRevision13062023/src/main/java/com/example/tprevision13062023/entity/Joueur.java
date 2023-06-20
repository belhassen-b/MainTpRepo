package com.example.tprevision13062023.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Joueur {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;


    @Enumerated(EnumType.STRING)
    private Jeu jeu;

}
