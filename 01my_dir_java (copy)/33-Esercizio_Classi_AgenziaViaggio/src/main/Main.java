package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
//		Creare un programma che gestisca un agenzia viaggi.
//		Formattare un file con le seguenti informazioni:
//		    destinazione,mezzo di trasporto,giorni di vacanza,costo giornaliero,numero persone.
//
//		Creare un programma che acquisite le informazioni dal file sia in grado di 
//		creare un vettore di oggetti di tipo Viaggio.
//		Scrivere il costruttore e i metodi
//		scheda()
//		prezzo() : REGOLE
//		          Calcolo del prezzo:
//		Prezzo base 100;
//		se la destinazione è Dubai o Tokyo aggiungo 200, se è Dublino o Londra aggiungo 150,
//		                    se è New York o Miami aggiungo 300. In tutti gli altri casi aggiungo 50
//		se il mezzo di trasporto è aereo o traghetto aggiungo 500, se è treno aggiungo 200,
//		                    e è automobile o autobus aggiungo 100. In tutti gli altri casi aggiungo 1000
//		se le persone sono più di 5 scontare il viaggio del 5%, se invece sono più di 10 scontare il
//		                    viaggio del 10%.
//
//		Stampare in console tramite un menù:
//		-Scheda di ogni viaggio disponibile nel file
//		-Lista destinazioni(senza ripetizioni)
//		-Lista mezzi di trasporto(senza ripetizioni)
//		-Costo medio dei viaggi in aereo
//		-Costo medio dei viaggi a Dubai
//		-Viaggi più economici(Viaggio/i che costano meno tra tutti quelli nel file)
//		-Viaggi di lusso(Viaggio/i che costano di più tra tutti quelli del file)
//		-Numero di viaggi per ogni destinazione presente nel file
//		-I viaggi che costano meno della media generale
//		-Permettete all'utente di cercare dei viaggi in base a una destinazione e a un mezzo a scelta
		
		Scanner file = new Scanner(new File("src/res/Data.txt"));
		int dim = Integer.parseInt(file.nextLine());
		Viaggio viaggi[] = new Viaggio[dim];
		
		int i = 0;
		while(file.hasNextLine())
		{
			String infoLine[] = file.nextLine().split(";");
			viaggi[i] = new Viaggio(infoLine[0], 
					infoLine[1], Integer.parseInt(infoLine[2]), Double.parseDouble(infoLine[3]), Integer.parseInt(infoLine[4]));
					
			i++;
		}
		
		file.close();
		
		String menu = "\tSeleziona: \n" +
				"1-Scheda di ogni viaggio disponibile\n"
				+ "2-Lista destinazioni(senza ripetizioni)\n"
				+ "3-Lista mezzi di trasporto(senza ripetizioni)\n"
				+ "4-Costo medio dei viaggi in aereo\n"
				+ "5-Costo medio dei viaggi a Dubai\n"
				+ "6-Viaggi più economici(Viaggio/i che costano meno tra tutti quelli nel file)\n"
				+ "7-Viaggi di lusso(Viaggio/i che costano di più tra tutti quelli del file)\n"
				+ "8-Numero di viaggi per ogni destinazione presente nel file\n"
				+ "9-I viaggi che costano meno della media generale\n"
				+ "10-cercare dei viaggi in base a una destinazione e a un mezzo a scelta\n"
				+ "M-Menu\n"
				+ "0-Esci";
		
		System.out.println(menu);
		
		String cmd;
		String result;
		Scanner input = new Scanner(System.in);
		do 
		{
			result = "";
			cmd = input.nextLine();
			switch (cmd.toUpperCase())
			{
				case "1":
					for (int j = 0; j < viaggi.length; j++) {
						result += (viaggi[j].scheda());
					}
					break;
				case "2":
					result = "\n";
					for (int j = 0; j < viaggi.length; j++) 
						if (!result.contains("\n" + viaggi[j].destinazione.toUpperCase() + "\n"))
							result += viaggi[j].destinazione.toUpperCase() + "\n";
					break;
				case "3":
					for (int j = 0; j < viaggi.length; j++) 
						if (!result.contains("\n" + viaggi[j].mezzoDiTrasporto.toUpperCase() + "\n"))
							result += viaggi[j].mezzoDiTrasporto.toUpperCase() + "\n";
					break;
				case "4":
					for (int j = 0; j < viaggi.length; j++)
					{
						int totalViaggiInAereo = 0;
						double totalPrezzoAereo = 0.0;
						if (viaggi[j].mezzoDiTrasporto.contains("aereo"))
						{
							totalViaggiInAereo++;
							totalPrezzoAereo += viaggi[j].prezzo();
							result = "" + totalPrezzoAereo / totalViaggiInAereo;
						}
					}
					break;
				case "5":
					for (int j = 0; j < viaggi.length; j++)
					{
						int totalViaggiInDubai = 0;
						double totalPrezzoDubai = 0.0;
						if (viaggi[j].mezzoDiTrasporto.contains("dubai"))
						{
							totalViaggiInDubai++;
							totalPrezzoDubai += viaggi[j].prezzo();
							result = "" + totalPrezzoDubai / totalViaggiInDubai;
						}
					}
					break;
				case "6":
					double minPrezzo = Integer.MAX_VALUE;
					
					for (int j = 0; j < viaggi.length; j++)
					{
						if (minPrezzo > viaggi[j].prezzo())
						{
							minPrezzo = viaggi[j].prezzo();
							result = viaggi[j].scheda();
						}
						
						else if (viaggi[j].prezzo() == minPrezzo)
						{
							result += viaggi[j].scheda();
						}
					}
					break;
				case "7":
					double maxPrezzo = Integer.MIN_VALUE;
					
					for (int j = 0; j < viaggi.length; j++)
					{
						if (maxPrezzo < viaggi[j].prezzo())
						{
							maxPrezzo = viaggi[j].prezzo();
							result = viaggi[j].scheda();
						}
						
						else if (viaggi[j].prezzo() == maxPrezzo)
						{
							result += viaggi[j].scheda();
						}
					}
					break;
				case "8":
					result = "\n";
					for (int j = 0; j < viaggi.length; j++) 
						if (!result.contains("\n" + viaggi[j].destinazione.toUpperCase() + "\n"))
							result += viaggi[j].destinazione.toUpperCase() + "\n";
					String singleDestination[] = result.split("\n");
					result = "";
					for (int j = 1; j < singleDestination.length; j++) {
						int numeroDiViaggi = 0;
						for (int k = 0; k < viaggi.length; k++)
						{
							if (singleDestination[j].equalsIgnoreCase(viaggi[k].destinazione))
								numeroDiViaggi++;
						}
						result += "\nNumero di viaggi per " + singleDestination[j] + " sono: " + numeroDiViaggi;
					}
					break;
				case "9":
//					"9-I viaggi che costano meno della media generale\n"
					double totPriceViaggio = 0;
					double media = 0.0;
					for (int j = 0; j < viaggi.length; j++) {
						totPriceViaggio += viaggi[j].prezzo();
					}
					media = totPriceViaggio/dim;
					for (int j = 0; j < viaggi.length; j++) {
						if(viaggi[j].prezzo() < media)
							result += viaggi[j].scheda();
					}
					result = "I viaggi che costano meno della media generale: \n" + result;
					break;
				case "10":
//					"10-cercare dei viaggi in base a una destinazione e a un mezzo a scelta\n"
					System.out.println("Scrivi la destinazione: ");
					String sceltaDestinazione = input.nextLine();
					System.out.println("Scrivi la mezzo di trasporto: ");
					String sceltaMezzo = input.nextLine();
					
					for (int j = 0; j < viaggi.length; j++) {
						if (sceltaDestinazione.equalsIgnoreCase(viaggi[j].destinazione)
								&& sceltaMezzo.equalsIgnoreCase(viaggi[j].mezzoDiTrasporto))
							result += viaggi[j].scheda();
					}
					break;
				case "M":
					result = menu;
					break;
				case "0":
					result = "Arrivederci !!";
					break;
			}
			System.out.println(result);
		} while (!cmd.equals("0"));
		
		input.close();
		
		System.out.println("END.");
	}//main
}//class MAin
