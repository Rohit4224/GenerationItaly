import { Component } from '@angular/core';
import { FilmsService } from '../service/films.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {
  // 41)METTIAMO UN BOOLENAO
  // PER TRACCIARE QUANDO VOGLIAMO 
  // EFFETTUARE LA MODIFICA
  isEditMode = false;

  // 44)INSERIAMO LA PROPRIETA'
  // CHE UTILIZZEREMO PER CAPIRE 
  // QUALE FILM VOGLIMO MODIFICARE
  // ATTRAVERSO L'ID.
  // Lo imposto ad un valore di dafault che non
  // sia un id (per noi gli id sono solo numeri
  // interi positivi)
  idFilmDaModificare = -1;

  // 13) PROPRIETA' CHE ANDREMO AD ASSOCIARE
  // SUL TEMPLATE DELLA 'form' TRAMITE IL
  // 'two-way binding', PER INSERIRE I DATI
  // TRAMITE INPUT
  titolo = '';
  genere = '';
  dataDiUscita = '';
  vietatoAiMinori = false;
  durata = 0;
  copertina = '';
  voto = 0;


  // 16)CREIAMO IL COSTRUTTORE
  // PER RICHIAMARE IL 'service'
  // CON TUTTI I SUOI METODI E PROPRIETA'
  constructor(private filmsService: FilmsService) {
    // 38)ED EFFETTUO LA SOTTO-SCRIZIONE 
    // NEL COSTRUTTORE, AL SUBJECT 'filmDaModificareChange'
    // CHE GESTISCE I FILM DA MODIFICARE (daModificare),
    // PER ADESSO FACCIAMO SOLO UNA console.log(daModificare)
    // E VEDIAMO CHE SUCCEDE. 
    this.filmsService.filmDaModificareChange.subscribe(daModificare => {
    // console.log(daModificare)
    //39)VADO A VALORIZZARE CON I DATI DEL FILM
    // DA MODIFICARE LE PROPRIETA' CHE SONO ASSOCIATE
    // AI VARI INPUT TRAMITE IL TWO-WAY BINDING
      this.titolo = daModificare.titolo;
      this.genere = daModificare.genere;
      this.dataDiUscita = daModificare.dataUscita;
      this.vietatoAiMinori = daModificare.vietatoAiMinoriDi18;
      this.durata = daModificare.durata;
      this.copertina = daModificare.immagineCopertina;
      this.voto = daModificare.voto;
      // 42) INSERIRE LA PROPRIETA'
      // 'isEditMode' A TRUE
      // Ogni volta che arriva un nuovo dato dal subject
      // so che è stata richiesta la modifica
      this.isEditMode = true;
      // 45) RICHIAMIAMO L'ID DEL FILM DA MODIFICARE
      // E LO ASSEGNAMO ALLA NOSTRA PROPRIETA'
      // 'idFilmDaModifare', COSI AVREMO IL NOSTRO
      // FILM CHE VOGLIAMO MODIFICARE ARRIVATO COME PARAMETRO
      // DALLA CALLBACK 'daModificare'.
      // Anche l'id perchè servirà in fase di salvataggio
      // della modifica
      this.idFilmDaModificare = daModificare.id;
  });
  }


  // 17)E CREIAMO IL METODO 'aggiungi'
  // IL QUALE PRENDE DAL 'service'
  // IL METODO 'aggiungiFilm'
  aggiungi() {
    this.filmsService.aggiungiFilm(
      this.titolo,
      this.genere,
      this.dataDiUscita,
      this.vietatoAiMinori,
      this.durata,
      this.copertina,
      this.voto
    );
    //Debug
    console.log(this.filmsService.getFilms());
    // 48)  RICHIAMIAMO IL METODO
    // PER PULIRE LA FORM DA EVENTUALI
    // INSERIMENTI
    this.resetForm();
  }


  // 43)COMINCIAMO A DEFINIRE L'INIZIO
  // DEL METODO, RICHIAMANDO 'salvaModificaFilm'.
  // CI ACCORGIAMO PERO'CHE CI VIENE RICHIESTO
  // ANCHE L'ID, PER CUI DOVREMO PASSARGLIELO
  // IN QUALCHE MODO.
  onCLickModifica() {
    this.filmsService.salvaModificaFilm(
      // 46)E TERMINIAMO IL METODO
      // AGGIUNGENDO L'ID DEL FILM DA MODIFICARE
      // PASSANDOLO AL METODO 'salvaModificaFilm'
      this.idFilmDaModificare,
      this.titolo,
      this.genere,
      this.dataDiUscita,
      this.vietatoAiMinori,
      this.durata,
      this.copertina,
      this.voto
    );
    // 48.1)ANCHE QUA RICHIAMIAMO
    // IL METODO PER PULIRE LA FORM
    this.resetForm();
  }

  // 47)CREIAMO QUESTO METODO, CHE ALTRO
  // NON FA CHE PULIRE LA FORM,
  // INSERENDO I DATI DI DEFAULT.
  // Metodo che vado ad invocare per
  // 'pulire' la form.
  private resetForm() {
    this.isEditMode = false;
    this.idFilmDaModificare = -1;
    this.titolo = '';
    this.genere = '';
    this.dataDiUscita = '';
    this.vietatoAiMinori = false;
    this.durata = 0;
    this.copertina = '';
    this.voto = 0;

  }

}
