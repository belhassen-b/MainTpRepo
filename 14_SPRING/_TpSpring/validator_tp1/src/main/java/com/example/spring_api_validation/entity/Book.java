package com.example.spring_api_validation.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    @Size(min = 3, max = 20, message = "Title must be between 3 and 20 characters")
    @Column(name = "title")
    private String title;

@ManyToOne(fetch = FetchType.EAGER, optional = false)
@JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Max(value = 2023, message = "Year must be less than 2023")
    @Column(name = "year", nullable = false)
    private Integer year;

}
