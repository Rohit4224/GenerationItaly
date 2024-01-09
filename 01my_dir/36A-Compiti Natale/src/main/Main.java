package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String path = "src/res/Data.txt";
		Human o = new Human(path);
		
		
		String menu = "1 - Lista Completa\n"
					+ "2 - Tutti coloro che non riescono a sbarcare\n"
					+ "3 - Tutti coloro che prendo lo stipendio più alto\n"
					+ "4 - Cerca per professione\n"
					+ "5 - Cambia tutte le residenze uguali a residenzaAbbandanata con il valore di nuovaResidenza\n"
					+ "6 - Piu' experienced\n"
					+ "7 - Menu\n"
					+ "0 - Esci"
					+ "\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n";
		
		System.out.println(menu);
		
		String res = "";
		Scanner input = new Scanner(System.in);
		String cmd = "";
		do
		{
			res = "";
			System.out.println("Commando: ");
			cmd = input.nextLine();
			
			switch (cmd)
			{
			case "1":
				res = o.listaCompleta();
				break;
			case "2":
				res = o.poveracci();
				break;
			case "3":
				res = o.nababbo();
				break;
			case "4":
				System.out.println("Scrivi la professione che vuoi cercare : ");
				String choosenProfession = input.nextLine();
				res = o.cercaPer(choosenProfession);
				break;
			case "5":
				System.out.println("Scrivi la residenza lasciata : ");
				String lasciataResidenza = input.nextLine();
				for (int i = 0; i < o.persone.length; i++)
				{
					if (o.persone[i].residence.equalsIgnoreCase(lasciataResidenza))
						res = "Trovato";
				}
				if (res.equalsIgnoreCase("trovato"))
				{
					System.out.println("Scrivi la residenza nuova : ");
					String nuovaResidenza = input.nextLine();
					res = o.sostituisci(lasciataResidenza, nuovaResidenza);					
				}
				else
					res = "La residenza non trovata.";
				break;
			case "6":
				int max = Integer.MIN_VALUE;
				for (int i = 0; i < o.persone.length; i++) {
					if (o.persone[i].age() > max)
					{
						max = o.persone[i].age();
						res = o.persone[i].info();
					}
					else if (o.persone[i].age() == max)
					{
						res += o.persone[i].info();
					}
				}
				break;
			case "7":
				res = menu;
				break;
			case "0":
				res = "Arrivederci.!";
				break;
			default:
				res = "Commando non trovato";
				break;
			}
			
			System.out.println(res);
		} while (!cmd.equals("0"));
		input.close();
		System.out.println("END");
	}//main
}//classe di avvio
