package main;

// Classe Modello
public class Libro
{
	// Proprietà
	String titolo;
	String autore;
	String genere;
	String casaEditrice;
	int numeroPagine;
	int annoPubblicazione;
	boolean primaEdizione;

	// Costruttore
	Libro(String titolo, String autore, String casaEditrice, String genere, int annoPubblicazione, 
		  int numeroPagine, boolean primaEdizione)
	{
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.autore = autore;
		this.genere = genere;
		this.numeroPagine = numeroPagine;
		this.casaEditrice = casaEditrice;
		this.primaEdizione = primaEdizione;
	}//Fine costruttore
	
	// Metodi
	String scheda()
	{
		return  "Titolo: " 				+ titolo 						+
				"\nAutore: " 			+ autore 						+
				"\nGenere: " 			+ genere 						+
				"\nEdito da: " 			+ casaEditrice.toUpperCase() 	+
				"\nPubblicato nel: " 	+ annoPubblicazione 			+ 
				"\nPrima Editizione: " 	+ (primaEdizione ? "Sì" : "No") +
				"\nPagine: " 			+ numeroPagine 					+
				"\nPrezzo: "			+ prezzo()						+
				"\n------------------------------------------\n"		;
	}
	
	double prezzo()
	{
		double ris = 3;
		
		ris += numeroPagine * 0.002;
		
		switch(casaEditrice.toLowerCase())
		{
			case "mondadori" :
				ris += 2.5;
				break;
			case "feltrinelli" :
				ris += 1.1;
				break;
			case "hoepli" :
				ris += 0.5;
				break;
			default :
				ris += 3.2;
		}
		
		ris += primaEdizione ? 5 : 0.5;
		
		return ris;
	}
	
}// Fine classe Libro