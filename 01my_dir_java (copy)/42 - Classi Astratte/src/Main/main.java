package Main;

import java.io.FileNotFoundException;

import entities.Scuola;

public class main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scuola s = new Scuola("src/res/Data.txt");
		
		//System.out.println(s.elenco());
		
		//System.out.println(s.elecoDipendentiPendolari());
		
		//System.out.println(s.personaPiuVecchia());
		
		//System.out.println(s.dipendenteStipendioMaggiore());
		
		//System.out.println(s.medioComplessivo());
		
		System.out.println(s.elencoConBonus());
	}
	
	

}
