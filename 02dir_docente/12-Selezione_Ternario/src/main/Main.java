package main;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		// PRINCIPI FONDAMENTALI DELLA PROGRAMMAZIONE CLASSICA
		// > Sequenza
		// > Selezione (IF, SWITCH, TERNARIO)
		// > ?
		
		//		TERNARIO
		// Il ternario è uno strumento della selezione, che è nato come risultato dei tentativi
		// di comprimere la scrittura di un IF-ELSE per tenerlo in linea.
		
		// SINTASSI
		// variabileFinale = condizione ? istruzione_nel_caso_sia_vero : istruzione_nel_caso_sia_falso;
		// SINTASSI condizioni concatenate
		// variabile = c1 ? (c2 ? (c3 ? (rV3) : (rF3)) : (rF2)) : rF1;
		
		// I simboli (? : ;) Sono sempre obbligatori!!!!
		// Come sono sempre obbligatori i blocchi per le istruzioni_vere e per le istruzioni_false
		// Il ternario è obbligato a restituire un valore, quindi siamo obbligati a assegnare quel 
		// valore a qualcosa
		
		// CONSIGLIO PERSONALE DEL DOCENTE
		// Usate i ternari per situazioni facili, mentre se dovete fare tante istruzioni di fila 
		//	meglio un IF
		
		
		// Esercizio Ternari
		/* Scrivere un programma che permetta di calcolare se
		* uno studente può andare in erasmus
		* Uno studente inserisce direttamente le medie di 4 materie
		* italiano, matematica, inglese e francese
		* - se la media globale è superiore a 7
		* può andare in erasmus a Londra e avere una borsa di studio di 300 euro
		* - se la media globale è superiore a 7
		* e la media di francese è maggiore di 8
		* può andare in erasmus a Parigi o a Londra e può avere una borsa di 400 euro
		* - se la media globale è superiore a 8
		* e la media di francese o la media di inglese è maggiore di 8
		* può andare in erasmus a Vancouver e può avere una borsa di studio di 1000 euro
		*/
		
		//D
		boolean erasmus;
		Scanner tastiera;
		double mediaItaliano;
		double mediaMatematica;
		double mediaInglese;
		double mediaFrancese;
		double mediaGlobale;
		String localitaErasmusPapabili;
		double borsaStudio;
		String risposta;
		
		//I
		tastiera = new Scanner(System.in);
		erasmus = false;
		mediaGlobale = 0;
		localitaErasmusPapabili = "Non puoi andare";
		borsaStudio = 0;
		risposta = "";
		
		System.out.println("Media Italiano:");
		mediaItaliano = Double.parseDouble(tastiera.nextLine());
		System.out.println("Media Matematica:");
		mediaMatematica = Double.parseDouble(tastiera.nextLine());
		System.out.println("Media Inglese:");
		mediaInglese = Double.parseDouble(tastiera.nextLine());
		System.out.println("Media Francese:");
		mediaFrancese = Double.parseDouble(tastiera.nextLine());
		
		tastiera.close();
		
		//C
		mediaGlobale = (mediaItaliano + mediaFrancese + mediaInglese + mediaMatematica)/4;
		
		// Metodo 1
//		if(mediaGlobale > 7)
//		{
//			erasmus = true;
//			localitaErasmusPapabili = "Londra";
//			borsaStudio = 300;
//		}
//		
//		if(mediaGlobale > 7 && mediaFrancese > 8)
//		{
//			erasmus = true;
//			localitaErasmusPapabili = "Londra o Parigi";
//			borsaStudio = 400;
//		}
//
//		if(mediaGlobale > 8 && (mediaFrancese > 8 || mediaInglese > 8))
//		{
//			erasmus = true;
//			localitaErasmusPapabili = "Vancuver";
//			borsaStudio = 1000;
//		}
		// O
//		if(erasmus == true)
//		{
//			System.out.println("Puoi andare in ERASMUS a " + localitaErasmusPapabili + ", con " + 
//								borsaStudio + "€ di borsa di studio");
//		}
//		else
//		{
//			System.out.println("Non puoi andare in ERASMUS");
//		}
		
		// Metodo 2: TERNARI
		// Assegnazione di più variabili in più ternari (più semplice)
		erasmus = mediaGlobale > 7 ? true : false;
		
		localitaErasmusPapabili = mediaGlobale > 7 ? "Londra" : localitaErasmusPapabili;
		borsaStudio = mediaGlobale > 7 ? 300 : 0;
		
		// Assegnazione di più variabili in un solo ternario
//		risposta = (mediaGlobale > 7) ? 
//										(erasmus = true) 					 +
//										(localitaErasmusPapabili = "Londra") +
//										(borsaStudio = 300) 
//									  : 
//										"Non puoi andare in Erasmus";

		 
		localitaErasmusPapabili = mediaGlobale > 7 && mediaFrancese > 8 ? "Londra o Parigi" : localitaErasmusPapabili;
		borsaStudio = mediaGlobale > 7 && mediaFrancese > 8? 400 : 0;
		
		localitaErasmusPapabili = mediaGlobale > 8 && (mediaFrancese > 8 || mediaInglese > 8) ? "Vancuver" : localitaErasmusPapabili;
		borsaStudio = mediaGlobale > 8 && (mediaFrancese > 8 || mediaInglese > 8) ? 1000 : 0;
		
		// I booleani sono già di loro natura TRUE o FALSE, quindi non serve fare una condizione: sono già 
		// loro il risultato della condizione di uguaglianza!
		risposta = erasmus ? 
								"Destinazioni Papabili: " + localitaErasmusPapabili + 
								"\nBorsa Studio: " + borsaStudio + "€" 
							: 
								"Nessun ERASMUS per te";
		
		System.out.println(risposta);
		
	}// Fine main, NON CANCELLARE!
}