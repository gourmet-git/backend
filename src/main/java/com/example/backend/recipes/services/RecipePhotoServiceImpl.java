package com.example.backend.recipes.services;

import com.example.backend.recipes.services.dto.RecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RecipePhotoServiceImpl implements  RecipePhotoService {

    private RecipeService recipeService;

    private PhotoService photoService;

    @Autowired
    public RecipePhotoServiceImpl(RecipeService s, PhotoService ps) {
        this.recipeService = s;
        this.photoService = ps;
    }

    @Override
    public RecipeDTO addPhoto(MultipartFile multipartFile, String recipeId) throws Exception {
        RecipeDTO recipeDTO = this.recipeService.getRecipe(recipeId);
        String directoryPath = String.format("/opt/resources/photos/%s", recipeId);
        String photoPath = this.photoService.save(multipartFile, directoryPath);
        recipeDTO.setPhoto(photoPath);
        return this.recipeService.saveRecipe(recipeDTO);
    }
}
