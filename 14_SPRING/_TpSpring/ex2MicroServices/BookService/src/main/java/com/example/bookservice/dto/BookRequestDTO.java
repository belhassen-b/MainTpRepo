package com.example.bookservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookRequestDTO {

    private String title;

    private String isbn;

    private String publishDate;

    private Long authorId;
}

