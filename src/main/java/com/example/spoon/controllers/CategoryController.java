package com.example.spoon.controllers;

import com.example.spoon.models.Recipe;
import com.example.spoon.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    RecipeService recipeService;

    @GetMapping("/category")
    public String categoryController(){
        return "category.html";
    }

    @GetMapping("/categorys")
    @ResponseBody
    public List<Recipe> recipeCatListController(String category){
        return recipeService.getRecipeByCategory(category);
    }
}
