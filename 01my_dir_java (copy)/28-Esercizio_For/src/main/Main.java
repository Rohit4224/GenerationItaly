package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		// Scrivere in un file i nomi e i voti complessivi di una serie di studenti.
        // Il file scrivetelo come CSV(nome,voto)
        // Leggere il file e salvare i dati nei vettori giusti.
        // Voglio poi vedere:
        // - La lista di tutti gli studenti coi loro voti
        // - Il nome dello studenti( o degli studenti) con il voto maggiore
        // - I nomi degli studenti con un voto superiore alla media complessiva dei voti nel file
		
		//D
		Scanner file;
		String percorso;
		String name[];
		int vote[];
		int dimension;
		String risposta;
		
		//I
		
		percorso = "src/res/File.txt";
		file = new Scanner(new File(percorso));
		File seVuotoFile = new File(percorso);
		if (seVuotoFile.length() == 0)
		{
			risposta = "FILE IS EMPTY";
		}
		else
		{
			dimension = Integer.parseInt(file.nextLine());
			name = new String[dimension];
			vote = new int[dimension];
			risposta = "";
			//C
			int TotVoti = 0;
			for(int i = 0;file.hasNextLine();i++)
			{
				String infoRiga[] = file.nextLine().split(";");
				
				name[i] = infoRiga[0];
				vote[i] = Integer.parseInt(infoRiga[1]);
				TotVoti += vote[i];
			}
			
			
			
			risposta += "\tLa lista di tutti gli studenti coi loro voti: \n";
			
			int maxVote = Integer.MIN_VALUE;
			String maxNameVote = "";
			double mediaVoti = TotVoti/dimension;
			String studentiVotoSuperioreAllaMedia = "La media e': " + mediaVoti + "\n";
			for(int i = 0; i < name.length; i++)
			{
				risposta += "Name: " + name[i] +  " ; " + "Vote: " + vote[i] + "\n";
				
				if(vote[i] > maxVote)
				{
					maxVote = vote[i];
					maxNameVote = "Name: " + name[i] +  " ; " + "Vote: " + vote[i] + "\n";
				}
				else if (vote[i] == maxVote)
				{
					maxNameVote += "Name: " + name[i] +  " ; " + "Vote: " + vote[i] + "\n";
				}
				if (vote[i] > mediaVoti)
				{
					studentiVotoSuperioreAllaMedia += "Name: " + name[i] +  " ; " + "Vote: " + vote[i] + "\n";
				}
			}
			
			risposta += "\n\tIl nome dello studenti( o degli studenti) con il voto maggiore: \n";
			risposta += maxNameVote;
			
			
			risposta += "\n\tI nomi degli studenti con un voto superiore alla media complessiva dei voti nel file: \n";
			risposta += studentiVotoSuperioreAllaMedia;
			
			
			file.close();
		} //else
		//O
		System.out.println(risposta);

	}
}
