package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salarie {
    private Long id;
    private String nom;
    private String prenom;

    //Enum pour Role
    private Role role;

    private String departement = String.valueOf(new Departement());

}
