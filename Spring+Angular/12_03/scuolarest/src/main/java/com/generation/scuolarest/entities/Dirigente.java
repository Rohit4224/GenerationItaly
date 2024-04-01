package com.generation.scuolarest.entities;

import java.sql.Date;

public class Dirigente extends Persona{
    
    public Dirigente(int id, String nome, String cognome, Date dataNascita, String username, String password) {
        super(id, nome, cognome, dataNascita, username, password);
    }
}
