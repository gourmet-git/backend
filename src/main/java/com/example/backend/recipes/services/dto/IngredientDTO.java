package com.example.backend.recipes.services.dto;

import lombok.Data;

@Data
public class IngredientDTO {
    private String id;
    private String name;

    public  IngredientDTO() {}
}
