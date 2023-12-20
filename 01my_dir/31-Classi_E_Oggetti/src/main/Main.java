package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// La classe MAIN si chiama CLASSE DI AVVIO, perch� non fa da modello a degli oggetti, ma ha il compito
// di interfacciarsi con l'esterno, cio� con la console.
// OCCHIO: potete avere tutte le classi modello che volete, ma in un programma esiste una e una 
// sola classe di avvio alla volta
public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// PROGRAMMAZIONE A OGGETTI: Cosa sono gli oggetti?
		
		// Di base, un oggetto � una variabile che rappresenta un elemento concreto nel mondo reale.
		// Ogni elemento reale ha delle caratteristiche che lo rappresentano: per distinguere i singoli
		// oggetti ci serve sapere il valore associato a quelle caratteristiche.
		
		// L'oggetto � il caso concreto (cio� l'insieme dei valori delle sue caratteristiche) mentre ci�
		// che determina quali caratteristiche ci interessano si chiama CLASSE.
		
		// DEFINIZIONE
		// La classe � l'idea, il modello di un elemento, l'oggetto � il caso concreto.
		
		// Per dettagli sulla classe, vedere il file Persona.java
		
		// LEGGO IL FILE DEI DATI --------------------------------------------------------------------------
		Scanner file =  new Scanner(new File("src/res/Dati.txt"));
		
		int dim = Integer.parseInt(file.nextLine());
		
		// Ogni riga del file rappresenta un oggetto, quindi d'ora in poi i nostri vettori
		// non conterranno pi� dati semplici (int, String, ecc) ma conterranno oggetti.
		// Il tipo degli oggetti � sempre il nome della loro classe di appartenenza
		// Quindi avremo una variabile "persone" che sar� di tipo "vettore di Persona".
		Persona[] persone = new Persona[dim];
		
		// I comandi in programmazioni si leggono sempre al contrario di come si scrivono:
		// se le cose le scrivo da sx a dx, allora verranno eseguite da dx a sx, per qui nella riga 38
		// si esegue prima il contenitore vettore e poi decido cosa metterci dentro (tipo Persona)
		dim = 0;
		
		while(file.hasNextLine())
		{
			String[] infoRiga = file.nextLine().split(";");
			
			// Questo � come si dichiara e inizializza a vuoto un oggetto.
			Persona persona = new Persona();
			
			// Ora assegno alle propriet� dell'oggetto vuoto i valori letti da file
			persona.nome = infoRiga[0];
			persona.cognome = infoRiga[1];
			persona.eta = Integer.parseInt(infoRiga[2]);
			persona.patentato = infoRiga[3].equalsIgnoreCase("s");
			
			// Ora il mio oggetto � "pieno" quindi posso salvarlo nel vettore
			persone[dim] = persona;
			
			dim++;
		}
		
		file.close();
		//--------------------------------------------------------------------------------------------------
	
		// Stampo per vedere se tutto e' salvato correttamente
		for(int i = 0; i < persone.length; i++)
			System.out.println(persone[i].scheda());

		System.out.println("\n\n----------------------------------\n\n");
		
//		 Voglio vedere le schede delle persone che possono guidare
		for(int i = 0; i < persone.length; i++)
			if(persone[i].patentato)
				System.out.println(persone[i].scheda());
		
		System.out.println("\n\n----------------------------------\n\n");
		
		// Voglio vedere la scheda della persona o delle persone piu' anziane
		int max = 0;
		int i = 0;
		String peopleWithMaxAge = "";
		while(i < persone.length)
		{
			if (persone[i].eta > max)
			{
				max = persone[i].eta;
				peopleWithMaxAge = persone[i].scheda();
			}
			else if(persone[i].eta == max)
			{
				peopleWithMaxAge += persone[i].scheda();
			}
			i++;
		}
		peopleWithMaxAge = "La scheda della persona o delle persone piu' anziane: \n" + peopleWithMaxAge;
		System.out.println(peopleWithMaxAge);
	
		System.out.println("\n\n----------------------------------\n\n");
		//quante persone sono maggiorenne
		
		i = 0;
		int cont = 0;
		String listAdultPeople = "";
		while (i < persone.length)
		{
			if (persone[i].eta >= 18)
				listAdultPeople += persone[i].scheda();
			i++;
		}
		listAdultPeople = "Persone sono maggiorenne: \n" + listAdultPeople;
		System.out.println(listAdultPeople);
		
		System.out.println("\n\n----------------------------------\n\n");
		
        //Voglio sapere i nomi dei minorenni con la patente
        
		i = 0;
		String names = "";
		while(i < persone.length)
		{
			if (persone[i].eta < 18 && persone[i].patentato)
			{
				names += "Name: " + persone[i].nome + "\nCognome: " + persone[i].cognome + "\n";
			}
			i++;
		}
		if (names.isEmpty())
			System.out.println("Minorenne non trovata in Dati.txt");
		else
			System.out.println("I nomi dei minorenni con la patente: \n" + names);
		
		System.out.println("\n\n----------------------------------\n\n");
		
		//Voglio sapere quante persone hanno la patente da almeno 20 anni(Immaginate che tutti l'abbiano presa a 18 anni)
        i = 0;
        cont = 0;
        while (i < persone.length)
        {
        	if ((persone[i].eta - 18) >= 20 && persone[i].patentato)
        		cont++;
        	i++;
        }
        System.out.println("Persone hanno la patente da almeno 20 anni sono: " + cont);
		
		System.out.println("\n\n----------------------------------\n\n");
		// Voglio permettere all'utente di cercare la scheda di una persona tramite il suo cognome
		
		Scanner input = new Scanner (System.in);
		System.out.println("Scrivi il cognome per la scheda che devi trovare: \n");
		String choosenSurname = input.nextLine();
		String listBySurname = "";
		i = 0;
		while(i < persone.length)
		{
			if (choosenSurname.equalsIgnoreCase(persone[i].cognome))
			{
				listBySurname += persone[i].scheda();
			}
			i++;
		}
		System.out.println(listBySurname);
		input.close();
		
		System.out.println("\n\n----------------------------------\n\n");
		
		
	
	}//main
}//class