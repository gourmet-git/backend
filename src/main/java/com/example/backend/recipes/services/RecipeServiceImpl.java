package com.example.backend.recipes.services;

import com.example.backend.recipes.RecipeRepository;
import com.example.backend.recipes.models.Recipe;
import com.example.backend.recipes.services.dto.RecipeDTO;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl  implements  RecipeService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private RecipeRepository repository;

    @Override
    public RecipeDTO createRecipe(RecipeDTO recipe) {
        Recipe model = this.mapper.map(recipe, Recipe.class);
        Recipe created = this.repository.save(model);
        return this.mapper.map(created, RecipeDTO.class);
    }
}
