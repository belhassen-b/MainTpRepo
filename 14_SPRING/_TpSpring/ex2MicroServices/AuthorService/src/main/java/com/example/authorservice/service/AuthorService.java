package com.example.authorservice.service;


import com.example.authorservice.entity.Author;
import com.example.authorservice.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;


    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(String firstName, String lastName, String nationality){
        Author author = Author.builder().firstName(firstName).lastName(lastName).nationality(nationality).build();
        authorRepository.save(author);
        return author;
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
