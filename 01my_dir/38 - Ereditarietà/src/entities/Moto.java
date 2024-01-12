package entities;

public class Moto extends Veicolo
{
	
	private boolean passegero;
	private boolean bauletto;
	
	
	public Moto(String marca, String modello, String colore, int capienzaSerbatoio, double kilometriAlLitro,
			boolean passegero, boolean bauletto) {
		super(marca, modello, colore, capienzaSerbatoio, kilometriAlLitro);
		setPassegero(passegero);
		setBauletto(bauletto);
	}


	public boolean isPassegero() {
		return passegero;
	}


	public void setPassegero(boolean passegero) {
		this.passegero = passegero;
	}


	public boolean isBauletto() {
		return bauletto;
	}


	public void setBauletto(boolean bauletto) {
		this.bauletto = bauletto;
	}


	@Override
	public String toString()
	{
		return "\tMOTO\n"
				+ super.toString() +
				"\nPassegero: " + (passegero ? "Si" : "No") 
				+ "\nBauletto: " +  (bauletto ? "Si" : "No") 
				+ "\n-----------------------------------------------------------\n";
	}

	
	
}
