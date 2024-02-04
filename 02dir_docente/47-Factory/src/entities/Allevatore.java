package entities;

import java.util.List;
import java.util.Map;

import factory.IFactory;

public class Allevatore extends Entity implements IFactory
{
	private String nome;
	private String cognome;
	private String dob;
	private int esperienza;
	private List<Animale> animali;
	
	public Allevatore(int id, String nome, String cognome, String dob, int esperienza, 
					  List<Animale> animali)
	{
		super(id);
		setNome(nome);
		setCognome(cognome);
		setDob(dob);
		setEsperienza(esperienza);
		setAnimali(animali);
	}
	public Allevatore() {}
	
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getCognome() 
	{
		return cognome;
	}
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}
	public String getDob() 
	{
		return dob;
	}
	public void setDob(String dob) 
	{
		this.dob = dob;
	}
	public int getEsperienza() 
	{
		return esperienza;
	}
	public void setEsperienza(int esperienza) 
	{
		this.esperienza = esperienza;
	}
	public List<Animale> getAnimali()
	{
		return animali;
	}
	public void setAnimali(List<Animale> animali)
	{
		this.animali = animali;
	}
	
	@Override
	public String toString()
	{
		return 	super.toString() +
				"\nNominativo: " + nome 		   + " "  + cognome 	 + 
				"\nNato il: " 	 + dob  								 + 
				"\nEsperienza: " + esperienza 	   + " anni" 			 +
				"\nCapi: "		 + (animali!= null ? animali.size() : 0) +
				"\n-------------------------------------------------\n"  ;
	}
	
	public void create(Map<String,String> map)
	{
		setId(Integer.parseInt(map.get("id")));
		setNome(map.get("nome"));
		setCognome(map.get("cognome"));
		setDob(map.get("dob"));
		setEsperienza(Integer.parseInt(map.get("esperienza")));
	}
}