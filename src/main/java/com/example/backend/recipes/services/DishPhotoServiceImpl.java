package com.example.backend.recipes.services;

import com.example.backend.recipes.services.dto.DishDTO;
import com.example.backend.recipes.services.dto.RecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DishPhotoServiceImpl implements DishPhotoService {

    private DishService dishService;

    private PhotoService photoService;

    @Autowired
    public DishPhotoServiceImpl(DishService s, PhotoService ps) {
        this.dishService = s;
        this.photoService = ps;
    }

    @Override
    public DishDTO addPhoto(MultipartFile multipartFile, String dishId) throws Exception {
        DishDTO dishDTO = this.dishService.getDish(dishId);
        String directoryPath = String.format("/opt/resources/photos/%s", dishId);
        String photoPath = this.photoService.save(multipartFile, directoryPath);
        dishDTO.setPhoto(photoPath);
        return this.dishService.saveDish(dishDTO);
    }
}
