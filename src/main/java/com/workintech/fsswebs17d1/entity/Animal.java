package com.workintech.fsswebs17d1.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Animal {
    private int id;
    private String name;

    public Animal(){

    }

    public Animal(int id){
        this.id = id;
    }

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
