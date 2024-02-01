package esercizio2;

import java.util.*;
import java.util.stream.Stream;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException
	{
		// Leggete da un file dei dati le informazioni relative a dei film
        // Il file sarà un CSV formattato così:
        // id,titolo,genere,durataMinuti

        // Usate solo le mappe, non voglio vedere classi modello!!

        //Voglio vedere poi: 
//         - Lista delle schede dei film
//         - Lista dei titoli dei film
//         - Film più lungo
//         - Durata media dei film di un genere passato dall'utente
//         - Numero di film presenti per ogni genere disponibile
		
		
		// id, <titolo,genere,durataMinuti>
		// - Lista delle schede dei film
		// id -> film Map
		Map<Integer, Map<String, String>> filmData = new LinkedHashMap<>();

		String path = "src/res/Data.txt";
		
		Scanner file = new Scanner(new File(path));
        
		while(file.hasNextLine())
		{
			String [] info = file.nextLine().split(",");
			
			int id = Integer.parseInt(info[0]);
			String titolo = info[1];
			String genere = info [2];
			String durataMinuti = info[3];
			
			Map<String, String> tempInfo = new LinkedHashMap<>();
			tempInfo.put("title", titolo);
			tempInfo.put("genere", genere);
			tempInfo.put("durata", durataMinuti);
			
			filmData.put(id, tempInfo);
		}
        
		file.close();
		
		
		String menu = "1 - Lista delle schede dei film\n"
				+ "2 - Lista dei titoli dei film\n"
				+ "3 - Film più lungo\n"
				+ "4 - Durata media dei film di un genere passato dall'utente\n"
				+ "5 - Numero di film presenti per ogni genere disponibile\n"
				+ "6 - Menu\n"
				+ "0 - Exit\n";
		
		System.out.println(menu);
		String cmd = "";
		StringBuilder resultBuilder = new StringBuilder();
		Scanner input = new Scanner(System.in);
		do
		{
			cmd = input.nextLine();
			resultBuilder.setLength(0);
			switch (cmd)
			{
			    //Lista delle schede dei film
				case "1" :
					filmData.forEach
					(
					(id, info) ->
					resultBuilder.append("ID: " + id + ", Title: " + info.get("title") 
							+", Genre: " + info.get("genere") + ", Duration: " + info.get("durata"))
							.append("\n")
					);
					break;
				//Lista dei titoli dei film
				case "2" :
					filmData.forEach((id, info) ->
					   resultBuilder.append(info.get("title") + "\n"));
					break;
				//Film più lungo
				case "3" :
					int [] max = {0};
					filmData.forEach
					(
					(id, info) ->
					{
						if (max[0] < Integer.parseInt(info.get("durata")))
						{
							max[0] = Integer.parseInt(info.get("durata"));
							resultBuilder.setLength(0);
							resultBuilder.append("ID: " + id + ", Titilo: " + info.get("title"));
						}
					}
					);
					break;
				//Durata media dei film di un genere passato dall'utente
				case "4" :
					System.out.println("Scrivi un genere: ");
					String genereScelta = input.nextLine();
					int [] count = {0};
					double [] media = {0};
					
					filmData.forEach
					(
				       (id, info) ->
				       {
				    	   if (genereScelta.equalsIgnoreCase(info.get("genere")))
				    	   {
				    		   count[0]++;
				    		   media[0] += Double.parseDouble(info.get("durata"));
				    		   
				    	   }
				       }
					);
					if (count[0] == 0)
						resultBuilder.append("Genere non trovato");
					else
						resultBuilder.append(media[0]/count[0]);
					break;
				//Numero di film presenti per ogni genere disponibile
				case "5" :
					Map<String, Integer> genereCounts = new LinkedHashMap<>();
					filmData.forEach
					(
						(id, info) ->
						{
							String genre = info.get("genere");
							genereCounts.put(genre, genereCounts.getOrDefault(genre, 0)+1);
						}
					);
					
					for (String key : genereCounts.keySet())
					{
						resultBuilder.append("Genere: " + key + ", " + genereCounts.get(key) + " Films\n");
					}
					break;
				case "0":
					resultBuilder.append("Arrivederci.!!");
					break;
					
			}
			if (!cmd.equals("0"))
				System.out.println(resultBuilder + ".\n\n" + menu);
			else
				System.out.println(resultBuilder);
		} while (!cmd.equals("0"));
		input.close();
		System.out.println("END.");
	}
}
