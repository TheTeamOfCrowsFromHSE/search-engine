package com.example.searchengine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(@RequestParam(name="string", required=false) String string, Model model) {
        model.addAttribute("title", "Search Engine");
        model.addAttribute("string", string);
        return "home";
    }
}