package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Theatre extends BaseModel {
    private String name;
    @OneToMany
    private List<Screen> screens;
    @ManyToOne
    private City city;

}
/*
1         m
Theatre   screen
1           1

1          1
theatre   city
m           1
 */