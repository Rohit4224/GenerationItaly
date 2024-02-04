package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import db.Database;
import db.IDatabase;
import entities.Corso;
import entities.Entity;
import entities.Utente;
import factory.Factory;
import factory.IFactory;

public class DAOCorso implements IDAO
{
	private IDatabase db;
	
	private DAOCorso(String nomeDB)
	{
		db = new Database(nomeDB);
	}
	
	public static DAOCorso instance = null;
	
	public static DAOCorso getInstance(String nomeDB)
	{
		if (instance == null)
		{
			instance = new DAOCorso(nomeDB);
		}
		
		return instance;
	}
	
	public boolean create(Entity e)
	{
		db.open();
		
		//IFactory u = Factory.createObject("Utente");
		
		String query = "INSERT INTO Corsi "
			 	 + "(nome, totale_ore, numero_lezioni, lingua, materiali)"
			 	 + "VALUES (?, ?, ?, ?, ?)";
		
		try 
		{
			PreparedStatement ps = db.getC().prepareStatement(query);
			ps.setString(1, ((Corso)e).getNome());
			ps.setInt(2, ((Corso)e).getTotale_ore());
	        ps.setInt(3, ((Corso)e).getNumero_lezioni());
	        ps.setString(4, ((Corso)e).getLingua());
	        ps.setBoolean(5, ((Corso)e).isMateriali());
			
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
			db.close();
		}
	}
	
	
	public List<Map<String,String>> getQuery(String query)
	{
		List<Map<String,String>> righe = new ArrayList<Map<String,String>>();
		
		try
		{
			db.open();
			
			PreparedStatement ps = db.getC().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Map<String,String> riga = new LinkedHashMap<String, String>();
				
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
				{
					riga.put(rs.getMetaData().getColumnLabel(i).toLowerCase(), rs.getString(i));
				}
				
				righe.add(riga);
			}

		}
		catch (Exception e)
		{
			System.out.println("Errore nella query: " + query);
			e.printStackTrace();
		}
		finally 
		{
			db.close();
		}
		
		return righe;
	}
	
	public List<Entity> read()
	{
		
		List<Entity> ris = new ArrayList<Entity>();

		String query = "SELECT * FROM Corsi";
		
		
		List<Map<String,String>> righe = getQuery(query);
		
		for(Map<String,String> riga : righe)
		{
			IFactory a = Factory.createObject("Corso");
			
			a.fillObj(riga);
			
			ris.add((Corso)a);
			
		}
		
		return (ris);
		
	}

	public Entity find (int id)
	{
		Map<String,String> riga = getQuery("SELECT * FROM Corsi WHERE id = " + id).get(0);
		
		IFactory a = Factory.createObject("Corso");
		a.fillObj(riga);
		
		return ((Corso)a);
	}
	
	public Corso findCorso(int idUtente)
	{
		
		List<Map<String,String>> righe = getQuery("SELECT	Corsi.* " 					   + 
													"FROM	Corsi INNER JOIN Utenti "    +
													"ON Utenti.corsoFrequentato = Corsi.id " + 
													"WHERE	Utenti.corsoFrequentato = " + idUtente   );
		
		IFactory c = Factory.createObject("Corso");
		for(Map<String,String> riga : righe)
		{
			c.fillObj(riga);
		}
		
		return ((Corso)c);
	}
	
	public boolean update(Entity e)
	{
		String query = "UPDATE Corsi SET "
						+ "nome = ?, "
						+ "totale_ore = ?, "
						+ "numero_lezioni = ?, "
						+ "lingua = ?, "
						+ "materiali = ? "
						+ "WHERE id = " + e.getId();
		
		try
		{
			db.open();
			
			PreparedStatement ps = db.getC().prepareStatement(query);
			
			ps.setString(1, ((Corso)e).getNome());
			ps.setInt(2, ((Corso)e).getTotale_ore());
	        ps.setInt(3, ((Corso)e).getNumero_lezioni());
	        ps.setString(4, ((Corso)e).getLingua());
	        ps.setBoolean(5, ((Corso)e).isMateriali());
			
			int righe = ps.executeUpdate();
			
			return righe > 0;
		}
		catch(Exception ex)
		{
			System.out.println("Errore nell'esecuzione della query:\n" + query);
			ex.printStackTrace();
			return false;
		}
		finally
		{ 
			db.close();
		}
	}
	
	public boolean delete(int id)
	{
		
		String query = "DELETE FROM Corsi WHERE id = " + id;
		
		try
		{
			db.open();
			
			PreparedStatement ps = db.getC().prepareStatement(query);
			int righe = ps.executeUpdate();
			
			return righe > 0;
		}
		catch(Exception e)
		{
			System.out.println("Errore nell'esecuzione della query:\n" + query);
			e.printStackTrace();
			return false;
		}
		finally
		{ 
			db.close();
		}
	}
	
	
}
