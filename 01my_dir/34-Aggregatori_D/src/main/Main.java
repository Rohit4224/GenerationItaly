package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

// CLassi di Avvio
public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Libreria l = new Libreria("src/res/Dati.txt");
		
		Scanner tastiera = new Scanner(System.in);
		String legenda = "\n\tLEGENDA" 						+
						 "\n1- Lista dei libri" 			+
						 "\n2- Libri pi� cari"				+
						 "\n3- Libri pi� lunghi"			+
						 "\n4- Libri di un autore a scelta"	+
						 "\n5 Prezzo medio per un genere a scelta";
		String cmd;
		String ris;
		
		System.out.println( "\n\tBenvenuto nella mia libreria!" +
				 			"\nEcco la legenda dei comandi:\n"  + legenda);
		
		do
		{
			System.out.println("  Comando:");
			cmd = tastiera.nextLine();
			
			switch(cmd)
			{
				case "1" :
					ris = "\n\tLISTA DEI LIBRI\n" + l.listaSchede();
					break;
				case "2" :
					ris = "\n\tLIBRI PIU' COSTOSI\n" + l.piuCari();
					break;
				case "3" :
					ris = "\n\tLIBRI PIU' LUNGHI\n" + l.piuLunghi();
					break;
				case "4":
					String stringIn;
					System.out.println("Inserisci un autore");
					stringIn = tastiera.nextLine();
					ris = "\n\bLIBRI DI QUESTO AUTORE\n" + l.cercaAutore(stringIn);
					break;
				case "5":
					System.out.println("Scrivi genere: ");
					String genere = tastiera.nextLine();
					
					ris = l.cercaGenere(genere);
					break;
				case "0" :
					ris = "Arrivederci";
					break;
				default :
					ris = "Comando non valido";
			}
			System.out.println(ris);
		}while(!cmd.equalsIgnoreCase("0"));
		
		tastiera.close();
		System.out.println("END");
	}
}