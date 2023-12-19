package main;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		// PRINCIPI FONDAMENTALI DELLA PROGRAMMAZIONE CLASSICA
		// 1 > Sequenza 
		// 2 > Selezione (IF,SWITCH,TERNARIO)
		// 3 > ITERAZIONE (WHILE,FOR)
		
		
		// 							CICLO FOR
		// Definizione
		// Il ciclo FOR si dice che cicla per indice.
		
		/*
		  		SINTASSI
		  		
		  	 for(int i = 0; i < limite; i++)
		  	 {
		  	 	istruzione1 da ciclare;
		  	 	istruzione2 da ciclare;
		  	 	....
		  	 }
		  	 
		  	 Nomenclatura parti del FOR:
		  	 	int i = 0 -> Dichiarazione e inizializzazione dell'indice
		  	 	i < limite -> condizione di iterazione
		  	 	i++ -> incremento/decremento
		  	 	
		  	 Come ciclo è nato tempo dopo il WHILE e si propone di centralizzare le regole di uso dell'indice.
		  	 E' il ciclo per eccellenza dei vettori.
		  	 
		  	 VANTAGGI:
		  	 	> l'indice è locale SOLO per il ciclo in questione, fuori dal ciclo i non esiste.
		  	 	> maggiore controllo dell'indice, sia del valore di partenza che dell'incremento
		  	 	> Potete scegliere per ogni ciclo da dove partire a leggere, potete scegliere di quanto salire
		  	 	> Il FOR è una versione del WHILE dopata -> for(;condizione;) I ; sono OBBLIGATORI anche se vuoti
		  	 	
		  	 CONTRO:
		  	 	> FOR per sua natura è portato a ciclare un numero finito di volte (non 0 e non infinto) 
		 */
		
		//	----------------------------	ESERCIZIO	----------------------------------------------------------
		
		// Chiedere all'utente quante persone ci sono in una classe. 
		// Per ogni persona chiedere l'età.
		// Alla fine, voglio vedere l'età media della classe, il numero di persone sopra i 25 anni, l'età minore presente
		
		// Passaggi: divido in 4 blocchi: chiedere e salvare i dati, quesito1, quesito2, quesito3
		
		// BLOCCO 1------------------------------------------------------------------------------------------------
		//D
		Scanner tastiera;
		int numeroPersone;
		int[] eta;
		
		//I
		tastiera = new Scanner(System.in);
		
		System.out.println("Quante persone ci sono in aula?");
		numeroPersone = Integer.parseInt(tastiera.nextLine());
		
		eta = new int[numeroPersone];
		
		//C
		// Si legge "per ogni i che parte da zero, finchè i è minore della dimensione di eta, i aumenterà di uno a ogni giro"
		for(int i = 0; i < eta.length; i++)
		{
			System.out.println("Digita l'età della persona " + (i+1));
			eta[i] = Integer.parseInt(tastiera.nextLine());
		}
		
		//O
		tastiera.close();
		
		//-----------------------------------------------------------------------------------------------------------
		// BLOCCO 1 -------------------------------------------------------------------------------------------------
		//D
		int somma;

		//I
		somma = 0;

		//C
		for(int i = 0; i < eta.length; i++)
			somma+= eta[i];
		
		//O
		System.out.println("L'età media della classe è: " + (somma/eta.length));
		
		//-----------------------------------------------------------------------------------------------------------
		// BLOCCO 2 -------------------------------------------------------------------------------------------------
		//D
		int conta;
		
		//I
		conta = 0;

		//C
		for(int i = 0; i < eta.length; i++)
			if(eta[i] > 25)
				conta++;

		//O
		System.out.println("Le persone sopra i 25 anni sono: " + conta);
		
		//-----------------------------------------------------------------------------------------------------------
		// BLOCCO 3 -------------------------------------------------------------------------------------------------
		//D
		int minore;

		//I
		minore = 160;

		//C
		for(int i = 0; i < eta.length; i++)
			if(eta[i] < minore)
				minore = eta[i];

		//O		
		System.out.println("L'età minore salvata è: " + minore);
		
		//-----------------------------------------------------------------------------------------------------------
		
		
	}
}