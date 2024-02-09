package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements IDatabase
{
	//anagrafe3

    private String user = "root";
    private String password = "12345699";
    private String path = "jdbc:mysql://127.0.0.1:3306/";
    private final String fusoOrario = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    private Connection c;
    
    public Database(String nomeDB)
    {
    	// ricordate di importare il JAR 
    	setPath(nomeDB);
    }
    
    public Connection getC()
    {
    	return c;
    }
    
    public void setPath(String nomeDB)
    {
    	this.path = path + nomeDB + "?" + fusoOrario;
    }
    
    // lo scopo di questo metodo è per aprire un ponte che colleghi Java al DBMS 
    // Finchè il ponte è accesibile possiamo dialogare con il DMBS ma cosi facendo ricordiamoci
    // che stiamo occupando un posto e i posti nei server sono limitati, quindi non lasciate 
    // aperta la connessione più del lavoro
    public void apriConnessione()
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
    public void chiudiConnessione()
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
    }
    
} // fine classe Database


//mariadb
	//private String url = "jdbc:mariadb://localhost:3306/";
	//Class.forName("org.mariadb.jdbc.Driver");