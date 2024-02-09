package main;

import java.util.Scanner;
import java.io.FileNotFoundException;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		String path;
		Libreria l;

		path = "src/res/Data.txt";
		l = new Libreria(path);
		String legenda = "\n1-Stampa la lista dei libri"
					  	 + "\n2-Libri più cari"
					  	 + "\n3-Libri con più pagine"
					  	 + "\n4-Libri di un autore a scelta"
					  	 + "\n0-Esci"
					  	 + "\nL-Legenda";
		
		String cmd;
		String risposta;
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println(legenda);
		do
		{
			System.out.println("Comando: ");
			cmd = tastiera.nextLine();
			risposta = "";
			
			switch(cmd.toUpperCase())
			{
			case "1":
				risposta = "\n\bLISTA DEI LIBRI\n" + l.listaSchede();
				break;
				
			case "2":
				risposta = "\n\bLISTA DEI LIBRI PIU' CARI\n" + l.libroPiuCaro();
				break;
				
			case "3":
				risposta = "\n\bLISTA DEI LIBRI CON PIU' PAGINE\n" + l.libroPiuPagine();
				break;
				
			case "4":
				String stringIn;
				
				System.out.println("Inserisci un autore");
				stringIn = tastiera.nextLine();
				risposta = "\n\bLIBRI DI QUESTO AUTORE\n" + l.cercaAutore(stringIn);
				break;
			case "0":
				risposta = "Adios";
				break;
				
			case "L":
				risposta = legenda;
				break;
			
			default:
				risposta = "comando inesistente";
			}
			System.out.println(risposta);
		}while(!cmd.equalsIgnoreCase("0"));
	}

}