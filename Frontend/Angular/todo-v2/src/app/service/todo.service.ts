

import { Injectable } from "@angular/core";
import { Todo } from "../model/todo"

// In Angular possiamo utilizzare dei 'service'
//a cui affidiamo la gestione dei dati, invece
// di gestire tutto tramite i vari componenti, è
// cioè andiamo a centralizzare il processo.
// Tutto deve passare da qui, sarà il nostro
// service' il responsabile della BusinessLogic.
// Nel nostro cosa gestirà la lista, l'inserimento
// dei nuovi 'todo', l'eliminazione di quelli esistenti
// è la modifica (effettuerà un 'tooggle' su completato)
// di un todo

// Questo decorator permette di rendere questa
// classe un 'service'.
// Mi permette di utilizzzare la dependency injection (DI).
// Un pattern che consiste nel togliere la responsabilità
// ad un oggetto, di istanziarne le dipendenze
@Injectable({
    providedIn: 'root'
})
export class TodoService {

  dati: Todo[] =  [ { id: 1,
        descrizione: 'Fare la spesa',
        completato: false
       },
       {
        id:2,
        descrizione: 'Bagnare le piante',
        completato: true
       },
  ];


  lastId = 3;

  addNew(todo: string) {
    // Creo un nuovo todo usando i dati
    // che arrivano al metodo
    const newTodo: Todo = {
        // Ho usato 'lastId' che tiene
        // traccia dell'ultimo id generato
        id: this.lastId++,
        descrizione: todo,
        completato: false
    };
    // Non mi resta che andare a pushare
    // sull'array
    this.dati.push(newTodo);
  }

//   Creiamo il metodo 'elimina()'
// passandogli un id di tipo 'number',
// è attraverso la funzione 'findIndex()'
// a cui passo un predicato (na funzione che 
// restituisce un BOOLEANO) è restituirà ò'indice
// del primo elemento che soddisfa il predicato
  elimina(id: number) {
    // Cerco l'indice tramite l'id del todo.
    // Grazie ad un metodo esistente di JS 'findIndex()'
    // acui passo un predicato (una funzione che 
    // restituisce un BOOLEANO) è restituirà l'indice
    // del primo elemento che soddisfa il predicato
    const todoIndex = this.dati.findIndex(x => x.id === id)
    // this.dati.splice(todoIndex, 1)
    // Qualora non trovasse nulla => -1
    // non faccio partire lo splice()
    if (todoIndex > -1) {
        this.dati.splice(todoIndex, 1)
    }
  }

//   Vado acapovolgere il valore
// booleano di completato
  tooggleCompletato(id: number) {
    const todo = this.dati.find(x => x.id === id)

    if (todo) {
        todo.completato = !todo.completato;
    }
  }

}