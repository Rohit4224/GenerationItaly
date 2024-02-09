package entities;

public class Laptop extends Pc 
{
	private String modello;
	private int ram;
	private String cpu;
	private int hd;
	private String tipoHd;
	
	
	public Laptop(int id, String marca, int annoProduzione, String modello, int ram, String cpu, int hd, String tipoHd) 
	{
		super(id, marca, annoProduzione, modello, ram, cpu, hd, tipoHd);
	}
	
	
}
