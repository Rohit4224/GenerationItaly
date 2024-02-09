package entities;

import java.time.LocalDate;

// Persona è figlia di Entity ed eredita le sue proprietà e i suoi metodi visibili.
// ciò che non eredita è l'Abstract, tanto è vero che Persona ora è concreta, cioè posso fare new Persona()

public abstract class Persona extends Entity
{
	private String nome;
	private String cognome;
	private String dob;
	private String residenza;

//	public Persona()
//	{
//	}
	
	public Persona(int id, String nome, String cognome, String dob, String residenza)
	{
		super(id);
		setNome(nome);
		setCognome(cognome);
		setDob(dob);
		setResidenza(residenza);
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


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getResidenza() {
		return residenza;
	}


	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}


	@Override
	public String toString()
	{
		return 	super.toString() + 
				"\nNominativo: " + nome + " " + cognome + 
				"\nNato il: " + dob + 
				"\nResidente a: " + residenza;
	}
	
	//metodo concreto
	public int eta()
	{
		return LocalDate.now().getYear() - Integer.parseInt(dob.split("-")[2]);
	}
	
	// metodo Astratto : posseggono solo le firme dei metodi e possono esistere solo nelle classi astratte.
	public abstract double bonus();
	
	
}// fine classe
