import { Component } from '@angular/core';
import { Film } from '../model/film';
import { FilmsService } from '../service/films.service';

@Component({
  selector: 'app-dettaglio-film',
  templateUrl: './dettaglio-film.component.html',
  styleUrls: ['./dettaglio-film.component.css']
})
export class DettaglioFilmComponent {

  // 22)DEFINIAMO UNA PROPRIETA' 'dettaglio'
  // CHE POTREBBE ESSERE 'UNDEFINED',
  // DI TIPO 'Film', E AGGIUNGIAMO
  // UN DATO DI PROVA***
  dettaglio?: Film;
  // 30)ADESSO TOGLIAMO I DATI DI PROVA,
  // PERCHE' FAREMO IN MODO CHE PRENDA
  // QUELLI CHE ARRIVANO DAL 'service'
  // E METTIAMO UN COSTRUTTORE, SEMPRE
  // PER RICHIAMARE IL service.
  constructor(private filmsService: FilmsService) {
    // 31) ED EFFETTUIAMO LA subscribe
    this.filmsService.filmDettaglioChange.subscribe(f => this.dettaglio = f)

  }
  
  
  //  ***  = {
  //     id: 1,
  //     titolo: 'Titanic',
  //     genere: 'Horror',
  //     dataUscita: '1998-01-16',
  //     vietatoAiMinoriDi18: true,
  //     durata: 180,
  //     immagineCopertina: 'https://movieplayer.net-cdn.it/t/images/2009/09/29/la-locandina-di-titanic-7522_jpg_400x0_crop_q85.jpg',
  //     voto: 8
  // }; ***










}
