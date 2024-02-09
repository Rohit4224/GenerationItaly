package factory;

import entities.Corso;
import entities.Utente;

public class Factory
{
	public static IFactory createObject(String classe)
	{
		if(classe.equals("Utente"))
			return new Utente();
		else if (classe.equals("Corso"))
			return new Corso();
		else
			throw new IllegalArgumentException(classe + " sconosciuta.");
	}
}
