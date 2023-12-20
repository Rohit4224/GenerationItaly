package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("src/res/Dati.txt"));
		String[] citta;
		
		// Modo valido se c'� UN SOLO vettore da popolare. 
		// Se i vettori sono 2 o pi� bisogna per forza usare la variabile di appoggio dimensione
		citta = new String[Integer.parseInt(file.nextLine())];
		
		int posizione = 0;
		
		while(file.hasNextLine())
		{
			citta[posizione] = file.nextLine();
			posizione++;
		}
		
		file.close();
		
		// STEP 1: Devo riuscire ad avere un campione di valori senza doppioni
		String elencoSenzaRipetizioni = "";
		
		for(int i = 0; i < citta.length; i++)
			if(!elencoSenzaRipetizioni.toLowerCase().contains(citta[i].toLowerCase() + ";"))
				elencoSenzaRipetizioni += citta[i] + ";";
		
		elencoSenzaRipetizioni = elencoSenzaRipetizioni.substring(0,elencoSenzaRipetizioni.length()-1);
		
		System.out.println(elencoSenzaRipetizioni);
		
		// STEP 2: Devo spezzare la stringa per ottenere le singole citt� senza ripetizioni
		String[] cittaSingole = elencoSenzaRipetizioni.split(";");
		
		// STEP 3: Conto quante volte una solo citt� si presenta nell'elenco completo di doppioni
		String ris = "";
		for (int i = 0; i < cittaSingole.length; i++)
		{
			int conta = 0;
			for (int j = 0; j < citta.length; j++)
			{
				if (cittaSingole[i].equalsIgnoreCase(citta[j]))
					conta++;
			}//fine ciclo j
			ris += "\nCitta': " + cittaSingole[i].toUpperCase() + " si presenta " + conta;
		}//fine ciclo i
		
		System.out.println(ris);
		
	}
}