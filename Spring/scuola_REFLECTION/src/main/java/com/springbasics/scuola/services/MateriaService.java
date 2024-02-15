package com.springbasics.scuola.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springbasics.scuola.database.MateriaDAO;
import com.springbasics.scuola.entities.Materia;

public class MateriaService {
    @Autowired
    private MateriaDAO materiaDAO;

    public List<Materia> findMaterieByIdStudente(int idStudente){
        return materiaDAO.readFromIdStudente(idStudente);
    }
}
