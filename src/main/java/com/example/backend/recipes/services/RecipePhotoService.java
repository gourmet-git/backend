package com.example.backend.recipes.services;

import com.example.backend.recipes.services.dto.RecipeDTO;
import org.springframework.web.multipart.MultipartFile;

public interface RecipePhotoService {

    RecipeDTO addPhoto(MultipartFile multipartFile, String recipeId) throws Exception;
}
