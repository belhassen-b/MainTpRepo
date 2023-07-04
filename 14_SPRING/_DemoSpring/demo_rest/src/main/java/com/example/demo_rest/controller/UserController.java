package com.example.demo_rest.controller;


import com.example.demo_rest.entity.User;
import com.example.demo_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/created")
    public ResponseEntity<String> post(@RequestBody User user) {
        if (user == null || user.getEmail() == null || user.getPassword() == null) {
            String message = "requête invalide : l'utilisateur doit avoir un email et un mot de passe";
            return ResponseEntity.badRequest().body(message);
        }
        userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("utilisateur créé");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        String message = "la liste des utilisateurs est vide";

        if(users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message);
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") Integer id) {
    if(id == null) {
        String message = "requête invalide : l'utilisateur doit avoir un id";
        return ResponseEntity.badRequest().body(message);
    }
    User user = userService.getUserById(id);
    return ResponseEntity.ok(user.toString());
    }
//
//    @PutMapping("/put/{id}")
//    public ResponseEntity<String> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
////if ( !userService.getTodoItemById(id).isPresent()) {
//
//        String message = "l'utilisateur n'existe pas";
//    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
//
//        userService.updateUser(id, user);
//        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/all")).build();
//    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        if (userService.getUserById(id) == null) {
            String message = "l'utilisateur n'existe pas";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
                userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/all")).build();
    }
}


//        if (id == null) {
//            String message = "requête invalide : l'utilisateur doit avoir un id";
//            return ResponseEntity.badRequest().body(message);
//        }