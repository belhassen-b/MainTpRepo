package com.example.spring_api_validation.controller;


import com.example.spring_api_validation.entity.Book;
import com.example.spring_api_validation.service.BookService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookService BookService;

    @PostMapping("/save")
    ResponseEntity<String> createPerson(@Valid @RequestBody Book book){
        BookService.save(book);
        return ResponseEntity.ok("Book created");
    }

    @GetMapping("/get/{id}")
    ResponseEntity<Book> getBookById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(BookService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteBookById(@PathVariable("id") Integer id){
        BookService.deleteById(id);
        return ResponseEntity.ok("Book deleted");
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Book> updateBookById(@PathVariable("id") Integer id, @Valid @RequestBody Book book){
return ResponseEntity.ok(BookService.updateBookById(id, book));
    }

    @GetMapping("/get")
    ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(BookService.findAll());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected  Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException exception){

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
