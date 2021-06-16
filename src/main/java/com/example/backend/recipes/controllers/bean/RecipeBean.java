package com.example.backend.recipes.controllers.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.util.List;

@Data
public class RecipeBean {

    private String id;
    private String name;
    private String source;
    private int servingSize;

    @JsonInclude(Include.NON_NULL)
    private List<IngredientBean> ingredients;

    public  RecipeBean() {}
}
