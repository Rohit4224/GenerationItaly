package entities;

public class Tram extends PublicTransport
{
	private int wagons;
	private boolean binarioSingolo;
	
	
	public Tram(String line, int seats, int standingPlaces, boolean nightService, int wagons, boolean binarioSingolo)
	{
		super(line, seats, standingPlaces, nightService);
		setWagons(wagons);
		setBinarioSingolo(binarioSingolo);
	}


	public int getWagons() {
		return wagons;
	}


	public void setWagons(int wagons) {
		this.wagons = wagons;
	}


	public boolean isBinarioSingolo() {
		return binarioSingolo;
	}


	public void setBinarioSingolo(boolean binarioSingolo) {
		this.binarioSingolo = binarioSingolo;
	}


	
	@Override
	public String toString() {
		return "\t\tTRAM\n"
				+ super.toString()
				+ "\nwagons: " + wagons + "\nbinarioSingolo: " + binarioSingolo
				+ "\n-----------------------------------------------------------\n";
	}
	
	
	
}
