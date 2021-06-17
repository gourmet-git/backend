package com.example.backend.recipes;

import com.example.backend.recipes.models.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecipeRepository extends PagingAndSortingRepository<Recipe,String> {
}
