package com.springbasics.scuola.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbasics.scuola.database.ClasseDAO;
import com.springbasics.scuola.database.Database;
import com.springbasics.scuola.database.DirigenteDAO;
import com.springbasics.scuola.database.DocenteDAO;
import com.springbasics.scuola.database.MateriaDAO;
import com.springbasics.scuola.database.StudenteDAO;
import com.springbasics.scuola.database.UserDAO;

@Configuration
public class DatabaseContext {
    @Bean
    public Database db(){
        return new Database("scuola");
    }

    @Bean
    public ClasseDAO newClasseDAO(){
        return new ClasseDAO();
    }

    @Bean DirigenteDAO newDirigenteDAO(){
        return new DirigenteDAO();
    }

    @Bean DocenteDAO newDocenteDAO(){
        return new DocenteDAO();
    }

    @Bean StudenteDAO newStudenteDAO(){
        return new StudenteDAO();
    }

    @Bean UserDAO newUserDAO(){
        return new UserDAO();
    }

    @Bean MateriaDAO newMateriaDAO(){
        return new MateriaDAO();
    }
}
