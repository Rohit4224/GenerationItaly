var marvelCharacters = [
    {
        characterName: "Iron Man",
        alias: "Tony Stark",
        superpower: "Flight, Super Strength",
        alignment: "hero",
        characterImage: "https://variety.com/wp-content/uploads/2016/05/iron-man-3-female-villain.jpg",
        characterDescription: "Genius billionaire with a suit of high-tech armor.",
    },
    {
        characterName: "Black Widow",
        alias: "Natasha Romanoff",
        superpower: "Master martial artist, espionage expert",
        alignment: "hero",
        characterImage: "https://media.vanityfair.com/photos/55369d4521478db3485e69de/1:1/w_957,h_638,c_limit/black-widow-merchandise-missing.jpg",
        characterDescription: "Skilled spy and assassin with a mysterious past.",
    }
    // Add more characters as needed
];

function displayMarvelCharacters() {
    var result = "";

    for (var i = 0; i < marvelCharacters.length; i++) {
        result += `<div class="character">
                        <h3>Name: ${marvelCharacters[i].characterName} </h3>
                        <h4>Alias: ${marvelCharacters[i].alias} </h4>

                        <div class="characterImage">
                            <img style="width:400px" src="${marvelCharacters[i].characterImage}" alt="${marvelCharacters[i].characterName}"/>
                        </div>

                        <div>
                            <p class="characterDescription">
                                ${marvelCharacters[i].characterDescription}
                            </p>
                            <p class="otherInfo">
                                Superpower: ${marvelCharacters[i].superpower}
                                <br>
                                Alignment: ${marvelCharacters[i].alignment}
                            </p>
                        </div>
                        <button onclick="marvelCharacters.splice(${i}, 1); displayMarvelCharacters()">Remove</button>
                    </div>`;
    }

    document.getElementById("characterContainer").innerHTML = result;
}

function clearCharacterFields() {
    var inputs = document.getElementsByTagName("input");

    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].type !== "button") {
            inputs[i].value = "";
        }
    }
    
    document.getElementById("characterDescription").value = "";
}

function addMarvelCharacter() {
    var inputs = document.getElementsByTagName("input");

    let characterName = document.getElementById("characterName").value;
    let alias = document.getElementById("alias").value;
    let superpower = document.getElementById("superpower").value;
    let alignment = document.getElementById("alignment").value;
    let characterImage = document.getElementById("characterImage").value;
    let characterDescription = document.getElementById("characterDescription").value;

    if (control(characterName, alias, superpower, alignment, characterImage, characterDescription)) {
        marvelCharacters.push({
            characterName: characterName,
            alias: alias,
            superpower: superpower,
            alignment: alignment,
            characterImage: characterImage,
            characterDescription: characterDescription
        });

        displayMarvelCharacters();
        clearCharacterFields();
    }
}

function control(characterName, alias, superpower, alignment, characterImage, characterDescription) {
    if (characterName === "" || alias === "" || superpower === "" || alignment === "" || characterImage === "" || characterDescription === "") {
        alert("Fill in all fields");
        return false;
    }

    return true;
}
