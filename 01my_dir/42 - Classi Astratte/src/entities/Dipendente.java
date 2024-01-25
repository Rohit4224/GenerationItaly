package entities;

public class Dipendente extends Persona
{
	private String mansione;
	private double stipendio;
	private String sede;
	private int anniLavorati;
	
	public Dipendente(int id, String nome, String cognome, String dob, String residenza, String mansione,
			double stipendio, String sede, int anniLavorati) {
		super(id, nome, cognome, dob, residenza);
		setMansione(mansione);
		setStipendio(stipendio);
		setSede(sede);
		setAnniLavorati(anniLavorati);
	}

	public String getMansione() {
		return mansione;
	}

	public void setMansione(String mansione) {
		this.mansione = mansione;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public int getAnniLavorati() {
		return anniLavorati;
	}

	public void setAnniLavorati(int anniLavorati) {
		this.anniLavorati = anniLavorati;
	}

	@Override
	public String toString()
	{
		return 	super.toString() + 
				"\nMansione: " + mansione 
				+ "\nStipendio: " + stipendio 
				+ "\nSede: " + sede 
				+ "\nAnni Lavorati: " + anniLavorati 
				+ "\n-----------------------------------------------------------\n";
	}
	
	public boolean pendolare()
	{
		return !getResidenza().equalsIgnoreCase(sede);
	}
	
	// siamo obbligatori a impletare(cioè dare )
	
	@Override
	public double bonus()
	{
		double ris = 0;
		
		ris += pendolare() ? 500 : 0;
		
		switch(mansione.toLowerCase())
		{
			case "programmatore":
				ris += 50;
				break;
			case "docente":
				ris += 25;
				break;
			case "ceo":
				ris += 100;
				break;
		}
		
		return ris;
	}
	
}
