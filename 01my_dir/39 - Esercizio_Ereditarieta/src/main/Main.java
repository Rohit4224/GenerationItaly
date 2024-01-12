package main;

import entities.PublicTransportAggregator;

public class Main {

	public static void main(String[] args) {
		// Scrivere un programma che gestisca i mezzi di trasporto di una città
        // Avrete un file che seguirà la seguente formattazione:
        // tram,linea,vagoni,posti a sedere, posti in piedi,binario singolo(boolean),notturno(boolean)
        // metro,linea,vagoni,posti a sedere, posti in piedi,passa in superficie(boolean),notturno(boolean)
        // autobus,linea,posti a sedere,posti in piedi,doppio piano(boolean),notturno(boolean)
        // Capite che grado di parentela c'è tra le classi necessarie, poi leggete il file
        // e rispondete alle seguenti domande:
        // - elenco tram
        // - elenco metro
        // - elenco autobus
        // - elenco notturni
        // - trovare il mezzo migliore per gestire il numero di persone dato
        // - trovare il mezzo con minore capienza
        // - trovare il mezzo per una linea cercata

		PublicTransportAggregator o = new PublicTransportAggregator("src/res/Dati.txt");
		
		System.out.println(o.elencoTram());
		
		System.out.println(o.elencoMetro());
		
		System.out.println(o.elencoAutobus());
		
		System.out.println("Elenco Notturno: \n" + o.elencoNotturni());
		
		System.out.println("Il mezzo migliore: " + o.mezzoMigliore(15));
		
		System.out.println("Il mezzo con minore capienza: \n" + o.minoreCapienza());
		
		System.out.println("Il mezzo per una linea cercata: \n" + o.lineaCercata("Linea 2"));
		
//		System.out.println();
	}

}
