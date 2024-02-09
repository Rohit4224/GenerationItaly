package com.generation.bar.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.bar.entities.Bevanda;
import com.generation.bar.services.BevandaService;

@Controller // it tells Spring that this class will handle web requests.
public class BevandaController
{
    @Autowired
    private BevandaService bevandaService;

    @Autowired
    private ApplicationContext context;

    @GetMapping("/allBevande")
    public String allBevande(Model model)
    {
        List<Bevanda> listaBevande = bevandaService.findAll();
        model.addAttribute("bevande", listaBevande);

        return "Bevande.html";
    }

    //http:localhost:8080/dettaglioBevanda?id=[ID]
    @GetMapping("/dettaglioBevanda")
    public String dettaglio(Model model, @RequestParam(name = "id") int id)
    {
        Bevanda b = bevandaService.findById(id);
        model.addAttribute("bevanda", b);

        return "dettaglioBevanda.html";
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


   /*  @GetMapping("/inserisciBevanda")
    public String inserisciBevanda(@RequestParam("nome") String nome, 
                @RequestParam(name = "prezzo") double prezzo)
    {
        System.out.println("Nome :" + nome);
        System.out.println("Prezzo : " + prezzo);
        return "Bevande.html";
    } */

    @PostMapping("/inserisciBevanda")
    public String inserisciBevanda(@RequestParam Map<String, String> params)
    {
        bevandaService.insertBevanda(params);
        /* System.out.println("Nome :" + b.getNome());
        System.out.println("Prezzo : " + b.getPrezzo()); */

        return "redirect:/allBevande";
    }

    @PostMapping("/modificaBevanda")
    public String modificaBevanda(@RequestParam Map<String, String> params)
    {
        bevandaService.modificaBevanda(params);
        /* System.out.println("Nome :" + b.getNome());
        System.out.println("Prezzo : " + b.getPrezzo()); */

        return "redirect:/allBevande";
    }

    @GetMapping("/eliminaBevanda")
    public String eliminaBevanda(@RequestParam(name = "id") int id)
    {
        bevandaService.eliminaBevanda(id);

        return "redirect:/allBevande";
    }

}
