package entities;

public class Pc extends Articolo
{
	// String modello, int ram, String cpu, int hd, String tipoHd
	private String modello;
	private int ram;
	private String cpu;
	private int hd;
	private String tipoHd;
	
	
	public Pc(int id, String marca, int annoProduzione, String modello, int ram, String cpu, int hd, String tipoHd) {
		super(id, marca, annoProduzione);
		
		setModello(modello);
		setRam(ram);
		setCpu(cpu);
		setHd(hd);
		setTipoHd(tipoHd);
	}


	public String getModello() {
		return modello;
	}


	public void setModello(String modello) {
		this.modello = modello;
	}


	public int getRam() {
		return ram;
	}


	public void setRam(int ram) {
		this.ram = ram;
	}


	public String getCpu() {
		return cpu;
	}


	public void setCpu(String cpu) {
		this.cpu = cpu;
	}


	public int getHd() {
		return hd;
	}


	public void setHd(int hd) {
		this.hd = hd;
	}


	public String getTipoHd() {
		return tipoHd;
	}


	public void setTipoHd(String tipoHd) {
		this.tipoHd = tipoHd;
	}
	
	
	
	
	/*e i metodi:
		double prezzo() ---> Ritorna il prezzo del pc(usate i calcoli che volete voi, usate però tutte le proprietà)
		boolean gaming() --> Ritorna true se il la cpu è i7 e il tipoHd è HHD*/
	
	@Override
	public String toString() {
		return super.toString()
				+  "\nModello: " + modello 
				+ "\nRam: " + ram 
				+ "\nCPU: " + cpu 
				+ "\nHD: " + hd 
				+ "\nTipoHd: " + tipoHd
				+ "\n-----------------------------------------------------------\n";
	}


	public double prezzo()
	{
		double prezzo = 1 * hd;
		
		if (getTipoHd().equalsIgnoreCase("ssd"))
			prezzo += 100;
		
		return prezzo;
	}
	
	
	public boolean gaming()
	{
		boolean res = false;
		
		if (getCpu().equalsIgnoreCase("i7") && getTipoHd().equalsIgnoreCase("hhd"))
			res = true;
		
		return res;
	}
	
	
	
	
	
	
	
}
