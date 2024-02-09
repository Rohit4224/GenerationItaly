package entities;

public class Film extends MultimediaContent
{
	private String regista;
	private boolean oscar;
	
	public Film(String title, int durata, String regista, boolean oscar) {
		super(title, durata);
		setRegista(regista);
		setOscar(oscar);
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public boolean isOscar() {
		return oscar;
	}

	public void setOscar(boolean oscar) {
		this.oscar = oscar;
	}

	
	public String scheda() {
		return "\tFILM\n"
				+ super.toString()
				+ "\nFilm Durata: " + super.getDurata()
				+ "\nRegista: " + regista + "\nOscar: " + oscar
				+ "\n-----------------------------------------------------------\n";
	}
	
	public double prezzo (int durata)
	{
		double pricePerMin = 0.1;
		double prezzo = pricePerMin * durata;
		
		return prezzo;
		
	}
	
	public boolean filmValido (int durata)
	{
		if (durata >= 65)
			return (true);
		return (false);
	}
	
}
