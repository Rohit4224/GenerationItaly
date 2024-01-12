package entities;

public class Autobus extends PublicTransport
{
	private boolean doubleDecker;

	public Autobus(String line, int seats, int standingPlaces, boolean nightService, boolean doubleDecker) {
		super(line, seats, standingPlaces, nightService);
		setDoubleDecker(doubleDecker);
	}

	public boolean isDoubleDecker() {
		return doubleDecker;
	}

	public void setDoubleDecker(boolean doubleDecker) {
		this.doubleDecker = doubleDecker;
	}

	
	@Override
	public String toString() {
		return "\t\tAUTOBUS\n"
				+ super.toString()
				+ "doubleDecker: " + (doubleDecker? "Si" : "No") 
				+ "\n-----------------------------------------------------------\n";
	}
	
	
}
