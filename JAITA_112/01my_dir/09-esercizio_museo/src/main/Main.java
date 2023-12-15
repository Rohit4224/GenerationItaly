package main;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		// lavorate in un biglietteria a Vezio.
		// Sapete che il  biglietto intero costa 10€
		// che il museo applica seguenti sconti (non cumulabili), piu avvantoggio in caso se ci sono due sconti applicabile
		// - residenti a Vezio e a Como entrano gratis
		// - studenti hanno diritto al 30% di sconto
		// - under 12 e gli over 65 hanno diritto al 50% di sconto
		// - militari e i medici hanno 65% sconto
		
		// scrivere un programma che chieda i dati all'utente e calcoli il prezzo del suo biglietto.
		
		// D
		int prezzoIntero;
		String nome;
		boolean militari_o_medici;
		int age;
		String residence;
		boolean university;
		Scanner tastiera;
		String risposta;

		// I
		tastiera = new Scanner(System.in);
		prezzoIntero = 10;
		nome = "";
		militari_o_medici = false;
		risposta = "";
		university = false;
		
		//c
		System.out.println("Welcome to ticket shop, Enter your name please.");
		nome = tastiera.nextLine();
		System.out.println("Please Enter your residence.");
		residence = tastiera.nextLine();
		if (residence.equalsIgnoreCase("vezio") || residence.equalsIgnoreCase("como"))
			risposta = "Dear " + nome + ", you have 100% of discount, you pay 0€.";
		else
		{
			System.out.println("For discount in ticket, Enter Y if you are a doctor or a military, else N");
			militari_o_medici = tastiera.nextLine().equalsIgnoreCase("Y");
			if (militari_o_medici == true)
				risposta = "Dear " + nome + ", you have 65% of discount, you pay 3.5€.";
			else
			{
				System.out.println("Please enter your age");
				age = Integer.parseInt(tastiera.nextLine());
				if (age < 12 || age > 65)
					risposta = "Dear " + nome + ", you have 50% of discount, you pay 5€.";
				else
				{
					System.out.println("Enter Y if you are student, else N");
					university = tastiera.nextLine().equalsIgnoreCase("Y");
					if (university == true)
						risposta = "Dear " + nome + ", you have 30% of discount, you pay 7€.";
					else
						risposta = "Dear " + nome + ", you are not eligible of any of our discounts, you pay 10€.";
				}
			}
		}
		
		tastiera.close();
		
		System.out.println(risposta);
	}

}
