package com.example.spring_api_validation.controller;


import com.example.spring_api_validation.entity.Genre;
import com.example.spring_api_validation.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping("/save")
    ResponseEntity<String> save(@Valid @RequestBody Genre genre){
        genreService.save(genre);
        return ResponseEntity.ok("Genre saved successfully");
    }
    @GetMapping("/get/{id}")
    ResponseEntity<Genre> getGenreById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(genreService.findById(id));
    }
    @DeleteMapping("/delete/{id}")

    ResponseEntity<String> deleteGenreById(@PathVariable("id") Integer id){
        genreService.deleteById(id);
        return ResponseEntity.ok("Genre deleted successfully");
    }
    @PutMapping("/update/{id}")
    ResponseEntity<Genre> updateGenreById(@PathVariable("id") Integer id, @Valid @RequestBody Genre genre){
        return ResponseEntity.ok(genreService.updateById(id, genre));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException exception){

        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
                    String fieldName = ((FieldError)error).getField();
                    String message = error.getDefaultMessage();
                    errors.put(fieldName,message);
                }
        );
        return errors;

    }

}
