package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		//leggo il file
		String percorso = "src/res/Data.txt";
		Scanner file = new Scanner(new File(percorso));
		
		Persona persone[] = new Persona[Integer.parseInt(file.nextLine())];
		
		int i = 0;
		while(file.hasNextLine())
		{
			String infoLine[] = file.nextLine().split(";");
//			Persona p = new Persona();
//			
//			p.name = infoLine[0];
//			p.surname = infoLine[1];
//			p.dob = infoLine[2];
//			p.personalTrainer = infoLine[3];
// 			p.objective = infoLine[4];
//			p.subscription = infoLine[5].equalsIgnoreCase("s");
//			
//			persone[i] = p;
			
			
			
//			persone[i] = new Persona(); //instantiation
//			
//			persone[i].name = infoLine[0];
//			persone[i].surname = infoLine[1];
//			persone[i].dob = infoLine[2];
//			persone[i].personalTrainer = infoLine[3];
// 			persone[i].objective = infoLine[4];
//			persone[i].subscription = infoLine[5].equalsIgnoreCase("s");
			
			
			
			
//			Persona p = new Persona(infoLine[0],
//								infoLine[1], infoLine[2], infoLine[3], infoLine[4], infoLine[5].equalsIgnoreCase("s"));
//			persone[i] = p;
			
			persone[i] = new Persona(infoLine[0],
					infoLine[1], infoLine[2], infoLine[3], infoLine[4], infoLine[5].equalsIgnoreCase("s"));
			
			i++;
		}
		
		file.close();
		for (int j = 0; j < persone.length; j++) {
			System.out.println(persone[j].scheda());			
		}

	}

}

