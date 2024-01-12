package entities;

public class Metro extends PublicTransport
{
	private int wagon;
	private boolean passaInSuperficie;
	
	public Metro(String line, int wagon, int seats, int standingPlaces 
			,boolean passaInSuperficie, boolean nightService)
	{
		super(line, seats, standingPlaces, nightService);
		setWagon(wagon);
		setPassaInSuperficie(passaInSuperficie);
	}

	public int getWagon() {
		return wagon;
	}

	public void setWagon(int wagon) {
		this.wagon = wagon;
	}

	public boolean isPassaInSuperficie() {
		return passaInSuperficie;
	}

	public void setPassaInSuperficie(boolean passaInSuperficie) {
		this.passaInSuperficie = passaInSuperficie;
	}

	
	@Override
	public String toString() {
		return "\tMETRO\n"
				+ super.toString()
				+ "wagon: " + wagon + "\npassaInSuperficie: " + (passaInSuperficie ? "Si" : "No")
				+ "\n-----------------------------------------------------------\n";
	}
	
	
	
}
