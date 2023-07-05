package com.example.demo_rest.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

     @Column(name = "first_name", nullable = false, length = 100)
     private String firstName;

     @Column(name = "last_name", nullable = false, length = 100)
        private String lastName;

     @Column(name = "email", nullable = false, length = 100)
        private String email;


}
