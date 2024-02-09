package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import db.Database;
import db.IDatabase;

public class DAO implements IDAO
{
	private static IDatabase instance = null;
	private IDatabase db;
	
	public DAO (String nomeDB)
	{
		db = getInstance(nomeDB);
	}
	
	private static IDatabase getInstance(String nomeDB)
	{
		if (instance == null)
			instance = new Database(nomeDB);
		return instance;
	}
	
	public boolean update(String query)
	{
		try
		{
			db.open();
			
			PreparedStatement ps = db.getC().prepareStatement(query);
			
			int righe = ps.executeUpdate();
			
			return righe > 0;
		}
		catch (Exception e)
		{
			System.out.println("Errore nella esecuzione della query:\n" + query);
			e.printStackTrace();
			return false;
		}
		finally
		{
			db.close();
		}
	}
	
	public List<Map<String, String>> read (String query)
	{
		List<Map<String, String>> ris = new ArrayList<Map<String, String>>();
		
		try
		{
			db.open();
			
			PreparedStatement ps = db.getC().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Map<String, String> riga = new LinkedHashMap<String, String>();
				
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
				{
					riga.put(rs.getMetaData().getColumnLabel(i).toLowerCase(), rs.getString(i));
				}
				
				ris.add(riga);
			}
		}
		catch (Exception e)
		{
			System.out.println("Errore nella query" + query);
			e.printStackTrace();
		}
		finally
		{
			db.close();
		}
		
		return ris;
		
	}
	
	
}
