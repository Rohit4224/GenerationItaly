package main;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
//		Chiedere all'utente di inserire 5 nomi
//		Per ogni nome concatenare in una variabile:
//		 - se il nome è Uberto o Zenelao "Il tuo nome è raro"
//		 - se il nome è Estella o Frisella "Il tuo nome è esotico"
//		 - se il tuo nome è Mario salvare unicamente "Ti chiami come l'idrauilico più famoso al mondo"
//		 - se il nome finisce con la lettera a "Il tuo nome termina con 'A'"
//		 - se il nome termina con la lettera o "Il tuo nome termina con 'O'"
//		 - se il nome ha un numero di lettere superiore a 7 "Il tuo nome è lungo"
//		Stampare in console la variabile caricata dopo i controlli sopra
//		(Il comando .length() che vi dice il numero di caratteri di una stringa, il resto provate a cercarlo con amico Google)
		
		Scanner tastiera;
		String nome;
		String risposta;
		String risposta_nome;
		int contatore;
		
		tastiera = new Scanner(System.in);
		risposta = "";
		risposta_nome = "";
		contatore = 0;
		
		
		while (contatore < 5)
		{
			System.out.println((contatore + 1) +  "° Nome:");
			nome = tastiera.nextLine();
			
			risposta += "\n\t NOME " + nome + ":";
			risposta_nome = "";
			switch(nome.toLowerCase())
			{
				case "uberto":
				case "zenelao":
					risposta_nome = "\n- Il tuo nome è raro";
					break;
				case "estella" :
				case "frisella" :
					risposta_nome = "\n- Il tuo nome è esotico";
					break;
				case "mario" :
					risposta_nome = "\n- Ti chiami come l'idrauilico più famoso al mondo";
					break;
			}
			
			if(nome.toLowerCase().endsWith("a"))
			{
				risposta_nome += "\n- Il tuo nome termina con 'A'";
			}
			else if(nome.toLowerCase().endsWith("o"))
			{
				risposta_nome += "\n- Il tuo nome termina con 'O'";
			}
			
			if(nome.length() > 7)
			{
				risposta_nome += "\n- Il tuo nome è lungo";
			}
			
			risposta += risposta_nome;
			
			
			contatore++;
		}
		
		tastiera.close();
		
		System.out.println(risposta);

	}

}
