package main;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		// scrivere una programma che calcoli le entrate annuali di un lavoratore
		//nome e cognome
		//stipendio medio Mensile
		//mensilità contrattuali
		//stampare in console "Buonasera sign. {cgnome} il suo lordo annuale vale {calcolo}€"
		
		//Declaration (D)
		String nome;
		String cognome;
		double stipendio;
		double calcolo;
		String risposta;
		int mensilità;
		Scanner tastiera;
		
		
		// Initialisation(I)
		tastiera = new Scanner(System.in);
		risposta = "";
		calcolo = 0;
		
		System.out.println("Digita il tuo nome and Enter");
		nome = tastiera.nextLine();
		System.out.println("Digita il tuo cognome");
		cognome = tastiera.nextLine();
		System.out.println("Digita lo stipendio medio Mensile and Enter");
		stipendio = Double.parseDouble(tastiera.nextLine());
		System.out.println("Digita la mensilità and Enter");
		mensilità = Integer.parseInt(tastiera.nextLine());

		//Calculation (C)
		calcolo = stipendio * mensilità;
		tastiera.close();
		
		//Output (O)
		risposta = "Buonasera sign." + cognome + "il suo lordo annuale vale " + calcolo + "€";
		System.out.println(risposta);
	}

}
