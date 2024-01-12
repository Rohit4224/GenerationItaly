package entities;

import java.time.Year;

//classe parente
public class Persona
{
	private String name;
	private String dob;
	
	
	public Persona(String name, String dob)
	{
		setName(name);
		setDob(dob);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	
	@Override
	public String toString() {
		return "\nName: " + name + "\nDate of Birth: " + dob;
	}
	
	public int eta()
	{
		String dob [] = getDob().split("-");
		int yearDob = Integer.parseInt(dob[2]);
		
		int currentYear = Year.now().getValue();
		int age = currentYear - yearDob;
		
		return (age);
	}
	
	
}
