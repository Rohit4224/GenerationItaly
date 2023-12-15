package main;

import java.io.File; //ricordare
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		//D
		Scanner file;
		String tipoAlcolico;
		String nomeAlcolico;
		double gradazioneAlcol;
		double minoreGradazione;
		String risposta;
//		String percorsoGlobale; //absolute path , inizia di solito con disco rigido (/home/rohit/.. ) o (C:\Users\..)
		String percorsoLocale; // relative path , inizia di solito con src (src/..)
		String nomeAlcolicoMinore;
		
		//I
		risposta = "";
		minoreGradazione = Integer.MAX_VALUE;
		percorsoLocale = "src/res/File.txt";
//		percorsoGlobale = "/home/rohit/Desktop/Corsi_Generation/JAITA_112/01my_dir/18-LetturaDaFile/src/res/File.txt";
		file = new Scanner(new File(percorsoLocale));
		nomeAlcolicoMinore = "";
		
		//C
		while (file.hasNextLine())
		{
			//tipo-nome-gradazione
			tipoAlcolico = file.nextLine();
			nomeAlcolico = file.nextLine();
			gradazioneAlcol = Double.parseDouble(file.nextLine());
			
			risposta += "\nTipo: " + tipoAlcolico + 
						"\nNome: " + nomeAlcolico +
						"\nGradazione: " + gradazioneAlcol +
						"\n------------------------------------\n";
			if (gradazioneAlcol < minoreGradazione)
			{
				minoreGradazione = gradazioneAlcol;
				nomeAlcolicoMinore = nomeAlcolico;
			}
			else if (gradazioneAlcol == minoreGradazione)
					nomeAlcolicoMinore += ", " + nomeAlcolico;
		} // fine While
		
		file.close();
		
		//o
		System.out.println("\tELENCO ALCOLICI: \n" + risposta + 
							"\nL'alcolico con gradazione minore è " + nomeAlcolicoMinore +
							" con " + minoreGradazione + "%");
	}

}
