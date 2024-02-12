package com.generation.bar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.generation.bar.dao.SnackDAO;
import com.generation.bar.entities.Bevanda;
import com.generation.bar.entities.Entity;
import com.generation.bar.entities.Snack;

@Component
public class SnackService
{
    @Autowired
    private SnackDAO snackDAO;

    @Autowired
    private ApplicationContext context;

    public List<Snack> findAll()
    {
        Map<Integer, Entity> data = snackDAO.read();
        List<Snack> ris = new ArrayList<>();

        for (Entity e : data.values())
        {
            if(e instanceof Snack)
            {
                ris.add((Snack)e);
            }
        }

        return ris;
    }


    public Snack findById(int id)
    {
        Map<Integer, Entity> data  = snackDAO.read();

        return (Snack)data.get(id);
    }

    public List<Snack> findByNome(String nome)
    {
        Map<Integer, Entity> data = snackDAO.read(nome);

        List<Snack> ris = new ArrayList<>();

        for (Entity e : data.values())
        {
            if (e instanceof Snack)
            {
                ris.add((Snack)e);
            }
        }

        return ris;
    }

    public void insertSnack(Map<String, String> params)
    {
        Snack b = context.getBean(Snack.class, params);
        snackDAO.create(b);
    }

    public void modificaSnack(Map<String, String> params)
    {
        Snack b = context.getBean(Snack.class, params);
        snackDAO.update(b);
    }

    public void eliminaSnack(int id)
    {
        snackDAO.delete(id);
    }
}
