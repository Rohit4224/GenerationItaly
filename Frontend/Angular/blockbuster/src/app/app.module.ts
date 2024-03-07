import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListaFilmComponent } from './lista-film/lista-film.component';
import { FormComponent } from './form/form.component';
import { FormsModule } from '@angular/forms';
import { DettaglioFilmComponent } from './dettaglio-film/dettaglio-film.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaFilmComponent,
    FormComponent,
    DettaglioFilmComponent
  ],
  imports: [
    BrowserModule,
    // 12)ABILITIAMO IL 'two-way binding'
    // IMPORTANDO 'FormsModule.
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
