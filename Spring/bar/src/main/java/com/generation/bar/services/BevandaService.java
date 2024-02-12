package com.generation.bar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.generation.bar.dao.BevandaDAO;
import com.generation.bar.entities.Bevanda;
import com.generation.bar.entities.Entity;

@Component
public class BevandaService
{
    /* @Autowired
    private BevandaDAO bevandaDAO; */

    @Autowired
    private ApplicationContext context;


    
    public List<Bevanda> findAll()
    {
        BevandaDAO bevandaDAO = context.getBean(BevandaDAO.class);
        Map<Integer, Entity> data = bevandaDAO.read();
        List<Bevanda> ris = new ArrayList<>();

        for (Entity e : data.values())
        {
            if(e instanceof Bevanda)
            {
                ris.add((Bevanda)e);
            }
        }

        return ris;
    }


    public Bevanda findById(int id)
    {
        BevandaDAO bevandaDAO = context.getBean(BevandaDAO.class);
        Map<Integer, Entity> data  = bevandaDAO.read();

        return (Bevanda)data.get(id);
    }

    public List<Bevanda> findByNome(String nome)
    {
        BevandaDAO bevandaDAO = context.getBean(BevandaDAO.class);
        Map<Integer, Entity> data = bevandaDAO.read(nome);

        List<Bevanda> ris = new ArrayList<>();

        for (Entity e : data.values())
        {
            if (e instanceof Bevanda)
            {
                ris.add((Bevanda)e);
            }
        }

        return ris;
    } 

    public void insertBevanda(Map<String, String> params)
    {
        BevandaDAO bevandaDAO = context.getBean(BevandaDAO.class);
        Bevanda b = context.getBean(Bevanda.class, params);
        bevandaDAO.create(b);
    }

    public void modificaBevanda(Map<String, String> params)
    {
        BevandaDAO bevandaDAO = context.getBean(BevandaDAO.class);
        Bevanda b = context.getBean(Bevanda.class, params);
        bevandaDAO.update(b);
    }

    public void eliminaBevanda(int id)
    {
        BevandaDAO bevandaDAO = context.getBean(BevandaDAO.class);
        bevandaDAO.delete(id);
    }
}
