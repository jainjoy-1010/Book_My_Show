package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;
    @ManyToMany
    private List<Actor> actors;
}
/*
1        m
Movie   actor
m       1
 */