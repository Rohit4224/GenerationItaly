package com.springbasics.scuola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springbasics.scuola.entities.Classe;
import com.springbasics.scuola.entities.Docente;
import com.springbasics.scuola.entities.Studente;
import com.springbasics.scuola.services.ClasseService;
import com.springbasics.scuola.services.PersonaService;

@Controller
public class ClasseController {
    
    @Autowired
    private ClasseService classeService;

    @Autowired
    private PersonaService personaService;

    @GetMapping("/dettagliclasse/{idClasse}")
    public String dettagliClasse(@PathVariable int idClasse, Model model){
        Classe c = classeService.findClasseById(idClasse);
        List<Docente> listaDocenti = personaService.findDocentiByIdClasse(idClasse);
        List<Studente> listaStudenti = personaService.findStudentiByIdClasse(idClasse);

        model.addAttribute("classe", c);
        model.addAttribute("listaDocenti", listaDocenti);
        model.addAttribute("listaStudenti", listaStudenti);
        return "dettagliClasse.html";
    }
}
