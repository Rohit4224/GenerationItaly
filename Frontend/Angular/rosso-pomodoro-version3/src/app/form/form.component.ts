import { Component } from '@angular/core';
import { RicetteService } from '../service/ricette.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {
  
  // 16)INIZIALIZZIAMO IL NOME A STRINGA VUOTA
  nome = "";

  // 17)RICHIAMIAMO IL SERVICE
  // TRAMITE IL COSTRUTTORE
  constructor(private ricetteService: RicetteService,
    // 23)RICHIAMIAMO QUESTA SPECIE SI 'SERVICE'
    // PER POTER FAR CAMBIARE PAGINA AL PROGRAMMA,
    // UNA VOLTA INSERITA LA RICETTA TRAMITE LA FORM
    // IN MODO AUTOMATICO.
    // Se ho necessità di gestire la navigazione tramite TS
    // posso sfruttare il servizio(Router) che mi fornisce gli 
    // strumenti per farlo.
    // Tramite la DI mi faccio fornire il service del router.
    private router: Router) {}

  // 18)E AGGIUNGIAMO UN METODO
  // onClickAggiungi().
  onClickAggiungi() {
    this.ricetteService.addRicetta(this.nome);
    // 21)AGGIUNGIAMO UN console.log, PER DEBUG.
    console.log(this.ricetteService.getRicette());
    // Se io voglio cambiare pagina dopo aver aggiunto
    // la ricetta lo posso fare lato codice.
    // La navigazione di angular può essere gestita 
    // anche lato TS.

    // 24)PER MANDARE ALLA PAGINA PRINCIPALE
    // DOPO AVER AGGIUNTO UNA RICETTA, UTILIZZIAMO
    // IL METODO 'navigateByUrl()' PASSANDOGLI
    // COME ARGOMENTO IL PATH CHE PORTERA'
    // ALLA NOSTRA PAGINA INIZIALE.
    // Possiamo dirgli di tornare sulla home page
    // tramite il metodo 'navigateByUrl()'. 
    this.router.navigateByUrl('/');
  }

}