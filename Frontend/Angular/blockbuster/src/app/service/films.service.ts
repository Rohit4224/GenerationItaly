import { Injectable } from "@angular/core";
import { Film } from "../model/film";
import { Subject } from "rxjs";

// 3)CREIAMO IL 'service' E 
// METTIAMO IL DECORATOR
// '@Injectable' PER FORNIRE DATI
// TRAMITE LA 'dependency Injection'
@Injectable({ providedIn: 'root' })
export class FilmsService {

    // 4)METTIAMO I DATI IN FORMA
    // 'private'
    private dati: Film[] = [

        {
            id: 1,
            titolo: 'Titanic',
            genere: 'Horror',
            dataUscita: '1998-01-16',
            vietatoAiMinoriDi18: true,
            durata: 180,
            immagineCopertina: 'https://movieplayer.net-cdn.it/t/images/2009/09/29/la-locandina-di-titanic-7522_jpg_400x0_crop_q85.jpg',
            voto: 8
        },
        {
            id: 2,
            titolo: 'Avatar',
            genere: 'Sci-fi/Azione',
            dataUscita: '2009-06-25',
            vietatoAiMinoriDi18: false,
            durata: 200,
            immagineCopertina: 'https://pad.mymovies.it/filmclub/2008/03/090/locandinapg13.jpg',
            voto: 7
        },
    ];

    // 5)CREIAMO UN METODO 'getFilms'
    // CHE RESTITUISCE UNA COPIA 
    // DEI DATI ORIGINALI.  
    getFilms() {
        return this.dati.slice();
    }

    // 19)METTIAMO UN 'subject' CHE SERVIRA'
    // A NOTIFICARE DAI DATI DI TIPO 'Film[]'
    // (UN ARRAY) A CHIUNQUE LO SOTTOSCRIVA
    filmsChange = new Subject<Film[]>();

    // 26) CREIAMO IL NUOVO SUBJECT
    // PER IL DETTAGLIO
    filmDettaglioChange = new Subject<Film>();


    // 35.1)CREIAMOCI IL 'subject'
    filmDaModificareChange = new Subject<Film>();


    // 11)AGGIUNGIAMO LA PROPRIETA' 
    // 'latId' PER GESTIRLO IN MODO
    // AUTOMATICO PARTENDO DAL NUMERO 3,
    // E CREIAMO IL METODO PER AGGIUNGERE
    // UN FILM 'aggiungiFilm()'
    lastId = 3;

    aggiungiFilm(
        titolo: string,
        genere: string,
        dataUscita: string,
        vietatoAiMinoriDi18: boolean,
        durata: number,
        immagineCopertina: string,
        voto: number)
         {
            const newFilm: Film = {
            id: this.lastId++,
            titolo,
            genere,
            dataUscita,
            vietatoAiMinoriDi18,
            durata,
            immagineCopertina,
            voto
            }
        this.dati.push(newFilm)
        // 20)CHE SERVE A MANDARE TRAMITE IL
        // '.next()' I NUOVI DATI OGNI VOLTA
        //  CHE VENGONO MANIPOLATI
        this.filmsChange.next(this.dati.slice())
    }


    // 25)CREIAMO UN METODO PER VISUALIZZARE 
    // IL DETTAGLIO DI UN FILM, TRAMITE IL 
    // '.next()'
    selezioneFilmDettaglio(film: Film) {
        // 27)COMPLETIAMO IL CORPO DEL METODO
        // AGGIUNDENDO IL 'next()'
        this.filmDettaglioChange.next(film)

    }


    // 32)CREIAMO UN METODO 'eliminaFilm'
    // DOVE CI FAREMO PASSARE L'ID 
    // ED UTILIZZEREMO IM METODO 'findIndex()'
    // CON UN PREDICATO
    eliminaFilm(id: number) {
        const index = this.dati.findIndex(f => f.id === id);

        if (index > -1) {
            this.dati.splice(index, 1)
            // notificare questi dati tramite il subject
            this.filmsChange.next(this.dati.slice());
        }
    }


    // 35)COMINCIAMO A DEFINIRE IL METODO
    // PER MODIFICARE UN FILM.
    // Questo metodo verrà utilizzato dal
    // componente 'lista' quando l'utente andrà 
    // a premere sul pulsante modifica,
    // perchè mi serve banalmente un passacarte
    // tra la 'lista' e la 'form':
    // i dati del film cliccato da modificare alla 'form'
    modificaFilm(film: Film) {
        // 35.2)E USIAMO IL subject EMETTENDO
        // QUESTO VALORE COL METODO 
        // next(), DOVE IL VALORE
        // GLI VIENE PASSATO COME PARAMETRO
        this.filmDaModificareChange.next(film)
    }


    // 40)ECCO IL MEDOTO PER SALVARE
    // E MODIFICARE UN FILM
    salvaModificaFilm(
        id: number,
        titolo: string,
        genere: string,
        dataUscita: string,
        vietatoAiMinoriDi18: boolean,
        durata: number,
        immagineCopertina: string,
        voto: number
    ) {
        const index = this.dati.findIndex(f => f.id === id)

        if (index > -1) {
            const filmModificato: Film = {
                id,
                titolo,
                genere,
                dataUscita,
                vietatoAiMinoriDi18,
                durata,
                immagineCopertina,
                voto
            };
            this.dati[index] = filmModificato;
            this.filmsChange.next(this.dati.slice());
        }
    }
}