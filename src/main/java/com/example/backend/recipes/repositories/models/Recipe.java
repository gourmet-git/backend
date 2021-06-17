package com.example.backend.recipes.repositories.models;

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
    private String instructions;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name="recipes_ingredients",
            joinColumns = @JoinColumn(name="recipe_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id")
    )
    private List<Ingredient> ingredients;

    public Recipe() {}
}
