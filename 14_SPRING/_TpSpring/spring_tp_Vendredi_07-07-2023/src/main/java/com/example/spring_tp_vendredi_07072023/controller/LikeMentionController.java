package com.example.spring_tp_vendredi_07072023.controller;


import com.example.spring_tp_vendredi_07072023.Dto.LikeMentionDto;
import com.example.spring_tp_vendredi_07072023.service.impl.LikeMentionServiceImpl;
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
@RequestMapping("/likeMentions")
public class LikeMentionController {

    private final LikeMentionServiceImpl likeMentionService;


    @PostMapping("/save")
    public ResponseEntity<String> createLikeMention( @RequestBody LikeMentionDto likeMentionDto) {
        if (likeMentionService.create(likeMentionDto) == null) {
            return ResponseEntity.badRequest().build();
        }
       likeMentionService.create(likeMentionDto);
        return ResponseEntity.ok("LikeMention created");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LikeMentionDto> updateLikeMentionById(@PathVariable("id") Long id, @Valid @RequestBody LikeMentionDto likeMentionDto) {
        if (likeMentionService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(likeMentionService.update(id, likeMentionDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLikeMentionById(@PathVariable("id") Long id) {
        if (likeMentionService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        likeMentionService.deleteById(id);
        return ResponseEntity.ok("LikeMention deleted");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<LikeMentionDto> getLikeMentionById(@PathVariable("id") Long id) {
        if (likeMentionService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(likeMentionService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<LikeMentionDto>> getAllLikeMentions() {
        if (likeMentionService.findAll() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(likeMentionService.findAll());
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