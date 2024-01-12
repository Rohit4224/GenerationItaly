package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Scuola;

public class Main {

	public static void main(String[] args)
	{
		String path = ("src/res/Data.txt");
		
		Scuola o = null;
		do {
			try
			{
				o = new Scuola(path);
				break;
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
				System.out.println(path + " Scrivi il Path giusto: ");
				Scanner input = new Scanner (System.in);
				path = input.nextLine();
				input.close();
			}
		} while (true);
		
		String menu = "1 - Scheda di Studenti\n"
				+ "2 - Scheda di Docenti\n"
				+ "3 - Scheda di Studenti e Docenti\n"
				+ "4 - Lista degli studenti promossi e il numero degli studenti bocciati\n"
				+ "5 - Numero degli studenti che possono andare in erasmus\n"
				+ "6 - Lista di insegnanti prossimi alla pensione(entro a 5 anni dalla pensione)\n"
				+ "7 - Totale stipendio degli insegnanti di italiano\n"
				+ "8 - Media degli stipendi di tutti gli insegnanti\n"
				+ "9 - Menu\n"
				+ "0 - Esci\n";
		
//		System.out.println("Scheda di Studenti: " + o.schedaStudenti());
//		System.out.println("Scheda di Docenti: " + o.schedaDocenti());
//		System.out.println("Scheda di Studenti e Docenti: " + o.schedaStudenti() + o.schedaDocenti());
		
//		System.out.println("Lista degli studenti promossi e il numero degli studenti bocciati:\n" + o.listaPromossi());
		
//		System.out.println("numero degli studenti che possono andare in erasmus sono: " + o.nErasmus());
		
		String cmd;
		Scanner input = new Scanner(System.in);
		String res = "";
		System.out.println(menu + "commando: ");
		do
		{
			res = "";
			cmd = input.nextLine();
			switch(cmd.toUpperCase())
			{
				case "1":
					res = ("Scheda di Studenti: \n" + o.schedaStudenti());
					break;
				case "2":
					res = ("Scheda di Docenti: \n" + o.schedaDocenti());
					break;
				case "3":
					res = ("Scheda di Studenti e Docenti: \n" + o.schedaStudenti() + o.schedaDocenti());
					break;
				case "4":
					res = ("Lista degli studenti promossi e il numero degli studenti bocciati: \n" + o.listaPromossi());
					break;
				case "5":
					res = ("Numero degli studenti che possono andare in erasmus: \n" + o.nErasmus());
					break;
				case "6":
					res = ("Lista di insegnanti prossimi alla pensione(entro a 5 anni dalla pensione): \n" + o.pensionamento());
					break;
				case "7":
					res = ("Totale stipendio degli insegnanti di italiano: \n"
							+ o.totaleStipendiIta());
					break;
				case "8":
					res = "Media degli stipendi di tutti gli insegnanti: " + o.mediaStipendi();
					break;
				case "M":
					res = menu;
					break;
				case "0":
					res = "Arrivederci.!";
					break;
				default :
					res = "Command not found!";
			}
			System.out.println(res);
		} while (!cmd.equals("0"));
		
		input.close();
		System.out.println("END!");
	}

}
