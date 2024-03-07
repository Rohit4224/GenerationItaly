import { Injectable } from "@angular/core";
import { Ricetta } from "../model/ricetta";
import { Subject } from "rxjs";

@Injectable({providedIn: 'root'})
export class RicetteService {
    private ricette: Ricetta[] = [
        {
            id: 1,
            nome: 'Pasta al pomodoro',
            categoria: 'Primo',
            descrizione: 'Pasta con passata di pomodoro e basilico',
            immagine: 'https://www.giallozafferano.it/images/221-22163/Spaghetti-al-pomodoro_650x433_wm.jpg'
        },
        {
            id: 2,
            nome: 'Bistecca',
            categoria: 'Secondo',
            descrizione: 'Non adatto ai vegani',
            immagine: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUCUusK06DyMaU0s6CH0kpc6smcFzIhtkPbVdjD_-WrTWB9EQgpeOO9MYHqK6eTuBm5AE&usqp=CAU'
        }
    ];

    // Esponiamo le ricette attraverso un getter
    // Il public e di default, potremo anche ometterlo
    public getRicette(): Ricetta[] {

        // return this.ricette;
        return this.ricette.slice();
        // Possiamo provare ad impedire l'accesso diretto
        // all'array priginale andando a restituire
        // una copia, grazie al metodo 'slice()'

    }

    private lastId = 3;

    ricettaSelezionataChanged = new Subject<Ricetta>();

    aggiungiRicetta(nome: string, categoria: string, descrizione: string, immagine: string) {
        const nuovaRicetta: Ricetta = {
            id: this.lastId++,
            nome,
            categoria,
            descrizione,
            immagine
        };
        this.ricette.push(nuovaRicetta);

        this.ricetteChanged.next(this.ricette.slice());
    }
    // 'Subject' e simile all' event emitter (in realtà 
    // event emitter estende subject), rd è una classe
    // che mi permette di sfruttare il pattern 'Observer'
    // Non è colui che ha bisogno dei dati che li chiede,
    // ma al contrario è colui che fornsce i dati a mandarli.
    // Sunject è parte della libreria 'RXJS'
    // che implementa una serie di strumenti
    // per la programmazione reattiva
    ricetteChanged = new Subject<Ricetta[]>();
    // Lo andremo ad utilizzare tutte le volte che
    // vorremmo notificare della disponibilità
    // di nuovi dati, per esempio quando viene 
    // aggiunta una nuova ricetta

    selezionaDettaglio(ricetta: Ricetta) {
        this.ricettaSelezionataChanged.next(ricetta);
    }

}