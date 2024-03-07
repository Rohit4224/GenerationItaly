import { Component } from '@angular/core';
import { Ricetta } from '../model/ricetta';
import { RicetteService } from '../service/ricette.service';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent {

  // 13)CREIAMO UN ARRAY VUOTO, CHE ANDREMO
  // A RIEMPIRE
  ricette: Ricetta[];

  // 13.1)PRENDENDO LA LISTA DELLE RICETTE
  // DAL NOSTRO SERVICE, TRAMITE IL COSTRUTTORE
  constructor(private ricetteService: RicetteService) {
    this.ricette = ricetteService.getRicette();
    // 14) ED EFFETTUIAMO LA SUBSCRIBE PER NOTIFICARE
    // LA MODIFICA DELLE RICETTE.
    // MI SERVE QUALORA VENGA AGGIORNATA LA LISTA
    // PERCHE' LO ABBIAMO INCAPSULATO ALL'INTERNO
    // DEL SERVICE, RENDENDOLA PRIVATA.
    this.ricetteService.ricetteChange.subscribe(
      nuoveRicette => this.ricette = nuoveRicette)
  }

}