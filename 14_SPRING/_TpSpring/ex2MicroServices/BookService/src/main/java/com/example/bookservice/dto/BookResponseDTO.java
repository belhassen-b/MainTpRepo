package com.example.bookservice.dto;


import com.example.bookservice.entity.Book;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookResponseDTO {

private List<Book> books;
private AuthorDTO authorDTO;
}
