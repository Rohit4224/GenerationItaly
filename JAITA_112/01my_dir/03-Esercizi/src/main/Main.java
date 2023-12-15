package main;

public class Main
{
	public static void  main(String[] args)
	{
		double altezza;
		double peso;
		String nome;
		double bmi;
		String risposta;
		
		altezza = 1.80;
		peso = 85;
		nome = "Rohit";
//		bmi = 0;
		
		bmi = peso/(altezza*altezza);
		
		risposta = "Ciao " + nome + " il tuo BMI vale " + bmi + " KG/m2" + ".";
		System.out.println(risposta);
	}
}