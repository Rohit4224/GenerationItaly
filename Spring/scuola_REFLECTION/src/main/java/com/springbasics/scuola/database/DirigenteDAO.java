package com.springbasics.scuola.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.springbasics.scuola.entities.Dirigente;
import com.springbasics.scuola.entities.Entity;

public class DirigenteDAO implements IDAO{
    @Autowired
    private Database db;
    
    @Autowired
    private ApplicationContext context;


    @Override
	public boolean create(Entity e) {
		String query = "insert into persone(nome, cognome, data_nascita) values(?, ?, ?)";
		boolean ris = false;
        ris = db.eseguiUpdate(query, 
                                ((Dirigente)e).getNome(), 
                                ((Dirigente)e).getCognome(), 
                                ((Dirigente)e).getDataNascita().toString()
        );

        query =	"insert into dirigenti(id) values((select max(id) from persone))";
        ris &= db.eseguiUpdate(query);

        return ris;
    }

	@Override
	public Map<Integer, Entity> read() {
		String query = "select * from persone p inner join dirigenti d on p.id = d.id";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query);
		
//		Set<Entry<Integer, Map<String, String>>> listaCoppie = result.entrySet();		
		
		Map<Integer, Entity> ris = new HashMap<>();
		for(Entry<Integer, Map<String, String>> entry : result.entrySet()) {
			Dirigente s = context.getBean(Dirigente.class, entry.getValue());
			ris.put(entry.getKey(), s);
		}
		return ris;
	}
	

	public Entity readOne(int idDirigente) {
		String query = "select * from persone p inner join dirigenti d on p.id = d.id where p.id=?";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idDirigente+"");
		
		if(result.values().size() == 1) {
			Entity e = context.getBean(Dirigente.class, new ArrayList<>(result.values()).get(0));
			return e;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean update(Entity e) {
		String query = "update persone set nome=?, cognome=?, data_nascita=? where id=?";
		boolean ris = false;
        ris = db.eseguiUpdate(query, ((Dirigente)e).getNome(), ((Dirigente)e).getCognome(), ((Dirigente)e).getDataNascita().toString(), ((Dirigente)e).getId()+"");
        return ris;
    }

	@Override
	public boolean delete(int id) {
		String query = "delete from dirigenti where id=?";
		return db.eseguiUpdate(query, id+"");
	}
}
