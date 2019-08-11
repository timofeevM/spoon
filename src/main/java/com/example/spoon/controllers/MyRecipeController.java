package com.example.spoon.controllers;

import com.example.spoon.models.Recipe;
import com.example.spoon.models.User;
import com.example.spoon.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyRecipeController {
    @Autowired
    RecipeService recipeService;

    @GetMapping("/my_recipe")
    public String myRecipeController(){
        return "my_recipe.html";
    }


    @GetMapping("/my_recipes")
    @ResponseBody
    public List<Recipe> myRecipeListController(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return recipeService.getMyRecipe(user.getUsername());
    }
}
