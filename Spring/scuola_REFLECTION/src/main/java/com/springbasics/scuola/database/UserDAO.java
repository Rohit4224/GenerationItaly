package com.springbasics.scuola.database;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.springbasics.scuola.entities.Dirigente;
import com.springbasics.scuola.entities.Docente;
import com.springbasics.scuola.entities.Persona;
import com.springbasics.scuola.entities.Studente;

public class UserDAO {
    @Autowired
    private Database db;

    @Autowired
    private StudenteDAO studenteDAO;

    @Autowired
    private DocenteDAO docenteDAO;

    @Autowired
    private DirigenteDAO dirigenteDAO;

	public boolean creaUtenza(Persona e) {
		String query = "update persone set username=?, password=? where id=?";
		boolean ris = false;
        ris = db.eseguiUpdate(query, 
                                ((Persona)e).getUsername(), 
                                ((Persona)e).getPassword(),
                                ((Persona)e).getId()+""
        );
        return ris;
    }
    
	public Persona readUsernameAndPassword(String username, String password) {
		String query = "select id from persone where username=? and password=?";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query, username, password);
		
		if(result.values().size() == 1) {
            int idPersona = Integer.parseInt(new ArrayList<>(result.values()).get(0).get("id"));
            Studente s = (Studente)studenteDAO.readOne(idPersona);
            Docente doc = (Docente)docenteDAO.readOne(idPersona);
            Dirigente dir = (Dirigente)dirigenteDAO.readOne(idPersona);

            if(s != null){
                return s;
            }
            else if(doc != null){
                return doc;
            }
            else if(dir != null){
                return dir;
            }
            else{
                return null;
            }
		}
		else {
			return null;
		}
	}
}
