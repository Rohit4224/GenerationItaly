class Libro
{
    constructor(t, a, g, np)
    {
        this.titolo = t;
        this.autore = a;
        this.genere = g;
        this.numeroPagine = np;
    }

    scheda()
    {
        return `Titolo: ${this.titolo} \nAutore: ${this.autore} \nGenere: ${this.genere} \nNumero Pagine: ${this.numeroPagine} \n`   
    }
}


//Esempi di oggetti definiti 
//oggetto vuoto
const libro1  = new Libro();

//oggetto "deforme"
const libro2 = new Libro("IT", "Horror");

//oggetto corretto
const libro3 = new Libro("IT", "Stephen King", "Horror", 1138);

const some = "Rohit";


// oggetti indefiniti
var libro = {
            titolo : "IT",
            autore : "Stephen King",
            genere : "Horror",
            pagine : 1138
            };

var libroBis = {
    titolo : "Addicted",
    autore : "Roversi",
    genere : "Thriller",
    pagine : 560
    };

/* ----------------------- Esercizio di oggi ----------------------- */

var viaggi = 
[
    {
        destinazione : "Roma",
        dataPartenza : "25/02/2024",
        permanenza : 7,
        costoGiornaliero : 20.50,
        immagine: "https://i.insider.com/63c715cd297d7e001963d046?width=1136&format=jpeg",
        descrizione: "città eterna",
        preventivo: function()
        {
            return this.permanenza * this.costoGiornaliero;
        }
    },
    {
        destinazione : "Miano",
        dataPartenza : "25/02/2024",
        permanenza : 7,
        costoGiornaliero : 20.50,
        immagine: "https://i.ytimg.com/vi/M2guxQBpygw/maxresdefault.jpg",
        descrizione: "città tranquilla",
        preventivo: function()
        {
            return this.permanenza * this.costoGiornaliero;
        }
    }

];


function grafica()
{
    var ris = "";

    for(var i = 0; i < viaggi.length; i++)
    {
        ris += `<div class="viaggio">
                    <h3>Destinazione: ${viaggi[i].destinazione} </h3>
                    <h4>Partenza : ${viaggi[i].dataPartenza} </h4>

                    <div class="immagineSingola">
                        <img style="width:400px" src="${viaggi[i].immagine}" alt="Roma"/>
                    </div>

                    <div>
                        <p class="descrizione">
                            ${viaggi[i].descrizione}
                        </p>
                        <p class= "altreinfo">
                            Permaneza: ${viaggi[i].permanenza} giorni
                            <br>
                            Costo: ${viaggi[i].costoGiornaliero} €/gg
                            <br>
                            Preventivo Finale: ${viaggi[i].preventivo()}€
                        </p>
                    </div>
                    <button onclick="viaggi.splice(${i}, 1); grafica()">Elimina</button>
                </div>`;
    }

    document.getElementById("contenitoreViaggi").innerHTML = ris;
}


function svuota ()
{
    //modo meccanico
    /* document.getElementById("destinazione").value = "";
    document.getElementById("dataPartenza").value = "";
    document.getElementById("parmanenza").value = "";
    document.getElementById("costoGiornaliero").value = "";
    document.getElementById("imagine").value = "";
    document.getElementById("descrizione").value = "";
    document.getElementById("preventivo").value = "";
 */

    //modo automatico

    var inputs = document.getElementsByTagName("input");

    for(var i = 0; i < inputs.length; i++)
    {
        if(inputs[i].type !== "button" )
        {
            inputs[i].value = "";
        }
    }
    document.getElementById("descrizione").value = "";
    document.getElementById("preventivo").value = "";
}

function aggiungi()
{
    var inputs = document.getElementsByTagName("input");

    let dest = document.getElementById("destinazione").value
    let dp = document.getElementById("dataPartenza").value
    let perm = document.getElementById("permanenza").value
    let cg = document.getElementById("costoGiornaliero").value
    let img = document.getElementById("immagine").value
    let desc = document.getElementById("descrizione").value

    control_(dest, dp, perm, cg, img, desc);
    
    if (control_ === true) 
    {
        viaggi.push(
                {
                    destinazione: dest,
                    dataPartenza: dp,
                    permanenza: perm,
                    costoGiornaliero: cg,
                    immagine: img,
                    descrizione: desc,
                    preventivo: function()
                    {
                        return this.permanenza * this.costoGiornaliero;
                    }

                }
            );

            grafica();
            svuota();
    }
}

function control_(dest, dp, perm, cg, img, desc) {
    if (dest === "" || dp === "" || perm === "" || cg === "" || img === "" || desc === "") {
        alert("Inserire tutti i campi");
        return false;
    }

    if (isNaN(perm) || isNaN(cg)) {
        alert("Inserire un numero");
        return false;
    }

    return true;
}


