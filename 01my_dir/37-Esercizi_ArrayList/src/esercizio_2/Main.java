package esercizio_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{	
	public static String nomiMax(ArrayList<String> nomi)
	{
		// D+I
		int max = 0;
		String nomeMax = "";
		
		// C
		for(String nome : nomi)
			if(nome.length() > max)
			{
				max = nome.length();
				nomeMax = nome;
			}
			else if(nome.length() == max)
				nomeMax += ", " + nome;
		// O
		return nomeMax;
	}
	
	public static String nomiVocaliMax(ArrayList<String> nomi)
	{
		String ris = "";
		int max = 0;
		int conta;
		
		for(int i = 0; i < nomi.size(); i++)
		{
			//System.out.println("Indice: " + i + " Nome: " + nomi.get(i));
			conta = 0;
			// Ora ho il singolo nome, devo contare le sue vocali
			String[] lettereNome = nomi.get(i).split("");
			
			for(String s : lettereNome)
				if( s.equalsIgnoreCase("a") || 
					s.equalsIgnoreCase("e") || 
					s.equalsIgnoreCase("i") || 
					s.equalsIgnoreCase("o") || 
					s.equalsIgnoreCase("u") )
				{
					conta++;
				}
			
			if(conta > max)
			{
				max = conta;
				ris = nomi.get(i);
			}
			else if(max == conta)
				ris += ", " + nomi.get(i);
		}
		
		return ris;
	}
	
	public static String nomiDopoCancellazione(ArrayList<String> nomi)
	{
		// Soluzione con AL
//		ArrayList<String> nomiCopia = nomi;
//		
//		for(int i = 0; i < nomi.size(); i++)
//			if(nomi.get(i).toLowerCase().startsWith("g"))
//				nomiCopia.remove(i);
//		
//		return nomiCopia;
		
		// Soluzione "banale"
//		String ris = "";
//		
//		for(int i = 0; i < nomi.size(); i++)
//		{	
//			boolean cancellato = false;
//			
//			if(nomi.get(i).toLowerCase().startsWith("g"))
//			{
//				nomi.remove(i);
//				i--;
//				cancellato = true;
//			}
//			
//			if(!cancellato)
//				ris += nomi.get(i) + ", ";
//		}
//		
//		return ris.substring(0,ris.length()-2);
		
		// Soluzione "al contrario"
		String ris = "";
		
		for(int i = nomi.size()-1; i >= 0 ; i--)
		{	
			boolean cancellato = false;
			
			if(nomi.get(i).toLowerCase().startsWith("g"))
			{
				nomi.remove(i);
				
				cancellato = true;
			}
			
			if(!cancellato)
				ris += nomi.get(i) + ", ";
		}
		
		return ris.substring(0,ris.length()-2);
	}
	
	public static void main(String[] args)
	{
		/*
		 			CONSEGNA
		 	1) Scrivere un programma che chieda all'utente di inserire dei numeri: quando l'uente scrive 0, 
		 		stampare in console: la somma dei pari, la lista dei multipli di 7, il numero più presente scritto
		 		(usate gli arraylist!!)
		 	2) Leggere da un file una serie di nomi, salvarli in un AL e poi: stampare il nome più lungo,
		 		il nome con più vocali presenti, cancellare tutti i nomi che iniziano per G 
		 	3) Riempire un AL con numeri generati casualmente tra 1 e 10 compresi finchè la loro somma non supera 40,
		 		poi stampare: elenco dei numeri, il numero dei pari, il numero dei dispari, cancellare i numeri 
		 		multipli di 3, modificare tutti i numeri 9 con il numero 0
		 */
		
		// ESERCIZIO 2
		
		//D
		ArrayList<String> nomi;
		
		Scanner file = null;
		Scanner tastiera = new Scanner(System.in);
		String path = "src/main/Nomi.txt";
		
		//I
		do
		{
			try
			{
				file = new Scanner(new File(path));
				nomi = new ArrayList<String>();
				break;
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File non trovato a '" + path + "'\nDigita un nuovo percorso:");
				path = tastiera.nextLine();
			}			
		}while(true);
		
		tastiera.close();
		
		while(file.hasNextLine())
		{
			String[] info = file.nextLine().split(",");
			
			for(String s : info)
				nomi.add(s);
		}
		
		//System.out.println(nomi);
		
		// C
		//stampare il nome più lungo
//		int max = 0;
//		String nomeMax = "";
//		
//		for(String s : nomi)
//			if(s.length() > max)
//			{
//				max = s.length();
//				nomeMax = s;
//			}
//			else if(s.length() == max)
//				nomeMax += ", " + s;
		String nomeMax = nomiMax(nomi);
		
 		//il nome con più vocali presenti
		String nomeVocaliMax = nomiVocaliMax(nomi);
		
		//cancellare tutti i nomi che iniziano per G 
		String nomiCompletiOriginali = nomi.toString();
		String nomiDopoCancellazione = nomiDopoCancellazione(nomi);
		
		// O
		System.out.println("\nNomi più lunghi: " + nomeMax);
		System.out.println("\nNomi con più vocali: " + nomeVocaliMax);
		System.out.println("\nNomi Originali: " + nomiCompletiOriginali + "\nNomi Senza G: " + nomiDopoCancellazione);
		
	}
}