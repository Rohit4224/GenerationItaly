package entities;

public class Insegnante extends Persona
{
	private String materiaInsegnata;
	private double stipendioBase;
	
	
	public Insegnante(String name, String dob, String materiaInsegnata, double stipendioBase) {
		super(name, dob);
		
		setMateriaInsegnata(materiaInsegnata);
		setStipendioBase(stipendioBase);
	}


	public String getMateriaInsegnata() {
		return materiaInsegnata;
	}


	public void setMateriaInsegnata(String materiaInsegnata) {
		this.materiaInsegnata = materiaInsegnata;
	}


	public double getStipendioBase() {
		return stipendioBase;
	}


	public void setStipendioBase(double stipendioBase) {
		this.stipendioBase = stipendioBase;
	}


	
	@Override
	public String toString() {
		return "\n\tInsegnanti: "
				+ super.toString()
				+ "\nMateriaInsegnata: " + materiaInsegnata + "\nStipendioBase: " + stipendioBase
				+ "\n-----------------------------------------------------------\n";
	}
	
//	double stipendio() -> Calcolato partendo da stipendioBase, a cui aggiungo:
//		- 300 se l'età è tra i 30 e i 40 anni
//		- 500 se l'età è tra i 40 compresi e i 50
//		- 800 se l'età è tra i 50 compresi e i 60
//		- 1000 se l'età è 60 o più, a cui aggiungo 50 per ogni 
//			anno che manca alla pensione
	
	public double stipendio()
	{
		 int age = super.eta();
	     double additionalSalary = 0;

	        if (age >= 30 && age <= 40) {
	            additionalSalary = 300;
	        } else if (age > 40 && age <= 50) {
	            additionalSalary = 500;
	        } else if (age > 50 && age <= 60) {
	            additionalSalary = 800;
	        } else if (age > 60) {
	            additionalSalary = 1000 + (60 - age) * 50;
	        }
	      
	      return (stipendioBase + additionalSalary);
//	      double total = stipendioBase + additionalSalary;
//	      return total;
	}
	
	public int anniPensione() {
        int pensionAge = 70;
        int age = super.eta();
        return Math.max(0, pensionAge - age);
    }
	
}
