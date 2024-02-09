package esercizio_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scrivere un programma che letti dei numeri da un file poi stampi:
//			numero maggiore
//			media totale
//			media dei multipli di 5
//			il numero minore tra i multipli di 3
//			modificare tutti i numeri multipli di 7 in 10
//			cancellare tutti i numeri compresi tra 10 e 25
//			BONUS
//			ordinare in modo crescente i numeri letti da file
		
		ArrayList<Integer>num;
		
		Scanner file = null;
		Scanner input = new Scanner(System.in);
		String path = "src/esercizio_4/numeri.txt";
		do {
			try {
				file = new Scanner(new File (path));
				num = new ArrayList<>();
				break;
				
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				System.out.println(path + "Not found. Enter new Path : ");
				path = input.nextLine();
			}
		} while (true);
		input.close();
		
		while (file.hasNextLine())
		{
			String info[] = (file.nextLine().split(","));
			
			for (String s : info)
			{
				int n = Integer.parseInt(s);
				num.add(n);
			}
		}
		
		System.out.println("Il numero maggiore è : " + numeroMaggiore(num));
		
		System.out.println("La media Totale è : " + mediaTotal(num));
		
		System.out.println("La media dei multipli di 5 : " + mediaMultipli5(num));
		
		System.out.println("Il numero piccolo tra mulitipli di 3 : " + numPiccoloMultipli3(num));
		
		System.out.println("7 modificato invece di 10 : " + modificato7in10(num));
		
		System.out.println("Numeri cancellati tra 10 e 25 : " + cancellatiTra10e25(num));
		
		System.out.println("Sorting increasing order : " + sortingIncreasing(num));
		
	}
	
	private static ArrayList<Integer> sortingIncreasing(ArrayList<Integer> num)
	{
		ArrayList<Integer> copy = new ArrayList<>(num);
		
		Collections.sort(copy);
		
		return copy;
	}

	private static ArrayList<Integer> cancellatiTra10e25(ArrayList<Integer> num)
	{
		ArrayList<Integer> copy = new ArrayList<>(num);
		
		for (int i = 0 ; i < copy.size() ; i++)
		{
			if (copy.get(i) > 10 && copy.get(i) < 25)
			{
				copy.remove(i);
				i--;
			}
		}
		return copy;
	}

	private static ArrayList<Integer> modificato7in10(ArrayList<Integer> num)
	{
		ArrayList<Integer> copy = new ArrayList<>(num);
		
		for (int i = 0 ; i < copy.size() ; i++)
		{
			if (copy.get(i) == 7)
			{
				copy.set(i, 10);
			}
		}
		
		return copy;
	}

	private static int numPiccoloMultipli3(ArrayList<Integer> num)
	{
		int min = Integer.MAX_VALUE;
		
		for (int i = 0 ; i < num.size() ; i++)
		{
			if (num.get(i) % 3 == 0 && num.get(i) < min)
			{
				min = num.get(i);
			}
		}
		
		return min;
	}

	private static int mediaMultipli5(ArrayList<Integer> num) 
	{
		int mediaMultipli5 = 0;
		int cont = 0;
		int sum = 0;
		
		for (int n : num)
		{
			if (n % 5 == 0)
			{
				sum += n;
				cont++;
			}
			mediaMultipli5 = sum / cont;
		}
		return mediaMultipli5;
	}

	private static int mediaTotal(ArrayList<Integer> num)
	{
		int mediaTotale = 0;
		int cont = 0;
		int sum = 0;
		
		for (int n : num)
		{
			cont++;
			sum += n;
			mediaTotale = sum / cont;
		}
		return mediaTotale;
	}

	private static int numeroMaggiore(ArrayList<Integer> num)
	{
		int max = Integer.MIN_VALUE;
		for (Integer n : num)
		{
			if (n > max)
				max = n;
		}
		return max;
	}

}
