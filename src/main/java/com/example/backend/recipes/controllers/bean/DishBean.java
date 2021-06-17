package com.example.backend.recipes.controllers.bean;

import com.example.backend.recipes.repositories.models.Recipe;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishBean {
    private String id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String photo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Recipe> recipes = new ArrayList<>();
    public DishBean() {}
}
