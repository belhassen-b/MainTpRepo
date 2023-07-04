package com.example.tp_spring_annonces.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isActive = true;

}
