package com.example.bookservice.service;


import com.example.bookservice.dto.AuthorDTO;
import com.example.bookservice.dto.BookResponseDTO;
import com.example.bookservice.entity.Book;
import com.example.bookservice.repository.BookRepository;
import com.example.bookservice.tool.RestClient;
import org.springframework.stereotype.Service;


@Service
public class BookService {

private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(String title, String isbn, String publishDate, Long authorId){
        Book book = Book.builder().title(title).isbn(isbn).publishDate(publishDate).authorId(authorId).build();
        bookRepository.save(book);
        return book;
    }


    public BookResponseDTO getBookByAuthorId(Long id) {
        RestClient<AuthorDTO, String> restClient = new RestClient<>();
        BookResponseDTO bookResponseDTO = BookResponseDTO.builder()
                .books(bookRepository.findAllByAuthorId(id))
                .authorDTO(restClient.get("author/"+id, AuthorDTO.class))
                .build();
        return bookResponseDTO;
    }

}
