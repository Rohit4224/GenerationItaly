package dao;

import entities.Entity;
import factory.Factory;
import factory.IFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Allevatore;
import entities.Animale;

public class DAOAllevatore extends DAO
{
	public DAOAllevatore(String nomeDB)
	{
		super(nomeDB);
	}
	
	public boolean delete (int id)
	{
		return super.update("DELETE FROM allevatori WHERE id = " + id);
	}
	
	public boolean insert (Entity e)
	{
		return super.update( 
							"INSERT INTO allevatori "
						+ "(nome, cognome, dob, esperienza)"
						+ "VALUES"
						+ "(\""  + ((Allevatore)e).getNome() 	+ "\", "
						+ "\""  + ((Allevatore)e).getCognome()  + "\", "
						+ "\""  + ((Allevatore)e).getDob()  	+ "\", "
						+ ""  + ((Allevatore)e).getEsperienza()  + ")"
							);
	}
	
	public boolean update (Entity e)
	{
		return super.update(
							"UPDATE allevatori SET "
							+ "nome = \""  + ((Allevatore)e).getNome()  + "\", "
							+ "cognome = \""  + ((Allevatore)e).getCognome()  + "\", "
							+ "dob = \""  + ((Allevatore)e).getDob()  + "\", "
							+ "esperienza = "  + ((Allevatore)e).getEsperienza()  + " "
							+ "WHERE id =" + e.getId()
						);
	}
	
	public List<Allevatore> list()
	{
		List<Allevatore> ris = new ArrayList<Allevatore>();
		
		List<Map<String, String>> righe = super.read("SELECT * FROM allevatori");
		
		for (Map<String, String> riga : righe)
		{
			// Tramite Factory creo un oggetto vuoto del tipo che voglio io
			IFactory a = Factory.createObject("Allevatore");
			
			// tramite il metodo create sfrutto la mappe e riempio le proprieta dell'oggetto
			a.create(riga);
			
			DAOAnimale daoa = new DAOAnimale("fattoria");
			
			
			List<Animale> animali = daoa.findAnimals(Integer.parseInt(riga.get("id")));
			((Allevatore)a).setAnimali(animali);
			
			// Aggiungo l'oggetto castato(perchè formalmente è tipo IFactory) alla liste finale
			ris.add((Allevatore)a);
		}
		
		return ris;
	}
	
	
	public Entity find(int id)
	{
		Map<String, String> riga = super.read("SELECT * FROM allevatori WHERE id = " + id).get(0);
		
		IFactory a = Factory.createObject("Allevatore");
		a.create(riga);
		
		return (Allevatore)a;
	}
	
	
}
