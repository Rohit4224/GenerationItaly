package main;

import java.io.FileNotFoundException;

import entities.Ospedale;

public class Main {

	public static void main(String[] args) throws FileNotFoundException
	{
		Ospedale o = new Ospedale("src/res/Data.txt");
		
		//System.out.println(o.listaCompleto());
		
		System.out.println(o.personaGiovane());
		
		System.out.println(o.medicoGiovane());
		
		System.out.println(o.medicoPiuPagato());
		
		System.out.println(o.spesa("apprendicite"));
		
		System.out.println(o.spendeTotale());
		
		System.out.println(o.spesaTotaleConRimborso());
	}

}
