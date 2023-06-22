package com.example.exercice1.controller;


import com.example.exercice1.entity.Personne;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/api/personnes")
public class PersonneController {

    private  List<Personne> personnes = new ArrayList<>(
            Arrays.asList(
                    new Personne(1, "toto", "tata"),
                    new Personne(2, "titi", "tutu")
            )
    );

@GetMapping
    public String getListPersonne() {
        return personnes.toString();
    }


    @PostMapping("/add")
    public Personne addPersonne(@RequestBody Personne personne) {
        System.out.println(personne);
        personnes.add(personne);
           return personne;
    }

    @GetMapping("/get/{id}")
    public String getPersonne(@PathVariable("id") Integer id) {

    return personnes.get(id).toString();
    }
}
