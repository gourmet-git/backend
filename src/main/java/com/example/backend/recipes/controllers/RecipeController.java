package com.example.backend.recipes.controllers;

import com.example.backend.recipes.controllers.bean.RecipeBean;
import com.example.backend.recipes.services.RecipeService;
import com.example.backend.recipes.services.dto.RecipeDTO;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @Autowired
    private Mapper mapper;

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/recipes")
    public RecipeBean createRecipe(@RequestBody RecipeBean recipe) {
        RecipeDTO recipeDTO = this.mapper.map(recipe, RecipeDTO.class);
        RecipeDTO created =  this.recipeService.createRecipe(recipeDTO);
        return this.mapper.map(created, RecipeBean.class);
    }
}
