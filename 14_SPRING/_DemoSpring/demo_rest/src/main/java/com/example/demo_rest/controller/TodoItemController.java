package com.example.demo_rest.controller;


import com.example.demo_rest.entity.TodoItem;
import com.example.demo_rest.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;


    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        String message = "todoItem non trouvé";
        if (!todoItemService.getTodoItemById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        }
        return ResponseEntity.ok(todoItemService.getTodoItemById(id).get());
    }

    @PostMapping("/create")
    public ResponseEntity<String> post(@RequestBody TodoItem todoItem) {
        if (todoItem.getName() == null || todoItem.getDate() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("le nom et la date sont obligatoires");
        }
        todoItemService.createTodoItem(todoItem);
        return ResponseEntity.ok("todoItem créé");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> put(@PathVariable("id") Integer id, @RequestBody TodoItem todoItem) {
        if (todoItem.getName() == null || todoItem.getDate() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("le nom et la date sont obligatoires");
        }
        todoItemService.updateTodoItem(id, todoItem);
        return ResponseEntity.ok("todoItem créé");
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<TodoItem>> getAll() {
        return ResponseEntity.ok((Iterable<TodoItem>) todoItemService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

//test if id is present

        if (!todoItemService.getTodoItemById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("todoItem non trouvé");

        }
            todoItemService.deleteTodoItem(id);
            return ResponseEntity.ok("todoItem supprimé");
        }

}

