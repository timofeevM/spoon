package com.example.spoon.controllers;

import com.example.spoon.models.Recipe;
import com.example.spoon.models.User;
import com.example.spoon.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AddController {
    @Autowired
    RecipeService recipeService;

    @GetMapping("/add")
    public String addController(){
        return "add.html";
    }

    @PostMapping("/add")
    public String postAddController(Recipe recipe){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        recipe.setAuthorName(user.getUsername());
        recipeService.save(recipe);
        return "redirect:/";
    }
    @PostMapping("/img")
    @ResponseBody
    public String imgAddController(@RequestParam("img") MultipartFile photo){
        if (!photo.isEmpty()) {
            if (photo.getContentType().startsWith("image/")) {
                String fileName = UUID.randomUUID().toString() + photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
                File file = new File("images/" + fileName);
                File dirFile = new File("images");
                if(!dirFile.exists()){
                    dirFile.mkdir();
                }
                try {
                    file.createNewFile();
                    FileOutputStream fout = new FileOutputStream(file);
                    fout.write(photo.getBytes());
                    fout.close();
                    return "images/"+fileName;

                } catch (IOException e) {
                    return null;
                }

            } else {
                return null;
            }

        } else {
            return null;
        }
    }
}
