import { Component } from '@angular/core';
import { Todo } from '../model/todo';
import { TodoService } from '../service/todo.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {

  // Abbiamo copiato la lista presente
  // in questo component è portata sul 'service'
  list: Todo[];

  // Angular nel momento in cui
  // andrà ad istanziare il componenente, passerà
  // attraverso il costruttore il singleton
  // del service richiesto

  
  // constructor(service: TodoService) {
  //   // Facciamo una cosa banale, andiamo a pescare
  //   // la lista dalla proprietà 'dati' del 'service'
  //   this.list = service.dati
  // }

  constructor(private todoService: TodoService) {
    this.list = this.todoService.dati
  }

  // Mi basta andare ad invocare il metodo
  // definito nel service
  cancella(id: number) {
    this.todoService.elimina(id);
  }

  toggle(id: number) {
    this.todoService.tooggleCompletato(id)
  }
 
}
