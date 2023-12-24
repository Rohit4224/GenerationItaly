//				LAVORO DI GRUPPO - Consegna entro il 29 sera
//				
//In un file, scrivere le seguenti informazioni:
//10,5
//paziente,nome,cognome,dob,cittàresidenza,patologia,reparto,contagioso(bool),probabilità di morte(numero)
//medico,nome,cognome,dob,cittaResidenza,reparto,anniDiEsperienza,pazientiCurati,pazientiPersi
//
//ESEMPIO File
//1,1
//paziente,Pino,Pane,28-08-1945,Milano,Raffreddore Radioattivo,Malattie Infettive,S,40
//medico,Giulio,Cesare,10-03-1925,Bergamo,Cardiologia,67,9,999
//
//Scrivere le classi modello Paziente che avrà le proprietà indicate nel file e i metodi:
//- costruttore,
//- scheda,
//- rischioZombificazione -> restituisce true nel caso in cui il paziente sia contagioso e abbia un rischio di morte superiore all'80%
//- maCheCiFaiQui -> restituisce true nel caso in cui la patoligia sia Raffreddore, Tosse, Mal di gola, mal di testa e il rischio di morte si inferiore al 20%
//- casoRaro -> restituisce true se è stato ricoverato in un reparto tra psichiatria, neurologia, nefrologia
//
//Scrivere la classe modello Medico che avrà le proprietà indicate nel file e i metodi:
//- costruttore
//- scheda
//- buon -> restituisce true se ha salvato in totale più dell'80% dei suoi pazientiCurati
//- cattivo -> restitusce true se ha perso più del 50% dei suoi pazienti totali
//- killer -> se è cattivo e inoltre ha più di 20 anni di esperienza
//
//Scrivere una classe Ospedale che legga il file e salvi i dati nei vettori di oggetti corretti.
//Scrivere poi i metodi:
//- listaPazienti() -> Tutte le schede dei soli pazienti
//- listaMedici() -> Tutte le schede dei soli medici
//- listaCompleta() -> Tutte le schede dei medici e dei pazienti
//- nominativiKiller() -> il nominativo dei medici killer
//- cerca(String nome, String cognome) -> fate vedere le schede del medico/paziente cercato
//- cerca(String patologia) -> fate vedere i nominativi dei pazienti con quella patologia
//- rischiosi() -> voglio vedere i nominativi dei pazienti a rischio zombificazione
//- statistichePazienti() -> voglio vedere il conteggio di pazienti gravi(quelli con uin rischio sopra l'80%), il conteggio dei pazienti lievi
//				
//Scrivere un Main che permetta all'utente di chiedere tutti i metodi dell'aggregatore.
//
//ATTENZIONE!
//	Fate in modo che il programma sia a prova di bomba (cioè fate in modo che sia quasi impossibile farlo crashare)
//


package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
