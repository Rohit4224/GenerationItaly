package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BlockbusterAggregator
{
	ArrayList<Film> film;
	ArrayList<SerieTV> serieTV;
	
	public BlockbusterAggregator(String path) throws FileNotFoundException
	{
		Scanner file;
		file = new Scanner(new File(path));
		film = new ArrayList<>();
		serieTV = new ArrayList<>();
		
		
		while(file.hasNextLine())
		{
			String info [] = (file.nextLine().split(","));
			
			switch(info[0].toLowerCase())
			{
				case "film" :
					film.add(new Film(
							info[1]
							,Integer.parseInt(info[2])
							, info[3]
							, info[4].equalsIgnoreCase("true")));
					break;
					
				case "serietv" :
					serieTV.add(new SerieTV(
							info[1]
							,Integer.parseInt(info[2])
							, Integer.parseInt(info[3])
							,Integer.parseInt(info[4])
							, info[5].equalsIgnoreCase("true")));
					break;
					
				default :
					System.out.println("check the Data.txt");
			}
			
			
		}
		
	}//Di construttore
	
	//metodi
	
	public String schedaFilm()
	{
		String res = "";
		
		for (Film f : film)
		{
			res += f.scheda();
		}
		
		return res;
	}

	public String schedaSerieTV()
	{
		String res = "";
		
		for (SerieTV t : serieTV)
		{
			res += t.scheda();
		}
		
		return res;
	}

	public String schedaCompleta()
	{
		String res = schedaFilm();
		res += schedaSerieTV();
		return res;
	}

	public double durataMediaFilm()
	{
		int count = 0;
		double media = 0;
		int durata = 0;
		for (Film f : film)
		{
			count++;
			durata += f.getDurata();
			media = durata/count;
		}
		return media;
	}

	public String filmPiuCaro()
	{
		String res = "";
		double max = 0;
		
		for (Film f : film)
		{
			if (f.prezzo(f.getDurata()) > max)
			{
				max = f.prezzo(f.getDurata());
				res = f.scheda();
			}
			else if (f.prezzo(f.getDurata()) == max)
				res += f.scheda();
		}
		return res;
	}

	public String nonValidi()
	{
		String res = "";
		
		for (Film f : film)
			if (!f.filmValido(f.getDurata()))
				res += f.scheda();
		for (Film f : film)
			if (!f.filmValido(f.getDurata()))
				res += f.scheda();
		return res;
	}

	public String registaFrequente()
	{
		String res = "";
		
		int count = 0;
		int max = 0;
		for (Film f : film)
		{
			count = 0;
			for (Film f2 : film)
			{
				if(f2.getRegista().equalsIgnoreCase(f.getRegista()))
					count++;
			}
			if (count > max)
			{
				max = count;
				res = f.getRegista();
			}
		}
		return res;
	}
	
	
}
