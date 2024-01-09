package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Human
{
	Persona persone[];
	Scanner file;
	
	Human (String path) 
	{
		while(true)
		{
			try
			{
				file = new Scanner(new File(path));
				break;
			}
			catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Path not found\nWrite the correct path: ");
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				path = input.nextLine();
							
			}
		}
		int dim = Integer.parseInt(file.nextLine());
		this.persone = new Persona[dim];
			
		int i = 0;
		while (file.hasNextLine())
		{
			String infoLine[] = file.nextLine().split(", ");
			this.persone[i] = new Persona(infoLine[0], 
									infoLine[1],
									infoLine[2],
									infoLine[3],
									infoLine[4],
									Integer.parseInt(infoLine[5]),
									Double.parseDouble(infoLine[6]));
					
			i++;
		}
		file.close();
	}
	
	String listaCompleta()
	{
		String res = "";
		
		for (int i = 0; i < this.persone.length; i++)
		{
			res += this.persone[i].info();
		}
		
		return (res);
	}
	
	String poveracci()
	{
		String res = "";
		
		for (Persona persona : this.persone) {
			if (!persona.sbarcare())
				res += persona.info();
		}
		if (res.isEmpty())
			res = "Poveraccio not found";
		return (res);
	}
	
	String nababbo()
	{
		String res = "";
		double max = Integer.MIN_VALUE;
		
		for (Persona persona : this.persone) {
			if (persona.salary > max)
			{
				res = persona.info();
				max = persona.salary;
			}				
			else if (persona.salary == max)
				res += persona.info();
		}
		res = "Persona piu' ricca : \n" + res;
		return (res);
	}
	
	String cercaPer(String profession)
	{
		String res = "";
		
		for (Persona persona : this.persone) {
			if (persona.profession.equalsIgnoreCase(profession))
				res += persona.info();
		}
		if (res.isEmpty())
			res = "Non trovato.!";
		return (res);
	}
	
	String sostituisci(String residenzaAbbandonata, String nuovaResidenza)
	{
		String res = "";
		
		for (Persona persona : this.persone) {
			if (persona.residence.equalsIgnoreCase(residenzaAbbandonata))
				persona.residence = Character.toString(nuovaResidenza.charAt(0)).toUpperCase()
									+ nuovaResidenza.substring(1).toLowerCase();
		}
		
		res = "La residenza e' cambiata da " + residenzaAbbandonata.toUpperCase() +
				" a nuova residenza " + nuovaResidenza.toUpperCase() + ". Premi 1 per vedere la scheda.";
		return (res);
	}
}
