import { Component } from '@angular/core';
import { TodoService } from '../service/todo.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {
  nuovo = '';

  // Aggiungiamo una proprietà 
  // e creiamo il costruttore:
  service: TodoService;

  // Il costruttore dei 'componenti'
  // mi permette di definire de dipendenze
  constructor(pippo : TodoService) {
    // Attrsverso la DI vado ad assegnare alla
    // proprietà il singleton che arriva
    // dalla DI.
    // Inquesto caso sono costretto ad assegnarlo
    // ad una mia proprietà perchè ne avroò bisogno
    // in un secondo momento, quando
    // verrà premuto il pulsante (metodo Add)
    this.service = pippo;
  }

  add() {
     console.log(this.nuovo);
    this.service.addNew(this.nuovo);
  }

}
