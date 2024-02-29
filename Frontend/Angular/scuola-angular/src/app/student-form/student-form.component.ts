import { Component, EventEmitter, Output } from '@angular/core';
import { Student } from '../model/students';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent {

  name: string = '';
  classRoom: number = 0;
  ita: number = 0;
  mate: number = 0;
  ing: number = 0;
  info : number = 0;

  @Output() studentAdd = new EventEmitter<Student>()

  aggiungiStudente() {
    // Quando viene premuto il pulsante
    // 'aggiungi' va a prendere le proprietà
    //  che sono associate ai ccampi di input
    // e ci crea un oggetto di tipo 'student'
    const newStudent: Student = {
      name: this.name,
      classRoom: this.classRoom,
      ita: this.ita,
      mate: this.mate,
      ing: this.ing,
      info: this.info
    }
    // utilizzare 'event emitter' per emettere
    // attraverso il metodo .next il nuovo
    // studente che è stato creato
    this.studentAdd.next(newStudent)
  };

}
