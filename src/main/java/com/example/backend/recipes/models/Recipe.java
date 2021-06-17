package com.example.backend.recipes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "recipes")
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String name;
    private String source;
    private int servingSize;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "recipes_ingredients")
    private List<Ingredient> ingredients;

    public Recipe() {}
}
