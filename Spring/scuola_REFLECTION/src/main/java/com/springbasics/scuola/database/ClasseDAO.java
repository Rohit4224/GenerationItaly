package com.springbasics.scuola.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.springbasics.scuola.entities.Entity;
import com.springbasics.scuola.entities.Classe;

public class ClasseDAO implements IDAO {

    @Autowired
    private Database db;

    @Autowired
    private ApplicationContext context;


    @Override
	public boolean create(Entity e) {
		String query = "insert into classi(sezione) values(?)";
		boolean ris = false;
        ris = db.eseguiUpdate(query, 
                                ((Classe)e).getSezione()
        );
        return ris;
    }

	public boolean addClasseToDocente(int idClasse, int idDocente){
		String query = "insert into classi_docenti(id_docente, id_classe) values(?, ?)";
		boolean ris = false;
        ris = db.eseguiUpdate(query, idDocente+"", idClasse+"");
		return ris;
	}

	@Override
	public Map<Integer, Entity> read() {
		String query = "select * from classi";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query);
				
		Map<Integer, Entity> ris = new HashMap<>();
		for(Entry<Integer, Map<String, String>> entry : result.entrySet()) {
			Classe e = context.getBean(Classe.class, entry.getValue());
			ris.put(entry.getKey(), e);
		}
		return ris;
	}
	
	public Map<Integer, Entity> readFromIdDocente(int idDocente) {
		String query = "select c.id, c.sezione from classi_docenti cd inner join docenti d on d.id = cd.id_docente inner join classi c on cd.id_classe = c.id where id_docente=?";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idDocente+"");
				
		Map<Integer, Entity> ris = new HashMap<>();
		for(Entry<Integer, Map<String, String>> entry : result.entrySet()) {
			Classe e = context.getBean(Classe.class, entry.getValue());
			ris.put(entry.getKey(), e);
		}
		return ris;
	}

	public Entity readOne(int idClasse) {
		String query = "select * from classi where id=?";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idClasse+"");

		if(result.values().size() == 1) {
			Entity e = context.getBean(Classe.class, new ArrayList<>(result.values()).get(0));
			return e;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean update(Entity e) {
		String query = "update classi set sezione=? where id=?";
		return db.eseguiUpdate(query, ((Classe)e).getSezione());
	}

	@Override
	public boolean delete(int id) {
		String query = "delete from classi where id=?";
		return db.eseguiUpdate(query, id+"");
	}
    
}
