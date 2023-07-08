package com.example.spring_api_validation.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Genre {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Integer id;

        @Size(min = 3, max = 10, message = "Genre Name must be between 3 and 10 characters")
        @Column(name = "name", nullable = false)
        private String name;

        @Size(min = 3, max = 200, message = "Genre Description must be between 3 and 200 characters")
        @Column(name = "description", nullable = false)
        private String description;

        @JsonIgnore
        @OneToMany (mappedBy = "genre", cascade = CascadeType.ALL)
        private List<Book> book;
}
