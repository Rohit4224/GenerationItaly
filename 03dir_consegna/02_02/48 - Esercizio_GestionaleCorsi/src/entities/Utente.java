package entities;

import java.util.List;
import java.util.Map;

import dao.DAOCorso;
import factory.IFactory;

public class Utente extends Entity implements IFactory
{
//	Utenti -> id, nome, cognome, dob, azienda(mi basta il nome), mansione, corsoFrequentato(FK)
	
	private String nome;
	private String cognome;
	private String dob;
	private String azienda;
	private String mansione;
	private Corso corsoFrequentato;
	
	public Utente ()
	{
		
	}
	
	public Utente(int id, String nome, String cognome, String dob, String azienda,
				String mansione, Corso corsoFrequentato)
	{
		super(id);
		
		setNome(nome);
		setCognome(cognome);
		setDob(dob);
		setAzienda(azienda);
		setMansione(mansione);
		setCorso(corsoFrequentato);
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getAzienda() {
		return azienda;
	}


	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}


	public String getMansione() {
		return mansione;
	}


	public void setMansione(String mansione) {
		this.mansione = mansione;
	}


	public Corso getCorso() {
		return corsoFrequentato;
	}


	public void setCorso(Corso corsoFrequentato) {
		this.corsoFrequentato = corsoFrequentato;
	}


	@Override
	public String toString() {
		return super.toString()
				+ "\nNome: " + nome 
				+ "\nCognome: " + cognome 
				+ "\nDob: " + dob 
				+ "\nAzienda: " + azienda 
				+ "\nMansione: " + mansione 
				+ "\nID del corso frequentato: " + corsoFrequentato.getId()
				+ "\n-----------------------------------------------------------\n";
	}

	public Corso findObjectById( int targetId)
	{
		DAOCorso c = DAOCorso.getInstance("GestionaleFormazione");
		List<Entity> objectList = (c.read());
		
        for (Entity obj : objectList)
        {
            if (obj instanceof Corso && ((Corso)obj).getId() == targetId)
            {
                return (Corso)obj; // Found the object with the specified ID
            }
        }
        return null;
	}
	
	@Override
	public void fillObj(Map<String, String> map)
	{
		setId(Integer.parseInt(map.get("id")));
		setNome(map.get("nome"));
		setCognome(map.get("cognome"));
		setDob(map.get("dob"));
		setAzienda(map.get("azienda"));
		setMansione(map.get("mansione"));
		
		Corso found = findObjectById(Integer.parseInt(map.get("corsofrequentato")));
				
		setCorso(found);
	}
	
	
	
	
}
