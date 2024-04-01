package com.generation.scuolarest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.scuolarest.dao.ClasseDAO;
import com.generation.scuolarest.entities.Classe;
import com.generation.scuolarest.entities.Entity;

@Service
public class ClasseService {
    @Autowired
    private ClasseDAO classeDAO;

    public Classe findClasseByIdStudente(int id){
        return classeDAO.readFromIdStudente(id);
    }

    public List<Classe> findAll(){
        Map<Integer, Entity> result = classeDAO.read();
        List<Classe> ris = new ArrayList<>();

        for(Entity e : result.values()){
            if(e instanceof Classe){
                ris.add((Classe)e);
            }
        }

        return ris;
    }

    public Classe findById(int id){
        return classeDAO.readFromId(id);
    }
}
