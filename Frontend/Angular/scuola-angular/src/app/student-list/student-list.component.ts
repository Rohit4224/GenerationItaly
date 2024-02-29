import { Component, Input } from '@angular/core';
import { Student } from '../model/students';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent {

  // In questo modo il dato gli viene passato
  // e non c'è l'ho più in scaffholding
  // Togliamo alla lista la responsabilità 
  // di gestire i dati.
  // Gli arrivano in input perchè devo assegnarlo
  // al componente ceh gestisce sia la 'form'
  // che la 'list', nel nostro caso
  // è ìstudents.component'

  @Input() studentList!: Student []

}
