package com.example.spring_api_validation.controller;


import com.example.spring_api_validation.entity.Author;
import com.example.spring_api_validation.service.AuthorService;
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
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    ResponseEntity<String> save(@Valid @RequestBody Author author){
        authorService.save(author);
        return ResponseEntity.ok("Author saved successfully");
    }

    @GetMapping("/get/{id}")
    ResponseEntity<Author> getAuthorById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(authorService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteAuthorById(@PathVariable("id") Integer id){
        authorService.deleteById(id);
        return ResponseEntity.ok("Author deleted successfully");
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Author> updateAuthorById(@PathVariable("id") Integer id, @Valid @RequestBody Author author){
        return ResponseEntity.ok(authorService.updateById(id, author));
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
