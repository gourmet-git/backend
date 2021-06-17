package com.example.backend.recipes.repositories;

import com.example.backend.recipes.repositories.models.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, String> {
}
