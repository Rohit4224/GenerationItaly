package entities;


// le classi modello devono cercare di essere il più aderenti possibile
// alla tabelle che vogliono rappresentare
public class Persona extends Entity
{
		//Esistono molto sistemi automatici che sono in grado di asseganre da soli
				// i valori letti nelle colonne SQL aglle proprietà degli oggetti Java.
				// per far funziona bene questi sistemi però dovete fare in modo che la colonna SQL
				// e la proprieta java si chiamano nello stesso modo.
	
		//PROPRIENTA' in java							//COLONNE in SQL
		//id appartiene a Entity		//	id INT PRIMARY KEY AUTO_INCREMENT,
		private String nome;		   //    nome VARCHAR(150),
		private String cognome;        //    cognome VARCHAR(150),
		private String dob; 		   //    dob DATE,
		private String residenza;      //    residenza VARCHAR(200),
		private String genere;         //    genere CHAR,
		private String professione;    //    professione VARCHAR(250) 
		
		
		public Persona(int id, String nome, String cognome, String dob, String residenza, String genere,
				String professione) {
			super(id);
			setNome(nome);
			setCognome(cognome);
			setDob(dob);
			setResidenza(residenza);
			setGenere(genere);
			setProfessione(professione);
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome)
		{
			if (nome.length() <= 150)
				this.nome = nome;
			else
				this.nome = nome.substring(0, 150);
		}


		public String getCognome()
		{
			return cognome;
		}


		public void setCognome(String cognome)
		{
			if (cognome.length() <= 200)
				this.cognome = cognome;
			else
				this.cognome = cognome.substring(0, 200);
		}


		public String getDob() {
			return dob;
		}


		public void setDob(String dob)
		{
			if (dob.length() == 10)
				this.dob = dob;
			else
				this.dob = null;
		}


		public String getResidenza() {
			return residenza;
		}


		public void setResidenza(String residenza)
		{
			if (residenza.length() <= 200)
				this.residenza = residenza;
			else
				this.residenza = residenza.substring(0, 200);
		}


		public String getGenere() {
			return genere;
		}


		public void setGenere(String genere)
		{
			if (genere.length() == 1)
				this.genere = genere;
			else if (genere.toLowerCase().startsWith("m") || genere.toLowerCase().startsWith("f"))
				this.genere = genere.substring(0,1);  //  è sbagliato (0,0)
			else
				this.genere = "A";
		}


		public String getProfessione() {
			return professione;
		}


		public void setProfessione(String professione)
		{
			if (professione.length() <= 250)
				this.professione = professione;
			else
				this.professione = professione.substring(0, 250);
		}


		@Override
		public String toString() {
			return super.toString()
					+ "Nominativo: " + nome + " " + cognome 
					+ "\nNato il: " + dob 
					+ "\nResidente a : " + residenza
					+ "\nGenere: " + genere.toUpperCase() 
					+ "\nProfessione: " + professione
					+ "\n-----------------------------------------------------------\n";
		}
		
		
		
}
