package com.example.esport.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated
    private Game game;

@ManyToOne
@JoinColumn(name = "team_id")
    private Team team;

    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
    }
}
