package com.generation.scuolarest.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Docente extends Persona{
    private List<Classe> classi = new ArrayList<>();

    public Docente(int id, String nome, String cognome, Date dataNascita, String username, String password) {
        super(id, nome, cognome, dataNascita, username, password);
    }

    public List<Classe> getClassi() {
        return classi;
    }

    public void setClassi(List<Classe> classi) {
        this.classi = classi;
    }
}
