package com.springbasics.scuola.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Docente extends Persona{
    private List<Classe> listaClassi;
}
