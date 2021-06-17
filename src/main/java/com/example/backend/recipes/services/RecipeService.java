package com.example.backend.recipes.services;

import com.example.backend.recipes.services.dto.RecipeDTO;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    /**
     * It retrieves an specific recipe
     * */
    RecipeDTO getRecipe(String id) throws Exception;
    /**
     * It creates a new recipe
     *
     * @param recipe to create
     * */
    RecipeDTO saveRecipe(RecipeDTO recipe);

    /**
     * It retrieves all recipes in the system
     * */
    List<RecipeDTO> getAll();

}
