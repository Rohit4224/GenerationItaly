package main;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args)
	{
		//D
		Scanner tastiera;
		int age;
		String name;
		String result;
		
		//I
		tastiera = new Scanner(System.in);
		result = "";
		
		System.out.println("Write your name and ENTER");
		name = tastiera.nextLine();
		System.out.println("Write your age and ENTER");
		age = Integer.parseInt(tastiera.nextLine());
		
		tastiera.close();
		
		// C
		if (age > 17)
			result = "Adult";
		if (age < 18)
			result = "Underage";
		
		// O
		System.out.println("Hello " + name + ", " + "You are " + result);
		}
	
	}
