package com.example.spring_api_validation.service;


import com.example.spring_api_validation.entity.Author;
import com.example.spring_api_validation.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void save(Author author){
        authorRepository.save(author);
    }

    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }

    public Author updateById(Integer id, Author author) {
        Author author1 = authorRepository.findById(id).get();
        author1.setName(author.getName());
        author1.setEmail(author.getEmail());
        author1.setBooks(author.getBooks());
        return authorRepository.save(author1);
    }

    public Author findById(Integer id) {
        return authorRepository.findById(id).get();
    }
}
