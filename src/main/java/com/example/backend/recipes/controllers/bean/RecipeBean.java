package com.example.backend.recipes.controllers.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeBean {
    private String id;
    private String name;

    @JsonInclude(Include.NON_NULL)
    private String source;

    @JsonInclude(Include.NON_NULL)
    private int servingSize;

    @JsonInclude(Include.NON_NULL)
    private List<String> instructions = new ArrayList<>();

    @JsonIgnoreProperties("recipes")
    private DishBean dish;

    private List<String> ingredients = new ArrayList<>();

    public  RecipeBean() {}
}
