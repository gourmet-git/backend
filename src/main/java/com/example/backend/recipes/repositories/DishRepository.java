package com.example.backend.recipes.repositories;

import com.example.backend.recipes.repositories.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DishRepository extends JpaRepository<Dish, String> {
}
