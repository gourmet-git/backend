package com.example.backend.recipes.repositories.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @Column(name="dish_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String name;
    private String photo;

    @OneToMany(
            mappedBy = "dish",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Recipe> recipes = new ArrayList<>();
    public Dish() {}
}
