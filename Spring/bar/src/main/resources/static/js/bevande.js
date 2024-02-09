console.log("HEllo from JS")

function onSelectionchange()
{
    var inputId = document.getElementById("inputIdBevanda")
    var inputNome = document.getElementById("inputNomeBevanda")
    var inputPrezzo = document.getElementById("inputPrezzoBevanda")

    var selectBevanda = document.getElementById("bevandaSelection")
    var selectOption = document.getElementById(selectBevanda.value)

    inputId.value = selectOption.getAttribute("id-bevanda")
    inputNome.value = selectOption.getAttribute("nome-bevanda")
    inputPrezzo.value = selectOption.getAttribute("prezzo-bevanda")
    console.log("Elemento Combiato");
}