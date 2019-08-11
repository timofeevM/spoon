package com.example.spoon.controllers;

import com.example.spoon.models.User;
import com.example.spoon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String getRegistrationController(){
        return "reg.html";
    }
    @PostMapping("/registration")
    @ResponseBody
    public boolean postRegistrationController(@RequestBody User user){
        if (userService.getUserByUsername(user.getUsername())==null){
            userService.save(user);
            return true;
        }else {
            return false;
        }
    }
}
