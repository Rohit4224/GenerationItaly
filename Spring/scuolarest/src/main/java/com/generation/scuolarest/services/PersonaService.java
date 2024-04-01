package com.generation.scuolarest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.generation.scuolarest.dao.ClasseDAO;
import com.generation.scuolarest.dao.DirigenteDAO;
import com.generation.scuolarest.dao.DocenteDAO;
import com.generation.scuolarest.dao.StudenteDAO;
import com.generation.scuolarest.entities.Classe;
import com.generation.scuolarest.entities.Entity;
import com.generation.scuolarest.entities.Studente;

@Service
public class PersonaService {
    @Autowired
    private StudenteDAO studenteDAO;

    @Autowired
    private DocenteDAO docenteDAO;

    @Autowired
    private DirigenteDAO dirigenteDAO;

    @Autowired
    private ClasseDAO classeDAO;

    @Autowired
    private ApplicationContext context;

    public Studente findStudenteById(int id){
        return studenteDAO.readFromId(id);
    }

    public List<Studente> findAllStudenti(){
        Map<Integer, Entity> result = studenteDAO.read();
        List<Studente> ris = new ArrayList<>();
        
        for(Entity e : result.values()){
            if(e instanceof Studente){
                ris.add((Studente)e);
            }
        }

        return ris;
    }

    public boolean updateStudente(Map<String, String> params){
        Studente s = context.getBean(Studente.class, params);
        Classe c = classeDAO.readFromId(Integer.parseInt(params.get("classe")));
        s.setClasse(c);
        studenteDAO.update(s);
        return true;
    }
}
