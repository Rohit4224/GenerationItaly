package entities;

import java.time.LocalDate;

public abstract class Articolo extends Entity
{
	// con le proprietà:
	//String marca, int annoProduzione
	private String marca;
	private int annoProduzione;
	
	public Articolo(int id, String marca, int annoProduzione)
	{
		super(id);
		setMarca(marca);
		setAnnoProduzione(annoProduzione);
	}

	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getAnnoProduzione() {
		return annoProduzione;
	}


	public void setAnnoProduzione(int annoProduzione) {
		this.annoProduzione = annoProduzione;
	}
	
	
	//int eta() -> Ritorna da quanti anni è in giro l'articolo
	//abstract double prezzo();
	
	public int eta()
	{
		return (LocalDate.now().getYear() - annoProduzione);
	}
	
	
	
	@Override
	public String toString() {
		return super.toString()
				+"\nMarca: " + marca + "\nAnnoProduzione: " + annoProduzione
				+ "\n-----------------------------------------------------------";
	}

	public abstract double prezzo();
	
}
