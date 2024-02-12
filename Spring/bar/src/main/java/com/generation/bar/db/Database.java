package com.generation.bar.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Database implements IDatabase
{

    private String user = "root";
    private String password = "12345699";
    private String path = "jdbc:mysql://127.0.0.1:3306/";
    private final String fusoOrario = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
	
    //private Connection c;
    
	private Connection connection;


    /* public Database (String nomeDb) */
	public Database (@Value("${database.name}") String nomeDb)
    {
        try
    	{
			path = path + nomeDb + "?" + fusoOrario;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		connection = DriverManager.getConnection(path,user,password);
    	}
    	catch (ClassNotFoundException ex)
    	{
    		System.out.println("Error loading in driver");
    		ex.printStackTrace();
    	}
    	catch (SQLException ex)
    	{
    		System.out.println("Error in opening connection");
    		ex.printStackTrace();
    	}
    }

	public void closeConnection() {
        try {
            connection.close();
        }
        catch(SQLException e) {
            System.out.println("Errore chiusura connesione");
        }
    }

	public Connection getConnection() {
        return connection;
    }

	

    /* public Database(String nomeDB)
    {
    	setC(nomeDB);
    }
    
    public Connection getC()
    {
    	return c;
    }
    
    public void setC(String nomeDB)
    {
    	this.path = path + nomeDB + "?" + fusoOrario;
    }
    

    public void open()
    {
    	try
    	{
    		// ATTENZIONE, IL driver cambia in base alla versioni del JAR che usate
    		// se avete dubbi, il driver trovate su MAVEN REPOSITORY o Google
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		c = DriverManager.getConnection(path,user,password);
    	}
    	catch (ClassNotFoundException ex)
    	{
    		System.out.println("Error loading in driver");
    		ex.printStackTrace();
    	}
    	catch (SQLException ex)
    	{
    		System.out.println("Error in opening connection");
    		ex.printStackTrace();
    	}
    }
    
    // Lo scopo di questo metodo è chiudere il ponte aperto precedentemente
    public void close()
    {
    	try
    	{
    		c.close();
		}
    	catch (SQLException e)
    	{
			System.out.println("Contralla che apriConnessione() funzioni");
			e.printStackTrace();
		}
    } */
    
} // fine classe Database


//mariadb
	//private String url = "jdbc:mariadb://localhost:3306/";
	//Class.forName("org.mariadb.jdbc.Driver");