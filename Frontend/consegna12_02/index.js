document.addEventListener("DOMContentLoaded", function () {
    const fromCurrencySelect = document.getElementById("fromCurrency");
    const toCurrencySelect = document.getElementById("toCurrency");

    // Fetch currency codes
    fetch("https://open.er-api.com/v6/latest/USD")
        .then(response => response.json())
        .then(data => {
            const currencies = Object.keys(data.rates);

            currencies.forEach(currency => {
                const option = document.createElement("option");
                option.value = currency;
                option.textContent = currency;
                fromCurrencySelect.appendChild(option.cloneNode(true));
                toCurrencySelect.appendChild(option);
            });
        })
        .catch(error => console.error("Error fetching currency codes:", error));
});

function convertCurrency() {
    const fromCurrency = document.getElementById("fromCurrency").value;
    const toCurrency = document.getElementById("toCurrency").value;
    const amount = parseFloat(document.getElementById("amount").value);

    
    if (fromCurrency === toCurrency) {
        alert("Please select different currencies");
        return;
    }

    if (amount <= 0) {
        alert("Please enter a valid amount");
        return;
    }

    if (isNaN(amount)) {
        alert("Please enter a valid amount");
        return;
    }

    // Fetch real-time exchange rate
    fetch(`https://open.er-api.com/v6/latest/${fromCurrency}`)
        .then(response => response.json())
        .then(data => {
            const conversionRate = data.rates[toCurrency];
            const convertedAmount = amount * conversionRate;

            const resultElement = document.getElementById("result");
            resultElement.innerHTML = `Converted Amount: ${convertedAmount.toFixed(2)} ${toCurrency}`;
        })
        .catch(error => console.error("Error fetching exchange rate:", error));
}
