package com.example.entities;


import com.example.Plateform;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

public class VideoGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String genre;

    private Plateform plateform;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date addedDate = new Date();

    private String image;

    private double price;

    public VideoGame(String name, String genre, Plateform plateforme, String description, Date addedDate, String image, double prix) {
    }

}
