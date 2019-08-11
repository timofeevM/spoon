package com.example.spoon.controllers;

import com.example.spoon.models.Recipe;
import com.example.spoon.models.User;
import com.example.spoon.services.RecipeService;
import com.example.spoon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Controller
public class SaveRecipeController {

    @Autowired
    RecipeService recipeService;
    @Autowired
    UserService userService;

    @GetMapping("/save_recipe")
    public String saveController() {
        return "save_recipe.html";
    }

    @GetMapping("/save_recipes")
    @ResponseBody
    public Set<Recipe> userSavesRecipeListController(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Set<Recipe> recipes = new HashSet<>();
        Iterator<Integer> iter = user.getSaveRecipe().iterator();
        while (iter.hasNext()) {
            Recipe recipe = recipeService.getRecipeById(iter.next());
            if (recipe!=null){
               recipes.add(recipe);
            }
        }
        return recipes;
    }

    @PostMapping("/saves_recipe")
    @ResponseBody
    public void likesController(@RequestBody Recipe recipe) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getSaveRecipe().contains(recipe.getId())){
            user.getSaveRecipe().remove(recipe.getId());
            userService.save(user);
        }else {
            user.getSaveRecipe().add(recipe.getId());
            userService.save(user);
        }
    }

    @PostMapping("/checked_save")
    @ResponseBody
    public boolean checkedSaveController(@RequestBody Recipe recipe) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getSaveRecipe().contains(recipe.getId())) {
            return true;
        } else {
            return false;
        }

    }
}