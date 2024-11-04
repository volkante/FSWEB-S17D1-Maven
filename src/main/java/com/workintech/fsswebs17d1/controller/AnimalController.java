package com.workintech.fsswebs17d1.controller;

import com.workintech.fsswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path= "/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    @PostConstruct
    public void loadAll(){
        System.out.println("postconstruct çalıştı");
        this.animals = new HashMap<>();
        this.animals.put(1,new Animal(1,"maymun"));
        this.animals.put(2,new Animal(2,"tavsan"));
    }

    @GetMapping
    public List<Animal> findAll(){
        System.out.println("Animals findAll method triggered ");
        //return animals.values().stream().toList();
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal find(@PathVariable int id){
        return animals.get(id);
    }

    @PostMapping
    public void add(Animal animal){
        animals.put(animal.getId(),animal);
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id, new Animal(animal.getId(), animal.getName()));
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        animals.remove(id);
    }

}
