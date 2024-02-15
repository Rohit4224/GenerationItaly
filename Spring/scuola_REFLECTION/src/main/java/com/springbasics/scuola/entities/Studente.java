package com.springbasics.scuola.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Studente extends Persona{
    private Classe classe;
    private List<Materia> materie;

    public void setIdClasse(int idClasse){
        if(classe == null){
            classe = new Classe();
            classe.setId(idClasse);
        }
    }
}
