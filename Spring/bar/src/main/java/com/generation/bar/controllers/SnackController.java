package com.generation.bar.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.bar.entities.Bevanda;
import com.generation.bar.entities.Snack;
import com.generation.bar.services.BevandaService;
import com.generation.bar.services.SnackService;

@Controller
public class SnackController
{
    @Autowired
    private SnackService snackService;

    @Autowired
    private ApplicationContext context;

    @GetMapping("/allSnacks")
    public String allsnacks(Model model)
    {
        List<Snack> listaSnacks = snackService.findAll();
        model.addAttribute("snacks", listaSnacks);

        return "Snacks.html";
    }
 
    //http:localhost:8080/dettaglioSnack?id=[ID]
    @GetMapping("/dettaglioSnack")
    public String dettaglio(Model model, @RequestParam(name = "id") int id)
    {
        Snack s = snackService.findById(id);
        model.addAttribute("snack", s);

        return "dettaglioSnack.html";
    }
    //meno consigliato
    //../dettaglioBevanda/1
    //../dettaglioBevanda/2
    //../dettaglioBevanda/n
    /* @GetMapping("/dettaglioBevanda/{id}")
    public String dettaglio1(Model model, @PathVariable("id") int id)
    {
        Bevanda b = bevandaService.findById(id);
        model.addAttribute("bevanda", b);

        return "dettaglioBevanda.html";
    } */


    @PostMapping("/inserisciSnack")
    public String inserisciBevanda(@RequestParam Map<String, String> params)
    {
        snackService.insertSnack(params);
        //System.out.println("Nome :" + b.getNome());
        //System.out.println("Prezzo : " + b.getPrezzo());

        return "redirect:/allSnacks";
    }

    @PostMapping("/modificaSnack")
    public String modificaSnack(@RequestParam Map<String, String> params)
    {
        snackService.modificaSnack(params);
        //System.out.println("Nome :" + b.getNome());
        //System.out.println("Prezzo : " + b.getPrezzo());

        return "redirect:/allSnacks";
    }

    @GetMapping("/eliminaSnack")
    public String eliminaSnack(@RequestParam(name = "id") int id)
    {
        snackService.eliminaSnack(id);

        return "redirect:/allSnacks";
    }   
}
