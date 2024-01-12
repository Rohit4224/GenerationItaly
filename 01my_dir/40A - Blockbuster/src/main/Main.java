package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.BlockbusterAggregator;

public class Main {

	public static void main(String[] args)
	{
		String path = "src/res/Data.tx";
		
		BlockbusterAggregator o = null;
		do {
			try
			{
				o = new BlockbusterAggregator(path);
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
		
		String menu = "1 - Scheda Film\n"
				+ "2 - Scheda SerieTV\n"
				+ "3 - Scheda per Tutti due\n"
				+ "4 - Durata media del Film\n"
				+ "5 - Film più caro\n"
				+ "6 - Schede dei film e serie tv non validi\n"
				+ "7 - Il nome del regista che ha fatto più film del file\n"
				+ "8 - Menu\n"
				+ "0 - Esci\n";
		
		String cmd;
		Scanner input = new Scanner(System.in);
		String res = "";
		System.out.println(menu + "commando: ");
		do
		{
			res = "";
			cmd = input.nextLine();
			switch(cmd)
			{
				case "1":
					res = ("Scheda Film: \n" + o.schedaFilm());
					break;
				case "2":
					res = ("Scheda SerieTV: \n" + o.schedaSerieTV());
					break;
				case "3":
					res = ("Scheda per Tutti due: \n" + o.schedaCompleta());
					break;
				case "4":
					res = ("Durata media del Film: \n" + o.durataMediaFilm());
					break;
				case "5":
					res = ("Film più caro: \n" + o.filmPiuCaro());
					break;
				case "6":
					res = ("Schede dei film e serie tv non validi: \n" + o.nonValidi());
					break;
				case "7":
					res = ("Il nome del regista che ha fatto più film del file: \n"
							+ o.registaFrequente());
					break;
				case "8":
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
	}//main
}//class
