package main;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		// ESERCIZIO
		
		// Dovete gestire una libreria.
		// Chiedete all'utente i dati dei libri.
		// Del libro vi interessa sapere: 
		//	titolo, autore, genere, anno di pubblicazione, numero di pagine, 
		//	casa editrice e tipo di copertina(rigida o no)
		// Il compito del programma è quello di calcolare il prezzo di copertina secondo queste regole:
		//  - Il costo per stampare una pagina del libro è di 0.05 euro
		//  - La copertina rigida implica 3 euro di spesa in più
		//  - Se l'autore è King +5.5, se è Rowling +2.1, se è Manfredi +4, se è Carrisi +6.5, per gli altri +2.5
		//  - Se il genere è Horror +5.5, se è Thriller o Giallo +6.5, se è storico +2.1, se è romanzo +8, gli altri generi +1.9
		//  - Se la casa editrice è rizzoli +3.5, se è mondadori +5.5, se è hoepli -0.5
		//  - Se l'anno di pubblicazione è antecedente al 2000 -4.5, se è compreso tra 2000 e 2015, -2.1, se ha meno di 2 anni +0.9
		//  - In ogni caso, un libro non può mai costare meno delle spese della materia prima
		//  - Siamo in periodo saldi, quindi tutti i libri con un costo superiore ai 25 euro saranno scontati del 5%
		
		// Stampare in console la scheda ordinata del libro, il suo costo totale e, se è presente, lo sconto applicato in euro
		
		/*
		 		[titoloLibro] di [autore]
		 		Copertina: [rigida o flessibile]
		 		Pubblicato nel: [anno] da [casa editrice]
		 		[numero di pagine] pagine
		 		Costo Totale: [costo del libro] 
		 		Applicato lo sconto del 5% -> [sconto in euro]€
		 		Costo Finale: [costo del libro scontato]		 		
		 */
		
		Scanner tastiera;
		String titolo;
		String autore;
		String genere;
		String casaEditrice;
		int annoPubblicazione;
		int numeroPagine;
		boolean copertinaRigida;
		double prezzoCopertina;
		double prezzoMateriali;
		double sconto;
		double prezzoScontato;
		String risposta;
		
		tastiera = new Scanner(System.in);
		risposta = "";
		prezzoCopertina = 0;
		prezzoMateriali = 0;
		sconto = 0;
		prezzoScontato = 0;
		
		System.out.println("Titolo:");
		titolo = tastiera.nextLine();
		System.out.println("Autore:");
		autore = tastiera.nextLine();
		System.out.println("Genere:");
		genere = tastiera.nextLine();
		System.out.println("Casa Editrice:");
		casaEditrice = tastiera.nextLine();
		System.out.println("Pagine:");
		numeroPagine = Integer.parseInt(tastiera.nextLine());
		System.out.println("Anno di pubblicazione:");
		annoPubblicazione = Integer.parseInt(tastiera.nextLine());
		System.out.println("Copertina Rigida? Y/N");
		copertinaRigida = tastiera.nextLine().equalsIgnoreCase("y") ? true : false;
		
		tastiera.close();
		
	//  - Il costo per stampare una pagina del libro è di 0.05 euro
		prezzoMateriali = numeroPagine * 0.05;
		
	//  - La copertina rigida implica 3 euro di spesa in più
		prezzoMateriali += copertinaRigida ? 3 : 0;
		
		prezzoCopertina = prezzoMateriali;
		
	//  - Se l'autore è King +5.5, se è Rowling +2.1, se è Manfredi +4, se è Carrisi +6.5, 
	//		per gli altri +2.5
		switch(autore.toLowerCase())
		{
			case "king" :
				prezzoCopertina += 5.5;
				break;
			case "rowling":
				prezzoCopertina += 2.1;
				break;
			case "manfredi" :
				prezzoCopertina += 4;
				break;
			case "carrisi":
				prezzoCopertina += 6.5;
				break;
			default:
				prezzoCopertina += 2.5;
		}
		
	//  - Se il genere è Horror +5.5, se è Thriller o Giallo +6.5, se è storico +2.1, 
	//		se è romanzo +8, gli altri generi +1.9
		switch(genere.toLowerCase())
		{
			case "horror":
				prezzoCopertina += 5.5;
				break;
			case "thriller":
			case "giallo":
				prezzoCopertina += 6.5;
				break;
			case "storico" :
				prezzoCopertina += 2.1;
				break;
			case "romanzo" :
				prezzoCopertina += 8;
				break;
			default:
				prezzoCopertina += 1.9;
		}
		
	//  - Se la casa editrice è rizzoli +3.5, se è mondadori +5.5, se è hoepli -0.5
		if(casaEditrice.equalsIgnoreCase("rizzoli"))
			prezzoCopertina += 3.5;
		else if(casaEditrice.equalsIgnoreCase("mondadori"))
			prezzoCopertina += 5.5;
		else if(casaEditrice.equalsIgnoreCase("hoepli"))
			prezzoCopertina -= 0.5;
		
	//  - Se l'anno di pubblicazione è antecedente al 2000 -4.5, se è compreso tra 2000 e 2015 -2.1, 
	// 		se ha meno di 2 anni +0.9
		//prezzoCopertina -= annoPubblicazione < 2000 ? 4.5 : 0;
		prezzoCopertina -= annoPubblicazione < 2000 ? 
														4.5 
													: 
														(annoPubblicazione >= 2000 && annoPubblicazione < 2015 ? 
																													2.1 
																											   : 
																												   (2023 - annoPubblicazione <= 2 ? 
																														   							  -0.9
																														   						  : 
																														   							  0));
		
	//  - In ogni caso, un libro non può mai costare meno delle spese della materia prima
	//  - Siamo in periodo saldi, quindi tutti i libri con un costo superiore ai 25 euro saranno 
	//		scontati del 5%
		prezzoCopertina = prezzoCopertina > prezzoMateriali ? prezzoCopertina : prezzoMateriali;
		
		if(prezzoCopertina > 25)
		{
			sconto = prezzoCopertina/100*5;
			
			if(sconto > prezzoCopertina-prezzoMateriali)
				sconto = prezzoCopertina - prezzoMateriali;
				
			prezzoScontato = prezzoCopertina - sconto;
		}
		
		risposta = 	"\n\n" 				 + titolo.toUpperCase()  + " di "   + autore 		+ 
					"\nCopertina: " 	 + (copertinaRigida      ? "Rigida" : "Flassibile") + 
					"\nPubblicato nel "  + annoPubblicazione     + " da "   + casaEditrice  +
					"\n" 				 + numeroPagine  		 + " pagine"+ 
					"\nCosto Totale: "   + prezzoCopertina 		 + "€" 		+
					(sconto > 0 ? "\nApplicato lo sconto del 5% -> "  + sconto  + "€" 		+ 
								  "\nCosto Finale: " + prezzoScontato + "€" : "");
						
		System.out.println(risposta);
	}
}