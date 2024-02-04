package main;

import dao.*;
import entities.*;

public class Main
{
	public static void main(String[] args)
	{
		IDAOTabelle a = null;
		
//		a = new DAOAnimale("fattoria2");
		
//		System.out.println(a.list());
		
//		System.out.println(a.delete(3));
		
//		Entity e = a.find(1);
//		((Animale)e).setNome("Bubu");
//		System.out.println(a.update(e));
		
//		Entity e = new Animale(0,"Mucca","Muh","2019-09-03","F",256.40,false);
//		System.out.println(a.insert(e));
//		-------------------------------------------------------------------------------------
		a = new DAOAllevatore("fattoria2");
		
		System.out.println(a.list());
	

//		System.out.println(a.delete(2));
		
//		Entity e = a.find(1);
//		((Allevatore)e).setCognome("Bianchi");
//		System.out.println(a.update(e));
		
//		Entity e = new Allevatore(0,"Giulio","Cesare","1978-03-17",25,null);
//		System.out.println(a.insert(e));
	}
}