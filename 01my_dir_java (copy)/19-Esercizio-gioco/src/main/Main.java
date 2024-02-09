package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
//		Scrivere un file coi dati delle figurine di un gioco.
//		Delle figurine sapete: nome del personaggio, attacco, difesa, vita, abilità(boolean), raro(boolean)
//		Scrivete minimo 5 personaggio.
//		Leggete il file e stampate in console:
//		La scheda di ogni personaggio
//		Il nome del/dei personaggi con difesa maggiore
//		La scheda del/dei personaggio/i con vita minore
//		Il numero di personaggi rari presenti
//		Il valore medio di attacco dei personaggi che hanno abilità come true
//		Il valore medio di vita dei personaggi rari con attacco superiore a 10
//		La scheda dei personaggi la cui difesa è superiore almeno del 5% rispetto al loro attacco
//
//	Usate una volta sola il comando System.out.println();

		//D
		Scanner file;
		String nomeDelPersonaggio;
		double attacco;
		double difesa;
		int vita;
		boolean abilita;
		boolean raro;
		
		String nomeConDifesaMaggiore;
		int difesaMaggiore;
		String nomeDifesaMaggiore;
		int numDiRari;
		
//		Il valore medio di attacco dei personaggi che hanno abilità come true
		Double medioAttacchiAbilita1;
		int attacchi;
		int personaggiAttacchi;
		
//		Il valore medio di vita dei personaggi rari con attacco superiore a 10
		Double medioVita;
		Double sumVita;
		Double personaggiRari;
		
//		La scheda dei personaggi la cui difesa è superiore almeno del 5% rispetto al loro attacco
		String schedaPersonaggi5Percento;
		double minimumDifesa;
		
		String risposta;
		String schedaConVitaMinore;
		int vitaMinore;

		
		//I
		file = new Scanner(new File("src/res/File.txt"));
		nomeConDifesaMaggiore = "";
		numDiRari = 0;
		medioAttacchiAbilita1 = 0.0;
		risposta = "La scheda di ogni personaggio: \n****************************** \n\n";
		difesaMaggiore = Integer.MIN_VALUE;
		nomeDifesaMaggiore = "";
		schedaConVitaMinore = "";
		vitaMinore = Integer.MAX_VALUE;
		attacchi = 0;
		personaggiAttacchi = 0;
		
		medioVita = 0.0;
		sumVita = 0.0;
		personaggiRari = 0.0;
		
		minimumDifesa = 0.0;
		
		schedaPersonaggi5Percento = "";
		
		//C
		while (file.hasNextLine())
		{
			nomeDelPersonaggio = file.nextLine();
			attacco = Double.parseDouble(file.nextLine());
			difesa = Double.parseDouble(file.nextLine());
			vita = Integer.parseInt(file.nextLine());
			abilita = Boolean.parseBoolean(file.nextLine());
			raro = file.nextLine().equalsIgnoreCase("true");
			
			risposta += "Nome del personaggio: " + nomeDelPersonaggio + "\n"
						+ "Attacco: " + attacco + "\n"
						+ "Difesa: " + difesa + "\n"
						+ "Vita: " + vita + "\n"
						+ "Abilità: " + abilita + "\n"
						+ "Raro: " + raro + "\n\n"
						+ "*******************************************\n\n";
			if (vitaMinore > vita)
			{
				vitaMinore = vita;
				schedaConVitaMinore = "Nome del personaggio: " + nomeDelPersonaggio + "\n"
									+ "Attacco: " + attacco + "\n"
									+ "Difesa: " + difesa + "\n"
									+ "Vita: " + vita + "\n"
									+ "Abilità: " + abilita + "\n"
									+ "Raro: " + raro + "\n\n"
									+ "*******************************************\n\n";
			}
			else if (vitaMinore == vita)
			{
				schedaConVitaMinore += "Nome del personaggio: " + nomeDelPersonaggio + "\n"
						+ "Attacco: " + attacco + "\n"
						+ "Difesa: " + difesa + "\n"
						+ "Vita: " + vita + "\n"
						+ "Abilità: " + abilita + "\n"
						+ "Raro: " + raro + "\n\n"
						+ "*******************************************\n\n";
			}
			if (difesa > difesaMaggiore)
			{
				difesaMaggiore = (int)difesa;
				nomeDifesaMaggiore = nomeDelPersonaggio;
			}
			else if (difesaMaggiore == difesa)
			{
				nomeDifesaMaggiore += ", " + nomeDelPersonaggio;
			}
			
			if (raro == true)
			{
				numDiRari++;
			}
//			Il valore medio di attacco dei personaggi che hanno abilità come true
			if (abilita == true)
			{
				attacchi += attacco;
				personaggiAttacchi++;
				medioAttacchiAbilita1 = (double)(attacchi/personaggiAttacchi); 
			}
//			Il valore medio di vita dei personaggi rari con attacco superiore a 10
			if (attacco > 10 && raro == true)
			{
				personaggiRari++;
				sumVita += vita;
				medioVita = sumVita / personaggiRari;
			}
//			La scheda dei personaggi la cui difesa è superiore almeno del 5% rispetto al loro attacco
			// Calculate the minimum defense required (5% more than attack)
			minimumDifesa = attacco * (1.05);
			if (difesa > minimumDifesa)
			{
				schedaPersonaggi5Percento += "Nome del personaggio: " + nomeDelPersonaggio + "\n"
											+ "Attacco: " + attacco + "\n"
											+ "Difesa: " + difesa + "\n"
											+ "Vita: " + vita + "\n"
											+ "Abilità: " + abilita + "\n"
											+ "Raro: " + raro + "\n\n"
											+ "*******************************************\n\n";
			}
		} // fine while
		
		file.close();
		risposta +=  "*******************************************\n\n"
				   + "Il nome dei/del personaggi/o con difesa maggiore sono/è " + nomeDifesaMaggiore
				   + "\n\n*******************************************\n\n"
				   + "*******************************************\n\n" 
				   + "La scheda del/dei personaggio/i con vita minore: \n\n" + schedaConVitaMinore
				   + "*******************************************\n\n"
				   + "Il numero di personaggi rari presenti: " + numDiRari
				   + "\n\n*******************************************\n\n"
				   + "*******************************************\n\n" 
				   + "Il valore medio di attacco dei personaggi che hanno abilità come true: " +  medioAttacchiAbilita1
				   + "\n\n*******************************************\n\n"
				   + "*******************************************\n\n"
				   + "Il valore medio di vita dei personaggi rari con attacco superiore a 10: " + medioVita
				   + "\n\n*******************************************\n\n"
				   + "*******************************************\n\n"
				   + "La scheda dei personaggi la cui difesa è superiore almeno del 5% rispetto al loro attacco: \n\n" + schedaPersonaggi5Percento;
		
		//O
		
		System.out.println(risposta);
	}

}
