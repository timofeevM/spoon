package com.example.spoon.controllers;

import com.example.spoon.models.Recipe;
import com.example.spoon.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserRecipeController {
    @Autowired
    RecipeService recipeService;

    @GetMapping("/user_recipe")
    public String myRecipeController(){
        return "user_recipe.html";
    }
    @GetMapping("/user_recipes")
    @ResponseBody
    public List<Recipe> userRecipeListController(String author){
        return recipeService.getMyRecipe(author);
    }
}
