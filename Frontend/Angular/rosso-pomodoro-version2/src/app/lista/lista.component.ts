import { Component } from '@angular/core';
import { RicetteService } from '../service/ricette.service';
import { Ricetta } from '../model/ricetta';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent {
  lista: Ricetta[];

  constructor(private ricetteService: RicetteService) {

    this.lista = this.ricetteService.getRicette();

    // Visto che abbiamo bisogno di aggiornre
    // i dati ogni volta che il service ne manda 
    // fuori di nuovi, ic sottoiscriviamo
    // al 'subject' di riferimento.
    this.ricetteService.ricetteChanged.subscribe((nuoveRicette) => {
      // Attraverso la callback che passiamo al metodo
      // 'subscribe', possiamo operare sui valori che
      // vengono emessi tramite il metodo '.next' del subject.
      // Banalmente lo prendiamo e lo sottoiscriviamo ai 
      // dati esistenti
      this.lista = nuoveRicette;
    });

    
  }
  
  onClickDettaglio(ricetta: Ricetta) {
    this.ricetteService.selezionaDettaglio(ricetta);
  }

  // test() {
  //   console.log(this.lista === this.ricetteService.getRicette());
  //   this.lista.push({id: 3, nome:'Prova1', descrizione: 'Prova2', categoria: 'Prova3', immagine: ''});
  //   console.log(this.lista);
  //   console.log(this.ricetteService.getRicette())
  //   console.log(this.lista === this.ricetteService.getRicette());
  // }
}
