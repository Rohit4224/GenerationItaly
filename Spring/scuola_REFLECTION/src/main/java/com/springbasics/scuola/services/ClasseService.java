package com.springbasics.scuola.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springbasics.scuola.database.ClasseDAO;
import com.springbasics.scuola.entities.Classe;

public class ClasseService {
    
    @Autowired
    private ClasseDAO classeDAO;

    public Classe findClasseById(int idClasse){
        return (Classe)classeDAO.readOne(idClasse);
    }

    public List<Classe> findAll(){
        return classeDAO.read().values()
        .stream()
        .map(
            e -> (Classe)e
        )
        .toList();
    }

    public List<Classe> findClassiByIdDocente(int idDocente){
        return classeDAO.readFromIdDocente(idDocente).values()
        .stream()
        .map(
            e -> (Classe)e
        )
        .toList();
    }

    public void addClasseToDocente(int idClasse, int idDocente){
        classeDAO.addClasseToDocente(idClasse, idDocente);
    }
}
