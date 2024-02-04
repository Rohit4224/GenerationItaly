package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Allevatore;
import entities.Animale;
import entities.Entity;
import factory.Factory;
import factory.IFactory;

public class DAOAllevatore extends DAO implements IDAOTabelle
{
	public DAOAllevatore(String nomeDB)
	{
		super(nomeDB);
	}
	
	public boolean delete(int id)
	{
		return super.update("DELETE FROM Allevatori WHERE id = " + id);
	}
	
	public boolean insert(Entity e)
	{
		return super.update("INSERT INTO Allevatori (nome, cognome, dob, esperienza) VALUES " +
							"(\"" + ((Allevatore)e).getNome() 	 	+ "\", " +
							"\""  + ((Allevatore)e).getCognome() 	+ "\", " +
							"\""  + ((Allevatore)e).getDob()	 	+ "\", " +
							""	  + ((Allevatore)e).getEsperienza() + ")" 	 );
	}
	
	public boolean update(Entity e)
	{
		return super.update(
							"UPDATE Allevatori SET " +
							"nome = \"" 	+ ((Allevatore)e).getNome() 	  + "\", " 	+
							"cognome = \"" 	+ ((Allevatore)e).getCognome() 	  + "\", " 	+
							"dob = \"" 		+ ((Allevatore)e).getDob() 		  + "\", " 	+
							"esperienza = " + ((Allevatore)e).getEsperienza() + " " 	+
							"WHERE id = " 	+ e.getId()
							);
	}
	
	public List<Entity> list()
	{
		List<Entity> ris = new ArrayList<Entity>();
		
		List<Map<String,String>> righe = super.read("SELECT * FROM Allevatori");
		
		for(Map<String,String> riga : righe)
		{
			IFactory a = Factory.createObject("Allevatore");
			a.create(riga);
			
			DAOAnimale daoa = new DAOAnimale("fattoria2");
			
			List<Animale> animali = daoa.findAnimals(Integer.parseInt(riga.get("id")));
			((Allevatore)a).setAnimali(animali);
			
			ris.add((Allevatore)a);
		}
		
		return ris;
	}
	
	public Entity find(int id)
	{
		Map<String,String> riga = super.read("SELECT * FROM Allevatori WHERE id = " + id).get(0);
		
		IFactory a = Factory.createObject("Allevatore");
		a.create(riga);
		
		return (Allevatore)a;
	}
}