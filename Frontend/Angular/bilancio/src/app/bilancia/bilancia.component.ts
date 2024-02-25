// bilancia.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-bilancia',
  templateUrl: './bilancia.component.html',
  styleUrls: ['./bilancia.component.css']
})
export class BilanciaComponent {
  entrata: { importo: number }[] = [];
  spesa: { importo: number }[] = [];
  numero: number = 0;

  aggiungiTransazione(tipo: string) {
    const importo = tipo === 'entrata' ? this.numero : -this.numero;
    if (tipo === 'entrata') {
      this.entrata.push({ importo });
    } else {
      this.spesa.push({ importo });
    }
    this.numero = 0;
  }

  eliminaTransazione(tipo: string, index: number) {
    if (tipo === 'entrata') {
      this.entrata.splice(index, 1);
    } else {
      this.spesa.splice(index, 1);
    }
  }

  calcolaSomma(tipo: string) {
    const movimenti = tipo === 'entrata' ? this.entrata : this.spesa;
    return movimenti.reduce((acc, t) => acc + t.importo, 0);
  }

  calcolaBilancia() {
    return this.calcolaSomma('entrata') + this.calcolaSomma('spesa');
  }
}
