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
                        <button onclick="window.location.href='update.html?index=${i}'">Update</button>
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


var urlParams = new URLSearchParams(window.location.search);
var index = urlParams.get('index');

var character = marvelCharacters[index];

document.getElementById('characterName').value = character.characterName;
document.getElementById('alias').value = character.alias;
document.getElementById('characterImage').value = character.characterImage;
document.getElementById('characterDescription').value = character.characterDescription;
document.getElementById('superpower').value = character.superpower;
document.getElementById('alignment').value = character.alignment;


document.getElementById('updateForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var characterName = document.getElementById('characterName').value;
    var alias = document.getElementById('alias').value;
    var characterImage = document.getElementById('characterImage').value;
    var characterDescription = document.getElementById('characterDescription').value;
    var superpower = document.getElementById('superpower').value;
    var alignment = document.getElementById('alignment').value;

    var character = marvelCharacters[index];
    character.characterName = characterName;
    character.alias = alias;
    character.characterImage = characterImage;
    character.characterDescription = characterDescription;
    character.superpower = superpower;
    character.alignment = alignment;
});


document.getElementById('updateForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var characterName = document.getElementById('characterName').value;
    var alias = document.getElementById('alias').value;
    var characterImage = document.getElementById('characterImage').value;
    var characterDescription = document.getElementById('characterDescription').value;
    var superpower = document.getElementById('superpower').value;
    var alignment = document.getElementById('alignment').value;

    // Here you would update the character information in your data
    // For example:
    // var character = marvelCharacters.find(c => c.characterName === characterName);
    // character.alias = alias;
    // character.characterImage = characterImage;
    // character.characterDescription = characterDescription;
    // character.superpower = superpower;
    // character.alignment = alignment;

    var character = marvelCharacters[index];
    character.characterName = characterName;
    character.alias = alias;
    character.characterImage = characterImage;
    character.characterDescription = characterDescription;
    character.superpower = superpower;
    character.alignment = alignment;

    // Redirect to the home page
    window.location.href = 'index.html';
});
