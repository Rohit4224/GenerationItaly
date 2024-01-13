package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Aggregator
public class Scuola
{
//	ArrayList<Studente> studente;
//	ArrayList<Insegnante> insegnante;
	
	ArrayList<Persona> persone;
	
	public Scuola(String path) throws FileNotFoundException
	{
		Scanner file;
		file = new Scanner(new File(path));
//		studente = new ArrayList<>();
//		insegnante = new ArrayList<>();
		persone = new ArrayList<>();
		
		
		while(file.hasNextLine())
		{
			String info [] = file.nextLine().split(";");
			Persona p = null;
			
			switch(info[0].toLowerCase())
			{
				case "studente":
					p  = (new Studente(
									info[1]
									, info[2]
									, Integer.parseInt(info[3])
									, info[4]
									, nToArray(Double.parseDouble(info[5]), 
											Double.parseDouble(info[6]), 
											Double.parseDouble(info[7]))));
					break;
				case "insegnante":
					p = (new Insegnante(info[1], info[2], info[3], 
												Double.parseDouble(info[4])));
			}
			if (p != null)
				persone.add(p);
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
		
		for (Persona p : persone)
		{
			if (p instanceof Studente)
				res += p.toString();
		}
		return res;
	}
	
	public String schedaDocenti()
	{
		String res = "";
		
		for (Persona p : persone)
		{
			if (p instanceof Insegnante)
				res += p.toString();
		}
		return res;
	}
	
	public String listaPromossi()
	{
		String res = "";
		int count = 0;
		for(Persona s : persone)
		{
			if (s instanceof Studente)
			{
				if (((Studente)s).esito().equalsIgnoreCase("promosso"))
					res += s.toString();
				else
					count++;
			}
			
		}
		res += "\n\nIl numero degli studenti bocciati: " + count;
		return res;
	}
	
//	int nErasmus() -> numero degli studenti 
//	che possono andare in erasmus(ricordate i metodi già scritti!)
	
	public int nErasmus()
	{
		int count = 0;
		for(Persona s : persone)
		{
			if (s instanceof Studente)
				if(((Studente)s).erasmus())
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

		for(Persona i : persone)
		{
			if (i instanceof Insegnante)
			{
				int yearsRemained = ((Insegnante)i).anniPensione();
	            if (yearsRemained <= yearsToRetirement)
	            {
	                res += i.toString();
	            }
			}
            
        }

        return res;
	}

//	 double totaleStipendiIta() -> totale stipendio degli insegnanti di italiano
	public double totaleStipendiIta() 
	{
		double res = 0;
		
		for(Persona i : persone)
		{
			if (i instanceof Insegnante)
			{
				if (((Insegnante)i).getMateriaInsegnata().equalsIgnoreCase("italiano"))
					res += ((Insegnante)i).stipendio();
			}
		}
			
		return res;
	}
	
//	double mediaStipendi() -> media degli stipendi di tutti gli insegnanti
	
	public double mediaStipendi()
	{
		double res = 0;
		int count = 0;
		double stipendi = 0;
		for(Persona i : persone)
		{
			if (i instanceof Insegnante)
			{
				count++;
				stipendi += ((Insegnante)i).stipendio();
			}
			
			
		}
		res = stipendi/count;
		return res;
	}

	public double mediaStipendiMate()
	{
		double res = 0;
		
		for(Persona i : persone)
		{
			if (i instanceof Insegnante)
			{
				if (((Insegnante)i).getMateriaInsegnata().equalsIgnoreCase("Matematica"))
					res += ((Insegnante)i).stipendio();
			}
		}
			
		return res;
	}

	public String studenteBravo()
	{
		double max = 0;
		String name = "";
		
		for (Persona p : persone)
		{
			if (p instanceof Studente)
			{
				if (((Studente)p).mediaStudenti() > max)
				{
					max = ((Studente)p).mediaStudenti();
					name = ((Studente)p).getName();
				}
			}
			
		}
		return (name + " ha media maggiore " + max);
	}

	public String insegnanteVecchio()
	{
		int max = 0;
		String name = "";
		
		for (Persona p : persone)
		{
			if(p instanceof Insegnante)
			{
				if (((Insegnante)p).eta() > max)
				{
					max = ((Insegnante)p).eta();
					name = ((Insegnante)p).getName();
				}
			}
		}
		return (name + " ha campiuto piu anni: " + max);
	}

	public String insegnanteRicco()
	{
		double max = 0;
		String name = "";
		String materia = "";
		
		for (Persona p : persone)
		{
			if(p instanceof Insegnante)
			{
				if (((Insegnante)p).stipendio() > max)
				{
					max = ((Insegnante)p).stipendio();
					name = ((Insegnante)p).getName();
					materia = ((Insegnante)p).getMateriaInsegnata();
				}
			}
		}
		return (name + " e' piu ricco di tutti, EURO " + max + ". Insegna " + materia + ".");
	}

	public String studenteGiovane()
	{
		int min = 200;
		String name = "";
		String classe = "";
		
		for (Persona p : persone)
		{
			if(p instanceof Studente)
			{
				if (((Studente)p).eta() < min)
				{
					min = ((Studente)p).eta();
					name = ((Studente)p).getName();
					classe = String.valueOf(((Studente)p).getClasse());
				}
			}
		}
		return (name + " e' piu giovane, eta " + min + " anni. Studia in classe " + classe);
	}
	
//	String fuoriCorso() -> Ritorna il nome e gli anni fuori corso degli studenti, 
//	tenendo presente che
//per essere in corso le combinazioni dovrebbero essere:  
//CLASSE -> ANNI => 5->19-18, 4->18-17, 3->17-16, 2->16-15, 1->15,14

	public String fuoriCorso()
	{
	    String res = "";

	    for (Persona p : persone)
	    {
	        if (p instanceof Studente)
	        {
	            Studente s = (Studente) p;
	                    
	            if (s.eta() > (14 + s.classe))
	            	res += s.getName() + " : " + (s.eta() - (14 + s.classe)) + " anni fuori corso\n";

	        }//if(p...
	    }//for
	    return res.isEmpty() ? "Nessun fuori corso trovato." : res;
	}
	
//	- String studentiPerAula() -> Per ogni aula (ES 4C) voglio vedere 
//	il nome dell'aula e il numero di studenti presenti
	
	public String studentiPerAula()
	{
		ArrayList<String> aule = new ArrayList<>();
		int i = 0;
		int student = 0;
		int j = 0;
		String res = "";
		
		for (Persona p : persone)
		{
			if (p instanceof Studente)
			{
				Studente s = (Studente)p;
				if(!aule.contains(s.classe + s.getSezione()))
				{
					aule.add(s.classe + s.getSezione());
					i = 0;
					student = 0;
					while(i < persone.size())
					{
						if(persone.get(i) instanceof Studente)
						{
							Studente s2 = (Studente)persone.get(i);
							if ((s2.classe + s2.getSezione()).equalsIgnoreCase(s.classe + s.getSezione()))
								student++;
						}
						i++;
					}//while
					res += "Aula: " + aule.get(j++) + " Studenti: " + student + "\n";
				}//if(!aule...
			}//if(p...
			 
		}//for
		return (res);
	}
	
}//end class scuola
