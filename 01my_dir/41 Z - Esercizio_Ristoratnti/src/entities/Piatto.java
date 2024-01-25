package entities;

import java.util.Arrays;
import java.util.List;

public class Piatto
{
	//proprieta di classe
	private final static String[] TIPI_VALIDI = {"Antipasto", "Primo", "Secondo", "Dolce"};	
	private final static String[] INGREDIENTI_VALIDI = {"farina", "glutine", "zucchero",
	                                                    "sale", "glutammato", "olio"};
	
	//proprieta di oggetto
	private String nome;
	private String tipo;
	private double prezzo;
	private String[] ingredienti;
	
	//costruttore
	public Piatto(String nome, String tipo, double prezzo, String[] ingredienti)
	{
		setNome(nome);
		setTipo(tipo);
		setPrezzo(prezzo);
		setIngredienti(ingredienti);
	}

	public Piatto() {
		// TODO Auto-generated constructor stub
	}

	//getters setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String[] getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(String[] ingredienti) {
		this.ingredienti = ingredienti;
	}

	
	
	//metodi
	
	@Override
	public String toString() {
		return "Nome: " + nome 
				+ "\nTipo: " + tipo 
				+ "\nPrezzo: " + prezzo 
				+ "\nIngredienti: " + Arrays.toString(ingredienti) 
				+ "\n-----------------------------------------------------------\n";
	}
	
//	> public boolean tipoValido()
//	Restituire true se il tipo
//	del piatto rientra nella lista dei tipi validi
	
	public boolean tipoValido()
	{
		boolean b = false;
		int i = 0;
		while (i < TIPI_VALIDI.length)
		{
			if (TIPI_VALIDI[i].equalsIgnoreCase(getTipo()));
				b = true;
			i++;
		}
		return b;
	}
	
//	> public boolean ingredientiValidi()
//	restituire true se TUTTI gli ingredienti
//	rientrano nella lista di quelli validi
	
	public boolean isValid(String ingredient)
	{
		for (String s : INGREDIENTI_VALIDI) {
			if(ingredient.equalsIgnoreCase(s))
				return true;
		}
		return false;
	}
	
	public boolean ingredientiValidi()
	{
		int i = 0;
		while (i < ingredienti.length)
		{
			if (!isValid(ingredienti[i]))
				return false;
			i++;
		}
		return true;
	}
	
//	> public boolean valido()
//	se il piatto ha sia il tipo valido
//	che gli ingredienti validi
	
	public boolean valido()
	{
		return (tipoValido() && ingredientiValidi());
	}
	
	
//	> public boolean contieneIngrediente(String ingrediente)
//	restituire true se nel vettore degli ingredienti
//	esiste l'ingrediente richiesto
	
	public boolean contieneIngrediente(String ingrediente)
	{
		for (String i : ingredienti) {
			if (ingrediente.equalsIgnoreCase(i));
				return true;
		}
		return false;
	}
	
//	> public boolean contieneIngredienti(String[] ingredienti)
//	restituire true se il vettore contiene
//	TUTTI gli ingredienti del parametro
	
	public boolean contieneIngredienti(String[] ingredienti)
	{
		List<String> ingredientiDiFile = Arrays.asList(getIngredienti());
		
		for (String i : ingredienti)
		{
			if (!(ingredientiDiFile.contains(i.toLowerCase())))
				return false;
		}
		return true;
	}
	
	
}
