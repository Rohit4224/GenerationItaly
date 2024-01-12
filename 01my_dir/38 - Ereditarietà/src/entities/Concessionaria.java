package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//Classe aggregatrice leggerà il file e risponderà alle domande richieste

public class Concessionaria {

	private ArrayList<Auto> automobili;
	private ArrayList<Moto> motocicli;


	public Concessionaria(String path) throws FileNotFoundException
	{
		automobili = new ArrayList<Auto>();
		motocicli = new ArrayList<Moto>();

		Scanner file = new Scanner(new File(path));

		while(file.hasNextLine()) 
		{
			String[] info = file.nextLine().split(",");

			switch(info[0].toLowerCase()) 
			{
			case"a":
				automobili.add(
						new Auto(
								info[1],
								info[2],
								info[3],
								Integer.parseInt(info[6]),
								Double.parseDouble(info[7]),
								info[4].equalsIgnoreCase("s"),
								info[5].equalsIgnoreCase("s")
								)
						);
				break;
			case"m":
				motocicli.add(
						new Moto(
								info[1],
								info[2],
								info[3],
								Integer.parseInt(info[4]),
								Double.parseDouble(info[5]),
								info[6].equalsIgnoreCase("s"),
								info[7].equalsIgnoreCase("s")
								)
						);
				break;
			default:
				System.out.println("Riga Errata nel file dati");
			}

		}


		file.close();
	}
	
	//Metodi
	
	public String elencoAuto() 
	{
		String ris = "";
		
		for(Auto a : automobili)
			ris += a.toString();
				
		return ris;
	}
	public String elencoMoto() 
	{
		String ris = "";
		
		for(Moto m : motocicli)
			ris += m.toString();
				
		return ris;
	}

	public String maggioreAutonomia()
	{
		String ris = "";
		double max = 0;
		
		for (Auto a : automobili)
			if(a.autonomia() > max)
			{
				max = a.autonomia();
				ris = a.toString();
			}
			else if (a.autonomia() == max)
				ris += a.toString();
		
		for (Moto m : motocicli)
			if(m.autonomia() > max)
			{
				max = m.autonomia();
				ris = m.toString();
			}
			else if (m.autonomia() == max)
				ris += m.toString();
		return ris;
		
	}

	public String raggiunge (double distanza, int passeggeri)
	{
		String ris = "";
		
		if (passeggeri > 5)
			return "Nessun veicolo disponibile";
		
		for (Auto a : automobili) {
			if (a.autonomia() >= distanza)
				ris += a.toString();
		}
			
		if (passeggeri <= 2)
			for (Moto m : motocicli)
				if (m.autonomia() >= distanza)
					ris += m.toString();
		return ris;
	}

	public String cerca(String marca)
	{
		String ris = "";
		for ( Auto a : automobili)
			if (a.getMarca().equalsIgnoreCase(marca))
				ris += a.toString();
		for (Moto m : motocicli) {
			if (m.getMarca().equalsIgnoreCase(marca))
				ris += m.toString();
		}		
		return ris;
	}
}//class
