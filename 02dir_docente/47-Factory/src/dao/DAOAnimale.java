package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Animale;
import entities.Entity;
import factory.Factory;
import factory.IFactory;

public class DAOAnimale extends DAO implements IDAOTabelle
{
	public DAOAnimale(String nomeDB)
	{
		super(nomeDB);
	}
	
	public boolean update(Entity e)
	{
		return super.update(
							"UPDATE Animali SET " 	+
							"specie = \"" 			+ ((Animale)e).getSpecie() 	+ "\", " +
							"nome = \"" 			+ ((Animale)e).getNome()	+ "\", " +
							"dob = \""				+ ((Animale)e).getDob()		+ "\", " +
							"genere = \""			+ ((Animale)e).getGenere()	+ "\", " +
							"peso = "				+ ((Animale)e).getPeso()	+ ", "	 +
							"vaccinato = "			+ ((Animale)e).isVaccinato()+ " "	 +
							"WHERE id = "			+ e.getId()
							);
	}
	
	public boolean insert(Entity e)
	{
		return super.update(
							"INSERT INTO animali (nome, specie, dob, genere, peso, vaccinato) VALUES " +
							"(\"" + ((Animale)e).getNome() 		+ "\", " +
							"\""  + ((Animale)e).getSpecie() 	+ "\", " +
							"\""  + ((Animale)e).getDob()		+ "\", " +
							"\""  + ((Animale)e).getGenere()	+ "\", " +
							""    + ((Animale)e).getPeso()		+ ", "	 +
							""	  + ((Animale)e).isVaccinato() + ")"
							);
	}
	
	public boolean delete(int id)
	{
		return super.update("DELETE FROM Animali WHERE id = " + id);
	}
	
	public List<Entity> list()
	{
		List<Entity> ris = new ArrayList<Entity>();
		
		List<Map<String,String>> righe = super.read("SELECT * FROM Animali");
		
		for(Map<String,String> riga : righe)
		{
			// Tramite Factory creo un oggetto vuoto del tipo che voglio io
			IFactory a = Factory.createObject("Animale");
			
			// Tramite il metodo create sfrutto la mappa e riempio le proprietà dell'oggetto
			a.create(riga);
			
			// Aggiungo l'oggetto castato(perchè formalmente è di tipo IFactory) alla lista finale
			ris.add((Animale)a);
		}
		
		return ris;
	}
	
	public Entity find(int id)
	{
		Map<String,String> riga = super.read("SELECT * FROM Animali WHERE id = " + id).get(0);
		
		IFactory a = Factory.createObject("Animale");
		a.create(riga);
		
		return (Animale)a;
	}
	
	public List<Animale> findAnimals(int idAllevatore)
	{
		List<Animale> ris = new ArrayList<>();
		
		List<Map<String,String>> righe = super.read("SELECT	Animali.* " 					   + 
													"FROM	Allevatori INNER JOIN Animali "    +
													"ON animali.idAllevatore = allevatori.id " + 
													"WHERE	Allevatori.id = " + idAllevatore   );
		
		for(Map<String,String> riga : righe)
		{
			IFactory a = Factory.createObject("Animale");
			a.create(riga);

			ris.add((Animale)a);
		}
		
		return ris;
	}
}