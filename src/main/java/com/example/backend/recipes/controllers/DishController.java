package com.example.backend.recipes.controllers;

import com.example.backend.recipes.controllers.bean.DishBean;
import com.example.backend.recipes.services.DishService;
import com.example.backend.recipes.services.dto.DishDTO;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private Mapper mapper;

    private DishService dishService;

    @Autowired
    public DishController(Mapper r, DishService s) {
        this.mapper = r;
        this.dishService = s;
    }

    @GetMapping()
    public List<DishBean> getAll() {
        List<DishBean> list = new ArrayList<>();
        List<DishDTO> dishes = this.dishService.getAll();
        dishes.stream().forEach( r -> list.add(this.mapper.map(r, DishBean.class)));
        return list;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public DishBean createDish(@RequestBody DishBean Dish) {
        DishDTO dishDTO = this.mapper.map(Dish, DishDTO.class);
        DishDTO created =  this.dishService.saveDish(dishDTO);
        return this.mapper.map(created, DishBean.class);
    }

    @GetMapping("/{id}")
    public DishBean getDishById(@PathVariable String id) throws Exception {
        DishDTO dish = this.dishService.getDish(id);
        return  this.mapper.map(dish, DishBean.class);
    }
}
