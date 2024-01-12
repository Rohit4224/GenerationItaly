package esercizio_1;

import java.util.ArrayList;
import java.util.Scanner;


/*
                     CONSEGNA
 1) Scrivere un programma che chieda all'utente di inserire dei numeri: quando l'uente scrive 0, 
                 stampare in console: la somma dei pari, la lista dei multipli di 7, il numero più presente scritto
                 (usate gli arraylist!!)
2) Leggere da un file una serie di nomi, salvarli in un AL e poi: stampare il nome più lungo,
                 il nome con più vocali presenti, cancellare tutti i nomi che iniziano per G 
3) Riempire un AL con numeri generati casualmente tra 1 e 10 compresi finchè la loro somma non supera 40,
                 poi stampare: elenco dei numeri, il numero dei pari, il numero dei diapari, cancellare i numeri 
                 multipli di 3, modificare tutti i numeri 9 con il numero 0
         */

public class Main
{
	public static int sommaPari(ArrayList<Integer> numeri)
	{
		int ris = 0;
		
		for(Integer n : numeri)
			if(n%2==0)
				ris+=n;
		
		return ris;
	}
	
	public static ArrayList<Integer> multipliDi7(ArrayList<Integer> numeri)
	{
		ArrayList<Integer> ris = new ArrayList<Integer>();
		
		for(Integer n : numeri)
			if(n%7==0 && !ris.contains(n))
				ris.add(n);
		
		return ris;
	}
	
	public static ArrayList<Integer> numeroPiuPresente(ArrayList<Integer> numeri)
	{
		ArrayList<Integer> ris = new ArrayList<Integer>();
		int max = 0;
		
		for(Integer n : numeri)
		{
			int conta = 0;
			
			for(Integer n2 : numeri)
				if(n == n2)
					conta++;
			
			if(conta > max)
			{
				max = conta;
				ris.clear();
				ris.add(n);
			}
			else if(conta == max && !ris.contains(n))
				ris.add(n);
		}
		
		return ris;
	}
	
	public static void main(String[] args)
	{
//		Scrivere un programma che chieda all'utente di inserire dei numeri: quando l'utente scrive 0, 
// 		stampare in console: la somma dei pari, la lista dei multipli di 7, il numero pi� presente scritto
// 		(usate gli arraylist!!)
		
		Scanner tastiera = new Scanner(System.in);
		ArrayList<Integer> numeri = new ArrayList<Integer>();
		int numero = 0;
		
		do
		{
			System.out.println("Scrivi il numero che vuoi inserire o digita 0 per uscire");
			String input = tastiera.nextLine();
			
			try
			{
				numero = Integer.parseInt(input);
				
				if(numero != 0)
					numeri.add(numero);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Digita un numero intero");
			}			
		}while(numero != 0);
		
		tastiera.close();
		
		System.out.println("\nElenco: " + numeri);
		System.out.println("\nSomma Pari: " + sommaPari(numeri));
		System.out.println("\nMultipli di 7: " + multipliDi7(numeri));
		System.out.println("\nNumero pi� Presente: " + numeroPiuPresente(numeri));
	}
}