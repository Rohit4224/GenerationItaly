package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// ESERCIZIO

        // Dovete gestire una libreria.
        // Chiedete all'utente i dati dei libri.
        // Del libro vi interessa sapere: 
        //    titolo, autore, genere, anno di pubblicazione, numero di pagine, 
        //    casa editrice e tipo di copertina(rigida o no)
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
		
		//D

		String titolo;
		String autore;
		String genere;
		int anno_publicazione;
		int numeroDiPagine;
		String casaEditrice;
		boolean rigida;
		Double costoTotale;
		int sconto;
		Double scontoEuro;
		Double costoFinale;
		Scanner tastiera;
		String copertina;
		Double costoMateriaPrima;
		
		//I
		titolo = "";
		autore = "";
		genere = "";
		anno_publicazione = 0;
		numeroDiPagine = 0;
		casaEditrice = "";
		rigida = false;
		costoTotale = 0.0;
		sconto = 0;
		scontoEuro = 0.0;
		costoFinale = 0.0;
		copertina = "";
		costoMateriaPrima = 0.0;
		
		tastiera = new Scanner(System.in);
		
//	    titolo, autore, genere, anno di pubblicazione, numero di pagine, 
        //    casa editrice e tipo di copertina(rigida o no)
		System.out.println("Scrivi titolo del libro: ");
		titolo = tastiera.nextLine();
		System.out.println("Scrivi l'autore: ");
		autore = tastiera.nextLine();
		System.out.println("Scrivi genere: ");
		genere = tastiera.nextLine();
		System.out.println("Scrivi anno di publicazione: ");
		anno_publicazione = Integer.parseInt(tastiera.nextLine());
		System.out.println("Scrivi numero di pagine: ");
		numeroDiPagine = Integer.parseInt(tastiera.nextLine());
		System.out.println("Scrivi la casa editrice: ");
		casaEditrice = tastiera.nextLine();
		System.out.println("Scrivi \"Y\" se tipo di copertina è rigida, altrimenti \"N\" : ");
		rigida = tastiera.nextLine().equalsIgnoreCase("y");
		
		tastiera.close();
		
		// O
	//  - La copertina rigida implica 3 euro di spesa in più
		costoTotale = rigida == true ? (costoTotale += 3.0) + (costoMateriaPrima += 3.0) : costoTotale;
		
		//- Il costo per stampare una pagina del libro è di 0.05 euro
		costoTotale += (numeroDiPagine * 0.05);
		costoMateriaPrima = costoTotale;
		//  - Se l'autore è King +5.5, se è Rowling +2.1, se è Manfredi +4, se è Carrisi +6.5, per gli altri +2.5
		switch(autore.toUpperCase())
		{
			case "KING":
				costoTotale += 5.5;
				break;
			case "ROWLING":
				costoTotale += 2.1;
				break;
			case "MANFREDI":
				costoTotale += 4.0;
				break;
			case "CARRISI":
				costoTotale += 6.5;
				break;
			default:
				costoTotale += 2.5;
		}
        //  - Se il genere è Horror +5.5, se è Thriller o Giallo +6.5, se è storico +2.1, se è romanzo +8, gli altri generi +1.9
		switch(genere.toLowerCase())
		{
			case"horror":
				costoTotale += 5.5;
				break;
			case "thriller":
			case "giallo":
				costoTotale += 6.5;
				break;
			case "storico":
				costoTotale += 2.1;
				break;
			case "romanzo":
				costoTotale += 8.0;
				break;
			default:
				costoTotale += 1.9;
		}
        //  - Se la casa editrice è rizzoli +3.5, se è mondadori +5.5, se è hoepli -0.5
		switch (casaEditrice.toLowerCase())
		{
			case "rizzoli":
				costoTotale += 3.5;
				break;
			case "mondadori":
				costoTotale += 5.5;
				break;
			case "hoepli":
				costoTotale -= 0.5;
		}
        //  - Se l'anno di pubblicazione è antecedente al 2000 -4.5, se è compreso tra 2000 e 2015, -2.1, 
				//se ha meno di 2 anni +0.9
		if (anno_publicazione <= 2000)
		{
			costoTotale -= 4.5;
		}
		else if (anno_publicazione > 2000 && anno_publicazione < 2015)
		{
				costoTotale -= 2.1;
		}
		else if ((2023 - anno_publicazione) < 2)
		{
			costoTotale += 0.9;
		}
		
        //  - In ogni caso, un libro non può mai costare meno delle spese della materia prima
        //  - Siamo in periodo saldi, quindi tutti i libri con un costo superiore ai 25 euro saranno scontati del 5%

		if (costoTotale > 25)
		{
			sconto = 5;
			scontoEuro = costoTotale * sconto / 100;
			costoFinale = costoTotale - scontoEuro;
			if (costoFinale < costoMateriaPrima)
			{
				scontoEuro = scontoEuro - (costoMateriaPrima - costoFinale);
				costoFinale = costoMateriaPrima;
			}
		}
		
		 /*
        [titoloLibro] di [autore]
        Copertina: [rigida o flessibile]
        Pubblicato nel: [anno] da [casa editrice]
        [numero di pagine] pagine
        Costo Totale: [costo del libro] 
        Applicato lo sconto del 5% -> [sconto in euro]€
        Costo Finale: [costo del libro scontato]
        
*/
		if (rigida == true)
		{
			copertina = "Rigida";
		}
		else 
			copertina = "Flessibile";
		System.out.println(titolo + " di " + autore + "\n"
							+ "Copertina: " + copertina + "\n"
							+"Pubblicato nel: " + anno_publicazione + " da " + casaEditrice + "\n"
							+ numeroDiPagine + " pagine\n"
							+ "Costo Totale: " + costoTotale);
		if (sconto > 0)
		{
			System.out.println("Appilcato lo sconto: " + scontoEuro);
			System.out.println("Costo Finale: " + costoFinale);
		}

	}

}
