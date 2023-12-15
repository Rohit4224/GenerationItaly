package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	// throws FileNotFoundException indica che non vogliamo gestire gli errori legati alla location del file:
	// se il file non viene trovato, il programma esplode con il nostro permesso
	public static void main(String[] args) throws FileNotFoundException
	{
		// Il nostro compito è leggere il contenuto di File.txt e poi:
		// - Scheda dei singoli alcolici
		// - Il nome dell'alcolico con gradazione minore
		
		//D
		Scanner file;
		String tipoAlcolico;
		String nomeAlcolico;
		double gradazioneAlcol;
		double minoreGradazione;
		String risposta;
		String percorsoGlobale;
		String percorsoLocale;
		String nomeAlcolicoMinore;
		
		//I
		risposta = "";
		nomeAlcolicoMinore = "";
		//oppure 100 perchè sappiamo che la gradazione non può superare i 100 gradi
		minoreGradazione = Integer.MAX_VALUE; 		
		
		// PERCORSO: è la strada che il pc deve fare per arrivare esattamente dove è salvato il 
		//				file che vi interessa.
		// Globale: percorso completo che parte dal vostro disco rigido (inizia di solito con C:)
		// Locale (o Relativo): percorso ristretto perchè parte dalla cartella del progetto che stiamo 
		//			usando (inizia di solito con src). Ai programmatori piace questo!!
		percorsoGlobale = "C:\\Users\\RAD\\Desktop\\LAVORO\\01 - Java\\Corsi Generation\\JAITA112\\18-Lettura_Da_File\\src\\res\\File.txt";
		percorsoLocale = "src/res/File.txt";
		
		// Importare File scegliendo il pacchetto java.io.File;
		// Bisogna scegliere la voce "Add throws Exception" per levare la sottolineatura rossa.
		file = new Scanner(new File(percorsoLocale));
		
		//C
		//.hasNextLine() -> Controlla se esiste una riga da leggere
		while(file.hasNextLine())
		{
			// Dato che il file è stato formattato secondo l'ordine: tipo-nome-gradazione
			// so che leggerò in ordine tipoAlcolico, nomeAlcolico,gradazioneAlcol
			
			// Sapendo l'ordine, parto a leggere e assegnare i valori del file
			
			// Leggo tutti i dati del primo alcolico
			tipoAlcolico = file.nextLine();
			nomeAlcolico = file.nextLine();
			gradazioneAlcol = Double.parseDouble(file.nextLine());
			
			// Scrivo la scheda ordinata dell'alcolico letto
			risposta += "\nTipo: " 			+ tipoAlcolico 		+ 
						"\nNome: " 			+ nomeAlcolico 		+ 
						"\nGradazione: " 	+ gradazioneAlcol 	+ "%" +
						"\n----------------------------------\n";
			
			// Trovo la gradazione minore
			if(gradazioneAlcol < minoreGradazione)
			{
				minoreGradazione = gradazioneAlcol;
				nomeAlcolicoMinore = nomeAlcolico;
			}
			else if(gradazioneAlcol == minoreGradazione)
				nomeAlcolicoMinore += ", " + nomeAlcolico;
			
		}// Fine WHILE
		
		file.close();		
		
		//O
		System.out.println( "\tELENCO ALCOLICI:\n" 					+ risposta 				+ 
							"\nL'alcolico con gradazione minore è " + nomeAlcolicoMinore 	+ 
							" con " 								+ minoreGradazione 		+ "%");
	}
}