package com.springbasics.scuola.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.springbasics.scuola.entities.Classe;
import com.springbasics.scuola.entities.Entity;
import com.springbasics.scuola.entities.Materia;
import com.springbasics.scuola.entities.Studente;

public class StudenteDAO implements IDAO {

    @Autowired
    private Database db;

    @Autowired
    private ClasseDAO classeDAO;

    @Autowired
    private ApplicationContext context;

	@Autowired
	private MateriaDAO materiaDAO;

    @Override
	public boolean create(Entity e) {
		String query = "insert into persone(nome, cognome, data_nascita) values(?, ?, ?)";
		boolean ris = false;
        ris = db.eseguiUpdate(query, 
                                ((Studente)e).getNome(), 
                                ((Studente)e).getCognome(), 
                                ((Studente)e).getDataNascita().toString()
        );

        query =	"insert into studenti(id, id_classe) values((select max(id) from persone), ?)";
        ris &= db.eseguiUpdate(query, 
                                ((Studente)e).getClasse().getId()+""
        );

        return ris;
    }

	public Map<Integer, Entity> readFromIdClasse(int idClasse) {
		String query = "select * from persone p inner join studenti s on p.id = s.id where s.id_classe=?";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idClasse+"");
		
		
		Map<Integer, Entity> ris = new HashMap<>();
		for(Entry<Integer, Map<String, String>> entry : result.entrySet()) {
			Studente s = context.getBean(Studente.class, entry.getValue());
            s.setClasse((Classe)classeDAO.readOne(s.getClasse().getId()));
			s.setMaterie(materiaDAO.readFromIdStudente(s.getId()));
			ris.put(entry.getKey(), s);
		}
		return ris;
	}

	public Map<Integer, Entity> read() {
		String query = "select * from persone p inner join studenti s on p.id = s.id";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query);
		
		Map<Integer, Entity> ris = new HashMap<>();
		for(Entry<Integer, Map<String, String>> entry : result.entrySet()) {
			Studente s = context.getBean(Studente.class, entry.getValue());
            s.setClasse((Classe)classeDAO.readOne(s.getClasse().getId()));
			s.setMaterie(materiaDAO.readFromIdStudente(s.getId()));
			ris.put(entry.getKey(), s);
		}
		return ris;
	}
	

	public Entity readOne(int idStudente) {
		String query = "select * from persone p inner join studenti s on p.id = s.id where p.id=?";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idStudente+"");
		
		if(result.values().size() == 1) {
			Studente s = context.getBean(Studente.class, new ArrayList<>(result.values()).get(0));
			s.setClasse((Classe)classeDAO.readOne(s.getClasse().getId()));
            s.setMaterie(materiaDAO.readFromIdStudente(s.getId()));
			return s;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean update(Entity e) {
		String query = "update persone set nome=?, cognome=?, data_nascita=? where id=?";
		boolean ris = false;
        ris = db.eseguiUpdate(query, ((Studente)e).getNome(), ((Studente)e).getCognome(), ((Studente)e).getDataNascita().toString(), ((Studente)e).getId()+"");
        query = "update studenti set id_classe=? where id=?";
        ris &= db.eseguiUpdate(query, ((Studente)e).getClasse().getId()+"", ((Studente)e).getId()+"");
        return ris;
    }

	@Override
	public boolean delete(int id) {
		String query = "delete from persone where id=?";
		return db.eseguiUpdate(query, id+"");
	}
    
}
