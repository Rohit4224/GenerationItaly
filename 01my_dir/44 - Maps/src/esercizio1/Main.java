package esercizio1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		// chiedete all'utente una serie di informazioni legate alla sua anagrafica.
		//Salvate le informazioni in una mappa
		// stampate poi la scheda riassuntiva ordinata delle informazioni prese da console
		
		
		Map <String, String> anagrafiche;
		anagrafiche = new LinkedHashMap<String, String>();
		
		Scanner sc = new Scanner(System.in);
		String key = "";
		String value = "";
		String flag = "";
		System.out.println("Scrivi informazione del'anagrafiche");
		do
		{
			System.out.println("Write the Key: ");
			key = sc.nextLine();
			
			if (key.isEmpty()) {
                break;
            }
			
			System.out.println("Write the Value: ");
			value = sc.nextLine();
			
			anagrafiche.put(key, value);
			System.out.println("Write 0 to end, else just Enter");
			flag = sc.nextLine();
		}while(!flag.equals("0"));
		
		for (String tempKey : anagrafiche.keySet())
		{
			System.out.println("Key: " + tempKey + ", Value: " + anagrafiche.get(tempKey));
		}
	}

}

//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        // Creating a TreeMap to store personal information (sorted by keys)
//        Map<String, String> anagrafica = new TreeMap<>();
//
//        // Creating a Scanner object for user input
//        Scanner sc = new Scanner(System.in);
//
//        // Prompt the user for personal information
//        System.out.println("Enter your personal information:");
//
//        // Array of information categories
//        String[] categories = {"Name", "Surname", "Address", "Phone Number", "Email"};
//
//        // Collect information from the user
//        for (String category : categories) {
//            System.out.print("Enter " + category + ": ");
//            String info = sc.nextLine();
//            anagrafica.put(category, info);
//        }
//
//        // Print the summary of entered information
//        System.out.println("\nSummary of Personal Information:");
//        for (Map.Entry<String, String> entry : anagrafica.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//        // Close the Scanner
//        sc.close();
//    }
//}

