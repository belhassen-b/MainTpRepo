package com.example.authorservice.controller;


import com.example.authorservice.entity.Author;
import com.example.authorservice.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/author")
public class AuthorController {

private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("")
    public ResponseEntity<Author> post(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String nationality) {

        Author author = authorService.createAuthor(firstName, lastName, nationality);
        return ResponseEntity.ok(author);
    }


    @GetMapping("{id}")
    public ResponseEntity<Author> get(@PathVariable Long id) {
        System.out.println("coucou");
        Author author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }
}
