package com.belhassen.tp_revision.entity;

import lombok.Data;

@Data
public class JeuVideo {
    private int id;
    private String nom;
    private String genre;
    private String plateforme;
    private String description;
    private String image;
    private double prix;

    public JeuVideo(String nom, String genre, String plateforme, String description, String image, double prix) {
    }

}
