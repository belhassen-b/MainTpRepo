package org.example;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Livre {

    private String titre;
    private String auteur;
    private int nbPages;
    private int anneePublication;
    private String genre;
    private int ISBN;

}
