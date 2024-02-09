package com.generation.bar.configurations;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.generation.bar.entities.Bevanda;
import com.generation.bar.entities.Snack;

@Configuration
public class EntitiesContext 
{
    @Bean
    @Scope("prototype")
    public Bevanda newBevanda(Map<String, String> params)
    {

        int id = params.containsKey("id") ? Integer.parseInt(params.get("id")) : -1;
        String nome = params.containsKey("nome") ? params.get("nome") : ""; 
        double prezzo = params.containsKey("prezzo") ? Double.parseDouble(params.get("prezzo")) : -1;

        Bevanda b = new Bevanda(
                                id,
                                nome,
                                prezzo
                                );
        return b;
    }

    @Bean
    @Scope("prototype")
    public Snack newStack(Map<String, String> params)
    {

    int id = params.containsKey("id") ? Integer.parseInt(params.get("id")) : -1;
    String nome = params.containsKey("nome") ? params.get("nome") : "";
    double prezzo = params.containsKey("prezzo") ? Double.parseDouble(params.get("prezzo")) : -1;
    int quantita = params.containsKey("quantita") ? Integer.parseInt(params.get("quantita")) : -1;
    //boolean salato = Boolean.parseBoolean((params.get("salato")));
    boolean salato = params.get("salato").equalsIgnoreCase("true") || params.get("salato").equalsIgnoreCase("on")
                    || params.get("salato").equalsIgnoreCase("si");

    Snack s = new Snack(
        id,
        nome,
        prezzo,
        quantita,
        salato
    );
        return s;
    }
}
