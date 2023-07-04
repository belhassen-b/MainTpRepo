package com.example.tp_spring_annonces.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Double price;

@ManyToOne
    private User user;

@ManyToMany(fetch = FetchType.EAGER)
    private List<Category>  categories = new ArrayList<>();


@OneToMany(mappedBy = "ad", fetch = FetchType.EAGER)
@JsonIgnoreProperties("ad")
private List<Picture> pictures = new ArrayList<>();


}
