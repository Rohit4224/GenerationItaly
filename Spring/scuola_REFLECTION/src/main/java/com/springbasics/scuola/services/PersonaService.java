package com.springbasics.scuola.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springbasics.scuola.database.DirigenteDAO;
import com.springbasics.scuola.database.DocenteDAO;
import com.springbasics.scuola.database.StudenteDAO;
import com.springbasics.scuola.entities.Dirigente;
import com.springbasics.scuola.entities.Docente;
import com.springbasics.scuola.entities.Studente;

public class PersonaService {
    @Autowired
    private StudenteDAO studenteDAO;

    @Autowired
    private DocenteDAO docenteDAO;

    @Autowired 
    private DirigenteDAO dirigenteDAO;

    public Studente findStudenteById(int idStudente){
        return (Studente)studenteDAO.readOne(idStudente);
    }

    public Docente findDocenteById(int idDocente){
        return (Docente)docenteDAO.readOne(idDocente);
    }

    public List<Docente> findAllDocenti(){
        return docenteDAO.read().values()
        .stream()
        .map(
            e -> (Docente)e
        )
        .toList();
    }

    public Dirigente findDirigenteById(int idDirigente){
        return (Dirigente)dirigenteDAO.readOne(idDirigente);
    }

    public List<Docente> findDocentiByIdClasse(int idClasse){
        return docenteDAO.readFromIdClasse(idClasse)
        .values()
        .stream()
        .map(
            e -> (Docente)e
        )
        .toList();
    }

    public List<Studente> findStudentiByIdClasse(int idClasse){
        return studenteDAO.readFromIdClasse(idClasse)
        .values()
        .stream()
        .map(
            e -> (Studente)e
        )
        .toList();
    }
}
