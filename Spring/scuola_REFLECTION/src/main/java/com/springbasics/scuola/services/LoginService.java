package com.springbasics.scuola.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.springbasics.scuola.database.UserDAO;
import com.springbasics.scuola.entities.Persona;

public class LoginService {
    @Autowired
    private UserDAO userDAO;


    public Persona checkAndReturnLogin(String username, String password){
        return userDAO.readUsernameAndPassword(username, password);
    }
    

}
