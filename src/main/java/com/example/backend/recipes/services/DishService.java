package com.example.backend.recipes.services;

import com.example.backend.recipes.services.dto.DishDTO;

import java.util.List;

public interface DishService {

    DishDTO getDish(String dishId);

    DishDTO saveDish(DishDTO dishDTO);

    List<DishDTO> getAll();
}
