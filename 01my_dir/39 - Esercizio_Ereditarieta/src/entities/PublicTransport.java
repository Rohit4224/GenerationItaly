package entities;

//parent class for Metro, Autobus and Tram
public class PublicTransport
{
	//proprieta
	private String line;
	private int seats;
	private int standingPlaces;
	private boolean nightService;
	
	//Constructor
	public PublicTransport(String line, int seats, int standingPlaces, boolean nightService)
	{
		
		setLine(line);
		setSeats(seats);
		setStandingPlaces(standingPlaces);
		setNightService(nightService);
	}
	
	//setters and getters

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getStandingPlaces() {
		return standingPlaces;
	}

	public void setStandingPlaces(int standingPlaces) {
		this.standingPlaces = standingPlaces;
	}

	public boolean isNightService() {
		return nightService;
	}

	public void setNightService(boolean nightService) {
		this.nightService = nightService;
	}

	
	
	@Override
	public String toString() {
		return "line: " + line + "\nseats: " + seats + "\nstandingPlaces: " + standingPlaces 
				+ "\nnightService: "
				+ (nightService ? "Si" : "No")
				;
	}
	
	//methods
	
	
}
