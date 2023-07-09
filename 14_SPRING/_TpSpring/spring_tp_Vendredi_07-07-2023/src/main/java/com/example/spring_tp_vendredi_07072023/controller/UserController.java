package com.example.spring_tp_vendredi_07072023.controller;


import com.example.spring_tp_vendredi_07072023.Dto.UserCreateDto;
import com.example.spring_tp_vendredi_07072023.Dto.UserReadDto;
import com.example.spring_tp_vendredi_07072023.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {


    private final UserServiceImpl userService;


    @PostMapping("/save")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        if ( userService.create(userCreateDto) == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok("User created");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserCreateDto> updateUserById(@PathVariable("id") Long id, @Valid @RequestBody UserCreateDto userCreateDto) {
        if(userService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.update(id, userCreateDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserReadDto>> getAllUsers()
    { if(userService.findAll() == null){
            return ResponseEntity.notFound().build();
    }
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserReadDto> getUserById(@PathVariable("id") Long id) {
        if (userService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        if(userService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    errors.put(fieldName, message);
                }
        );
        return errors;

    }

}