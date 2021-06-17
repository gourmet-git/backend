package com.example.backend.recipes.services;

import com.example.backend.recipes.exceptions.DishNotFoundException;
import com.example.backend.recipes.repositories.models.Dish;
import com.example.backend.recipes.repositories.DishRepository;
import com.example.backend.recipes.services.dto.DishDTO;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    private Mapper mapper;

    private DishRepository repository;

    @Autowired
    public DishServiceImpl(Mapper m, DishRepository r) {
        this.mapper = m;
        this.repository = r;
    }

    @Override
    public DishDTO getDish(String dishId) {
        Optional<Dish> dish = this.repository.findById(dishId);
        if (dish.isEmpty()) {
            throw new DishNotFoundException(String.format("Dish: %s not Found", dishId));
        }
        return this.mapper.map(dish.get(), DishDTO.class);
    }

    @Override
    public DishDTO saveDish(DishDTO dishDTO) {
        Dish dish = this.mapper.map(dishDTO, Dish.class);
        Dish saved = this.repository.save(dish);
        return this.mapper.map(saved, DishDTO.class);
    }

    @Override
    public List<DishDTO> getAll() {
        List<DishDTO> dishesDTO = new ArrayList<>();
        Iterable<Dish> dishes = this.repository.findAll();
        dishes.forEach( d -> dishesDTO.add(this.mapper.map(d, DishDTO.class)));
        return dishesDTO;
    }
}
