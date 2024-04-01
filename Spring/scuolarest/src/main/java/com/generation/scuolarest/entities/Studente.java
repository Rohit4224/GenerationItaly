package com.generation.scuolarest.entities;

import java.sql.Date;

public class Studente extends Persona{
    private Classe classe;

    public Studente(int id, String nome, String cognome, Date dataNascita, String username, String password) {
        super(id, nome, cognome, dataNascita, username, password);
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
