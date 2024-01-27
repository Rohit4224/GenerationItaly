package _main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args)
	{
		//Mappe
		// Definizione - una Mappa è un insieme di coppie chiave-valore
		
		/*
		 * Le mappe per loro natura tendono al disordine, cioè non esiste un indice che tenga
		 * 		ordinato l'insieme di dati che salviamo nella variabile
		 * 
		 * Al posto dell'indice numerico classico, le mappe hanno le CHIAVI.
		 * Una chiave puo essere del tipo che volete voi (int, double, String, Entity..)
		 * L'unica cosa a cui dovete prestare attenzione è non far ripetere mai la chiave.
		 * 
		 * ogni chiave mi permetterà di identificare con assoluto certezza il valore a lei associato.
		 * Il valore può essere del tipo che volete voi (int, double, String, Entity..)
		 * 
		 * Il tipo della chiave e il tipo del valore non devono essere per forza uguali.
		 * 
		 * Le mappe sono principalmente di due tipi:
		 *  - Ordinate : significa che mantiene l'ordine di inserimento
		 *  - disordinate : significa che restituiscono un ordine diverso da quello di inserimento  
		 *  
		 * */
		
		//DICHIARAZIONE
		// Map è un interfaccia che ci permetta di scegliere dopo se usare una mappa
		//  ordinata o disordinata, Ricordatevi di importare Map da java.util
		// SINTASSI: Map<tipoChiave, tipoValore> nomeMappa
		Map <String, Integer> merciOrdinata;
		Map <String, Integer> merciDisordinata;
		
		// INIZIALIZZAZIONE
			//mappa ordinata
		merciOrdinata = new LinkedHashMap<String, Integer>();
		
			//mappa disordinata
		merciDisordinata = new HashMap<String, Integer>();
		
		// VALORIZZAZIONE
		merciOrdinata.put("Pane", 5);
		merciOrdinata.put("Tergicristallo", 1);
		merciOrdinata.put("Latte", 6);
		merciOrdinata.put("Cereali", 1);
		merciOrdinata.put("Pane", 10); //ATTENZIONE: Sovrascrive il valore di "Pane"
		
		
		merciDisordinata.put("Sugo", 12);
		merciDisordinata.put("Succo d'arancia", 2);
		merciDisordinata.put("Pasta", 2);
		merciDisordinata.put("Yogurt", 2);
		
		//STAMPA in console
		System.out.println(merciOrdinata);
		System.out.println("\n\n" + merciDisordinata);
		
		
		/*
		 
		 A java le tabelle non piacciono, quindi farà un lavoro simile a questo:
		 
		id	nome	cognome		residenza
		1	Alice	Bensanelli	Milano			-> {id=1, nome=Alice, cognome=Bensanelli, residenza=Milano}
		2	Pino	Pane		Lodi			-> {id=2, nome=Pino, cognome=Pane, residenza=Lodi}
		3	Luca	Bianchi		Milano			-> {id=3, nome=Luca, cognome=Bianchi, residenza=Milano}
		
		ArrayList<Map<String,String>> -> [
		                                  0: {id=1, nome=Alice, cognome=Bensanelli, residenza=Milano}, 
		                                  1: {id=2, nome=Pino, cognome=Pane, residenza=Lodi}, 
		                                  2: {id=3, nome=Luca, cognome=Bianchi, residenza=Milano} 
		                                 ]
		*/
		
		// CICLARE
			// Il ciclo for indicizzato con le mappe non funziona
			// L'unico ciclo che si presta con le mappe è il foreach
		// Le mappe si possono ciclare sia per le chiavi che per i valori
			//CICLO Per CHIAVI: 
			// posso ottenere sia le informazioni delle chiavi che dei valori collegati alle chiavi
		for(String key : merciOrdinata.keySet())
			System.out.println("Chiave " + key + "   Valore " + merciOrdinata.get(key));
		
		// .keySet() -> Restituisce una lista delle chiavi della mappa
		// mappa.get(key) -> Restituisce il valore associato alla chiave key
		
			//CICLO per VALORI:
			// posso ottenere solo le informazioni legati ai singoli valori (non so nulla delle chiavi)
		for(Integer value : merciOrdinata.values())
			System.out.println("Valore: " + value);
		
		// CANCELLARE un valore della mappa
		merciOrdinata.remove("Pane");
		
		System.out.println(merciOrdinata);
		
		merciOrdinata.put("Pane",10);
		
		System.out.println(merciOrdinata);
		
	} //main

}// classe modello
