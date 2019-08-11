package com.example.spoon.controllers;

import com.example.spoon.models.Recipe;
import com.example.spoon.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class DeleteRecipeController {
    @Autowired
    RecipeService recipeService;

    @PostMapping("/delete")
    public void delController(@RequestBody Recipe recipe){
        new File(recipe.getPhoto()).delete();
        recipeService.delRecipeById(recipe.getId());
    }
}
