package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.*;
import factory.Factory;
import factory.IFactory;

public class DAOAnimale extends DAO
{
	public DAOAnimale(String nomeDB)
	{
		super(nomeDB);
	}
	
	public boolean update (Entity e)
	{
		return super.update(
							"UPDATE animali SET "
							+ "specie = \""  + ((Animale)e).getSpecie()  + "\", "
							+ "nome = \""  + ((Animale)e).getNome()  + "\", "
							+ "dob = \""  + ((Animale)e).getDob()  + "\", "
							+ "genere = \""  + ((Animale)e).getGenere()  + "\", "
							+ "peso = "  + ((Animale)e).getPeso()  + ", "
							+ "vaccinato = "  + ((Animale)e).isVaccinato()  + " "
							+ "WHERE id =" + e.getId()
						);
	}
	
	public boolean insert(Entity e)
	{
		return super.update(
							"INSERT INTO animali "
							+ "(nome, specie, dob, genere, peso, vaccinato)"
							+ "VALUES"
							+ "(\""  + ((Animale)e).getNome()  + "\", "
							+ "\""  + ((Animale)e).getSpecie()  + "\", "
							+ "\""  + ((Animale)e).getDob()  + "\", "
							+ "\""  + ((Animale)e).getGenere()  + "\", "
							+ ""  + ((Animale)e).getPeso()  + ","
							+ ""  + ((Animale)e).isVaccinato()  + ")"
						
							);
	}
	
	public boolean delete (int id)
	{
		return super.update("DELETE FROM animali WHERE id = " + id);
	}
	
	public List<Animale> list()
	{
		List<Animale> ris = new ArrayList<Animale>();
		
		List<Map<String, String>> righe = super.read("SELECT * FROM animali");
		
		for (Map<String, String> riga : righe)
		{
			// Tramite Factory creo un oggetto vuoto del tipo che voglio io
			IFactory a = Factory.createObject("Animale");
			
			// tramite il metodo create sfrutto la mappe e riempio le proprieta dell'oggetto
			a.create(riga);
			
			// Aggiungo l'oggetto castato(perchè formalmente è tipo IFactory) alla liste finale
			ris.add((Animale)a);
		}
		
		return ris;
	}
	
	
	public Entity find(int id)
	{
		Map<String, String> riga = super.read("SELECT * FROM animali WHERE id = " + id).get(0);
		
		IFactory a = Factory.createObject("Animale");
		a.create(riga);
		
		return (Animale)a;
	}
	
	
	public List<Animale> findAnimals(int idAllevatore)
	{
		List<Animale> ris = new ArrayList<Animale>();
		
		List<Map<String, String>> righe = super.read( " SELECT animali.* "
				 + " FROM allevatori INNER JOIN animali ON animali.idAllevatore = allevatori.id"
				 + " WHERE allevatori.id =" + idAllevatore
														);
		
		for (Map<String, String> riga : righe)
		{
			// Tramite Factory creo un oggetto vuoto del tipo che voglio io
			IFactory a = Factory.createObject("Animale");
			
			// tramite il metodo create sfrutto la mappe e riempio le proprieta dell'oggetto
			a.create(riga);
			
			// Aggiungo l'oggetto castato(perchè formalmente è tipo IFactory) alla liste finale
			ris.add((Animale)a);
		}
		
		return ris;
	}
	
	
	
}
