package com.example.tprevision13062023.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Tournoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Jeu jeu;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime date;

    @OneToMany(mappedBy = "tournoi")
    List<Equipe> participants;


}
