
// 2) DEFINIAMO UN INTERFACCIA
// PER IL MODELLO DEI NOSTRI
// OGGETTI 'film'
export interface Film {

    id: number;
    titolo: string;
    genere: string;
    dataUscita: string;
    vietatoAiMinoriDi18: boolean;
    durata: number;
    immagineCopertina: string;
    voto: number;
}