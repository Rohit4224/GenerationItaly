package com.springbasics.scuola.entities;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Persona extends Entity {
    private String nome;
    private String cognome;
    private Date dataNascita;
    private String username;
    private String password;
    
}
