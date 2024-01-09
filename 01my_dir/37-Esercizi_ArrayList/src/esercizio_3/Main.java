package esercizio_3;

import java.util.ArrayList;

public class Main
{
	public static String pari(ArrayList<Integer> numeri)
	{
		int ris = 0;
		
		for(Integer n : numeri)
			if(n%2==0)
				ris++;
		
		return ris + "";
	}
	
	public static int dispari(ArrayList<Integer> numeri)
	{
		int ris = 0;
		
		for(Integer n :  numeri)
			if(n%2!=0)
				ris++;
		
		return ris;
	}
	
	public static String modificaDei9In0(ArrayList<Integer> numeri)
	{
		ArrayList<Integer> copia = new ArrayList<Integer>(numeri);
		String ris = "";
		
//		for(Integer n : copia)
//		{	
//			if(n == 9)
//				n = 0;
//			ris += n + ", ";
//		}
		
		for(int i = 0; i < copia.size(); i++)
		{
			if(copia.get(i) == 9)
				copia.set(i, 0);
			
			ris += copia.get(i) + ", ";
		}
		
		return ris.substring(0,ris.length()-2);
	}

	public static String senzaMultipli3(ArrayList<Integer> numeri)
	{
		ArrayList<Integer> copia = new ArrayList<Integer>(numeri);
		String ris = "";
		
		for(int i = 0; i < copia.size(); i++)
		{
			boolean cancellato = false;
			
			if(copia.get(i)%3==0)
			{
				copia.remove(i);
				i--;
				cancellato = true;
			}
			
			if(!cancellato)
				ris += copia.get(i) + ", ";
		}
		
		return ris.substring(0,ris.length()-2);
	}
	
	public static void main(String[] args)
	{
//		3) Riempire un AL con numeri generati casualmente tra 1 e 10 compresi finchè la loro somma non supera 40,
//		poi stampare: elenco dei numeri, il numero dei pari, il numero dei dispari, cancellare i numeri 
//		multipli di 3, modificare tutti i numeri 9 con il numero 0
		
		ArrayList<Integer> numeri = new ArrayList<Integer>();
		int somma = 0;
		
		do
		{
			int numeroRandom = (int)(Math.random() * 10) + 1;
			
			numeri.add(numeroRandom);
			//System.out.println(numeroRandom);
			somma += numeroRandom;
			//System.out.println(somma);
		}while(somma <= 40);
		
		String pari = pari(numeri);
		int dispari = dispari(numeri);
		String modificaDei9In0 = modificaDei9In0(numeri);
		String senzaMultipli3 = senzaMultipli3(numeri);
		
		// O
		System.out.println("\nElenco: " + numeri);
		System.out.println("\nTotale Pari: " + pari);
		System.out.println("\nTotale Dispari: " + dispari);
		System.out.println("\nModifica dei 9 in 0: " + modificaDei9In0);
		System.out.println("\nSenza multipli di 3: " + senzaMultipli3);
	}
}