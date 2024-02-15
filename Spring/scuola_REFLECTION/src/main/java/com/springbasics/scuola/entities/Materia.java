package com.springbasics.scuola.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Materia extends Entity{
    private String nome;
    private int voto;
}
