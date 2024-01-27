package esercizio2;

import java.util.*;
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
        // - Lista delle schede dei film
        // - Lista dei titoli dei film
        // - Film più lungo
        // - Durata media dei film di un genere passato dall'utente
        // - Numero di film presenti per ogni genere disponibile
		
		
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
        
		filmData.forEach((id, info) ->
        System.out.println("ID: " + id + ", Title: " + info.get("title") +
                ", Genre: " + info.get("genre") + ", Duration: " + info.get("duration")));

		
	}

}
