package com.springbasics.scuola.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbasics.scuola.services.ClasseService;
import com.springbasics.scuola.services.LoginService;
import com.springbasics.scuola.services.MateriaService;
import com.springbasics.scuola.services.PersonaService;

@Configuration
public class ServicesContext {
    @Bean
    public ClasseService newClasseService(){
        return new ClasseService();
    }

    @Bean
    public LoginService newLoginService(){
        return new LoginService();
    }

    @Bean
    public PersonaService newPersonaService(){
        return new PersonaService();
    }

    @Bean
    public MateriaService newMateriaService(){
        return new MateriaService();
    }
}
