package com.example.backend.recipes.repositories;

import com.example.backend.recipes.repositories.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,String> {
}
