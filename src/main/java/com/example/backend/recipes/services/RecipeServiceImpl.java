package com.example.backend.recipes.services;

import com.example.backend.recipes.RecipeRepository;
import com.example.backend.recipes.exceptions.RecipeNotFoundException;
import com.example.backend.recipes.models.Recipe;
import com.example.backend.recipes.services.dto.RecipeDTO;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl  implements  RecipeService {

    private Mapper mapper;

    private RecipeRepository repository;

    @Autowired
    public RecipeServiceImpl(Mapper m, RecipeRepository r) {
        this.mapper = m;
        this.repository = r;
    }

    @Override
    public RecipeDTO getRecipe(String id) throws Exception {
        Optional<Recipe> recipe = this.repository.findById(id);
        if (recipe.isEmpty()) {
            throw new RecipeNotFoundException("Recipe: "+id+ " not Found" );
        }
        return this.mapper.map(recipe.get(), RecipeDTO.class);
    }

    @Override
    @Transactional
    public RecipeDTO saveRecipe(RecipeDTO recipe) {
        Recipe model = this.mapper.map(recipe, Recipe.class);
        Recipe created = this.repository.save(model);
        return this.mapper.map(created, RecipeDTO.class);
    }

    @Override
    public List<RecipeDTO> getAll() {
        List<RecipeDTO> recipes = new ArrayList<>();
        Iterable<Recipe> entities = this.repository.findAll();
        entities.forEach(e -> recipes.add(this.mapper.map(e, RecipeDTO.class)));
        return  recipes;
    }
}
