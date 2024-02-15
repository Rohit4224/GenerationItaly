package com.springbasics.scuola.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.springbasics.scuola.entities.Entity;
import com.springbasics.scuola.entities.Materia;

public class MateriaDAO implements IDAO{

    @Autowired
    private Database db;

    @Autowired
    private ApplicationContext context;

    @Override
    public boolean create(Entity e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Map<Integer, Entity> read() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Materia> readFromIdStudente(int idStudente){
        String query = "select ms.id, m.nome, ms.voto from materie_studenti ms inner join materie m on ms.id_materia = m.id where ms.id_studente=?";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idStudente+"");
        List<Materia> listaMaterie = new ArrayList<>();
        for(Entry<Integer, Map<String, String>> entry : result.entrySet()){
            listaMaterie.add(context.getBean(Materia.class, entry.getValue()));
        }
        return listaMaterie;
    }

    @Override
    public boolean update(Entity e) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
