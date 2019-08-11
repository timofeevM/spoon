package com.example.spoon.services;

import com.example.spoon.models.Recipe;
import com.example.spoon.repositorys.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    public Recipe getRecipeById(int id){
        return recipeRepository.findById(id);
    }
    public void delRecipeById(int id){
        recipeRepository.deleteById(id);
    }

    public List<Recipe> getRecipeByCategory(String category){
        return recipeRepository.findByCategory(category);
    }

    public List<Recipe> getAllRecipe(){
        return recipeRepository.findAll();
    }

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public List<Recipe> getMyRecipe(String author){
        return recipeRepository.findByAuthorName(author);
    }
}