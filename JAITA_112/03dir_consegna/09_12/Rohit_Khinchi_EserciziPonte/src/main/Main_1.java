package main;

import java.util.Scanner;

public class Main_1 {

	public static void main(String[] args) {
//		1- Scrivere un programma che, dato un numero limite da parte dell'utente,
//		restituisca la serie di fibonacci fino all'indice indicato
//		(Fibonacci: ogni numero è dato dal risultato della somma dei due precedenti
//				ESEMPIO: L'utente dice 8, la serie sarà: 1, 1, 2, 3, 5, 8, 13, 21)

		//D
		Scanner input;
		int limit;
		int currNum;
		int prevNum;
		int sumNum;
		String risposta;
		String rispostaNum;
		
		
		//I
		risposta = "Scrivi un numero limite per la serie di fibonacci: ";
		System.out.println(risposta);
		input = new Scanner(System.in);		
		limit = Integer.parseInt(input.nextLine());
		input.close();
		currNum = 1;
		prevNum = 0;
		sumNum = 0;
		rispostaNum = "1, ";
		//C
		while (limit > 1)
		{
			sumNum = prevNum + currNum;
			rispostaNum += sumNum;
			prevNum = currNum;
			currNum = sumNum;
			limit--;
			if (limit != 1)
				rispostaNum += ", ";
		}
		
		
		//O
		System.out.println(rispostaNum);
	}

}
