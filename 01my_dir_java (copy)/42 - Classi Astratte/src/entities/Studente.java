package entities;

public class Studente extends Persona
{
	private String scuola;
	private String classe;
	private double[] votiFinali;
	

	public Studente(int id, String nome, String cognome, String dob, String residenza, String scuola, String classe,
			double[] votiFinali) {
		super(id, nome, cognome, dob, residenza);
		this.scuola = scuola;
		this.classe = classe;
		this.votiFinali = votiFinali;
	}


//	public Studente() {
//		// TODO Auto-generated constructor stub
//	}


	public String getScuola() {
		return scuola;
	}




	public void setScuola(String scuola) {
		this.scuola = scuola;
	}




	public String getClasse() {
		return classe;
	}




	public void setClasse(String classe) {
		this.classe = classe;
	}




	public double[] getVotiFinali() {
		return votiFinali;
	}




	public void setVotiFinali(double[] votiFinali) {
		this.votiFinali = votiFinali;
	}

	
	
	@Override
	public String toString() {
		return super.toString() 
				+ "\nScuola: " + scuola 
				+ "\nClasse: " + classe 
				+ "\nVoti: " + stampaVoti()
				+ "\nMedia: " + media() 
				+ "\nEsito: " + esito()
				+ "\n-----------------------------------------------------------\n";
	}

	public double media()
	{
		double ris = 0;
				
		for (double v : votiFinali)
			ris += v;
		
		ris = ris > 0 ? ris/ votiFinali.length : 0;
		
		return ris;
	}
	
	public String esito()
	{
		return media() >= 6 ? "PROMOSSO" : "BOCCIATO";
	}
	
	
	public String stampaVoti()
	{
		String ris = "";
		
		for (double v : votiFinali)
		{
			ris += v + ", ";
		}
		
		ris = ris.length() > 2 ? ris.substring(0, ris.length() - 2) : ris;
		
		return ris;
	}
	
	public double bonus()
	{
		double ris = 0;
		
		ris += media() > 9 ? 800 : media() >= 8 ? 600 : media() >= 7 ? 400 : 0;
		
		return ris;
	}
} // fine classe
