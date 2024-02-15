package com.springbasics.scuola.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.springbasics.scuola.entities.Classe;
import com.springbasics.scuola.entities.Entity;
import com.springbasics.scuola.entities.Docente;

public class DocenteDAO implements IDAO{
    @Autowired
    private Database db;

	@Autowired
	private ClasseDAO classeDAO;

    @Autowired
    private ApplicationContext context;


    @Override
	public boolean create(Entity e) {
		String query = "insert into persone(nome, cognome, data_nascita) values(?, ?, ?)";
		boolean ris = false;
        ris = db.eseguiUpdate(query, 
                                ((Docente)e).getNome(), 
                                ((Docente)e).getCognome(), 
                                ((Docente)e).getDataNascita().toString()
        );

        query =	"insert into docenti(id) values((select max(id) from persone))";
        ris &= db.eseguiUpdate(query);

        query = "insert into classi_docenti(id_docente, id_classe) values((select max(id) from persone), ?)";
        for(Classe c : ((Docente)e).getListaClassi()){
            ris &= db.eseguiUpdate(query, c.getId()+"");
        }

        return ris;
    }

	@Override
	public Map<Integer, Entity> read() {
		String query = "select * from persone p inner join docenti d on p.id = d.id";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query);
		
		Map<Integer, Entity> ris = new HashMap<>();
		for(Entry<Integer, Map<String, String>> entry : result.entrySet()) {
			Docente e = context.getBean(Docente.class, entry.getValue());
			e.setListaClassi(
				classeDAO.readFromIdDocente(e.getId()).values()
				.stream()
				.map(
					v -> (Classe)v
				)
				.toList()
			);
			ris.put(entry.getKey(), e);
		}
		return ris;
	}
	

	public Entity readOne(int idDocente) {
		String query = "select * from persone p inner join docenti d on p.id = d.id where p.id=?";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idDocente+"");
		
		if(result.values().size() == 1) {
			Docente e = context.getBean(Docente.class, new ArrayList<>(result.values()).get(0));
			e.setListaClassi(
				classeDAO.readFromIdDocente(e.getId()).values()
				.stream()
				.map(
					v -> (Classe)v
				)
				.toList()
			);
			return e;
		}
		else {
			return null;
		}
	}

	public Map<Integer, Entity> readFromIdClasse(int idClasse){
		String query = "select p.id, p.nome, p.cognome, p.data_nascita, p.username, p.password from classi_docenti cd inner join docenti d on d.id = cd.id_docente inner join persone p on d.id = p.id where id_classe=?";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idClasse+"");
		
		Map<Integer, Entity> ris = new HashMap<>();
		for(Entry<Integer, Map<String, String>> entry : result.entrySet()) {
			Docente e = context.getBean(Docente.class, entry.getValue());
			e.setListaClassi(
				classeDAO.readFromIdDocente(e.getId()).values()
				.stream()
				.map(
					v -> (Classe)v
				)
				.toList()
			);
			ris.put(entry.getKey(), e);
		}
		return ris;
	}

	@Override
	public boolean update(Entity e) {
		String query = "update persone set nome=?, cognome=?, data_nascita=? where id=?";
		boolean ris = false;
        ris = db.eseguiUpdate(query, ((Docente)e).getNome(), ((Docente)e).getCognome(), ((Docente)e).getDataNascita().toString(), ((Docente)e).getId()+"");
        return ris;
    }

	@Override
	public boolean delete(int id) {
		String query = "delete from docenti where id=?";
		return db.eseguiUpdate(query, id+"");
	}
}
