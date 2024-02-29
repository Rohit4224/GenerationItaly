// Creiamo il modello
// per l'oggetto todo
export interface Todo {
// Nella maggior parte dei casi
// in cui abbiamo a che fare
// coi dati, avremo sempre
// un 'id'
id: number;
descrizione: string;
completato: boolean;
}