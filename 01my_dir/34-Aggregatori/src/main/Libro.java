package main;

//Classe Modello
public class Libro {

	String titolo;
	String autore;
	String genere;
	String casaEditrice;
	int numeroPagine;
	int annoPubblicazione;
	boolean primaEdizione;
	
	Libro(String titolo,String autore,String genere,String casaEditrice,int numeroPagine,int annoPubblicazione,boolean primaEdizione)
	{
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.casaEditrice = casaEditrice;
		this.numeroPagine = numeroPagine;
		this.annoPubblicazione = annoPubblicazione;
		this.primaEdizione = primaEdizione;
	}
	
	String scheda()
	{
		String ris = "";
		return   "\nTitolo: " + titolo
				 + "\nAutore: " + autore
				 + "\nGenere: " + genere
				 + "\nCasa editrice: " + casaEditrice.toUpperCase()
				 + "\nNumero di pagine: " + numeroPagine
				 + "\nAnno di pubblicazione: " + annoPubblicazione
				 + "\nPrima edizione: " + (primaEdizione ? "Si" : "No" )
				 + "\nPrezzo: " + prezzo()
				 + "\n______________________________\n";

	}
	
	double prezzo()
	{
		double ris = 3;
		
		ris += numeroPagine*0.002;
		
		switch(casaEditrice.toLowerCase())
		{
		case "mondadori":
			ris += 2.5;
			break;
			
		case "feltrinelli":
			ris += 1.1;
			break;
		case "hoepli":
			ris += 0.5;
		default:
			ris += 3.2;
		}
		
		ris += primaEdizione ? 5 : 0.5;
		return ris;
	}
}
