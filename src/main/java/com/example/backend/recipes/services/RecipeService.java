package com.example.backend.recipes.services;

import com.example.backend.recipes.services.dto.RecipeDTO;

public interface RecipeService {

    /**
     * It creates a new recipe
     *
     * @param recipe to create
     * */
    RecipeDTO createRecipe(RecipeDTO recipe);
}
