package com.example.spring_tp_vendredi_07072023.controller;


import com.example.spring_tp_vendredi_07072023.Dto.CommentDto;
import com.example.spring_tp_vendredi_07072023.service.impl.CommentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentServiceImpl commentService;

    @PostMapping("/save")
    public ResponseEntity<String> createComment(@Valid @RequestBody CommentDto commentDto) {
        if (commentService.create(commentDto) == null) {
            return ResponseEntity.badRequest().build();

        }
        return ResponseEntity.ok("Comment created");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable("id") Long id, @Valid @RequestBody CommentDto commentDto) {
        if (commentService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(commentService.update(id, commentDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCommentById(@PathVariable("id") Long id) {
        if (commentService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        commentService.deleteById(id);
        return ResponseEntity.ok("Comment deleted");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable("id") Long id) {
        if (commentService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(commentService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<CommentDto>> getAllComments() {

        if (commentService.findAll() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(commentService.findAll());
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
