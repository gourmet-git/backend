package com.example.backend.recipes.services.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeDTO{

    private String id;
    private String name;
    private String source;
    private int servingSize;
    private String photo;

    private List<IngredientDTO> ingredients;

    public RecipeDTO() {}
}
