package entities;

import java.util.Arrays;

public class Studente extends Persona
{
	int classe;
	String sezione;
	double [] voti = new double[3];
	
	
	public Studente(String name, String dob, int classe, String sezione, double[] voti)
	{
		super(name, dob);
		setClasse(classe);
		setSezione(sezione);
		setVoti(voti);
	}


	public int getClasse() {
		return classe;
	}


	public void setClasse(int classe) {
		this.classe = classe;
	}


	public String getSezione() {
		return sezione;
	}


	public void setSezione(String sezione) {
		this.sezione = sezione;
	}


	public double[] getVoti() {
		return voti;
	}


	public void setVoti(double[] voti) {
		this.voti = voti;
	}



	@Override
	public String toString() {
		return "\n\tStudenti: "
				+ super.toString()
				+ "\nclasse: " + classe + "\nsezione: " + sezione + "\nvoti: " + Arrays.toString(voti)
				+ "\n-----------------------------------------------------------\n";
	}
	
	public int nInsuff()
	{
		int count = 0;
		
		for (double v : voti)
			if (v < 6)
				count++;
		return count;
	}
	
	//String esito() -> Stampa promosso se la media complessiva è maggiore di 6 
	//e c'è al massimo 1 insufficienza
	public double mediaStudenti()
	{
		return (voti[0] + voti[1] + voti[2]) / 3;
	}
	
	public String esito()
	{
		String res = "";
		//double media = (voti[0] + voti[1] + voti[2]) / 3;
		if (mediaStudenti() > 6 && nInsuff() <= 1)
			res = "Promosso";
		else
			res = "Non Promosso";
		return (res);
	}
	
	//boolean erasmus() -> Ritorna true se lo studente: è in 4° o 5°, 
	//è promosso e ha una media complessiva di almeno 8
	
	public boolean erasmus()
	{
		double media = voti[0] + voti[1] + voti[2] / 3;
		if(esito().equalsIgnoreCase("Promosso") && media >= 8
				&& (getClasse() == 4 || getClasse() == 5))
			return true;
		return false;
	}
	
}
