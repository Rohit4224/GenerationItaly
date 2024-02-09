package entities;

public class Auto extends Veicolo
{
	private boolean ariacondizionata;
	private boolean cerchiinlega;
	

	public Auto(String marca, String modello, String colore, int capienzaSerbatoio, double kilometriAlLitro,
			boolean ariacondizionata, boolean cerchiinlega) {
		super(marca, modello, colore, capienzaSerbatoio, kilometriAlLitro);
		setAriacondizionata(ariacondizionata);
		setCerchiinlega(cerchiinlega);
	}



	public boolean isAriacondizionata() {
		return ariacondizionata;
	}



	public void setAriacondizionata(boolean ariacondizionata) {
		this.ariacondizionata = ariacondizionata;
	}



	public boolean isCerchiinlega() {
		return cerchiinlega;
	}



	public void setCerchiinlega(boolean cerchiinlega) {
		this.cerchiinlega = cerchiinlega;
	}



	@Override
	public String toString()
	{
		return "\t\tAuto\n"
				+ super.toString() +
				"\nAriacondizionata: " + (ariacondizionata? "Si" : "No") 
				+ "\nCerchiinlega: " + (cerchiinlega? "Si" : "No")
				+ "\n-----------------------------------------------------------\n";
	}
	
	
	
}
