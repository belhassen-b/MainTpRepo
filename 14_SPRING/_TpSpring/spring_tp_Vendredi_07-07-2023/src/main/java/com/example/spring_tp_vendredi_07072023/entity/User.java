package com.example.spring_tp_vendredi_07072023.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table( name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 3, max = 15, message = "Name must be between 3 and 15 characters")
    private String name;

    @Column(name = "password", nullable = false, unique = true)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{5,8}$",  message = "Password must contain at least two digit, one lowercase, one uppercase, one special character and must be between 5 and 8 characters")
    private String password;


    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

}