package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scuola implements IScuola
{
	private ArrayList<Entity> persone;
	
	//private ArrayList<Persona> pers;
	//private ArrayList<Studente> studente;
	//private ArrayList<Dipendente> dipendente;
	
	//Entity p = new Studente();  // then i have to create empty contructor for every super class because its empty parameter
	
	public Scuola(String path) throws FileNotFoundException
	{
		persone = new ArrayList<>();
		
		Scanner file = new Scanner(new File(path));
		
		Entity e;
		
		while (file.hasNextLine())
		{
			String [] info = file.nextLine().split(";");
			
			e = null;
			
			if (info[0].equalsIgnoreCase("s"))
			{
				e = new Studente (
							Integer.parseInt(info[1]),
							info[2],
							info[3],
							info[4],
							info[5],
							info[6],
							info[7],
							trasforma(info[8])
							);
			}
			
			else if(info[0].equalsIgnoreCase("d"))
			{
				e = new Dipendente(
						Integer.parseInt(info[1]),
						info[2],
						info[3],
						info[4],
						info[5],
						info[6],
						Double.parseDouble(info[7]),
						(info[8]),
						Integer.parseInt(info[9])
						);
			}
			
			if(e != null)
				persone.add(e);
		}
		file.close();
			
	}
	
	private double[] trasforma (String info)
	{
		String [] vettore = info.split("-");
		double [] ris = new double[vettore.length];
		
		for (int i = 0; i < vettore.length; i++)
		{
			ris[i] = Double.parseDouble(vettore[i]);
		}
		
		return ris;
	}
	
	public ArrayList<Entity> getPersone()
	{
		return persone;
	}
	
	public String elenco()
	{
		String res = "";
		
		for (Entity entity : persone)
		{
			res += entity.toString();
		}
		
		return res;
	}
	
	
	// Voglio vedere l'elenco dei dipendenti pendolari
	public String elecoDipendentiPendolari()
	{
		String res = "";
		
		for (Entity entity : persone)
		{
			if (entity instanceof Dipendente)
				if (((Dipendente)entity).pendolare())
					res += entity.toString();
		}
		
		return res;
	}
		
	
    // Voglio vedere la persona più vecchia tra tutti
	
	public String personaPiuVecchia()
	{
		String res = "";
		int max = 0;
		
		for (Entity entity : persone)
		{
			if (entity instanceof Dipendente)
			{
				Dipendente d = (Dipendente)entity;
				if (max < d.eta())
				{
					max = d.eta();
					res = d.getNome() + " " + d.getCognome();
				}
				else if (max == d.eta())
					res += "\n" + d.getNome() + " " + d.getCognome();
			}
			
			else if (entity instanceof Studente)
			{
				Studente s = (Studente)entity;
				if (max < s.eta())
				{
					max = s.eta();
					res = s.getNome() + " " + s.getCognome();
				}
				else if (max == s.eta())
					res += "\n" + s.getNome() + " " + s.getCognome();
			}
		}
		return res;
	}
	
    // Voglio vedere il dipendente con lo stipendio maggiore, bonus compresi
	
	public String dipendenteStipendioMaggiore()
	{
		String res = "";
		double sal = 0;
		double max = 0;
		
		for (Entity entity : persone)
		{
			if (entity instanceof Dipendente)
			{
				Dipendente d = (Dipendente)entity;
				sal = d.getStipendio() + d.bonus();
				if (max < sal)
				{
					max = sal;
					res = d.toString();
				}
				else if (max == sal)
				{
					res += d.toString();
				}
			}
		}
		return res;
	}
	
    // Voglio vedere il voto medio complessivo della scuola
	
	public Double medioComplessivo()
	{
		int count = 0;
		double medioTotale = 0;
		double res = 0;
		
		for (Entity entity : persone)
		{
			if (entity instanceof Studente)
			{
				count++;
				Studente s = (Studente)entity;
				medioTotale += s.media();
				res = medioTotale / count;
			}
		}
		
		return res;
	}
	
    // Voglio vedere per ogni persona il valore del bonus che prende
	
	public String elencoConBonus()
	{
		String res = "";
		
		for (Entity entity : persone)
		{
			if (entity instanceof Dipendente)
			{
				Dipendente d = (Dipendente)entity;
				res += d.getNome() + " " + d.getCognome() + "\nBONUS:" + d.bonus() + "\n\n";
			}
			
			else if (entity instanceof Studente)
			{
				Studente s = (Studente)entity;
				res += s.getNome() + " " + s.getCognome() + "\nBONUS:" + s.bonus() + "\n\n";
			}
		}
		return res;
	}
}
