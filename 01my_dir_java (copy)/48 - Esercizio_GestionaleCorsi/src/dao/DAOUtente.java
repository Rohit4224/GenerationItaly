package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import db.*;
import entities.*;
import factory.*;

public class DAOUtente implements IDAO
{
	private IDatabase db;
	
	private DAOUtente(String nomeDB)
	{
		db = new Database(nomeDB);
	}
	
	public static DAOUtente instance = null;
	
	public static DAOUtente getInstance(String nomeDB)
	{
		if (instance == null)
		{	
			instance = new DAOUtente(nomeDB);
		}
		
		return instance;
	}
	
	public boolean create(Entity e)
	{
		db.open();
		
		//IFactory u = Factory.createObject("Utente");
		
		String query = "INSERT INTO Utenti "
			 	 + "(nome, cognome, dob, azienda, mansione, corsoFrequentato)"
			 	 + "VALUES (?, ?, ?, ?, ?, ?)";
		
		try 
		{
			PreparedStatement ps = db.getC().prepareStatement(query);
			ps.setString(1, ((Utente)e).getNome());
			ps.setString(2, ((Utente)e).getCognome());
	        ps.setString(3, ((Utente)e).getDob());
	        ps.setString(4, ((Utente)e).getAzienda());
	        ps.setString(5, ((Utente)e).getMansione());
	        ps.setInt(6, ((Utente)e).getCorso().getId());;
			
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

		String query = "SELECT * FROM Utenti";
		
		
		List<Map<String,String>> righe = getQuery(query);
		
		for(Map<String,String> riga : righe)
		{
			IFactory a = Factory.createObject("Utente");
			
			a.fillObj(riga);
			
			// importante
			DAOCorso daoa = DAOCorso.getInstance("GestionaleFormazione");
			
			Corso corso = daoa.findCorso(Integer.parseInt(riga.get("id")));
			((Utente)a).setCorso(corso);
			
			ris.add((Utente)a);
			
		}
		
		return (ris);
	}
	
	public Entity find (int id)
	{
		Map<String,String> riga = getQuery("SELECT * FROM Utenti WHERE id = " + id).get(0);
		
		IFactory a = Factory.createObject("Utente");
		a.fillObj(riga);
		
		return ((Utente)a);
	}
	
	public boolean update(Entity e)
	{
		//nome, cognome, dob, azienda, mansione, corsoFrequentato
		String query = "UPDATE Utenti SET "
						+ "nome = ?, "
						+ "cognome = ?, "
						+ "dob = ?, "
						+ "azienda = ?, "
						+ "mansione = ?, "
						+ "corsoFrequentato = ? "
						+ "WHERE id = " + e.getId();
		
		try
		{
			db.open();
			
			PreparedStatement ps = db.getC().prepareStatement(query);
			
			ps.setString(1, ((Utente)e).getNome());
			ps.setString(2, ((Utente)e).getCognome());
	        ps.setString(3, ((Utente)e).getDob());
	        ps.setString(4, ((Utente)e).getAzienda());
	        ps.setString(5, ((Utente)e).getMansione());
	        ps.setInt(6, ((Utente)e).getCorso().getId());
			
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
		String query = "DELETE FROM Utenti WHERE id = " + id;
		
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
	
//	public List<Entity> read()
//	{
//		
//		List<Entity> ris = new ArrayList<Entity>();
//		
//		List<Map<String,String>> righe = new ArrayList<Map<String,String>>();
//		
//		String query = "SELECT * FROM Utenti";
//		
//		try
//		{
//			db.open();
//			
//			PreparedStatement ps = db.getC().prepareStatement(query);
//			ResultSet rs = ps.executeQuery();
//			
//			while (rs.next())
//			{
//				Map<String,String> riga = new LinkedHashMap<String, String>();
//				
//				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
//				{
//					riga.put(rs.getMetaData().getColumnLabel(i).toLowerCase(), rs.getString(i));
//				}
//				
//				righe.add(riga);
//			}
//			
//			for(Map<String,String> riga : righe)
//			{
//				IFactory a = Factory.createObject("Utente");
//				
//				a.fillObj(riga);
//				
//				// manca qua
//				DAOCorso daoa = DAOCorso.getInstance("Gestionale_corsi");
//				
//				Corso corso = daoa.findCorso(Integer.parseInt(riga.get("id")));
//				((Utente)a).setCorso(corso);
//				
//				ris.add((Utente)a);
//				
//			}
//			
//
//		}
//		catch (Exception e)
//		{
//			System.out.println("Errore nella query: " + query);
//			e.printStackTrace();
//		}
//		finally 
//		{
//			db.close();
//		}
//		
//		return ris;
//	}

}

