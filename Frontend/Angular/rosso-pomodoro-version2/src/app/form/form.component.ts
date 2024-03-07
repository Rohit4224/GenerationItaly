import { Component } from '@angular/core';
import { RicetteService } from '../service/ricette.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {

  nome = '';
  categoria = '';
  descrizione = '';
  immagine = '';

  constructor(private ricetteService: RicetteService) {}

  onAggiungi() {
    this.ricetteService.aggiungiRicetta(
      this.nome,
      this.categoria,
      this.descrizione,
      this.immagine
    );
    console.log(this.ricetteService.getRicette());
  }


} 
// fine classe
