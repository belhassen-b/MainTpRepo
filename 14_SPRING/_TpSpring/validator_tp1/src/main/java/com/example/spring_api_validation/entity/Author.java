package com.example.spring_api_validation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @Email(regexp = "^[A-Za-z0-9+_.-]+@editor.com", message = "Ce n'est pas une adresse mail valide")
    @Column(name = "email", nullable = false)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

}
