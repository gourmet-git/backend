package com.example.backend.recipes;

import com.example.backend.recipes.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe,String> {
}
