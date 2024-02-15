package com.springbasics.scuola.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbasics.scuola.entities.Dirigente;
import com.springbasics.scuola.entities.Docente;
import com.springbasics.scuola.entities.Materia;
import com.springbasics.scuola.entities.Studente;
import com.springbasics.scuola.services.ClasseService;
import com.springbasics.scuola.services.MateriaService;
import com.springbasics.scuola.services.PersonaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ClasseService classeService;

    @Autowired
    private MateriaService materiaService;

    @GetMapping("/areapersonale-studenti")
    public String areaStudenti(HttpSession session, Model model){
        
        if(session.getAttribute("logged") != null){
            if("OK".equals(session.getAttribute("logged"))){
                if(!"studente".equalsIgnoreCase(session.getAttribute("role").toString())) return "redirect:/loginpage";
                
                int idPersona = Integer.parseInt(session.getAttribute("idPersona").toString());
                Studente s = personaService.findStudenteById(idPersona);
                model.addAttribute("studente", s);
                return "studenti.html";
            }
        }
        return "redirect:/loginpage";
    }

    @GetMapping("/areapersonale-docenti")
    public String areaDocenti(HttpSession session, Model model){
        
        if(session.getAttribute("logged") != null){
            if("OK".equals(session.getAttribute("logged"))){
                if(!"docente".equalsIgnoreCase(session.getAttribute("role").toString())) return "redirect:/loginpage";
                
                int idPersona = Integer.parseInt(session.getAttribute("idPersona").toString());
                Docente d = personaService.findDocenteById(idPersona);
                model.addAttribute("docente", d);
                return "docenti.html";
            }
        }
        return "redirect:/loginpage";
    }

    @GetMapping("/areapersonale-dirigenti")
    public String areaDirigenti(HttpSession session, Model model){
        
        if(session.getAttribute("logged") != null){
            if("OK".equals(session.getAttribute("logged"))){
                if(!"dirigente".equalsIgnoreCase(session.getAttribute("role").toString())) return "redirect:/loginpage";
                
                int idPersona = Integer.parseInt(session.getAttribute("idPersona").toString());
                Dirigente d = personaService.findDirigenteById(idPersona);

                model.addAttribute("listaClassi", classeService.findAll());
                model.addAttribute("listaDocenti", personaService.findAllDocenti());
                model.addAttribute("dirigente", d);
                return "dirigenti.html";
            }
        }
        return "redirect:/loginpage";
    }

    @GetMapping("/dettagliDocente/{idDocente}")
    public String dettagliDocente(@PathVariable int idDocente, HttpSession session, Model model){
        
        
        if(session.getAttribute("logged") != null){
            if("OK".equals(session.getAttribute("logged"))){
                if(!"dirigente".equalsIgnoreCase(session.getAttribute("role").toString())) return "redirect:/loginpage";
                
                Docente d = personaService.findDocenteById(idDocente);
                model.addAttribute("docente", d);
                model.addAttribute("listaClassi", d.getListaClassi());
                model.addAttribute("allListaClassi", classeService.findAll());
                return "dettagliDocente.html";
            }
        }
        return "redirect:/loginpage";
    }

    @GetMapping("/dettagliStudente/{idStudente}")
    public String dettagliStudente(@PathVariable int idStudente, HttpSession session, Model model){
        
        
        if(session.getAttribute("logged") != null){
            if("OK".equals(session.getAttribute("logged"))){
                if(!"dirigente".equalsIgnoreCase(session.getAttribute("role").toString())) return "redirect:/loginpage";
                
                Studente s = personaService.findStudenteById(idStudente);
                model.addAttribute("studente", s);
                model.addAttribute("listaMaterie", s.getMaterie());
                
                
                model.addAttribute("mediaTotaleVoti", 
                                    s.getMaterie().stream()
                                    .mapToDouble(Materia::getVoto)
                                    .average()
                                    .orElse(0.0)
                );
                return "dettagliStudente.html";
            }
        }
        return "redirect:/loginpage";
    }

    @PostMapping("/docente-aggiungi-classe")
    public String spostaDocente(@RequestParam Map<String, String> params){
        int idClasse = Integer.parseInt(params.get("idClasse"));
        int idDocente = Integer.parseInt(params.get("idDocente"));
        classeService.addClasseToDocente(idClasse, idDocente);
        return "redirect:/areapersonale-dirigenti";
    }
}
