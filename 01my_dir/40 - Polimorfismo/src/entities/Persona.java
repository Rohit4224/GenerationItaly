package entities;

import java.time.LocalDate;

public class Persona
{
	//pe,nome,cognome,residenza,dob
	//
	//
	
	private String nome;
	private String cognome;
	private String residenza;
	private String dob;
	
	public Persona()
	{
		
	}
	
	public Persona(String nome, String cognome, String residenza, String dob)
	{
		setNome(nome);
		setCognome(cognome);
		setResidenza(residenza);
		setDob(dob);
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getResidenza() {
		return residenza;
	}


	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	
	
	@Override
	public String toString() {
		return "\tPersona" +
				"\nNominativo: " + nome + " " + cognome 
				+ "\nResidenza: " + residenza 
				+ "\ndob: " + dob
				+ "\nEta: " + eta();
	}


	public int eta() {
		
		return LocalDate.now().getYear() - Integer.parseInt(dob.split("-")[2]);
	}
	
	
	
	
}
