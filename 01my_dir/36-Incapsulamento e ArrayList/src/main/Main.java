package main;

import java.io.FileNotFoundException;

import entites.Anagrafe;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// PRINCIPI FONDAMENTALI DELLA PROGRAMMAZIONE A OGGETTI
		// > Incapsulamento: Significa proteggere dei pezzi di codice.
		//						Si può fare tramite un discorso di "permessi" o 
		//						tramite un discrso di "mascherare" pezzi di codice
		
		// Quando parliamo di permessi parliamo di "livelli di visibilità" che sono 4
		// PUBLIC -------------> Rende visibile l'elemento in tutto il programma
		// PROTECTED ----------> Rende visibile l'elemento in tutte le parti imparentate tra loro, anche se stanno in 
		//						 package diversi
		// PACKAGE(o default) -> Rende visibile l'elemento solo ai componenti del suo stesso package di appartenza 
		// PRIVATE ------------> Rende visibile l'elemento solo nella sua classe di appartenza
		
		// Esempio di come reagisce il codice ai livelli di visibilità dei commenti dentro Persona
//		Persona p = new Persona();
//		
//		p.nome = "Alice";
//		p.cognome = "Bensanelli";
//		p.eta = 26;
//		p.residenza = "Milano";
		
		Anagrafe a = new Anagrafe("src/res/Dati.txt");
		
		System.out.println(a.cerca("milano"));
		
	}
}