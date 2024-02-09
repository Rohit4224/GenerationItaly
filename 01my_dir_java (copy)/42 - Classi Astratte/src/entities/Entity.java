package entities;

// Classe modello : Questa classe rispecchia la colonna id PK delle tabelle di SQL.
// un oggetto solo Entity però non mi serve a nulla, la classe mi serve solo dal punto di vista
// strutturale. Per questo motivo rendo la classe ASTRATTA con termine "ABSTRACT"
// Le classi astratte funzionano come classi "normali" (classi concrete) tranne che impediscono la
// creazione di oggetto (nella pratica non potremo mai fare Entity e = new Entity())
// La caratteristica ABSTRACT non si eredita, eridita solo abstract

public abstract class Entity
{
//	public Entity() {
//		// TODO Auto-generated constructor stub
//	}
	
	private int id;
	
	public Entity(int id)
	{
		setID(id);
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public String toString()
	{
		return "\n\tID " + id;
	}
	
	public abstract double bonus();
}
