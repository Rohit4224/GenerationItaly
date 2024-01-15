package main;

import entities.Persona;

public class Main
{
	public static void main (String [] args)
	{
		int min = Persona.etaMin;
		int eta = 30;
		
		if (Persona.valida(eta))
		{
			Persona p = new Persona("Rohit", "Khinchi", "Lombaridia", "Milano", 26);
			System.out.println(p.toString());
			Persona.valida(p.getEta(), p.getProvincia());
		}
		else
			System.out.println("Oggetto non creato");
	}
}
