package main;

import java.time.Year;

public class Persona
{
	//nome, cognome, dob, residenza (città), professione, figliACarico, stipendio
	String name;
	String surname;
	String dob;
	String residence;
	String profession;
	int dependentChildren;
	double salary;
	
	Persona (String name, String surname, String dob, String residence, String profession, int dependentChildren, double salary)
	{
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.residence = residence;
		this.profession = profession;
		this.dependentChildren = dependentChildren;
		this.salary = salary;
	}
	
	//scheda
	String info()
	{
		String res = "";
		
		res = "Name : " + this.name + 
				"\nSurname : " + this.surname +
				"\nDate of Birth : " + this.dob +
				"\nResidence : " + this.residence +
				"\nProfession : " + this.profession + 
				"\nDependent Children : " + this.dependentChildren + 
				"\nSalary per month: " + this.salary + 
				"\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
						
		return (res);
	}
	
	int age()
	{
		int age;
		age = Integer.parseInt(this.dob.split("/")[2]);
		age = Year.now().getValue() - age;
		return (age);
	}
	
	boolean sbarcare()
	{
		boolean vivereBene = false;
//		sottrae 100 euro per ogni figlio a carico dallo stipendio.
//		Per vivere a Milano si pagano al mese 900 euro, 
//		per vivere a Roma se ne pagano 850, 
//		per vivere in altre città se ne pagano 550. 
//		Il metodo torna true se lo stipendio rimanente è superiore al 30% dello stipendio mensile

		double salaryAfterExpenses = this.salary;
		
		salaryAfterExpenses = this.dependentChildren > 0 ? this.salary - (100 * this.dependentChildren) : this.salary;
		salaryAfterExpenses = this.residence.equalsIgnoreCase("milano") ? this.salary - 900 
							: this.residence.equalsIgnoreCase("roma") ? this.salary - 850 
							: this.salary - 550;
		
		double percentRemaining = salaryAfterExpenses * 100 /this.salary; 
		
		vivereBene = percentRemaining > 30 ? true : false;
		
		return (vivereBene);
	}
}
