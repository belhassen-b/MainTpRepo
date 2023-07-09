package com.example.spring_tp_vendredi_07072023.controller;


import com.example.spring_tp_vendredi_07072023.Dto.PostDto;
import com.example.spring_tp_vendredi_07072023.service.impl.PostServiceImpl;
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
@RequestMapping("/posts")
public class PostController {

    private final PostServiceImpl postService;

    @PostMapping("/save")
    public ResponseEntity<String> createPost(@Valid @RequestBody PostDto postDto) {
        if (postService.create(postDto) == null) {
            return ResponseEntity.badRequest().build();
        }
        postService.create(postDto);
        return ResponseEntity.ok("Post created");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PostDto> updatePostById(@PathVariable("id") Long id, @Valid @RequestBody PostDto postDto) {
        if (postService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postService.update(id, postDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        if (postService.findAll() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") Long id) {
        if (postService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable("id") Long id) {
        if (postService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        postService.deleteById(id);
        return ResponseEntity.ok("Post deleted");
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
