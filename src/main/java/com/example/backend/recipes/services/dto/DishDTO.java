package com.example.backend.recipes.services.dto;

import com.example.backend.recipes.repositories.models.Recipe;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishDTO {

    private String id;
    private String name;
    private String photo;
    List<Recipe> recipes = new ArrayList<>();

    public DishDTO() {}
}
