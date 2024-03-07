import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { ListaComponent } from './lista/lista.component';
import { FormsModule } from '@angular/forms';
import { DettaglioComponent } from './dettaglio/dettaglio.component';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    ListaComponent,
    DettaglioComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
