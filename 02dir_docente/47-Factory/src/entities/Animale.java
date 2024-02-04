package entities;

import java.util.Map;

import factory.IFactory;

public class Animale extends Entity implements IFactory
{
	private String specie;
	private String nome;
	private String dob;
	private String genere;
	private double peso;
	private boolean vaccinato;
	//private Allevatore allevatore; -> Colleghiamo lato Allevatore, aggiungendogli un List<Animale> come proprietà 
	
	public Animale(int id, String specie, String nome, String dob, String genere, 
					double peso, boolean vaccinato)
	{
		super(id);
		setSpecie(specie);
		setNome(nome);
		setDob(dob);
		setPeso(peso);
		setGenere(genere);
		setVaccinato(vaccinato);
	}
	public Animale() {}
	
	public String getSpecie() 
	{
		return specie;
	}
	public void setSpecie(String specie) 
	{
		this.specie = specie;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getDob() 
	{
		return dob;
	}
	public void setDob(String dob) 
	{
		this.dob = dob;
	}
	public String getGenere() 
	{
		return genere;
	}
	public void setGenere(String genere) 
	{
		this.genere = genere;
	}
	public double getPeso() 
	{
		return peso;
	}
	public void setPeso(double peso) 
	{
		this.peso = peso;
	}
	public boolean isVaccinato() 
	{
		return vaccinato;
	}
	public void setVaccinato(boolean vaccinato) 
	{
		this.vaccinato = vaccinato;
	}

	@Override
	public String toString() 
	{
		return 	super.toString() +
				"\nSpecie: " 	 + specie 	  + 
				"\nNome: " 		 + nome 	  + 
				"\nNato il: " 	 + dob 		  +  
				"\nGenere: " 	 + genere 	  + 
				"\nPeso: " 		 + peso 	  + "KG" 		 +
				"\nVaccinato: "  + (vaccinato ? "Sì" : "No") + 
				"\n-------------------------------------------------\n";
	}

	// Questo metodo avrà il compito di bypassare il costruttore per popolare un oggetto 
	// creato inizialmente vuoto.
	public void create(Map<String,String> map)
	{
		// La mappa che arriva qui è il risultato dei record letti da DB.
		// Sarà quindi una mappa che avrà come KEY il nome della colonna della tabella SQL e come
		// VALUE il valore nella cella SQL
		
		// Tramite i metodi SET vado a associare i VALUE SQL alle proprietà JAVA
		// ATTENTI! Le chiavi sono il nome delle colonne SQL in toLowerCase!!!!!!!
		setId(Integer.parseInt(map.get("id")));
		setNome(map.get("nome"));
		setSpecie(map.get("specie"));
		setDob(map.get("dob"));
		setGenere(map.get("genere"));
		setPeso(Double.parseDouble(map.get("peso")));
		setVaccinato(map.get("vaccinato").equalsIgnoreCase("1"));
	}
	
	
}