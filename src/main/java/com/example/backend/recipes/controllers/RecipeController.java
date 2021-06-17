package com.example.backend.recipes.controllers;

import com.example.backend.recipes.controllers.bean.RecipeBean;
import com.example.backend.recipes.services.RecipeService;
import com.example.backend.recipes.services.dto.RecipeDTO;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/recipes")
public class RecipeController {

    private Mapper mapper;

    private RecipeService recipeService;

    @Autowired
    public RecipeController(Mapper r, RecipeService s) {
        this.mapper = r;
        this.recipeService = s;
    }

    @GetMapping()
    public List<RecipeBean> getAll() {
        List<RecipeBean> list = new ArrayList<>();
        List<RecipeDTO> recipes = this.recipeService.getAll();
        recipes.stream().forEach( r -> list.add(this.mapper.map(r, RecipeBean.class)));
        return list;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeBean createRecipe(@RequestBody RecipeBean recipe) {
        RecipeDTO recipeDTO = this.mapper.map(recipe, RecipeDTO.class);
        RecipeDTO created =  this.recipeService.saveRecipe(recipeDTO);
        return this.mapper.map(created, RecipeBean.class);
    }

    @GetMapping("/{id}")
    public RecipeBean getRecipeById(@PathVariable String id) throws Exception {
        RecipeDTO recipe = this.recipeService.getRecipe(id);
        return  this.mapper.map(recipe, RecipeBean.class);
    }

}
