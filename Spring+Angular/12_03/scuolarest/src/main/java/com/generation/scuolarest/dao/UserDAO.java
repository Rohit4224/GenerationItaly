package com.generation.scuolarest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.scuolarest.entities.Dirigente;
import com.generation.scuolarest.entities.Docente;
import com.generation.scuolarest.entities.Persona;
import com.generation.scuolarest.entities.Studente;

@Service
public class UserDAO {
    @Autowired
    private Database database;

    @Autowired
    private StudenteDAO studenteDAO;

    @Autowired
    private DocenteDAO docenteDAO;

    @Autowired
    private DirigenteDAO dirigenteDAO;

    public Persona readFromUsernameAndPassword(String username, String password){
        String query = "select id from persone where username = ? AND password = ?";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Persona ris = null;
        try{
            ps = database.getConnection().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                int idPersona = rs.getInt(1);
                Studente s = studenteDAO.readFromId(idPersona);
                Docente doc = docenteDAO.readFromId(idPersona);
                Dirigente dir = dirigenteDAO.readFromId(idPersona);

                if(s != null){
                    ris = s;
                }
                else if(doc != null){
                    ris = doc;
                }
                else if(dir != null){
                    ris = dir;
                }
                else{
                    ris = null;
                }
            }
            
        }
        catch(SQLException exc){
            System.out.println("Errore nella select in UserDAO");
        }
        finally{
            try{
                ps.close();
                rs.close();
            }
            catch(Exception exc){
                System.out.println("Errore chiusura PreparedStatement");
            }
        }
        return ris;
    }
}
