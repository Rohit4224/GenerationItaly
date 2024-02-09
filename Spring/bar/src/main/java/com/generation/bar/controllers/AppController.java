package com.generation.bar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // it tells Spring that this class will handle web requests.
public class AppController
{
    @GetMapping({"/", "/home"})
    public String home()
    {
        System.out.println("/home is processed");
        return "MainPage.html";
    }
}
