package com.example.tp1spring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private boolean done;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="date")
    private Date date;

    private Priority priority;

    private Category category;

    private boolean urgent;


    public boolean getDone() {
        return done;
    }

    public boolean getUrgent() {
        return urgent;
    }
}
