package com.example.backend.recipes.services.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeDTO{

    private String id;
    private String name;
    private String source;
    private int servingSize;
    private List<String> instructions = new ArrayList<>();
    private DishDTO dish;
    private List<String> ingredients = new ArrayList<>();
    public RecipeDTO() {}
}
