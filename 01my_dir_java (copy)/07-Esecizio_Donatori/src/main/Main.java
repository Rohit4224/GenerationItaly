package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// se la persona puo donare o no
		// deve essere maggiorenne
		// devono essere passati 6 mesi per la donne e 4 mesi per uomini
		// non deve aver fatto tattuaggio negli ultimi 6mesi
		// non deve essersi drogato
		// deve essere esente da patologie ematiche
		// non deve aver subito trasfusione negli ultimi 6 mesi
		
		// stampare in console se puo donare o no.
		
		// D
		String name;
		int age;
		String gender;
		int lastDonate;
		String tatto;
		String drogato;
		String blood_disorder;
		String transfusione;
		Scanner tastiera;
		String risposta;
		
		//I
		tastiera = new Scanner(System.in);
		
		System.out.println("Write your name and ENTER");
		name = tastiera.nextLine();
		System.out.println("write your age and ENTER");
		age = Integer.parseInt(tastiera.nextLine());
//		System.out.println("Enter F if you are Feminine and Enter M if you are Masculine.");
//		gender = tastiera.nextLine();
//		System.out.println("Enter months when you last donated the blood");
//		lastDonate = Integer.parseInt(tastiera.nextLine());
//		System.out.println("Enter Y if you have had a tattoo in the last 6 months, else N");
//		tatto = tastiera.nextLine();
//		System.out.println("Enter Y if you are drugged, else N");
//		drogato = tastiera.nextLine();
//		System.out.println("Enter Y if you have any blood disorders, else N");
//		blood_disorder = tastiera.nextLine();
//		System.out.println("Enter Y if you have had a transfusion in the last 6 months, else N");
//		transfusione = tastiera.nextLine();
		
		risposta = "Sorry " + name + ", you cannot donate blood";
		
		
		// C
		
//		if (age >= 18 && lastDonate == "N" && tatto == "N" && drogato == "N" && blood_disorder == "Y" && transfusion == "N")
//			System.out.println("Yes, " + name +  "You can donate blood");
//		else
//			System.out.println("Sorry, you cannot donate blood");
			
		if (age >= 18)
		{
			System.out.println("Enter F if you are Feminine and Enter M if you are Masculine.");
			gender = tastiera.nextLine();
			System.out.println("Enter months when you last donated the blood");
			lastDonate = Integer.parseInt(tastiera.nextLine());
			if ((gender.equalsIgnoreCase("F") && lastDonate >= 6) 
					|| (gender.equalsIgnoreCase("M") && lastDonate >= 4))
			{
				System.out.println("Enter Y if you have had a tattoo in the last 6 months, else N");
				tatto = tastiera.nextLine();
				if (tatto.equalsIgnoreCase("N"))
				{
					System.out.println("Enter Y if you are drugged, else N");
					drogato = tastiera.nextLine();
					if (drogato.equalsIgnoreCase("N"))
					{
						System.out.println("Enter Y if you have any blood disorders, else N");
						blood_disorder = tastiera.nextLine();
						if (blood_disorder.equalsIgnoreCase("N"))
						{
							System.out.println("Enter Y if you have had a transfusion in the last 6 months, else N");
							transfusione = tastiera.nextLine();
							if (transfusione.equalsIgnoreCase("N"))
							{
								risposta = "Yes " + name +  ", You can donate blood.";
							}
//							else
//								risposta = "Sorry " + name + ", you cannot donate blood";
						}
//						else
//							risposta = "Sorry " + name + ", you cannot donate blood";
					}
//					else
//						risposta = "Sorry " + name + ", you cannot donate blood";
				}
//				else
//					risposta = "Sorry " + name + ", you cannot donate blood";
			}
//			else
//				risposta = "Sorry " + name + ", you cannot donate blood";
		}
//		else
//			risposta = "Sorry " + name + ", you cannot donate blood";
		
		tastiera.close();
		//O
		System.out.println(risposta);
		
	}


}
