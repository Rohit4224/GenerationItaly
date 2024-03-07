import { Injectable } from '@angular/core';
import { Ricetta } from '../model/ricetta';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RicetteService {

  // 9)FACCIAMO UN ARRAY IN FORMA 'PRIVATE'
  // PER LE NOSTRE RICETTE, CON DATI
  // DI scaffholding.
  private ricette: Ricetta[] = [
    {
      id: 1,
      nome: 'Parmigiana'
    },
    {
      id: 2,
      nome: 'Lasagne'
    },
  ];

  // 11.1)E CI CREIAMO LA PROPRIETA'
  // lastId PER POTERLA USARE NEL METODO
  // CHE AGGIUNGE UNA RICETTA, PER L'INCREMENTO
  // AUTOMATICO A PARTIRE DALL'ID 3.
  private lastId = 3;


  // 12)CREIAMOCI IL 'subject' GIA' CHE 
  // CI SIAMO
  ricetteChange = new Subject<Ricetta[]>();


  // 10)FACCIAMO IL METODO PER RESTITUIRE
  // IL NOSTRO ARRAY FUORI DALLA SUA CLASSE, 
  // UNA SUA COPIA IN REALTA, TRAMITE IL METODO
  // '.slice()'.
  getRicette() {
    return this.ricette.slice();
  }

  // 11)CREIAMOCI IL METODO PER AGGIUNGERE
  // UNA RICETTA AL NOSTRO ARRAY
  addRicetta(nome: string) {

    const nuovaRicetta: Ricetta = {

      id: this.lastId++,
      nome
    };
    this.ricette.push(nuovaRicetta);
    // 12.1) E AGGIUNGIAMO IL   next() PER
    // MANDARE QUESTI DATI 
    this.ricetteChange.next(this.ricette.slice());
  }


  // 34)CREIAMO UN METODO PER PRENDERE
  // LA RICETTA IL CUI ID E' UGUALE
  // A QUELLO RICERCATO.
  // Questo metodo mi servirà poi
  // nel dettaglio per recuperare i
  // dati completi della ricetta tramite l'id
  // che gli viene passato attraverso 
  // la 'path variable'.
  getRicetta(id: number) {
    return this.ricette.find(r => r.id === id)
  }
  
}