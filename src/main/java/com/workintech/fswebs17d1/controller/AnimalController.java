package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {
    Map<Integer, Animal>  animals = new HashMap<>();


    @PostConstruct
    public void loadAll() {
     this.animals = new HashMap<>();

     animals.put(1, new Animal(1, "maymun"));
     animals.put(2, new Animal(2, "Tiger"));
     animals.put(3, new Animal(3, "Elephant"));
    }

    @GetMapping
    public List<Animal> findAll() {
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping
    public Animal save(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;

    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable Integer id, @RequestBody Animal newAnimal) {
       this.animals.replace(id, newAnimal);
       return this.animals.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(Integer id) {
        animals.remove(id);
    }


}
