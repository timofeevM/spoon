package com.example.spoon.controllers;

import com.example.spoon.models.Recipe;
import com.example.spoon.models.User;
import com.example.spoon.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
public class LikeController {

    @Autowired
    RecipeService recipeService;

    @PostMapping("/likes")
    public int likesController(@RequestBody Recipe recipe){
        Recipe recipe1 = recipeService.getRecipeById(recipe.getId());
        Set<Integer> likesUser = recipe1.getLikesUser();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (likesUser.contains(user.getId())){
            recipe1.setLikes(recipe1.getLikes()-1);
            likesUser.remove(user.getId());
        }else {
            likesUser.add(user.getId());
            recipe1.setLikes(recipe1.getLikes()+1);
        }
        recipe1.setLikesUser(likesUser);
        recipeService.save(recipe1);
        return recipe1.getLikes();
    }

    @PostMapping("/checked_like")
    public boolean checkLikeController(@RequestBody Recipe recipe){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (recipe.getLikesUser().contains(user.getId())){
            return true;
        }else {
            return false;
        }

    }
}
