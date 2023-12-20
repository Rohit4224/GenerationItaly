package main;

import java.time.LocalDate;

//classe Modello: ha come scopo la creazione di oggetti.
public class Persona
{
	String name;
	String surname;
	String dob;
	String personalTrainer;
	String objective;
	boolean subscription;
	
	// COSTRUTTORE : Ha il compito di costruire un oggetto.
	// cioe' ha il compito di valorizzare le proprieta' della classe.
	// In sostenza un costruttore e' un metodo un po piu' particolari degli altri
	Persona()
	{
		// Costruttore vuoto e' sempre presente finche scrivi altro
		// presente automatico anche se non scriviamo nulla
	}
	
	Persona(String name, String surname, String dob, String personalTrainer, String objective, boolean subscription)
	{
		//proprieta' = parametro
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.personalTrainer = personalTrainer;
		this.objective = objective;
		this.subscription = subscription;
	}
	
	
	//Metodi
	String scheda()
	{
		String res = "";
		
		res = "Nome: " + name + " " + surname
				+ "\nNato il: " + dob + " di anni " + age()
				+ "\nSeguito da: " + personalTrainer
				+ "\nObbietivo: " + objective
				+ "\nAbbonato: " + (subscription ? "Si" : "No")
				+ "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
				
		return res;
	}
	
	int age()
	{
		int ris = 0;
		int yob = Integer.parseInt(dob.split("-")[2]);
		
		ris = LocalDate.now().getYear() - yob;
		
		return ris;
	}
	
}
