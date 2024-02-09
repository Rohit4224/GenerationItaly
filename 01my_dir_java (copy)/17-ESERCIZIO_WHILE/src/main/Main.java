package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scrivere un programma che chieda all'utente di inserire una serie di numeri positivi.
        // Se il numero inserito è negativo, segnalare tramite una stampa che il numero non va bene 
        // e non considerarlo nei calcoli.
        // Per terminare il programma indicare all'utente di scrivere 0
        // Il programma deve:
        // - fare la somma di tutti i numeri inseriti
        // - fare la somma dei numeri pari
        // - fare il prodotto dei numeri multipli di 3
        // - contare quanti numeri dispari scrive l'utente
        // BONUS
        // - trovare il numero maggiore inserito dall'utente

        // Stampare infine in console in modo ordinato le richieste precedenti
		
		//D
		Scanner userInput;
		int number;
		int count;
		int sum;
		int product;
		int sumEvenNumber;
		int productMultipliDi3;
		int countOddNumber;
		int max;
		String risposta;
		
//		I
		userInput = new Scanner(System.in);
		number = 1;
		sum = 0;
		product = 0;
		sumEvenNumber = 0;
		productMultipliDi3 = 1;
		countOddNumber = 0;
		max = 0;
		risposta = "";
		count = 0;
		
		System.out.println("Inserire una serie di numeri positivi: ");
		while (number != 0)
		{
			System.out.println((count + 1) + "° numero");
			number = Integer.parseInt(userInput.nextLine());
			if (number < 0)
			{
				System.out.println("Il numero non va bene, non considera nei calcoli.");
				count--;
			}
			else if (number != 0 && number > 0)
			{
//				C
				System.out.println("Scrivi 0 per terminare la programma.");
				sum += number;
				if (number % 2 == 0)
				{
					sumEvenNumber += number;
				}
				if (number % 3 == 0)
				{
					productMultipliDi3 *= number;
				}
				if (number % 2 != 0)
				{
					countOddNumber++;
				}
				if (number > max)
				{
					max = number;
				}
			}
			count++;
		}
		if (productMultipliDi3 == 1)
			productMultipliDi3 = 0;
		userInput.close();
		
//		O
		risposta = "Risultati: \nLa somma di tutti i numeri inseriti: " + sum + "\n"
				   + "La somma dei numeri pari: " + sumEvenNumber + "\n"
				   + "Il prodotto dei numeri multipli di 3: " + productMultipliDi3 + "\n"
				   + "Numeri dispari sono: " + countOddNumber + "\n"
				   + "Il numero maggiore inserito dall'utente: " + max;
		System.out.println(risposta);
	}

}
