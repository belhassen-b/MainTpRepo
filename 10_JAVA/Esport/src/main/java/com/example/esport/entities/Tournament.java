package com.example.esport.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tournament {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)// Auto-increment
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Game game;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime date;

    @OneToMany(mappedBy = "tournament")
    List<Team> teams;

}
