package com.springbasics.scuola.configurations;

import java.sql.Date;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.springbasics.scuola.entities.Classe;
import com.springbasics.scuola.entities.Dirigente;
import com.springbasics.scuola.entities.Docente;
import com.springbasics.scuola.entities.Materia;
import com.springbasics.scuola.entities.Studente;

@Configuration
public class EntitiesContext {
    
    @Bean
    @Scope("prototype")
    public Studente newStudente(Map<String, String> params){
        return (Studente)new Studente().fromMap(params);
        // Studente e = new Studente();
        // e.setId(Integer.parseInt(params.get("id")));
        // e.setNome(params.get("nome"));
        // e.setCognome(params.get("cognome"));
        // e.setDataNascita(Date.valueOf(params.get("datanascita")));
        // e.setUsername(params.get("username"));
        // e.setPassword(params.get("password"));
        // e.setIdClasse(Integer.parseInt(params.get("idclasse")));
        // return e;
    }

    @Bean
    @Scope("prototype")
    public Docente newDocente(Map<String, String> params){
        return (Docente)new Docente().fromMap(params);
        // Docente e = new Docente();
        // e.setId(Integer.parseInt(params.get("id")));
        // e.setNome(params.get("nome"));
        // e.setCognome(params.get("cognome"));
        // e.setDataNascita(Date.valueOf(params.get("datanascita")));
        // e.setUsername(params.get("username"));
        // e.setPassword(params.get("password"));
        // return e;
    }

    @Bean
    @Scope("prototype")
    public Dirigente newDirigente(Map<String, String> params){
        // return (Dirigente)new Dirigente().fromMap(params);
        Dirigente e = new Dirigente();
        e.setId(Integer.parseInt(params.get("id")));
        e.setNome(params.get("nome"));
        e.setCognome(params.get("cognome"));
        e.setDataNascita(Date.valueOf(params.get("datanascita")));
        e.setUsername(params.get("username"));
        e.setPassword(params.get("password"));
        return e;
    }

    @Bean
    @Scope("prototype")
    public Classe newClasse(Map<String, String> params){
        // return (Classe)new Classe().fromMap(params);
        Classe e = new Classe();
        e.setId(Integer.parseInt(params.get("id")));
        e.setSezione(params.get("sezione"));
        return e;
    }

    @Bean
    @Scope("prototype")
    public Materia newMateria(Map<String, String> params){
        // return (Materia)new Materia().fromMap(params);
        Materia e = new Materia();
        e.setId(Integer.parseInt(params.get("id")));
        e.setNome(params.get("nome"));
        e.setVoto(Integer.parseInt(params.get("voto")));
        return e;
    }
}
