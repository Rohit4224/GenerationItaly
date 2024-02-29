import { Component } from '@angular/core';
import { Student } from '../model/students';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent {

  students: Student [] = [
    {
      name: 'Pierino',
      classRoom: 3,
      ita: 7,
      mate: 6,
      ing: 5,
      info: 8
    },
    {
      name: 'Alice',
      classRoom: 5,
      ita: 10,
      mate: 10,
      ing: 10,
      info: 10
    },
    {
      name: 'Sasha',
      classRoom: 1,
      ita: 6,
      mate: 6,
      ing: 5,
      info: 8
    },
    {
      name: 'Ambrogio',
      classRoom: 3,
      ita: 3,
      mate: 5,
      ing: 2,
      info: 2
    }
  ];

  // prendo il parametro e lo 'pusha'
  // nell'array di oggetti 'students'
  // Questo metodo sarà associato tramite
  // l'event binding al metodo 'studentAdd'
  onAddStudent(stud: Student) {
    // prendo dal parametro è aggiungo all'array
    this.students.push(stud);
  }

}
