package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Aggregator
public class Scuola
{
	ArrayList<Studente> studente;
	ArrayList<Insegnante> insegnante;
	
	public Scuola(String path) throws FileNotFoundException
	{
		Scanner file;
		file = new Scanner(new File(path));
		studente = new ArrayList<>();
		insegnante = new ArrayList<>();
		
		while(file.hasNextLine())
		{
			String info [] = file.nextLine().split(";");
			
			switch(info[0].toLowerCase())
			{
				case "studente":
					studente.add(new Studente(
									info[1]
									, info[2]
									, Integer.parseInt(info[3])
									, info[4]
									, nToArray(Double.parseDouble(info[5]), 
											Double.parseDouble(info[6]), 
											Double.parseDouble(info[7]))));
					break;
				case "insegnante":
					insegnante.add(new Insegnante(info[1], info[2], info[3], 
												Double.parseDouble(info[4])));
			}
		}
	} //  costruttore

	private double[] nToArray(double n1, double n2, double n3)
	{
		double [] unArray = new double [3];
		unArray[0] = n1;
		unArray[1] = n2;
		unArray[2] = n3;
		return unArray;
	}
	
	public String schedaStudenti()
	{
		String res = "";
		
		for (Studente s : studente)
			res += s.toString();
		return res;
	}
	
	public String schedaDocenti()
	{
		String res = "";
		
		for (Insegnante s : insegnante)
			res += s.toString();
		return res;
	}
	
	public String listaPromossi()
	{
		String res = "";
		int count = 0;
		for(Studente s : studente)
		{
			if (s.esito().equalsIgnoreCase("promosso"))
				res += s.toString();
			else
				count++;
		}
		res += "\n\nIl numero degli studenti bocciati: " + count;
		return res;
	}
	
//	int nErasmus() -> numero degli studenti 
//	che possono andare in erasmus(ricordate i metodi già scritti!)
	
	public int nErasmus()
	{
		int count = 0;
		for(Studente s : studente)
		{
			if(s.erasmus())
				count++;
		}
		return count;
	}
	
//	String pensionamento() -> lista di insegnanti prossimi alla pensione
//	(entro a 5 anni dalla pensione)
	
	public String pensionamento()
	{
		int yearsToRetirement = 5;
		String res = "";

        for (Insegnante i : insegnante) {
            int anniManenti = i.anniPensione();
            if (anniManenti <= yearsToRetirement) {
                res += i.toString();
            }
        }

        return res;
	}

//	 double totaleStipendiIta() -> totale stipendio degli insegnanti di italiano
	public double totaleStipendiIta() 
	{
		double res = 0;
		
		for (Insegnante s : insegnante)
			if (s.getMateriaInsegnata().equalsIgnoreCase("italiano"))
				res += s.stipendio();
		return res;
	}
	
//	double mediaStipendi() -> media degli stipendi di tutti gli insegnanti
	
	public double mediaStipendi()
	{
		double res = 0;
		int count = 0;
		double stipendi = 0;
		for (Insegnante s : insegnante)
		{
			count++;
			stipendi += s.stipendio();
			
		}
		res = stipendi/count;
		return res;
	}
}
