package entities;

public class Televisore extends Articolo
{
	// double pollici, String modello, boolean smartTv
	
	private double pollici;
	private String modello;
	private boolean smartTv;
	
	public Televisore(int id, String marca, int annoProduzione, double pollici, String modello, boolean smartTv) {
		super(id, marca, annoProduzione);
		
		setPollici(pollici);
		setModello(modello);
		setSmartTv(smartTv);
	}
	public double getPollici() {
		return pollici;
	}
	public void setPollici(double pollici) {
		this.pollici = pollici;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public boolean isSmartTv() {
		return smartTv;
	}
	public void setSmartTv(boolean smartTv) {
		this.smartTv = smartTv;
	}
	@Override
	public double prezzo()
	{
		double prezzo = 2 *getPollici();
		if (isSmartTv())
			prezzo += 200;
		return prezzo;
	}
	
	
}
