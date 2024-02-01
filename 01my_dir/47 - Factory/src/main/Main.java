package main;

import entities.Entity;
import dao.DAOAllevatore;
import dao.DAOAnimale;
import entities.Allevatore;
import entities.Animale;

public class Main {

	public static void main(String[] args)
	{
//		DAOAnimale a = new DAOAnimale("fattoria");
		
//		System.out.println(a.list());
		
//		System.out.println(a.delete(6));
		
//		Entity e = a.find(4);
//		((Animale)e).setNome("Bubu");
//		System.out.println(a.update(e));
		
//		Entity e = new Animale(0, "Mucca", "Muh", "2019-09-03", "F", 256.40, false);
//		System.out.println(a.insert(e));
		
		// --------------------------------------------------------
		
		DAOAllevatore a = new DAOAllevatore("fattoria");
		
		System.out.println(a.list());
		
		
//		System.out.println(a.delete(2));
		
//		Entity e = a.find(1);
//		((Allevatore)e).setCognome("BIANCHI");
//		System.out.println(a.update(e));
		
//		Entity e = new Allevatore(0, "Giulio", "Cesare", "1978-03-17", 25, null);
//		System.out.println(a.insert(e));
//		
		
	}

}
