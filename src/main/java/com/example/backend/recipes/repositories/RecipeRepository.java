package com.example.backend.recipes.repositories;

import com.example.backend.recipes.repositories.models.Recipe;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,String> {
}
