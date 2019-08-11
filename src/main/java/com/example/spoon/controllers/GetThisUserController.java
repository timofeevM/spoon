package com.example.spoon.controllers;

import com.example.spoon.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetThisUserController {
    @GetMapping("/user")
    public User user(){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return user;
        }catch (Exception e){
            return null;
        }
    }
}
