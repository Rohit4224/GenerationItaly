package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//D
		String nomi[]; // Declaration
		
		//I
		
		nomi = new String[4]; // Instantiation
		
		nomi[0] = "Alice"; // Initialisation
		nomi[1] = "Bella"; // Si legge "nomi in posizione 1 uguale a Bella"
		nomi[2] = "Anna";
		nomi[3] = "Rohit";
		
//		nomi = new String[]{"Alice", "Bella", "Anna", "Rohit", null};  // Instantiation and Initialisation

//		String nomi1[] = new String[4];  //Declaration &&  Instantiation
//		
//		String nomi2[] = {"Alice", "Bella", "Anna", "Rohit", null};   ////declaration, instantiation and initialization  
		
		//C
		
		int i = 0;
		while (i < nomi.length)
		{
			if (nomi[i].toLowerCase().startsWith("a"))
			{
				System.out.println(nomi[i]);
			}
			i++;
		}
		
		i = 0;
		while(i < nomi.length)
			System.out.println(nomi[i++]);
		
		//O
	}

}
