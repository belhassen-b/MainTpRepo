package com.example.spring_api_validation.service;

import com.example.spring_api_validation.entity.Author;
import com.example.spring_api_validation.entity.Genre;
import com.example.spring_api_validation.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public void save(Genre genre){
        genreRepository.save(genre);
    }

    public Genre findById(Integer id) {
        return genreRepository.findById(id).get();
    }


    public void deleteById(Integer id) {
        genreRepository.deleteById(id);
    }

    public Genre updateById(Integer id, Genre genre) {
        Genre genre1 = genreRepository.findById(id).get();
        genre1.setName(genre.getName());
        genre1.setDescription(genre.getDescription());
        genre1.setBook(genre.getBook());
        genreRepository.save(genre1);
        return genre1;
    }
}

