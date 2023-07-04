package com.example.demo_rest.controller;


import com.example.demo_rest.entity.ListTodoItem;
import com.example.demo_rest.service.ListTodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/todos")
public class ListTodoController {

    @Autowired
    private ListTodoItemService listTodoItemService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllTodos() {
        String message = "La liste est vide";
        if (listTodoItemService.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message);
        } else {
            return ResponseEntity.ok(listTodoItemService.getAll());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> post(@RequestBody ListTodoItem listTodoItem) {
        if (listTodoItem.getTitle() == null || listTodoItem.getDate() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("le nom et la date sont obligatoires");
        }
        return ResponseEntity.ok( listTodoItemService.createListTodoItem(listTodoItem));
    }

}
