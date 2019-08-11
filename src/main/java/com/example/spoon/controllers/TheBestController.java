package com.example.spoon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TheBestController {
    @GetMapping("/the_best")
    public String getBestController(){
        return "the_best.html";
    }
}
