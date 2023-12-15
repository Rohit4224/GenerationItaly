package main;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		// AGENZIA VIAGGI
		
		// Dovete organizzare un viaggio all'estero.
		// Dal cliente (che è un agenzia viaggi) vi farete passare le seguenti informazioni:
		// - destinazione
		// - mezzo di locomozione
		// - durata viaggio
		// - numero partecipanti al viaggio
		
		// Dovete creare una scheda ordinata con le informazioni che vi hanno passato e dovete calcolare il 
		// prezzo del viaggio per i singoli partecipanti, sapendo che:
		// Il costo in base al mezzo di locomozione sarà:
		//		- aereo: 500
		//		- treno: 300
		//		- traghetto: 450
		//		- pulman: 350
		//		- altro: 1000
		// Il costo in base alla destinazione sarà:
		//		- Roma: 50
		//		- Dubai: 200
		//		- Tokyo: 500
		//		- Dublino: 150
		//		- Amsterdam: 90
		//		- altro: 1500
		// Ogni giorno di viaggio ha una base fissa di 10.50
		// Se il numero di partecipanti è inferiore a 10 si calcoli una penale aggiuntiva del 2%, 
		// se sono tra 11 e 20, pagano una penale del 0.5%, 
		// se sono più di 20 hanno diritto allo sconto comitiva del 5% sul totale
		// Nella scheda ordinata del viaggio voglio vedere tutti i dati che sono stati passati dal cliente
		// il prezzo complessivo del viaggio e il prezzo che paga la singola persona che partecipa al viaggio
		
		/* Esempio di output desiderato
		 
			SCHEDA VIAGGIO
		Destinazione: Dubai
		Mezzo: Monopattino Elettrico
		Durata: 40 giorni
		Partecipanti: 30 persone
		
		Costo Totale: millemila euro
		[Sconto 5%/Sconto 0.5%/Penale 2%] Facoltativa come riga
		Costo Per Partecipante: 10 euro caduno
		
		*/
		
		//D
		Scanner tastiera;
		String destinazione;
		String mezzoLocomozione;
		int durataViaggio;
		int partecipanti;
		double prezzoTotale;
		double prezzoFissoGiornaliero;
		String scontoOsovrapprezzo;
		String risposta;
		
		//I
		tastiera = new Scanner(System.in);
		risposta = "";
		prezzoTotale = 0;
		prezzoFissoGiornaliero = 10.5;
		
		System.out.println("Dove vuoi andare?");
		destinazione = tastiera.nextLine();
		System.out.println("Con che mezzo?");
		mezzoLocomozione = tastiera.nextLine();
		System.out.println("Quanti giorni dura la vacanza?");
		durataViaggio = Integer.parseInt(tastiera.nextLine());
		System.out.println("Quante persone partecipano?");
		partecipanti = Integer.parseInt(tastiera.nextLine());
		
		tastiera.close();
		
		//C
		switch(mezzoLocomozione.toLowerCase())
		{
			case "aereo":
				// Versione "estesa"
				//prezzoTotale = prezzoTotale + 500;
				// Versione "compatta"
				prezzoTotale += 500;
				break;
			case "treno":
				prezzoTotale += 300;
				break;
			case "traghetto":
				prezzoTotale += 450;
				break;
			case "pulman":
				prezzoTotale += 350;
				break;
			default:
				prezzoTotale += 1000;				
		}
		
		switch(destinazione.toLowerCase())
		{
			case "roma":
				prezzoTotale += 50;
				break;
			case "dubai":
				prezzoTotale += 200;
				break;
			case "tokyo":
				prezzoTotale += 500;
				break;
			case "dublino":
				prezzoTotale += 150;
				break;
			case "amsterdam":
				prezzoTotale += 90;
				break;
			default:
				prezzoTotale += 1500;
		}
		
		prezzoTotale += durataViaggio * prezzoFissoGiornaliero * partecipanti;
		
		if(partecipanti <= 10)
		{
			prezzoTotale += (prezzoTotale/100*2);
			scontoOsovrapprezzo = "Penale del 2%";
		}
		else if(partecipanti > 10 && partecipanti <= 20)
		{
			prezzoTotale += prezzoTotale/100*0.5;
			scontoOsovrapprezzo = "Penale del 0.5%";
		}
		else
		{
			prezzoTotale -= prezzoTotale/100*5;
			scontoOsovrapprezzo = "Sconto del 5%";
		}
		
		//O
		// Possiamo scrivere così:
//		risposta = 	"\n\n\tANTEPRIMA SCHEDA VIAGGIO" 										+
//					"\nDestinazione: " 			+ destinazione 								+
//					"\nMezzo di Locomozione: " 	+ mezzoLocomozione 							+
//					"\nDurata Vacanza: " 		+ durataViaggio 				+ "gg" 		+
//					"\nPartecipanti: "			+ partecipanti  				+ "persone" +
//					"\n\nCosto Totale: "		+ prezzoTotale  				+ "€"		+
//					"\n---  " 					+ scontoOsovrapprezzo 			+ "  ---"	+
//					"\nCosto Per Partecipante: "+ (prezzoTotale/partecipanti) 	+ "€/pers." +
//					"\n-------------------------------------------------------------------" ;
		
		// Oppure possiamo scrivere così, spezzando ogni riga.
		risposta = 	"\n\n\tANTEPRIMA SCHEDA VIAGGIO";
		risposta = risposta + "\nDestinazione: " + destinazione;
		risposta = risposta + "\nMezzo di Locomozione: " + mezzoLocomozione;
		// risposta += "" è come dire: 'attacca al contenuto di risposta il nuovo pezzo di testo ce ti do'
		risposta += "\nDurata Vacanza: " + durataViaggio + "gg";
		risposta += "\nPartecipanti: " + partecipanti + "persone";
		risposta += "\n\nCosto Totale: " + prezzoTotale + "€";
		risposta += "\n---  " + scontoOsovrapprezzo + "  ---";
		risposta += "\nCosto Per Partecipante: " + (prezzoTotale/partecipanti) + "€/pers.";
		risposta += "\n-------------------------------------------------------------------";
		
		
		System.out.println(risposta);
		System.out.println("\n\nEND");
	}
}