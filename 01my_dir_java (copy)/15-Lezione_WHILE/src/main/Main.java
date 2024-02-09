package main;

import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		
		//D
		Scanner keyboard;
		int number;
		int sum;
		
		//I
		keyboard = new Scanner(System.in);
		number = 0;
		sum = 0;
		
		while (number >=  0)
		{
			System.out.println("Write your number to add: ");
			number = Integer.parseInt(keyboard.nextLine());
			
			//C
			sum += number;
		}
		
		keyboard.close();
		
		//O
		System.out.println("The sum of the values are: " + sum);
	}

}
