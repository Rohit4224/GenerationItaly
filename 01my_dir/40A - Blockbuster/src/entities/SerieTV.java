package entities;

public class SerieTV extends MultimediaContent
{
	//proprieta
	private int nStagioni;
	private int puntateStagione;
	private boolean conclusa;
	
	//constructor
	public SerieTV(String title, int durata, int nStagioni, int puntateStagione, boolean conclusa) {
		super(title, durata);
		setNumeriStagioni(nStagioni);
		this.nStagioni = nStagioni;
		this.puntateStagione = puntateStagione;
		this.conclusa = conclusa;
	}

	//getters setters
	public int getNumeriStagioni() {
		return nStagioni;
	}

	public void setNumeriStagioni(int nStagioni) {
		this.nStagioni = nStagioni;
	}

	public int getPuntateStagione() {
		return puntateStagione;
	}

	public void setPuntateStagione(int puntateStagione) {
		this.puntateStagione = puntateStagione;
	}

	public boolean isConclusa() {
		return conclusa;
	}

	public void setConclusa(boolean conclusa) {
		this.conclusa = conclusa;
	}

	

	//methods
	
	public String scheda() {
		return "\tSERIETV\n"
				+ super.toString()
				+ "\nDurata Media a Stagione: " + super.getDurata()  
				+ "\nnStagioni: " + nStagioni + "\npuntateStagione: " + puntateStagione + "\nconclusa: " + conclusa
				+ "\n-----------------------------------------------------------\n";
	}
	
	public int durataMediaStagione()
	{
		return (super.getDurata() * puntateStagione);
	}
	
	public int durataMediaSerie()
	{
		return (super.getDurata() * puntateStagione * nStagioni);
	}
	
	public boolean serieValida(int nStagioni, int nPuntate)
	{
		return (nStagioni >= 1 && nPuntate >= 3);
	}
}
