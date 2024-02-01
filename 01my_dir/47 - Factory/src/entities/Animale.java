package entities;

import java.util.Map;

import factory.IFactory;

public class Animale extends Entity implements IFactory
{
	private String specie;
	private String nome;
	private String dob;
	private String genere;
	private double peso;
	private boolean vaccinato;
	// private Allevatore allevatore; -> Colleghiamo lato Allevatore, aggiungendogli un List<Animale>
	
	public Animale()
	{
		
	}
	
	public Animale(int id, String specie, String nome, String dob, String genere, double peso, boolean vaccinato) {
		super(id);
		setSpecie(specie);
		setNome(nome);
		setDob(dob);
		setGenere(genere);
		setPeso(peso);
		setVaccinato(vaccinato);
	}

	

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean isVaccinato() {
		return vaccinato;
	}

	public void setVaccinato(boolean vaccinato) {
		this.vaccinato = vaccinato;
	}
	
	
	@Override
	public String toString()
	{
		return super.toString()
				+ "\nSpecie: " + specie 
				+ "\nNome: " + nome 
				+ "\nDob: " + dob 
				+ "\nGenere: " + genere 
				+ "\nPeso: " + peso + "KG"
				+ "\nVaccinato: " + (vaccinato ? "Si" : "No")
				+ "\n-----------------------------------------------------------\n";
	}

	@Override
	public void create(Map<String, String> map)
	{
		setId(Integer.parseInt(map.get("id")));
		setNome(map.get("nome"));
		setSpecie(map.get("specie"));
		setDob(map.get("dob"));
		setGenere(map.get("genere"));
		setPeso(Double.parseDouble(map.get("peso")));
		setVaccinato(map.get("vaccinato").equalsIgnoreCase("1"));
		
	}
	
}
