package com.generation.scuolarest.dto;

public class LoginStatus {
    //RUOLO-IsLogin-IdPersona
    private String token;


    public void setToken(String ruolo, boolean isLogin, int idPersona){
        //ESEMPIO DI TOKEN
        //STUDENTE-true-16
        token = ruolo+"-"+isLogin+"-"+idPersona;
    }

    public String getRuolo(){
        return token.split("-")[0];
    }

    public boolean getLogin(){
        return Boolean.parseBoolean(token.split("-")[1]);
    }

    public int getIdpersona(){
        return Integer.parseInt(token.split("-")[2]);
    }

    public String getToken(){
        return token;
    }


}
