package com.springbasics.scuola.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    

    @GetMapping("/")
    public String root(){
        return "redirect:/loginpage";
    }
}
