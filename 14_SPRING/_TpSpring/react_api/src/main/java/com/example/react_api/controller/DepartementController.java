package com.example.react_api.controller;


import com.example.react_api.dto.DepartementDto;
import com.example.react_api.service.impl.DepartementServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/departments")
public class DepartementController {

    private final DepartementServiceImpl departementService;

    @PostMapping("/save")
    public ResponseEntity<String> createDepartement( @RequestBody DepartementDto departementDto) {
        departementService.create(departementDto);
        return ResponseEntity.ok("Departement created");
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartementDto>> getAllDepartements() {
        if (departementService.findAll() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departementService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DepartementDto> getDepartementById(@PathVariable("id") Long id) {
        if (departementService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departementService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DepartementDto> updatedepartementById(@PathVariable("id") Long id,  @RequestBody DepartementDto departementDto) {
        if (departementService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departementService.update(id, departementDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartementById(@PathVariable("id") Long id) {
        if (departementService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        departementService.delete(id);
        return ResponseEntity.ok("Departement deleted");
    }
}
