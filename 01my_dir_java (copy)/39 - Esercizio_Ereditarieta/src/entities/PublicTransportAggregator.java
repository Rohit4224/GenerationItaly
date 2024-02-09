package entities;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class PublicTransportAggregator
{
	private ArrayList<Metro> metro;
	private ArrayList<Autobus> autobus;
	private ArrayList<Tram> tram;
	
	public PublicTransportAggregator(String path)
	{
		
		Scanner input = new Scanner(System.in);
		Scanner file = null;
		do
		{
			try
			{
				file = new Scanner (new File (path));
				metro = new ArrayList<Metro>();
				autobus = new ArrayList<>();
				tram = new ArrayList<>();
				break;
			}
			catch (FileNotFoundException e)
			{
				System.out.println("File not found on this path: " + path + "\nWrite the right path: ");
				path = input.nextLine();
			}
		} while (true);
		
		input.close();
		
		while (file.hasNextLine())
		{
			String info[] = file.nextLine().split(",");
			
			switch(info[0].toLowerCase())
			{
				case "tram":
					tram.add(new Tram(info[1]
									, Integer.parseInt(info[3])
									, Integer.parseInt(info[4])
									, Boolean.parseBoolean(info[6])
									, Integer.parseInt(info[2])
									, Boolean.parseBoolean(info[5])));
					break;
				case "metro":
					metro.add(new Metro(
									  info[1]
									, Integer.parseInt(info[2])
									, Integer.parseInt(info[3])
									, Integer.parseInt(info[4])
									, Boolean.parseBoolean(info[5])
									, Boolean.parseBoolean(info[6])
									));
					break;
				case "autobus":
					autobus.add(new Autobus(
							  info[1]
							, Integer.parseInt(info[2])
							, Integer.parseInt(info[3])
							, Boolean.parseBoolean(info[5])
							, Boolean.parseBoolean(info[4])));
					break;
				default:
					System.out.println("Riga Errata nel file dati");
			}
		}
		
	} // Constr
	
	//Metodi
	
	public String elencoTram()
	{
		String ris = "";
		
		for (Tram t : tram)
		{
			ris += t.toString();
		}
		
		return ris;
	}
	
	public String elencoAutobus()
	{
		String ris = "";
		
		for (Autobus t : autobus)
		{
			ris += t.toString();
		}
		
		return ris;
	}
	
	public String elencoMetro()
	{
		String ris = "";
		
		for (Metro t : metro)
		{
			ris += t.toString();
		}
		
		return ris;
	}
	
	public String elencoNotturni()
	{
		String ris = "";
		
		for (Metro t : metro)
		{
			if(t.isNightService())
				ris += t.toString();
		}
		
		for (Autobus t : autobus)
		{
			if(t.isNightService())
				ris += t.toString();
		}
		
		for (Tram t : tram)
		{
			if(t.isNightService())
				ris += t.toString();
		}
		
		return ris;
	}
	
	public String mezzoMigliore(int n)
	{
		String ris = "";
		
		for (Metro t : metro)
		{
			if(t.getSeats() >= n)
				ris += t.toString();
		}
		
		for (Autobus t : autobus)
		{
			if(t.getSeats() >= n)
				ris += t.toString();
		}
		
		for (Tram t : tram)
		{
			if(t.getSeats() >= n)
				ris += t.toString();
		}
		
		return ris;
	}
	
	public String minoreCapienza()
	{
		String ris = "";
		int min = Integer.MAX_VALUE;
		
		for (Metro t : metro)
		{
			if(t.getSeats() + t.getStandingPlaces() < min)
			{
				min = t.getSeats() + t.getStandingPlaces();
				ris = t.toString();
			}
			else if (t.getSeats() + t.getStandingPlaces() == min)
				ris += t.toString();
		}
		
		for (Autobus t : autobus)
		{
			if(t.getSeats() + t.getStandingPlaces() < min)
			{
				min = t.getSeats() + t.getStandingPlaces();
				ris = t.toString();
			}
			else if (t.getSeats() + t.getStandingPlaces() == min)
				ris += t.toString();
		}
		
		for (Tram t : tram)
		{
			if(t.getSeats() + t.getStandingPlaces() < min)
			{
				min = t.getSeats() + t.getStandingPlaces();
				ris = t.toString();
			}
			else if (t.getSeats() + t.getStandingPlaces() == min)
				ris += t.toString();
		}
		
		return ris;
	}
	
	public String lineaCercata(String linea)
	{
		String ris = "";
		
		for (Metro t : metro)
		{
			if(t.getLine().equalsIgnoreCase(linea))
				ris += t.toString();
		}
		
		for (Autobus t : autobus)
		{
			if(t.getLine().equalsIgnoreCase(linea))
				ris += t.toString();
		}
		
		for (Tram t : tram)
		{
			if(t.getLine().equalsIgnoreCase(linea))
				ris += t.toString();
		}
		
		return ris;
	}
	
}//Class
