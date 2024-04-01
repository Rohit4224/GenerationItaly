package com.generation.scuolarest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.scuolarest.entities.Classe;
import com.generation.scuolarest.entities.Studente;
import com.generation.scuolarest.services.ClasseService;
import com.generation.scuolarest.services.PersonaService;


//Un RestController è un controller che risponde con dei JSON (JavaScript Object Notation) che sono dei formati universali per descrivere degli oggetti
//I RestController sono anche Sateless cioè non hanno lo stato del client e quindi non ne conservano le informazioni, semplicemente
//sono li che ascoltano eventuali richieste e rispondono.
//Creeremo tante richieste REST quanti sono i dati specifici di cui abbiamo bisogno.
//Queste richieste posso farle anche senza avere un frontend ad esempio tramite postman per simulare e testare le risposte
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/persona")
public class PersonaRestController {
    @Autowired
    private PersonaService personaService;

    //http://localhost:8080/api/persona/studente-all
    @GetMapping("/studente-all")
    public List<Studente> getAllStudenti(){
        return personaService.findAllStudenti();
    }

    //http://localhost:8080/api/persona/studente-byId?idStudente=[VALORE]
    @GetMapping("/studente-byId")
    public Studente getStudenteById(@RequestParam("idStudente") int id){
        return personaService.findStudenteById(id);
    }

    

    //Prova di un endopoint POST con accesso al body e ad un header specifico
    // @PostMapping("/prova-post")
    // public List<Studente> provaPost(@RequestBody Map<String, String> body, @RequestHeader("MioHeader") String contentType){
    //     System.out.println("HEADER content-type: " + contentType + "\nBODY:\n" + body);
    //     return personaService.findAllStudenti();
    // }






}
