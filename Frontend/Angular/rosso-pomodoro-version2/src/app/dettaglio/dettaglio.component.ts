import { Component } from '@angular/core';
import { Ricetta } from '../model/ricetta';
import { RicetteService } from '../service/ricette.service';

@Component({
  selector: 'app-dettaglio',
  templateUrl: './dettaglio.component.html',
  styleUrls: ['./dettaglio.component.css']
})
export class DettaglioComponent {

  ricettaNelDettaglio?: Ricetta;

  constructor(private ricetteService: RicetteService){
    this.ricetteService.ricettaSelezionataChanged.subscribe((selezionata) => {
      this.ricettaNelDettaglio = selezionata;
    })
  }

  
}

