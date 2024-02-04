package main;

import factory.Factory;
import factory.IFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.*;
import entities.*;

public class Main {

	public static void main(String[] args)
	{
		// leggere tutti i corsi disponibili
		//IDAO c = DAOCorso.getInstance("GestionaleFormazione");
		//System.out.println(c.read());
		
		//inserire nuovi corsi
/*
		IDAO c = DAOCorso.getInstance("GestionaleFormazione");
		Entity e = new Corso(0, "Corso di lingua", 30, 15, "Italiano", false);
		System.out.println(c.create(e));
		*/
		
		//modificare un corso
		/*
		 * 
		DAOCorso c = DAOCorso.getInstance("GestionaleFormazione");
		Entity e = c.find(1);
		((Corso)e).setLingua("ChangedToRusso");
		System.out.println(c.update(e));
		*/
		
		//cancellare un corso
		/*
		 DAOCorso c = DAOCorso.getInstance("GestionaleFormazione");
		System.out.println(c.delete(6));
		 */
		
		//leggere tutti gli utenti disponibili
		/*
		 DAOUtente u = DAOUtente.getInstance("GestionaleFormazione");
		 System.out.println(u.read());
		 * */
		
		//modificare un utente
		/*
		DAOUtente u = DAOUtente.getInstance("GestionaleFormazione");
		Entity e = u.find(1);
		((Utente)e).setNome("ChangedToSome");
		System.out.println(u.update(e));
*/
		
		// inserire un nuovo utente
		//id, nome, cognome, dob, azienda(mi basta il nome), mansione, corsoFrequentato
		/*
		DAOUtente u = DAOUtente.getInstance("GestionaleFormazione");
		Entity e = new Utente(0, "Rohit", "Khinchi", "1997-02-24", "GenIta", "Programmazione", 1);
		System.out.println(u.create(e));
		*/
		
		//cancellare un utente
		/*
		 IDAO c = DAOUtente.getInstance("GestionaleFormazione");
		System.out.println(c.delete(6));
		 */
		
		//il numero di utenti per ogni corso disponibile
		
		//il corso che dura di più
		
		/*
		IDAO c = DAOCorso.getInstance("GestionaleFormazione");
		List<Entity> list = c.read();
		int maxDurata = 0;
		String res = "";
		for (Entity e : list)
		{
			if (e instanceof Corso && maxDurata < ((Corso)e).getTotale_ore())
			{
				maxDurata = ((Corso)e).getTotale_ore();
				res = ((Corso)e).getNome();
			}
		}
		System.out.println("Il corso che dura di più è " +  res + ", " + maxDurata + "ore."); 
		*/
	
		
		//dato il nome di un corso, voglio vedere i nominativi di chi lo segue
		/*
		String nomeCorso = "Data Science with Python";
		IDAO u = DAOUtente.getInstance("GestionaleFormazione");
		List<Entity> list = u.read();
		String res = "";
		for (Entity e : list)
		{
			if (nomeCorso.equalsIgnoreCase(((Utente)e).getCorso().getNome()))
					res = ((Utente)e).getNome() + " " + ((Utente)e).getCognome();
		}
		System.out.println(res);
		*/
		
		//le lingue disponibili per i vari corsi
		/*
		IDAO c = DAOCorso.getInstance("GestionaleFormazione");
		List<Entity> list = c.read();
		String res = "";
		for (Entity e : list)
		{
			if (e instanceof Corso)
			{
				if (!res.contains(((Corso)e).getLingua()))
						res += ((Corso)e).getLingua() + "\n";
			}
		}
		System.out.println(res);
		*/
	}

}
