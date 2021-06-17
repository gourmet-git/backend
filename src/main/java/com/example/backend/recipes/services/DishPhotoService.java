package com.example.backend.recipes.services;

import com.example.backend.recipes.services.dto.DishDTO;
import com.example.backend.recipes.services.dto.RecipeDTO;
import org.springframework.web.multipart.MultipartFile;

public interface DishPhotoService {

    DishDTO addPhoto(MultipartFile multipartFile, String dishId) throws Exception;
}
