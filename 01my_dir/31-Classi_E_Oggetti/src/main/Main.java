package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// La classe MAIN si chiama CLASSE DI AVVIO, perchè non fa da modello a degli oggetti, ma ha il compito
// di interfacciarsi con l'esterno, cioè con la console.
// OCCHIO: potete avere tutte le classi modello che volete, ma in un programma esiste una e una 
// sola classe di avvio alla volta
public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// PROGRAMMAZIONE A OGGETTI: Cosa sono gli oggetti?
		
		// Di base, un oggetto è una variabile che rappresenta un elemento concreto nel mondo reale.
		// Ogni elemento reale ha delle caratteristiche che lo rappresentano: per distinguere i singoli
		// oggetti ci serve sapere il valore associato a quelle caratteristiche.
		
		// L'oggetto è il caso concreto (cioè l'insieme dei valori delle sue caratteristiche) mentre ciò
		// che determina quali caratteristiche ci interessano si chiama CLASSE.
		
		// DEFINIZIONE
		// La classe è l'idea, il modello di un elemento, l'oggetto è il caso concreto.
		
		// Per dettagli sulla classe, vedere il file Persona.java
		
		// LEGGO IL FILE DEI DATI --------------------------------------------------------------------------
		Scanner file =  new Scanner(new File("src/res/Dati.txt"));
		
		int dim = Integer.parseInt(file.nextLine());
		
		// Ogni riga del file rappresenta un oggetto, quindi d'ora in poi i nostri vettori
		// non conterranno più dati semplici (int, String, ecc) ma conterranno oggetti.
		// Il tipo degli oggetti è sempre il nome della loro classe di appartenenza
		// Quindi avremo una variabile "persone" che sarà di tipo "vettore di Persona".
		Persona[] persone = new Persona[dim];
		
		// I comandi in programmazioni si leggono sempre al contrario di come si scrivono:
		// se le cose le scrivo da sx a dx, allora verranno eseguite da dx a sx, per qui nella riga 38
		// si esegue prima il contenitore vettore e poi decido cosa metterci dentro (tipo Persona)
		dim = 0;
		
		while(file.hasNextLine())
		{
			String[] infoRiga = file.nextLine().split(";");
			
			// Questo è come si dichiara e inizializza a vuoto un oggetto.
			Persona persona = new Persona();
			
			// Ora assegno alle proprietà dell'oggetto vuoto i valori letti da file
			persona.nome = infoRiga[0];
			persona.cognome = infoRiga[1];
			persona.eta = Integer.parseInt(infoRiga[2]);
			persona.patentato = infoRiga[3].equalsIgnoreCase("s");
			
			// Ora il mio oggetto è "pieno" quindi posso salvarlo nel vettore
			persone[dim] = persona;
			
			dim++;
		}
		
		file.close();
		//--------------------------------------------------------------------------------------------------
	
		// Stampo per vedere se tutto è salvato correttamente
		for(int i = 0; i < persone.length; i++)
			System.out.println(persone[i].scheda());

		System.out.println("\n\n----------------------------------\n\n");
		
		// Voglio vedere le schede delle persone che possono guidare
		for(int i = 0; i < persone.length; i++)
			if(persone[i].patentato)
				System.out.println(persone[i].scheda());
		
		// Voglio vedere la scheda della persona o delle persone più anziane
		
	
	}
}