package main;

import java.io.FileNotFoundException;

import entities.Menu;
import entities.Piatto;

public class Main {

	public static void main(String[] args)
	{
		String path = "src/res/ListaPiatti.txt";
		Menu o = null;
		try {
			o = new Menu(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("PATH ERROR");
			e.printStackTrace();
		}
		
		
		for (Piatto piatto : o.getPiatti()) {
			System.out.println(piatto); //it implicitly call toString()
		}
		
		System.out.println(o.listaPiatti("acido"));
		
		System.out.println(o.piattiConIngrediente("zucchero"));
		
		String[] targetIngredients = {"zucchero", "olio"};
		System.out.println(o.piattiConIngredienti(targetIngredients));
		
		System.out.println("\nl'oggetto Piatto più costoso: " + o.piuCostoso());
		
		System.out.println("\nil costo medio di tutti i piatti: " + o.costoMedioMenu());
		
		System.out.println("\ni piatti con valido()== false: " + o.piattiNonValidi());
		
		System.out.println("\nla moda del TIPO: \n" + o.tipoRicorrente());
		
		System.out.println("\nla moda dell'ingrediente: \n" + o.ingredienteRicorrente());
		
		System.out.println("\nse la moda del tipo è più di una, restituirle tutte sottoforma di arraylist: \n"
								+ o.tipiRiccorenti());
		
		System.out.println("\nse la moda del ingrediente è più di una, restituirle tutte sottoforma di arraylist: \n"
				+ o.ingredientiRicorrenti());
		

	}//main
}//class
