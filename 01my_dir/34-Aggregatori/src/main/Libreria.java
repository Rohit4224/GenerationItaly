package main;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

//Classe di aggregazione: Qui Ã¨ dove solitamente si riuniscono tutti gli oggetti del programma per fini di sicurezza, quindi si spostano i calcoli dal Main a qui
//Convenzionalmente si usano nomi di aggregatori nella vita reale per chiamare la classe
public class Libreria {

	Libro[] libri;
	
	Libreria(String path) throws FileNotFoundException
	{
		int dim = 0;
		Scanner file = new Scanner(new File(path));
		
		while(file.hasNextLine())
		{
			file.nextLine();
			dim++;
		}
		
		libri = new Libro[dim];
		file.close();
		file = new Scanner(new File(path));
		for(int i = 0; file.hasNextLine(); i++)
		{
			String[] infoRiga = file.nextLine().split(";");
			
			libri[i] = new Libro(
								 infoRiga[0], 
								 infoRiga[1], 
								 infoRiga[2], 
								 infoRiga[3], 
								 Integer.parseInt(infoRiga[4]), 
								 Integer.parseInt(infoRiga[5]), 
								 infoRiga[6].equalsIgnoreCase("S"));
		}
		file.close();
		
	}
	
	String listaSchede()
	{
		String ris = "";
		
		for(int i = 0; i < libri.length; i++)
			ris += libri[i].scheda();
		return ris;
	}
	
	String libroPiuCaro()
	{
		String ris = "";
		double max = 0;
		for(int i = 0; i < libri.length; i++)
		{
			if(libri[i].prezzo() > max)
			{
				max = libri[i].prezzo();
				ris = libri[i].scheda();
			}
			else if(libri[i].prezzo() == max)
				ris += libri[i].scheda();
		}
		
		return ris;
	}
	
	String libroPiuPagine()
	{
		String ris = "";
		double max = 0;
		for(int i = 0; i < libri.length; i++)
		{
			if(libri[i].numeroPagine > max)
			{
				max = libri[i].numeroPagine;
				ris = libri[i].scheda();
			}
			else if(libri[i].numeroPagine  == max)
				ris += libri[i].scheda();
		}
		
		return ris;
	}
	
	String cercaAutore(String sceltaAutore)
	{
		String ris = "";
		for (int i = 0; i < libri.length; i++)
		{
			if (libri[i].autore.equalsIgnoreCase(sceltaAutore))
				ris += libri[i].scheda();
		}
		
		return (ris);
	}

}