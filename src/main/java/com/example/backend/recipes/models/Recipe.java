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
    @Column(name="recipe_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String name;
    private String source;
    private int servingSize;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name="recipes_ingredients",
            joinColumns = @JoinColumn(name="recipe_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id")
    )
    private List<Ingredient> ingredients;

    public Recipe() {}
}
