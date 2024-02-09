package entities;

public class Paziente extends Persona
{
	//pa,nome,cognome,residenza,dob,malattia,contagioso,giorniDegenza
	
	private String malattia;
	private boolean contagioso;
	private int giorniDegenza;
	
	public Paziente(String nome, String cognome, String residenza, String dob, String malattia, boolean contagioso,
			int giorniDegenza) {
		super(nome, cognome, residenza, dob);
		
		setMalattia(malattia);
		setContagioso(contagioso);
		setGiorniDegenza(giorniDegenza);
	}
	public String getMalattia() {
		return malattia;
	}
	public void setMalattia(String malattia) {
		this.malattia = malattia;
	}
	public boolean isContagioso() {
		return contagioso;
	}
	public void setContagioso(boolean contagioso) {
		this.contagioso = contagioso;
	}
	public int getGiorniDegenza() {
		return giorniDegenza;
	}
	public void setGiorniDegenza(int giorniDegenza) {
		this.giorniDegenza = giorniDegenza;
	}
	
	
	@Override
	public String toString() {
		return 
				super.toString().replace("\tPersona", "\n\tPAZIENTE\n")
				+ "\nRicoverato per: " + malattia 
				+ "\nStato: " + (contagioso? "Contagioso" : "Non Contagioso" )
				+ "\nDegenza: " + giorniDegenza + " giorni"
				+ "\nCosto: " + spesaPaziente() + "€"
				+ "\n-----------------------------------------------------------\n";
	}
	
	public double spesaPaziente()
	{
		double ris = 150;
		
		ris += contagioso ? 300 : 0;
		
		ris += giorniDegenza * 100;
		
		return (ris);
	}
}
