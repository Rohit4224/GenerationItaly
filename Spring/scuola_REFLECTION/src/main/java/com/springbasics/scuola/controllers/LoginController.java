package com.springbasics.scuola.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbasics.scuola.entities.Dirigente;
import com.springbasics.scuola.entities.Docente;
import com.springbasics.scuola.entities.Persona;
import com.springbasics.scuola.entities.Studente;
import com.springbasics.scuola.services.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    @GetMapping("/loginpage")
    public String loginpage(HttpSession session){

        if(session.getAttribute("logged") != null){
            if("OK".equals(session.getAttribute("logged"))){
                switch(session.getAttribute("role").toString().toLowerCase()){
                    case "studente":
                        return "redirect:/areapersonale-studenti";
                    case "docente":
                        return "redirect:/areapersonale-docenti";
                    case "dirigente":
                        return "redirect:/areapersonale-dirigenti";
                    default:
                        session.invalidate();
                        return "loginpage.html";
                }
            }
        }

        return "loginpage.html";
    }


    @PostMapping("/login")
    public String login(@RequestParam Map<String, String> params, HttpSession session){
        Persona p = loginService.checkAndReturnLogin(params.get("username"), params.get("password"));

        if(p == null){
            return "redirect:/loginpage";
        }
        
        if(p instanceof Studente){
            session.setAttribute("role", "studente");
            session.setAttribute("logged", "OK");
            session.setAttribute("idPersona", p.getId());
            return "redirect:/areapersonale-studenti";
        }
        else if(p instanceof Docente){
            session.setAttribute("role", "docente");
            session.setAttribute("logged", "OK");
            session.setAttribute("idPersona", p.getId());
            return "redirect:/areapersonale-docenti";
        }
        else if(p instanceof Dirigente){
            session.setAttribute("role", "dirigente");
            session.setAttribute("logged", "OK");
            session.setAttribute("idPersona", p.getId());
            return "redirect:/areapersonale-dirigenti";
        }
        else{
            return "redirect:/loginpage";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/loginpage";
    }
}
