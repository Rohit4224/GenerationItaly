package entities;


//questa classe è padre del Auto e Moto
public class Veicolo
{
	//Proprietà
		private String marca;
		private String modello;
		private String colore;
		private int capienzaSerbatoio;
		private double kilometriAlLitro;
	
	public Veicolo(String marca, String modello, String colore, int capienzaSerbatoio, double kilometriAlLitro)
	{
		//super indica che veicolo è figlio di object, e che se vuole potrebbe usare il construttore vuoto
		super();
//		this.marca = marca;
//		this.modello = modello;
//		this.colore = colore;
//		this.capienzaSerbatoio = capienzaSerbatoio;
//		this.kilometriAlLitro = kilometriAlLitro;
		setMarca(marca);
		setModello(modello);
		setColore(colore);
		setCapienzaSerbatoio(capienzaSerbatoio);
		setKilometriAlLitro(kilometriAlLitro);
		
	}
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public int getCapienzaSerbatoio() {
		return capienzaSerbatoio;
	}
	public void setCapienzaSerbatoio(int capienzaSerbatoio) {
		this.capienzaSerbatoio = capienzaSerbatoio;
	}
	public double getKilometriAlLitro() {
		return kilometriAlLitro;
	}
	public void setKilometriAlLitro(double kilometriAlLitro) {
		this.kilometriAlLitro = kilometriAlLitro;
	}
	
	@Override
	public String toString() {
		return "marca: " + marca + "\nmodello: " + modello + "\ncolore: " + colore + "\ncapienzaSerbatoio: "
				+ capienzaSerbatoio + "\nkilometriAlLitro: " + kilometriAlLitro
				+ "\nAutonomia: " + autonomia()
				+ "\n-----------------------------------------------------------";
	}
	
	public double autonomia ()
	{
		return capienzaSerbatoio * kilometriAlLitro;
	}
	
}
