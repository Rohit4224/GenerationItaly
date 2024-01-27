/**
 * 
 */
package entities;

import java.util.ArrayList;

/**
 * Per convenzione alcune aziende usa scrivere il nome delle interfaccie con una I e poi il nome 
 * 		delle classi che sfruttano questa interface.
 * Non tutti seguono queste regole, in generale l'importante è seguire le stesse convenzioni che si 
 * 		seguono per la nomenclatura delle classi.
 * 
 * INTERFACCIA/INTERFACE : è un contratto
 * In particulare, le interfaccie stipulano dei contratti tra loro stesse e delle classi.
 * L'accordo tra le due parti si regge su questi presupposti: L'interfaccia fornisce alla classe protezione.
 * e la classe fornisce all'interfaccia l'implementazione dei suoi metodi.
 */

// it can extend another interface
public interface IScuola
{
	/*IMPORTANTE
	 * Le interfaccie recenti assomiglierannno tantissimo a una classe astratta
	 * La differenza è che le interfaccie non possono avere lo stato dell'oggetto, invece la classe 
	 *     astratta  si.
	 * */
	
	// Le interfaccia nel corso delle diversioni sono cambiate molto.
	// Uno scaglione grosso c'è stato tra le versioni precedenti alla 1.8 e le versione 1.8 e successive
	// Nelle versioni più recenti c'è stato un altro grosso passo in avanti, che ha cambiato nuovamente
	//      le possibilità di questo strumento
	
	// le versioni precedenti alla 1.8 permettevano alle interfaccie di possedere
	//     unicamente le firme dei metodi
	
	
	// int age = 24   // final and static
	// interface doesnt have its own memory thats why it cannot save properties in stack memory
	
	public abstract String elenco();
	String elecoDipendentiPendolari();  // by default public and abstract
	ArrayList<Entity> getPersone();
	
	// Dalla versione 1.8 in poi, è stata implementata la possibilità di dare un corpo ai metodi
	// e se scriviamo corpo in interfaccia ci vuole "DEFAULT"
	default String personaPiuVecchia()
	{
		String res = "";
		int max = 0;
		
		for (Entity entity : getPersone())
		{
			if (entity instanceof Dipendente)
			{
				Dipendente d = (Dipendente)entity;
				if (max < d.eta())
				{
					max = d.eta();
					res = d.getNome() + " " + d.getCognome();
				}
				else if (max == d.eta())
					res += "\n" + d.getNome() + " " + d.getCognome();
			}
			
			else if (entity instanceof Studente)
			{
				Studente s = (Studente)entity;
				if (max < s.eta())
				{
					max = s.eta();
					res = s.getNome() + " " + s.getCognome();
				}
				else if (max == s.eta())
					res += "\n" + s.getNome() + " " + s.getCognome();
			}
		}
		return res;
	}

	// nelle versioni più recenti è stata introdotta la possibilità di avere delle proprietà STATICHE
	

}
