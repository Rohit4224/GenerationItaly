package entities;

public class Persona
{
	// La proprietà o i metodi che sono veri per la categoria e non per il caso specifico,
	  	// vengono definiti DI CLASSE
	//sia la proprietà che i metodi di classe in java vengono riconosciuto grazie alla 
	       //parolina STATIC
	//spesso l'uso di proprieta o metodi static si limita a fare controlli per prevenire la creazione
			//di oggetti errati
	public static int etaMin = 0;
	public static int etaMax = 150;
	
	public static boolean valida(int eta)
	{
		if (!(etaMin < eta && eta < etaMax))
		{
			System.out.println("ETA NON VALIDA");
			return false;
		}
		else 
			return true;
	}
	
	private static String[] provincie = {"MI","LO","MB","CO","VA","LC","BG","BS","SO"};
	
	private static boolean valida (String provincia)
	{
		for (String s : provincie) {
			if (s.equalsIgnoreCase(provincia))
				return true;
			
		}
		System.out.println("PROVINCIA NON VALIDA");
		return false;
	}
	
	public static boolean valida(int eta, String provincia)
	{
		return valida(eta) && valida(provincia);
	}
	
	// Spesso static viene scritto insieme alla parola FINAL
		// STATIC e FINAL esistono in modo indipendente l'uno dall'altro.
		// FINAL indica una proprietà il cui valore non potrà mai essere sovrascritto se non 
		//	nel codice originale, nello specifico nella riga in cui do il valore.
		// Per quanto riguarda i metodi FINAL impedisce l'override dei figli.
		
		public final String COMUNE_CAPOLUOGO = "ROMA";
		
		// Spesso sta associato a STATIC per rendere la proprietà di classe, e poterla usare anche senza oggetti
		// Per convenzione i final sono scritti di solito in CAPS e gli static hanno in automatico il corsivo.
		public static final String CAPOLUOGO = "Milano";
		
		public static final boolean valida(String nome, String cognome)
		{
			if(nome.length()> 2 && cognome.length() > 4)
				return true;
			
			System.out.println("Nominativo Errato");
			return false;
		}
	
	// Stato dell'oggetto
	//=> E' l'insieme dei valori delle proprietà di un oggetto in un dato momento
	
	// Proprieta dell'oggetto: perche il loro valore ha senso solo in realzione con la creazione
			// di un nuovo oggetto.
	private String nome;
	private String cognome;
	private String provincia;
	private String comune;
	private int eta;
	
	public Persona(String nome, String cognome, String provincia, String comune, int eta)
	{
		setNome(nome);
		setCognome(cognome);
		setProvincia(provincia);
		setComune(comune);
		setEta(eta);
		
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	@Override
	public String toString() {
		return "Nome: " + nome 
				+ "\nCognome: " + cognome 
				+ "\nProvincia: " + provincia 
				+ "\nComune: " + comune
				+ "\nEta: " + eta;
	}
	
	
	
}
