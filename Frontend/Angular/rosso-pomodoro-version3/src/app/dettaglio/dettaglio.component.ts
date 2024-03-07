import { Component } from '@angular/core';
import { Ricetta } from '../model/ricetta';
import { RicetteService } from '../service/ricette.service';
import { ActivatedRoute } from '@angular/router';
import { subscribeOn } from 'rxjs';

@Component({
  selector: 'app-dettaglio',
  templateUrl: './dettaglio.component.html',
  styleUrls: ['./dettaglio.component.css']
})
export class DettaglioComponent {

  // 26)METTIAMO DEI DATI DI PROVA ***
  // ricetta: Ricetta = {
  //   id: 1,
  //   nome: 'Lasagna'
  // }; 

  // 35)COMMENTIAMO I DATI DELLA RICETTA
  // CHE STANNO SOPRA***
  // SENZA CONCRETIZZARLA, METTENDOLO
  // 'nullable', CIOE' CON IL PUNTO
  // INTERROGATIVO.
  ricetta?: Ricetta;

  constructor(private ricetteService: RicetteService,
    // 38)MI FACCIO PASSARE UN ALTRO SERVIZIO:
    // "ActivatedRoute", UN SERVIZO CHE FORNISCE
    // INFORMAZIONI SUL PERCORSO ATTIVO
    // Questo servizio fornisce informazioni
    // sul percorso attivato.
    // Mi serve per andare a ricavare le informazioni
    // che ho 'codificato' nel path l'id della ricetta
    // quando vado su /dettaglio/:id 
    private route: ActivatedRoute
    ) {
      // 39)FACCIAMO UNA subscrive CON PARAM, 
      // POI RICHIAMIAMO IL SERVICE, PER FARCI DARE
      // LA RICETTA CON L'ID SEGNATO SU params E
      // LO ASSEGNAMO ALLA NOSTRA ricetta.
      this.route.params.subscribe(params => {
        const id = +params['id'];
        // Prendo l'ID che ricavo dai 'params' e 
        // lo utilizzo per richiedere al service la 
        // ricetta corrispondente.
        // Il simbolo '+' davanti ad una variabile è
        // una 'shorthand' per il parsing ad un numero.
        this.ricetta = this.ricetteService.getRicetta(id);
        console.log(params)
      });
    }

}