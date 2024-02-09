package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
//		Dato un file di serie Tv formattato nel seguente modo:
//	        NumeroSerieTvNelFile
//	        titoloSerie,genere,numeroStagioni,numeroDipuntateMedieAStagione
//
//	Leggere il file e salvare le informazioni sfruttando i vettori.
//	Creare poi un menù che mi consenta, a ripetizione, di usare i comandi:
	//		Lista delle serie Tv coi loro dettagli
	//		Nome della serie con maggior numero di stagioni
	//		Nome della serie con maggior numero di puntate a stagione
	//		Nome della serie con il minore numero di stagioni
	//		Nome della serie con il minore numero di puntate a stagione
	//		Numero medio di stagioni tra tutte le serie del file
	//		Permettere all'utente di cercare il nome di una serie in particolare e stampare i suoi dettagli. 
	//		  Se la serie non esiste nel file farlo sapere all'utente.
	//		Permettere all'utente di cercare un genere a sua scelta e stampare una lista coi nomi delle serie 
	//		  che corrispondono alla ricerca.
	//		  Se non esistono corrispondenze farlo sapere all'utente
	//		Indicare per ogni genere quante serie sono presentiù
	//		I titolo che hanno un numero totale di episodi minori alla media
	//		Legenda menù
	//		Fine programma
//
//	Consiglio:
//	    Per fare il menù sfruttate lo switch, ogni case avrà dei comandi specifici da eseguire. 
//	    DA CONSEGNARE ENTRO SABATO SERA con le solite regole di nomenclatura
		
	//D
	Scanner file;
	String percorso;
	String titoloSerie[];
	String genere[];
	int numeroStagioni[];
	int numeroDiPuntateMedieStagione[];
	int dimension;
	String risposta;
	String legenda;
	int TotPuntate;

	percorso = "src/res/File.txt";
	file = new Scanner(new File(percorso));
	dimension = Integer.parseInt(file.nextLine());
	titoloSerie = new String[dimension];
	genere = new String[dimension];
	numeroDiPuntateMedieStagione = new int[dimension];
	numeroStagioni = new int[dimension];
	risposta = "";
	legenda = "";
	
	int i = 0;
	String ListaDelleSerieTv = "";
	int maxNumeroDiStagioni = Integer.MIN_VALUE;
	String serieConMaggiorNumeroDiStagioni = "";
	
	int maxNumeroDiPuntateAStagione = Integer.MIN_VALUE;
	String serieConMaggiorNumeroDiPuntateAStagione = "";
	
	int minNumeroDiStagioni = Integer.MAX_VALUE;
	String serieConMinoreNumeroDiStagioni = "";
	
	int minNumeroDiPuntateAStagione = Integer.MAX_VALUE;
	String serieConMinoreNumeroDiPuntateAStagione = "";
	
	int TotStagione = 0;
	TotPuntate = 0;
	
	while (file.hasNextLine())
	{
		String temp[] = file.nextLine().split(";");
		
		titoloSerie[i] = temp[0];
		genere[i] = temp[1];
		numeroStagioni[i] = Integer.parseInt(temp[2]);
		numeroDiPuntateMedieStagione[i] = Integer.parseInt(temp[3]);
		ListaDelleSerieTv += "\nTitolo: " + titoloSerie[i] //1
							+ "\nGenere: " + genere[i]
							+ "\nNumero Stagioni: " + numeroStagioni[i]
							+ "\nNumero Di Puntate Medie a Stagione: " + numeroDiPuntateMedieStagione[i]
							+"\n------------------------------------------------------------------\n";
		
//		2 Nome della serie con maggior numero di stagioni
		if (maxNumeroDiStagioni < numeroStagioni[i])
		{
			maxNumeroDiStagioni = numeroStagioni[i];
			serieConMaggiorNumeroDiStagioni = "Nome/i della serie con maggior numero di stagioni: \n\n" 
											+ "Nome: " + titoloSerie[i]
											+ "\nNumeri di stagione: " + numeroStagioni[i] + "\n";
		}
		else if (maxNumeroDiStagioni == numeroStagioni[i])
			serieConMaggiorNumeroDiStagioni += "----------------\nNome: " + titoloSerie[i]
										+ "\nNumeri di stagione: " + numeroStagioni[i] + "\n";
		
//		3 Nome della serie con maggior numero di puntate a stagione
		if (maxNumeroDiPuntateAStagione < numeroDiPuntateMedieStagione[i])
		{
			maxNumeroDiPuntateAStagione = numeroDiPuntateMedieStagione[i];
			serieConMaggiorNumeroDiPuntateAStagione = "Nome/i della serie con maggior numero di puntate a stagioni: \n\n" 
											+ "Nome: " + titoloSerie[i]
											+ "\nNumero di puntate a stagioni: " + numeroDiPuntateMedieStagione[i] + "\n";
		}
		else if (maxNumeroDiPuntateAStagione == numeroDiPuntateMedieStagione[i])
			serieConMaggiorNumeroDiPuntateAStagione += "----------------\nNome: " + titoloSerie[i]
										+ "\nNumero di puntate a stagioni: " + numeroDiPuntateMedieStagione[i] + "\n";
		
//		4 Nome della serie con il MINORE numero di stagioni
		if (minNumeroDiStagioni > numeroStagioni[i])
		{
			minNumeroDiStagioni = numeroStagioni[i];
			serieConMinoreNumeroDiStagioni = "Nome/i della serie con MINORE numero di stagioni: \n\n" 
											+ "Nome: " + titoloSerie[i]
											+ "\nNumeri di stagione: " + numeroStagioni[i] + "\n";
		}
		else if (minNumeroDiStagioni == numeroStagioni[i])
			serieConMinoreNumeroDiStagioni += "----------------\nNome: " + titoloSerie[i]
										+ "\nNumeri di stagione: " + numeroStagioni[i] + "\n";
		
//		5 Nome della serie con il minore numero di puntate a stagione
		if (minNumeroDiPuntateAStagione > numeroDiPuntateMedieStagione[i])
		{
			minNumeroDiPuntateAStagione = numeroDiPuntateMedieStagione[i];
			serieConMinoreNumeroDiPuntateAStagione = "Nome/i della serie con il MINORE numero di puntate a stagioni: \n\n" 
											+ "Nome: " + titoloSerie[i]
											+ "\nNumero di puntate a stagioni: " + numeroDiPuntateMedieStagione[i] + "\n";
		}
		else if (minNumeroDiPuntateAStagione == numeroDiPuntateMedieStagione[i])
			serieConMinoreNumeroDiPuntateAStagione += "----------------\nNome: " + titoloSerie[i]
										+ "\nNumero di puntate a stagioni: " + numeroDiPuntateMedieStagione[i] + "\n";
		
		//6
		TotStagione += numeroStagioni[i]; 
		TotPuntate += numeroDiPuntateMedieStagione[i];
		
		
		i++;		
	}
	
	file.close();
	
	//9 Indicare per ogni genere quante serie sono presentiù
	String ogniGenereQuanteSerie = "";
	String serieTrovati = "";
	int count = 0;
	i = 0;
	while (i < genere.length)
	{
		if (!ogniGenereQuanteSerie.toLowerCase().contains(genere[i].toLowerCase() + ":"))
		{
			serieTrovati = "";
			count = 0;
			ogniGenereQuanteSerie += "\nGenere - " + genere[i] + ":";
			for(int j = 0; j < genere.length; j++)
			{
				if (genere[i].equalsIgnoreCase(genere[j]))
				{
					serieTrovati +=  "\nTitolo: " + titoloSerie[j];
					count++;
				}
			}
			ogniGenereQuanteSerie += serieTrovati + "\nGenere " + genere[i] + " ha " + count + " serieTV.\n"
					+ "------------------------------------------------------------------\n";
		}
		i++;
	}
	
	legenda = "\tSeleziona: \n"
			+"1 - Lista delle serie Tv con loro dettagli\n"
			+ "2 - Nome della serie con maggior numero di stagioni\n"
			+ "3 - Nome della serie con maggior numero di puntate a stagione\n"
			+ "4 - Nome della serie con il minore numero di stagioni\n"
			+ "5 - Nome della serie con il minore numero di puntate a stagione\n"
			+ "6 - Numero medio di stagioni tra tutte le serie del file\n"
			+ "7 - Cercare il nome di una serie in particolare e stampare i suoi dettagli\n"
			+ "8 - Cercare un genere a scelta e stampare una lista coi nomi delle serie \n"
			+ "9 - Per Vedere ogni genere quante serie sono presenti \n"
			+ "10 - I titolo che hanno un numero totale di episodi minori alla media\n"
			+ "L - Legenda menù\n"
			+ "0 - Fine programma\n";
	System.out.println(legenda);
	
	String cmd = "";
	Scanner input = new Scanner(System.in);
	do
	{
		cmd = input.nextLine();
		switch(cmd.toUpperCase())
		{
		case "1":
			risposta = ListaDelleSerieTv;
			break;
		case "2":
			risposta = serieConMaggiorNumeroDiStagioni;
			break;
		case "3":
			risposta = serieConMaggiorNumeroDiPuntateAStagione;
			break;
		case "4":
			risposta = serieConMinoreNumeroDiStagioni;
			break;
		case "5":
			risposta = serieConMinoreNumeroDiPuntateAStagione;
			break;
		case "6":
			//		Numero medio di stagioni tra tutte le serie del file
			
			risposta= "\nNumero medio di stagioni tra tutte le serie del file: " + TotStagione/dimension;
			break;
		case "7":
//			Permettere all'utente di cercare il nome di una serie in particolare e stampare i suoi dettagli. 
				//		  Se la serie non esiste nel file farlo sapere all'utente.
			risposta = "";
			String serieScelta;
			System.out.println("Scrivi il nome di una serie a tua scelta: ");
			serieScelta = input.nextLine();
			for (int j = 0; j < titoloSerie.length;j++)
			{
				if (titoloSerie[j].equalsIgnoreCase(serieScelta))
				{
					risposta += "\nTitolo: " + titoloSerie[j] 
							+ "\nGenere: " + genere[j]
							+ "\nNumero Stagioni: " + numeroStagioni[j]
							+ "\nNumero Di Puntate Medie a Stagione: " + numeroDiPuntateMedieStagione[j]
							+"\n------------------------------------------------------------------\n";
				}
			}
			if (risposta.isEmpty())
				risposta = "Scelta serieTV NON Trovata.\n";
			break;
		case "8":
//			Permettere all'utente di cercare un genere a sua scelta e stampare una lista coi nomi delle serie 
			//		  che corrispondono alla ricerca.
			//		  Se non esistono corrispondenze farlo sapere all'utente
			risposta = "";
			String genereScelta;
			System.out.println("Scrivi il nome di un genere a tua scelta: ");
			genereScelta = input.nextLine();
			for (int j = 0; j < genere.length;j++)
			{
				if (genere[j].equalsIgnoreCase(genereScelta))
				{
					risposta += "\nTitolo: " + titoloSerie[j] 
							+ "\nGenere: " + genere[j]
							+ "\nNumero Stagioni: " + numeroStagioni[j]
							+ "\nNumero Di Puntate Medie a Stagione: " + numeroDiPuntateMedieStagione[j]
							+"\n------------------------------------------------------------------\n";
				}
			}
			if (risposta.isEmpty())
				risposta = "Scelta genere NON Trovato.\n";
			break;
		case "9":
//			Indicare per ogni genere quante serie sono presenti
			risposta = ogniGenereQuanteSerie;
			break;
		case "10":
//			I titolo che hanno un numero totale di episodi minori alla media
			double media = TotPuntate / dimension;
			risposta = "La media e' " + media + ".\n";
			for(int j = 0; j < titoloSerie.length; j++)
			{
				if (numeroDiPuntateMedieStagione[j] < media)
				{
					risposta += "\nTitolo: " + titoloSerie[j]
							+ "\nNumero Di Puntate a Stagione: " + numeroDiPuntateMedieStagione[j]
							+"\n------------------------------------------------------------------\n";
				}
			}
			break;
		case "L":
			risposta = legenda;
			break;
		case "0":
			risposta = "Arrivederci";
			break;
			
		}
		
		System.out.println(risposta);
	}while(!cmd.equalsIgnoreCase("0"));
	
	input.close();
	System.out.println("END");
	
	} //main
}//class
