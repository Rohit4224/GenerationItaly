import { Component, Input } from '@angular/core';
import { Student } from '../model/students';

@Component({
  selector: 'app-student-card',
  templateUrl: './student-card.component.html',
  styleUrls: ['./student-card.component.css']
})
export class StudentCardComponent {
  // Sfruttiamo un metodo per restituire
  // il valore calcolato tramite i dati in 
  // nostro possesso.
  // Questo :number vuole dire che questo metodo
  // deve restituire un numero, altrimenti 
  // darà arrore
  media(): number {


    // possiamo prendere queste proprietà
    // per il calcolo tramite la 'destructure'(scomporre
    // l'oggetto) e sarebbe in questo modo:
    const { ita, mate, ing, info: informatica} = this.student;
    // Sembra di assegnare un valore ad un oggetto
    // ma in realtà, quando vedete le {} vuol dire
    // che stiamo scomponendo l'oggetto, andando
    // a recuperare le proprietà che ci interessano
    // per l'operazione che ci interessa eseguire

    return (ita + mate + ing + informatica) / 4;

  }

  // Nei casi di valori di input(inizilamente
  // questa proprietà sarà sprovvista di valore)
  // possiamo decidere di usare il 'bang operator( ! )
  // per indicare a TS che questa proprietà avra sempre, in 
  // qualche modo un valore.
  // Anche se a livello di classe la proprietà
  // sembra non assumere mai un valore concreto.
  // In realtà verrà passato un valore tramite @input
  @Input() student!: Student;
}
