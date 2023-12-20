package main;

public class Viaggio 
{
//    destinazione,mezzo di trasporto,giorni di vacanza,costo giornaliero,numero persone.

	String destinazione;
	String mezzoDiTrasporto;
	int giorniDiVacanza;
	double costoGiornaliero;
	int numeroPersone;
	
	Viaggio()
	{
		//solo per ricordarmi che questo costruttore esiste gia' anche se non scrivo
	}
	
	//Costruttore
	Viaggio(String destinazione, String mezzoDiTrasporto, int giorniDiVacanza, double costoGiornaliero, int numeroPersone)
	{
		this.destinazione = destinazione;
		this.mezzoDiTrasporto = mezzoDiTrasporto;
		this.giorniDiVacanza = giorniDiVacanza;
		this.costoGiornaliero = costoGiornaliero;
		this.numeroPersone = numeroPersone;
	}
	
	String scheda()
	{
		String res = "";
		
		res = "Destinazione: " + destinazione
				+ "\nMezzo di trasporto: " + mezzoDiTrasporto
				+ "\nGiorni Di vacanza: " + giorniDiVacanza
				+ "\nCosto giornaliero: " + costoGiornaliero
				+ "\nNumero di Persone: " + numeroPersone
				+ "\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
		
		return res;
	}
	
	double prezzo()
	{
		double prezzo = 100;
		prezzo += (destinazione.equalsIgnoreCase("dubai") || destinazione.equalsIgnoreCase("tokyo")) ?
				200 : (destinazione.equalsIgnoreCase("dublino") || destinazione.equalsIgnoreCase("londra")) ?
						150 : (destinazione.equalsIgnoreCase("new york") || destinazione.equalsIgnoreCase("miami")) ?
								300 : 50;
		switch(mezzoDiTrasporto)
		{
			case "aereo" :
			case "traghetto" :
				prezzo += 500;
				break;
			case "treno" :
				prezzo += 200;
				break;
			case "autobus" :
			case "automobile" :
				prezzo += 100;
				break;
			default:
				prezzo += 1000;
		}
		
//		> se le persone sono più di 5 scontare il viaggio del 5%, se invece sono più di 10 scontare il 
//		viaggio del 10%.
		
		prezzo += giorniDiVacanza * costoGiornaliero;
		
		prezzo += numeroPersone > 10 ? prezzo * 0.90 : numeroPersone > 5 ? prezzo * 0.95 : prezzo;
		
		return (prezzo);
	}
	
}
