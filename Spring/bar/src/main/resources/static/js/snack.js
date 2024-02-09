
function onSelectionchange()
{
    var inputId = document.getElementById("inputIdSnack")
    var inputNome = document.getElementById("inputNomeSnack")
    var inputPrezzo = document.getElementById("inputPrezzoSnack")
    var inputQuantita = document.getElementById("inputQuantitaSnack")
   // var inputSalato = document.getElementById("inputSalatoSnack")
    
    var inputSalatoYes = document.getElementById("salato_si_modifica")
    var inputSalatoNo = document.getElementById("salato_no_modifica")

    var selectSnack = document.getElementById("snackSelection")
    var selectOption = document.getElementById(selectSnack.value)

    inputId.value = selectOption.getAttribute("id-snack")
    inputNome.value = selectOption.getAttribute("nome-snack")
    inputPrezzo.value = selectOption.getAttribute("prezzo-snack")
    inputQuantita.value = selectOption.getAttribute("quantita-snack")
    //inputSalato.value = selectOption.getAttribute("salato-snack")
    
    var salatoValue = selectOption.getAttribute("salato-snack");
    if (salatoValue === "true") {
        inputSalatoYes.checked = true;
        inputSalatoNo.checked = false;
    } else {
        inputSalatoYes.checked = false;
        inputSalatoNo.checked = true;
    }
    
    console.log("Elemento Combiato");
}