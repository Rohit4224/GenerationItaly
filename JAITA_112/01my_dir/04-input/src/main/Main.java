package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//DICO - Declaration, initialization, calculation, Output
		double altezza;
		double peso;
		String nome;
		double bmi;
		String risposta;
		
		Scanner tastiera;
		
//		altezza = 1.80;
//		peso = 85;
//		nome = "Rohit";
		tastiera = new Scanner(System.in);
		bmi = 0;
		risposta = "";
		
		System.out.println("Digita il tuo nome e poi premi ENTER");
		//tastiera.nextLine() legge quello che scritto in console,
		//il dato letto da console viene portato nel prgramma sempre come string
		nome = tastiera.nextLine();  
		System.out.println("Digita il tuo peso in chiligrami e poi premi ENTER");
		// per trasformare il dato letto in double devo usare Double.parseDouble()
		// gli interi si scrive Integer.parseInt()
		peso = Double.parseDouble(tastiera.nextLine());
		System.out.println("Digita la tua altezza in metri e poi premi ENTER");
		altezza = Double.parseDouble(tastiera.nextLine());
		
		tastiera.close();
		
		bmi = peso/(altezza*altezza);
		
		risposta = "Ciao " + nome + " il tuo BMI vale " + bmi + " KG/m2" + ".";
		System.out.println(risposta);

	}

}
