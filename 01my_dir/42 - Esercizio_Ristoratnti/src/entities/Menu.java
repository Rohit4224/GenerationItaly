package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Menu
{
	ArrayList <Piatto> piatti;
	
	public Menu(String path) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File (path));
		piatti = new ArrayList<Piatto>();
		
		while (file.hasNextLine())
		{
			 Piatto p = null;
			 
			 String info[] = file.nextLine().split(",");
			 
			 p = new Piatto(info[0], info[1], Double.parseDouble(info[2]), 
					 info[3].split("-"));
			 
			 if (p != null)
				 piatti.add(p);
		}//while
	}//Constructor
	
//	public ArrayList<Piatto> getPiatti()-> Ritornare tutta la lista dei piatti
	
	public ArrayList<Piatto> getPiatti()
	{
		ArrayList<Piatto> p = new ArrayList<Piatto>(); 
		
		for (Piatto piatto : piatti) {
			p.add(piatto);
		}
		return p;
	}
	
//	> public ArrayList<Piatto> listaPiatti(String tipo)-> 
//			Ritornare tutti i piatti del tipo indicato
	
	public ArrayList<Piatto> listaPiatti(String tipo)
	{
		ArrayList<Piatto> p = new ArrayList<>();
		
		for (Piatto piatto : piatti)
		{
			if (piatto.getTipo().equalsIgnoreCase(tipo))
				p.add(piatto);
		}
		
		return p;
	}
	
//	> public ArrayList<Piatto> piattiConIngrediente(String ingrediente)
//	-> Ritornare tutti i piatti che hanno l'ingrediente specificato
	
	public ArrayList<Piatto> piattiConIngrediente(String ingrediente)
	{
		ArrayList<Piatto> p = new ArrayList<>();
		
		for (Piatto piatto : piatti)
		{
			if (piatto.contieneIngrediente(ingrediente))
				p.add(piatto);
		}
		return p;
	}
	
//	> public ArrayList<Piatto> piattiConIngredienti(String[] ingredienti)
//	-> Ritornare tutti i piatti che hanno gli ingredienti specificati
	
	public ArrayList<Piatto> piattiConIngredienti(String[] ingredienti)
	{
		ArrayList<Piatto> p = new ArrayList<>();
		
		for (Piatto piatto : piatti)
		{
			if (piatto.contieneIngredienti(ingredienti))
				p.add(piatto);
		}
		return p;
	}
	
//	> public Piatto piuCostoso()
//	-> Restituire l'oggetto Piatto più costoso
	
	public Piatto piuCostoso()
	{
		Piatto p = null;
		double maxPrice = 0;
		
		for (Piatto piatto : piatti)
		{
			if (piatto.getPrezzo() > maxPrice)
			{
				maxPrice = piatto.getPrezzo();
				p = piatto;
			}
		}
		return p;
	}
	
//	> public double costoMedioMenu()
//	-> Restituire il costo medio di tutti i piatti
	
	public double costoMedioMenu()
	{
		double costoMedio = 0;
		double sum = 0;
		int count = 0;
		
		for (Piatto piatto : piatti) {
			sum += piatto.getPrezzo();
			costoMedio = sum / ++count;
		}
		return (costoMedio);
	}
	
//	> public ArrayList<Piatto> piattiNonValidi()
//	-> Ritorna un AL contenente tutti i piatti con valido() == false
	
	public ArrayList<Piatto> piattiNonValidi()
	{
		ArrayList<Piatto> p = new ArrayList<>();
		
		for (Piatto piatto : piatti) {
			if (!piatto.valido())
				p.add(piatto);
		}
		
		return p;
	}
	
	
//	> public String tipoRicorrente()
//	-> Trovare la moda del TIPO
	
	public String tipoRicorrente()
	{
		int max = 0;
		String tipo = "";
		int count = 0;
		
		for (Piatto piatto : piatti)
		{
			count = 0;
			for (Piatto piatto2 : piatti)
			{
				if (piatto.getTipo().equalsIgnoreCase(piatto2.getTipo()))
					count++;
			}
			if (max < count)
			{
				max = count;
				tipo = piatto.getTipo();
			}
		}
		return tipo + " occured " + max + " times.";
	}
	
	
//	> public String ingredienteRicorrente()
//	-> Trovare la moda dell'ingrediente
	
	public String ingredienteRicorrente()
	{
		int max = 0;
		String ingrediente = "";
		int count = 0;
		
		String[] ingredienti_validi = {"farina", "glutine", "zucchero",
                "sale", "glutammato", "olio"};
		
		for (int i = 0; i < ingredienti_validi.length; i++)
		{
			count = 0;
			for (Piatto piatto : piatti)
			{
				List<String> ingred = Arrays.asList(piatto.getIngredienti());
				if (ingred.contains(ingredienti_validi[i]))
					count++;
				
			}
			if (max < count)
			{
				max = count;
				ingrediente = ingredienti_validi[i];
			}	
		}
		return ingrediente + " occured " + max + " times.";
	}
	
	
//	> public ArrayList<String> tipiRiccorenti()
//	-> Se la moda è più di una, restituirle tutte sottoforma di arraylist
	
	public ArrayList<String> tipiRiccorenti()
	{
		int max = 0;
		String tipo = "";
		int count = 0;
		ArrayList<String> res = new ArrayList<String>();
		
		for (Piatto piatto : piatti)
		{
			count = 0;
			for (Piatto piatto2 : piatti)
			{
				if (piatto.getTipo().equalsIgnoreCase(piatto2.getTipo()))
					count++;
			}
			if (max < count)
			{
				max = count;
				tipo = piatto.getTipo();
			}
		}
		
		for (Piatto piatto : piatti)
		{
			if (piatto.getTipo().equalsIgnoreCase(tipo))
				res.add(piatto.toString());
		}
		
		return res;
		
	}
	
//	> public ArrayList<String> ingredientiRicorrenti()
//	-> Stessa cosa del metodo precedente ma per gli ingredienti
	
	public ArrayList<String> ingredientiRicorrenti()
	{
		int max = 0;
		String ingrediente = "";
		int count = 0;
		ArrayList<String> res = new ArrayList<String>();
		
		String[] ingredienti_validi = {"farina", "glutine", "zucchero",
                "sale", "glutammato", "olio"};
		
		for (int i = 0; i < ingredienti_validi.length; i++)
		{
			count = 0;
			for (Piatto piatto : piatti)
			{
				List<String> ingred = Arrays.asList(piatto.getIngredienti());
				if (ingred.contains(ingredienti_validi[i]))
					count++;
				
			}
			if (max < count)
			{
				max = count;
				ingrediente = ingredienti_validi[i];
			}	
		}
		
		for (Piatto piatto : piatti)
		{
			if (piatto.contieneIngrediente(ingrediente))
				res.add(piatto.toString());
		}
		
		return res;
	}
	
	
	//BONUS
//	> public ArrayList<Piatto> menuOrdinatoPerPrezzo()
//	-> Restituire un AL ordinato in modo crescente per prezzo
	
//	public ArrayList<Piatto> menuOrdinatoPerPrezzo()
//	{
//		ArrayList<Piatto> copy = new ArrayList<Piatto>(piatti);
//		copy = piatti;
//		
//		Collections.sort(copy);
//	}
	
	
}//class
