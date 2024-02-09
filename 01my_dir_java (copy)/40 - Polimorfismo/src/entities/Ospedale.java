package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ospedale
{
	private ArrayList<Persona> persone;
	
	public Ospedale(String path) throws FileNotFoundException
	{
		persone = new ArrayList<Persona>();
		
		Scanner file = new Scanner (new File(path));
		
		Persona p;
		
		while (file.hasNextLine())
		{
			p = null;
			
			String[] info = file.nextLine().split(",");
			
			switch (info[0].toLowerCase())
			{
				case "pe":
					p = new Persona(
									  info[1]
									, info[2]
									, info[3]
									, info[4]);
					break;
				case "me":
					p = new Medico(
									  info[1]
									, info[2]
									, info[3]
									, info[4]
									, info[5]
									, info[6]
									, Double.parseDouble(info[7]));
					break;
				case "pa":
					p = new Paziente(
									  info[1]
									, info[2]
									, info[3]
									, info[4]
									, info[5]
									, info[6].equalsIgnoreCase("s")
									, Integer.parseInt(info[7]));
					break;
				default :
					System.out.println("Riga errata nel file");
			}//fineSwitch
			
			if (p != null)
				persone.add(p);
		}//fine WHile
		file.close();
	}//fine Costruttore
	
	
	// voglio un metodo che stampi la lista completa di tutte del persone del file
	public String listaCompleto()
	{
		String ris = "";
		
		for (Persona p : persone)
			ris += p.toString();
		
		return ris;
	}
	
	//voglgio vedere il nominativo della PERSONA piu giovane
	
	public String personaGiovane()
	{
		String ris = "";
		int min = 200;
		
		for (Persona p : persone)
		{
			if(p.eta() < min)
			{
				min = p.eta();
				ris = p.getNome() + " " + p.getCognome();
 			}
			else if (p.eta() < min)
				ris += "\n" + p.getNome() + " " + p.getCognome();
		}
		
		return ris;
	}
	
	//voglgio vedere il nominativo della MEDICO piu giovane
	
	public String medicoGiovane()
	{
		String res = "";
		int min = 145;
		
		for (Persona p : persone)
		{
			if (p instanceof Medico) // "instanceof" controlla se il tipo concreto dell'oggetto p è uguale al tipo medico
			{
				if(p.eta() < min)
				{
					min = p.eta();
					res = p.getNome() + " " + p.getCognome();
	 			}
				else if (p.eta() < min)
					res += "\n" + p.getNome() + " " + p.getCognome();
			}
			
		}
		
		return res;
		
	}
	
	//voglio vedere il medico con lo stipendio maggiore
	
	public String medicoPiuPagato()
	{
		String res = "";
		double max = 0;
		
		for (Persona p : persone)
		{
			if (p instanceof Medico) // "instanceof" controlla se il tipo concreto dell'oggetto p è uguale al tipo medico
			{
				//Medico m = (Medico)p; //typecasting
				//m.getStipendio(); 
				if(((Medico)p).getStipendio() > max)
				{
					max = ((Medico)p).getStipendio();
					res = p.toString();
				}
				else if (((Medico)p).getStipendio() == max)
					res += p.toString();
			}
			
		}
		
		return res;
	}
	
	//voglio vedere la spesa sostenuta dall'ospedale per tutti i pazienti con una malattia passata
	public double spesa(String malattia)
	{
		double ris = 0;
		
		for (Persona p : persone)
		{
			if (p instanceof Paziente)
			{
				Paziente pa = (Paziente)p;
				if (pa.getMalattia().equalsIgnoreCase(malattia))
					ris += pa.spesaPaziente();
			}
		}
		
		return ris;
	}
	
	//voglio sapere quanto spende in totale l'ospedale immaginando di tratare tutti i
	//pazienti del file e di pagare lo stipendio mensile di tutti i medici del file
	
	public double spendeTotale()
	{
		double ris = 0;
		
		for(Persona p : persone)
		{
			if (p instanceof Paziente)
			{
				
				ris += ((Paziente)p).spesaPaziente();
			}
			else if (p instanceof Medico)
			{
				ris += ((Medico)p).getStipendio();
			}
		}
		return ris;
	}
	
	//Fare lo stesso conto di prima, ma per ogni medico fuori sede,
	// aggiungere alla spesa calcolata un rimborso spese per il medico pari al 25% del suo stipendio
	
	public double spesaTotaleConRimborso()
	{
		double ris = 0;
		
		for (Persona p : persone)
		{
			if (p instanceof Paziente)
				ris += ((Paziente)p).spesaPaziente();
			if (p instanceof Medico && ((Medico)p).fuoriSede())
				ris += 25 * ((Medico)p).getStipendio() / 100;
			if (p instanceof Medico)
				ris+= ((Medico)p).getStipendio();
		}
		
		return ris;
	}
	
	
}//fine classe
