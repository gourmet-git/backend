package com.example.backend.recipes.controllers;

import com.example.backend.recipes.controllers.bean.RecipeBean;
import com.example.backend.recipes.models.Recipe;
import com.example.backend.recipes.services.PhotoService;
import com.example.backend.recipes.services.RecipePhotoService;
import com.example.backend.recipes.services.RecipeService;
import com.example.backend.recipes.services.dto.RecipeDTO;
import com.github.dozermapper.core.Mapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RecipePhotoController {

    private Mapper mapper;

    private RecipePhotoService  recipePhotoService;

    public RecipePhotoController(Mapper m,RecipePhotoService recipePhotoService) {
        this.mapper = m;
        this.recipePhotoService = recipePhotoService;

    }

    @PutMapping("/recipes/{id}/photos")
    public RecipeBean addPhoto(@PathVariable String id, @RequestParam("image") MultipartFile multipartFile) throws Exception {
        RecipeDTO recipeUpdated = this.recipePhotoService.addPhoto(multipartFile, id);
        return this.mapper.map(recipeUpdated, RecipeBean.class);
    }
}
