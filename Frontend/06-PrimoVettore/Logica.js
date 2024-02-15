//  VETTORI
// I vettori in JS non hanno limitazioni sui tipi di dati che possono contenere, ne sul numero.
// In un carto senso sono dinamici sia dal punto di vista della quantità di infrmazioni immaganizinate, sia dalla tipologia.

//  Ecco alcuni esempi di vettori in JS:
// Vettore Vuoto
var vettore1 = [];
// Vettore con testo
var vettore2 = ["Ciao","Amico","Come","Stai","?"];
// Vettore con numeri interi
var vettore3 = [1,2,3,4,5,6,7];
// Vettore con numeri decimali
var vettore4 = [1.1,1.2,2.3,2.4,3.4,4.5];
// Vettore Misti (più frequenti dei precedenti)
var vettore5 = [1,"Pippo",3.5,2.0,"Pizza",true,vettore2];

// Le variabili seguono ancora le regole di Globali/Locali che conosciamo

// Per l'esercizio useremo il vettore sottostante
var vettore = [];

/**
 * Con questa funzione io voglio sfogliare uno per uno i dati del mio vettore e li voglio graficare nella pagina HTML in modo ordinato.
 */
function grafica()
{
    var ris = "";

    for(var i = 0; i < vettore.length; i++)
        ris += vettore[i] + ", ";

    if(ris.length == 0)
        ris = "Qui graficheremo tutto il contenuto del vettore";
    else
        ris = ris.substring(0, ris.length-2);

    document.getElementById("outputVettore").innerHTML = ris;

    somma();
    media();
    maggiore();
}

/**
 * Questa funzione ha il compito di aggiungere informazioni al vettore
 */
function aggiungi()
{
    var n = parseInt(document.getElementById("numero").value);

    vettore.push(n);

    grafica();
    pulisci();
}

function pulisci()
{
    document.getElementById("numero").value = "";
}

function rimuovi()
{
    // Elimino il primo elemento del vettore
    //vettore.shift();

    // Elimino l'ultimo elemento del vettore
    vettore.pop();

    // Elimino un elemento preciso dal vettore
    //      VERSIONE BASE
    //  Parametro 1: Da che indice parto a cancellare
    //  Parametro 2: Quanti elementi cancello 
    //vettore.splice(2,1); // -> Qui dico che voglio cancella dall'indice 2 un solo elemento
    //vettore.splice(1,2); // -> Dico che voglio cancellare dall'indice 1 due elementi, cioè l'elemento a indice 1 e l'elemento a indice 2
    //      VERSIONE PRO
    //  Parametro 3 e successivi: Inserisce a partire dall'indice del Parametro 1 i dati del Paramtro 3 e successivi
    //vettore.splice(2,1,567,345);

    grafica();
}

function somma()
{
    var ris = 0;

    // FOR OF -> è come il ciclo FOREACH di Java
    for(var n of vettore)
    {
        // Funzione che ritorna true se il valore nelle tonde è NaN, cioè se n non è un numero
        if(!(isNaN(n)) && n != '')
            ris += n;
    }

    if(ris == 0)
        ris = "Qui graficheremo la somma di tutte le cifre presenti nel vettore";

    document.getElementById("outputSomma").innerHTML = ris;
}

function media()
{
    var ris = 0;
    var conta = 0;

    for(var n of vettore)
    {
        if( !(isNaN(n)) && n != '')
        {
            ris += n;
            conta++;
        }
    }

    if(ris == 0)
        ris = "Stamperemo qui la media dei dati nel vettore";
    else
        ris = ris/conta;

    document.getElementById("outputMedia").innerHTML = ris;
}

function maggiore()
{
    var ris = Number.MIN_VALUE;

    for(var n of vettore)
    {
        if( !(isNaN(n)) && n != '')
        {
            if(n > ris)
            {
                ris = n;
            }
        }
    }

    if(ris == Number.MIN_VALUE)
        ris = "Stamperemo qui il numero maggiore tra i dati nel vettore";

    document.getElementById("outputMaggiore").innerHTML = ris;
}