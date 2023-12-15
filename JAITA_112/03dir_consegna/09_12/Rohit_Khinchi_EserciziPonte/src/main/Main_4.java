package main;

import java.util.Scanner;

public class Main_4 {

	public static void main(String[] args) {
//		4- Scrivere un programma che permetta di richiedere all’utente di inserire i dati di N studenti, 
//		dove N è il numero di studenti da chiedere come prima informazione.
//		I dati da richiedere sono il nome, il voto finale di italiano,di inglese, di informatica e di matematica.
//		Voglio vedere in console:
//		- La media complessiva di ogni singolo studente e il nome dello studente con la media ottenuta
//		- Il nome dello studente e il suo esito(è promosso se ha almeno tre voti maggiori di 5 e la media complessiva è maggiore di 6) 
//		- Il numero di studenti bocciati
//		- Il numero di studenti con il voto di informatica superiore a 8

		//D
		Scanner input;
		int numStudenti;
		String name;
		double ita;
		double ing;
		double inf;
		double math;
		double mediaStudent;
		String esito;
		int bocciati;
		int numInfGr8;
		int count;
		String risposta;
		int countPassingGradesGr5;
		String simpleLine;
		
		
		//I
		System.out.println("Insirisci numeri di studenti:");
		input = new Scanner(System.in);
		numStudenti = Integer.parseInt(input.nextLine());
		count = 0;
		risposta = "";
		countPassingGradesGr5 = 0;
		bocciati = 0;
		numInfGr8 = 0;
		simpleLine = "";
		
		//C
		while (numStudenti > 0)
		{
			System.out.println((count+1) + "° Studente.");
			System.out.println("Il nome del studente: ");
			name = input.nextLine();
			System.out.println("Il voto finale di italiano: ");
			ita = Double.parseDouble(input.nextLine());
			System.out.println("Il voto finale di inglese:");
			ing = Double.parseDouble(input.nextLine());
			System.out.println("Il voto finale di informatica :");
			inf = Double.parseDouble(input.nextLine());
			System.out.println("Il voto finale di matematica: ");
			math = Double.parseDouble(input.nextLine());
			simpleLine = "-----------------------------------------";
			if (numStudenti == 1)
			{
				simpleLine += "\n-----------------------------------------";
			}
			System.out.println(simpleLine);
			mediaStudent = ((ita + ing + inf + math)/4.0);
			
			countPassingGradesGr5 = (ita > 5.0 ? 1 : 0) + (ing > 5.0 ? 1 : 0) + (inf > 5.0 ? 1 : 0) + (math > 5.0 ? 1 : 0);
			esito = countPassingGradesGr5 >= 3 && mediaStudent > 6.0 ? "Promosso/a" : "Bocciato/a";

			bocciati += esito == "Bocciato/a" ? 1 : 0;
			
			numInfGr8 += inf > 8.0 ? 1 : 0;

			risposta += "Nome: " + name + "\n" 
					+ "La media complessiva: " + mediaStudent + "\n"
					+ "Esito: " + esito + "\n"
					+ "-----------------------------------------" + "\n";
			
			numStudenti--;
			count++;
		}
		
		input.close();
		//O
		risposta += "-----------------------------------------\n" +
					"Il numero di studenti bocciati: " + bocciati + "\n\n" +
					"Il numero di studenti con il voto di informatica superiore a 8: " + numInfGr8 +
					"\n-----------------------------------------" + 
					"\n-----------------------------------------";
		System.out.println(risposta);
	}

}
