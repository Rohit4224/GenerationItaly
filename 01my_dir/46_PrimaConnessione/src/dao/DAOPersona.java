package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.IDatabase;
import entities.Entity;
import entities.Persona;

// DAO è un acronimo che sta per Data Access Object

// Essendo un acronimo per convenzione viene sempre scritto in CAPS

/*
 * Tutte le classi che iniziano per DAO sono classi il cui compito è quello di interrogare il
 * DBMS scambiando dati (facendo domande, cercando di fare inserimenti sul db, 
 * facendo modifiche o eliminazioni sui dati già presenti in tabella)
 * 
 * Solitamente abbiamo minimo un DAO per ogni tabella SQL e/o per ogni Classe JAVA
 * */

public class DAOPersona implements IDAO
{
	/*
	 * PATTERN : significa trovare una soluzione a un problema ricorrente nel tempo.
	 * I pattern si dividono in famiglie in base al tipo di problema che vanno a risolvere
	 * 
	 *Pattern SINGLETON -> impedisce la creazione di oggetti copia della classe in cui si usa
	 * */
	//STEP 1 : creo una variabile static che tenga in memoria se ho gia' creato un oggetto di
				// un tipo DAOPersona oppure no
	private static DAOPersona instance = null;
	
	
	//STEP 2 : privatizzo il costruttore, cosi da impedire la creazioni di oggetti non 
				// desiderati
	private DAOPersona(String nomeDB)
	{
		db = new Database(nomeDB);
	}
	
	// STEP 3 : creo un metodo statico pubblico che gestira' la creazione di un nuovo oggetto
				// di tipo DAOPersona: il metodo valutera' se instance ha un valore o meno,
				// se e' null crea un oggetto di tipo DAOPersona e lo salva in instance,
				// altrimenti restituisce l'oggetto gia' in memoria nella variabile instance
	
	public static DAOPersona getInstance()
	{
		if (instance == null)
			instance = new DAOPersona("anagrafe3");
		
		return instance;
	}
//	------------------------------------------------------------------------------
	private IDatabase db;
	
// Le classi DAO si occupano degli scambi con il DBMS	
// Quindi nelle classi DAO troviamo i cosi detti metodi CRUD -> Create, Read, Update, Delete
// i metodi CRUD sono il minimo indispensabile per una classe DAO
	
// DELETE : elimina un record alla volta della tabella
	public boolean delete(int id)
	{
		//STEP 1.) apro la connessione con il DBMS
		db.apriConnessione();
		
		//STEP 2.) scrivo la query che mi interessa eseguire
		String query = "DELETE FROM Persone WHERE id = " + id;
		
		
		try
		{
	//STEP 3: Creo un messaggero che sia capace di portare la query da JAVA al DBMS interssato
			PreparedStatement s = db.getC().prepareStatement(query);
			//preparedStatement cerca di trovare errori di sintassi di query 
		//STEP 4 : Ordina di eseguire la query sul DBMS
			int righe = s.executeUpdate();
			
			return righe > 0;
			
		}
		catch (Exception e)
		{
			System.out.println("Errore nel metodo DELETE di DAOPersona");
			e.printStackTrace();
			return false;
		}
		finally
		{
			// STEP  : chiudo la connessione con il DBMS
			db.chiudiConnessione();
		}
		
	}
	
	
	//UPDATE : modifica un record alla volta gia' esistente nelle tabella
	public boolean update(Entity e)
	{
		db.apriConnessione();
		
		Persona p = (Persona)e;
//		String query = "UPDATE Persone SET "
//						+ "nome = \""  + p.getNome() + "\", "
//						+ "Cognome = \""  + p.getCognome() + "\", "
//						+ "dob = \""  + p.getDob() + "\", "
//						+ "residenza = \""  + p.getResidenza() + "\", "
//						+ "genere = \""  + p.getGenere() + "\", "
//						+ "professione = \""  + p.getProfessione() + "\" "
//						+ "WHERE id = "  + p.getId();
		
		String query = "UPDATE Persone SET "
				+ "nome = ?, "
				+ "cognome = ?, "
				+ "dob = ?, "
				+ "residenza = ?, "
				+ "genere = ?,"
				+ "professione = ? WHERE id = "  + p.getId();
		
		try 
		{
			PreparedStatement ps = db.getC().prepareStatement(query);
			
			ps.setString(1, p.getNome());
	        ps.setString(2, p.getCognome());
	        ps.setString(3, p.getDob());
	        ps.setString(4, p.getResidenza());
	        ps.setString(5, p.getGenere());
	        ps.setString(6, p.getProfessione());
			
			int righe = ps.executeUpdate();
			return righe > 0;
			
		}
		catch (Exception ex)
		{
			System.out.println("Errore nel metodo UPDATE di DAOPersona\nQUERY: " + query);
			ex.printStackTrace();
			return false;
		}
		finally
		{
			db.chiudiConnessione();
		}
	}
	
	// INSERT
	public boolean create(Entity e)
	{
		db.apriConnessione();
		
		Persona p = (Persona)e;
		String query = "INSERT INTO Persone "
				 	 + "(nome, cognome, dob, residenza, genere, professione)"
				 	 + "VALUES (?, ?, ?, ?, ?, ?)";
		
		
		try 
		{
			PreparedStatement ps = db.getC().prepareStatement(query);
			ps.setString(1, p.getNome());
	        ps.setString(2, p.getCognome());
	        ps.setString(3, p.getDob());
	        ps.setString(4, p.getResidenza());
	        ps.setString(5, p.getGenere());
	        ps.setString(6, p.getProfessione());
			
			int righe = ps.executeUpdate();
			return righe > 0;
			
		}
		catch (Exception ex)
		{
			System.out.println("Errore nel metodo CREATE di DAOPersona\nQUERY: " + query);
			ex.printStackTrace();
			return false;
		}
		finally
		{
			db.chiudiConnessione();
		}
	}
	
	public List<Entity> read ()
	{
		List<Entity> ris = new ArrayList<Entity>();
		
		db.apriConnessione();
		
		String query = "SELECT * FROM Persone";
		
		try 
		{
			PreparedStatement ps = db.getC().prepareStatement(query);
			
			//RisultSet e' un interfaccia che e' in grado di gestire la struttura di una 
			   // tabella SQL 
			ResultSet tabella = ps.executeQuery();
			
			// Bisogna per forza ciclare, anche se sappiamo che la tabella avra' un solo record
			while (tabella.next())
			{
				Entity e = new Persona(
									tabella.getInt("id"),
									tabella.getString("nome"),
									tabella.getString("cognome"),
									tabella.getString("dob"),
									tabella.getString("residenza"),
									tabella.getString("genere"),
									tabella.getString("professione")
									);
				ris.add(e);
			}
			
			
		}
		catch (Exception ex)
		{
			System.out.println("Errore nel metodo READ di DAOPersona\nQUERY: " + query);
			ex.printStackTrace();
		}
		finally
		{
			db.chiudiConnessione();
		}
		
		return ris;
	}
	
	public Entity find (int id)
	{
		Entity ris = null;
		
		db.apriConnessione();
		
		String query = "SELECT * FROM Persone WHERE id = " + id;
		
		try 
		{
			PreparedStatement ps = db.getC().prepareStatement(query);
			
			//RisultSet e' un interfaccia che e' in grado di gestire la struttura di una 
			   // tabella SQL 
			ResultSet tabella = ps.executeQuery();
			
			// Bisogna per forza ciclare, anche se sappiamo che la tabella avra' un solo record
			while (tabella.next())
			{
				ris = new Persona(
									tabella.getInt("id"),
									tabella.getString("nome"),
									tabella.getString("cognome"),
									tabella.getString("dob"),
									tabella.getString("residenza"),
									tabella.getString("genere"),
									tabella.getString("professione")
									);
			}
			
			
		}
		catch (Exception ex)
		{
			System.out.println("Errore nel metodo FIND di DAOPersona\nQUERY: " + query);
			ex.printStackTrace();
		}
		finally
		{
			db.chiudiConnessione();
		}
		
		return ris;
	}
	
}// end DAOPersona
