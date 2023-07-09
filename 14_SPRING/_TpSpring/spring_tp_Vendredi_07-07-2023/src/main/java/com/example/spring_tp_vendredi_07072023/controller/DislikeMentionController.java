package com.example.spring_tp_vendredi_07072023.controller;


import com.example.spring_tp_vendredi_07072023.Dto.DislikeMentionDto;
import com.example.spring_tp_vendredi_07072023.service.impl.DislikeMentionServiceImpl;
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
@RequestMapping("/dislikeMentions")
public class DislikeMentionController {

    private final DislikeMentionServiceImpl dislikeMentionService;


    @PostMapping("/save")
    public ResponseEntity<String> createDislikeMention(@Valid @RequestBody DislikeMentionDto dislikeMentionDto) {
        if (dislikeMentionService.create(dislikeMentionDto) == null) {
            return ResponseEntity.badRequest().build();
        }
        dislikeMentionService.create(dislikeMentionDto);
        return ResponseEntity.ok("DislikeMention created");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DislikeMentionDto> updateDislikeMentionById(@PathVariable("id") Long id, @Valid @RequestBody DislikeMentionDto dislikeMentionDto) {
        if (dislikeMentionService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dislikeMentionService.update(id, dislikeMentionDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDislikeMentionById(@PathVariable("id") Long id) {
        if (dislikeMentionService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        dislikeMentionService.deleteById(id);
        return ResponseEntity.ok("DislikeMention deleted");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DislikeMentionDto> getDislikeMentionById(@PathVariable("id") Long id) {
        if (dislikeMentionService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dislikeMentionService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DislikeMentionDto>> getAllDislikeMentions() {
        if (dislikeMentionService.findAll() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dislikeMentionService.findAll());
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
