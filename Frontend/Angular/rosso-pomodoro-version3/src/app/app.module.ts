import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListaComponent } from './lista/lista.component';
import { FormComponent } from './form/form.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { DettaglioComponent } from './dettaglio/dettaglio.component';

// 1)CREIAMO QUESTA COSTANTE, CHE SARA'
// IL NOSTRO ARRAY CHE DESCRIVE LE REGOLE
// DI NAVIGAZIONE.
// 'Routes' è soltanto un alias per Route[]
const routes: Routes = [
  // 2)ED INSERIRE QUESTI OGGETTI
  // ALL'INTERNO DEL NOSTRO ARRAY
  // CHE SONO IL 'path' E 'component'.
  // Questi oggetti servono a configurare
  // le regole di navigazione. Di base 
  // abbiamo bisogno almeno del percorso e del 
  // corrispettivo componente
  // da renderizzare.
  {
    path: '',
    component: ListaComponent
  },
  {
    path: 'nuova-ricetta',
    component: FormComponent
  },
  // 28)METTIAMO UN NUOVO PATH CHE PUNTI
  // AL NOSTRO NUOVO COMPONENTE, CHE SI 
  // CHIAMA 'dettaglio'.
  // Praticamente abbiamo definito
  // delle regole di navigazione.
  {
    // ******path: 'dettaglio',
    // 31)ATTENZIONE: QUESTO PATH SERVE 
    // PER MOSTRARE COME FUNZIONA 
    // LA NAVIGAZIONE DINAMICA,
    // RICORDARSI DI COMMENTARE.
    path: 'dettaglio/:id',
    // :id  è la parte dinamica di questo path
    // e vuol dire che può assumere un valore qualsiasi.
    // ATTENZIONE al nome, è arbitrario, ma RICORDATEVI di
    // quello che utilizzate!!!
    component: DettaglioComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    ListaComponent,
    FormComponent,
    DettaglioComponent
  ],
  imports: [
    BrowserModule,
    // 3) AGGIUNGIAMO AGLI 'imports'
    // QUESTO 'RouterModule.forRoot()'
    // DOVE ALL'INTERNO GLI PASSIAMO LA 
    // NOSTRA COSTANTE 'routes', DOVE
    // SONO CONTENUTI I PERCORSI
    // DEGLI ALTRI COMPONENT.
    RouterModule.forRoot(routes),
    // 19) CI SERVE PER ABILITARE IL
    // two-way binding.
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }