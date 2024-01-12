package entities;

public class Medico extends Persona
{
	//me,nome,cognome,residenza,dob,specializzazione,ospedale,stipendio
	private String specializzazione;
	private String ospedale;
	private double stipendio;
	
	public Medico(String nome, String cognome, String residenza, String dob, String specializzazione, String ospedale,
			double stipendio) {
		super(nome, cognome, residenza, dob);
		setSpecializzazione(specializzazione);
		setOspedale(ospedale);
		setStipendio(stipendio);
	}
	public Medico() {
		// TODO Auto-generated constructor stub
	}
	public String getSpecializzazione() {
		return specializzazione;
	}
	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	public String getOspedale() {
		return ospedale;
	}
	public void setOspedale(String ospedale) {
		this.ospedale = ospedale;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	
	@Override // si chiama NOTAZIONE ed è codice!
	public String toString() {
		return super.toString().replace("\tPersona", "\n\tMedico\n")
				+ "\nspecializzazione: " + specializzazione + 
				"\nOspedale: " + ospedale + 
				"\nStipendio: " + stipendio + "€"
				+ (fuoriSede() ? "\nFuori Sede" : "")
				+ "\n-----------------------------------------------------------\n";
	}
	
	public boolean fuoriSede()
	{
		String sedeOspedale = "";
		switch(ospedale.toLowerCase())
		{
			case "san raffaele":
			case "fatebene fratelli":
			case "humatis":
				sedeOspedale = "Milano";
				break;
			case "ponte san pietro":
				sedeOspedale = "Bergamo";
			case "spedali civili":
				sedeOspedale = "Brescia";
				break;
		}
		return (!getResidenza().equalsIgnoreCase(sedeOspedale));
	}
}
