package com.generation.scuolarest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.scuolarest.dao.UserDAO;
import com.generation.scuolarest.entities.Persona;

@Service
public class LoginService {
    @Autowired
    private UserDAO userDAO;


    public Persona findUser(String username, String password){
        return userDAO.readFromUsernameAndPassword(username, password);
    }
}
