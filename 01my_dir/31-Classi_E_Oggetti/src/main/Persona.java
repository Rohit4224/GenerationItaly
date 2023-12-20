package main;

// Questa e' una CLASSE, in particolare si chiama CLASSE MODELLO
public class Persona
{
	// Una classe si compone di due elementi diversi:
	// 1) PROPRIETA': sono le caratteristiche che mi interessa rappresentare nel concreto con i miei oggetti.
	String nome;
	String cognome;
	int eta;
	boolean patentato;
	
	// 						!!!!ATTENZIONE!!!
	// 			MAI MAI MAI MAI MAI Inizializzare le propriet� in linea!!!
	// Le proprieta' si dichiarano e basta!
	// Esistono pochissime eccezioni a questa regola, e non le vedremo fino a dopo natale, quindi il primo
	// che becco a inizializzare le proprieta' si vedra' vandalizzare il frigo.
	
	// 2) METODO: e' un algoritmo che dato un input calcola un output.
	//  Ogni metodo si compone di una cosa chiamata FIRMA DEL METODO.
	//  La firma del metodo � data dal nome (scheda) e dal contenuto delle parentesi tonde 
	//   (che siano piene o vuote come nel nostro caso poco importa).
	//  Prima della firma del metodo dobbiamo sempre mettere il cos� detto TIPO DI RITORNO 
	//   (sar� il tipo di dato che vogliamo dare in output)
	String scheda()
	{
		// Le graffe nei metodi sono OBBLIGATORIE e indicano il CORPO DEL METODO
		String ris = "";
		
		ris =   "Nominativo: " 	  + nome  +   " "   + cognome 			+
				"\ndi anni " 	  + eta  								+
				"\n" + (patentato ? "Ha la patente" : "Senza Patente") 	+ 
				"\n---------------------------------------------\n"		;
		
		
		// RETURN � la parola chiave che spedisce all'esterno di un metodo il valore della variabile
		//  o del calcolo che gli scriviamo accanto
		// Se ho un tipo di ritorno, devo per forza avere un return
		return ris;
	}
	
	
}