package entities;

import java.util.Map;

import factory.IFactory;

public class Corso extends Entity implements IFactory
{
//	Corsi -> id, nome, totale_ore, numero_lezioni, lingua, materiali(si o no)
	
	private String nome;
	private int totale_ore;
	private int numero_lezioni;
	private String lingua;
	private boolean materiali;
	
	public Corso()
	{
		
	}
	
	public Corso(int id, String nome, int totale_ore, int numero_lezioni,
			String lingua, boolean materiali)
	{
		super(id);
		setNome(nome);
		setTotale_ore(totale_ore);
		setNumero_lezioni(numero_lezioni);
		setLingua(lingua);
		setMateriali(materiali);
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getTotale_ore() {
		return totale_ore;
	}


	public void setTotale_ore(int totale_ore) {
		this.totale_ore = totale_ore;
	}


	public int getNumero_lezioni() {
		return numero_lezioni;
	}


	public void setNumero_lezioni(int numero_lezioni) {
		this.numero_lezioni = numero_lezioni;
	}


	public String getLingua() {
		return lingua;
	}


	public void setLingua(String lingua) {
		this.lingua = lingua;
	}


	public boolean isMateriali() {
		return materiali;
	}


	public void setMateriali(boolean materiali) {
		this.materiali = materiali;
	}


	@Override
	public String toString() {
		return super.toString()
				+ "\nNome: " + nome 
				+ "\nTotale_ore: " + totale_ore 
				+ "\nNumero_lezioni: " + numero_lezioni 
				+ "\nLingua: " + lingua 
				+ "\nMateriali: " + materiali
				+ "\n-----------------------------------------------------------\n";
	}
	
	public void fillObj(Map<String, String> map)
	{
		setId(Integer.parseInt(map.get("id")));
		setNome(map.get("nome"));
		setTotale_ore(Integer.parseInt(map.get("totale_ore")));
		setNumero_lezioni(Integer.parseInt(map.get("totale_ore")));
		setLingua(map.get("lingua"));
		setMateriali(map.get("materiali").equalsIgnoreCase("1"));
		
	}
	
}
