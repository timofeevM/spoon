package com.example.spoon.controllers;

import com.example.spoon.models.Recipe;
import com.example.spoon.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    RecipeService recipeService;

    @GetMapping("/")
    public String getMainController(){
        return "main.html";
    }
    @GetMapping("/all_recipes")
    @ResponseBody
    public List<Recipe> allRecipeController(){
        return recipeService.getAllRecipe();
    }
}
