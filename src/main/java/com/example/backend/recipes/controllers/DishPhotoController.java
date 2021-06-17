package com.example.backend.recipes.controllers;

import com.example.backend.recipes.controllers.bean.DishBean;
import com.example.backend.recipes.controllers.bean.RecipeBean;
import com.example.backend.recipes.services.DishPhotoService;
import com.example.backend.recipes.services.dto.DishDTO;
import com.example.backend.recipes.services.dto.RecipeDTO;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DishPhotoController {

    private Mapper mapper;

    private DishPhotoService dishPhotoService;

    @Autowired
    public DishPhotoController(Mapper m, DishPhotoService dishPhotoService) {
        this.mapper = m;
        this.dishPhotoService = dishPhotoService;

    }

    @PutMapping("/dishes/{id}/photos")
    public DishBean addPhoto(@PathVariable String id, @RequestParam("image") MultipartFile multipartFile) throws Exception {
        DishDTO dishUpdated = this.dishPhotoService.addPhoto(multipartFile, id);
        return this.mapper.map(dishUpdated, DishBean.class);
    }
}
