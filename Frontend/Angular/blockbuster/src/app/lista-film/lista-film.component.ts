import { Component } from '@angular/core';
import { Film } from '../model/film';
import { FilmsService } from '../service/films.service';

@Component({
  selector: 'app-lista-film',
  templateUrl: './lista-film.component.html',
  styleUrls: ['./lista-film.component.css']
})
export class ListaFilmComponent {

  // 6)DEFINIAMO UNA PROPRIETA' 'films'
  // NELLA QUALE PORTEREMO I DATI PRESI 
  // DAL 'service' TRAMITE IL METODO
  // 'getFilms', CON IL COSTRUTTORE
  films: Film[];

  constructor(private filmsService: FilmsService) {
    this.films = this.filmsService.getFilms();
    // 21)EFFETUIAMO LA 'subscrive', DI MODO
    //  DA RICEVERE DAL METODO 'next()' DEL NOSTRO
    // 'service' I NUOVI DATI AGGIORNATI,
    // ED INSERIRLI NELLA NOSTRA LISTA DI 'films'
    this.filmsService.filmsChange.subscribe(nuoviDati => this.films = nuoviDati)
  }

  // 8)CREIAMO UN METODO PER SPLITTARE
  // LA DATA DI USCITA, E PRENDERE SOLO
  // L'ANNO.
  getAnnoUscita(dataUscita: string) {
    return dataUscita.split('-')[0];
  }

  // 29)DEFINIAMO IL COMPORTAMENTO DEL METODO
  // DI onCLickDettaglio
  onClickDettaglio(film: Film) {
    this.filmsService.selezioneFilmDettaglio(film)
  }


  // 33)CREO IL METODO ELIMINA 
  // DA CUI RICHIAMERA' DAL SERVICE
  // IL METODO 'eliminaFilm' PASSANDOGLI
  // UN ID
  onClickElimina(id: number) {
    this.filmsService.eliminaFilm(id);
  }


  // 37)E COLLEGHIAMO IL METODO 
  // AL BOTTONE PRESENTE SUL NOSTRO 
  // TEMPLATE DI lista-film.
  onClickModifica(film: Film) {
    this.filmsService.modificaFilm(film)
  }

}
