package main;

import dao.DAOPersona;
import entities.*;

public class Main {

	public static void main(String[] args)
	{
//		System.out.println("\tELENCO\n\n" + DAOPersona.getInstance().read());
		
//		System.out.println("\tELENCO\n\n" + DAOPersona.getInstance().find(1));
		
//		Entity e = DAOPersona.getInstance().find(1);
//		((Persona)e).setCognome("CICCIO");
//		System.out.println("\tUPDATE\n\n" + DAOPersona.getInstance().update(e));
		
//		Entity e = new Persona(0, "Giulio", "Cesare", "1945-09-04", "Roma", "M", "Imperatore");
		Entity e = new Persona(0, "Lorenzo", "Corri", "1996-05-01", "Napoli", "Masculine", "Medico");
		System.out.println("\n\tINSERT: " + DAOPersona.getInstance().create(e));
	
//		System.out.println("\n\tDELETE: " +	DAOPersona.getInstance().delete(4));

	}//fine metodo main

}// fine classe modello
