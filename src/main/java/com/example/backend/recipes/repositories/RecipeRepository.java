package com.example.backend.recipes.repositories;

import com.example.backend.recipes.repositories.models.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecipeRepository extends PagingAndSortingRepository<Recipe,String> {
}
