#                                CONSEGNA
# Creare il database Mondadori
# Creare la tabella Libri che avrà come colonne: id INT PK AI, titolo, autore, genere, numero_pagine
# Inserire almeno 5 libri
# Scrivere una query che vi permetta di vedere tutti i dati inseriti
# Aggiungete la colonna prezzo
# Riempite il prezzo di ogni libro, sapendo che il calcolo sarà 3 + 0.005 per ogni pagina
# Voglio poi vedere:
#    - I titoli di tutti i libri di un genere a vostra scelta
#    - I titoli dei libri che sono di genere Horror e dell'autore King
#    - I libri che hanno più di 100 pagine
#    - I libri che hanno un prezzo compreso tra 10 e 15 euro
#    - I titoli in ordine alfabetico per genere e autore

CREATE DATABASE Mondadori;


# Creare la tabella Libri che avrà come colonne: id INT PK AI, titolo, autore, genere, numero_pagine
CREATE Table Libri
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	titolo VARCHAR(200),
    autore VARCHAR(80),
    genere VARCHAR(60),
    numero_pagine INT
);

ALTER TABLE Libri DROP COLUMN id;

# Inserire almeno 5 libri
INSERT INTO Libri
VALUES
("Cime tempestose", "Emily Brontë", "Romanzo", 342),
("Il nome della rosa", "Umberto Eco", "Mistero", 552),
("Il codice Da Vinci", "Dan Brown", "Mistero", 592),
("Carrie", "King", "Horror", 290),
("Il miglio verde", "Stephen King", "Horror", 480),
("Don Chisciotte", "Miguel de Cervantes", "Romanzo", 1072),
("Orgoglio e pregiudizio", "Jane Austen", "Romanzo", 432),
("La zona morta", "King", "Horror", 594);

ALTER TABLE Libri ADD id INT PRIMARY KEY AUTO_INCREMENT FIRST;

# Scrivere una query che vi permetta di vedere tutti i dati inseriti
SELECT * FROM Libri;

# Aggiungete la colonna prezzo
ALTER TABLE Libri ADD prezzo INT;

# Riempite il prezzo di ogni libro, sapendo che il calcolo sarà 3 + 0.005 per ogni pagina
UPDATE Libri SET prezzo = 3 + (0.005 * numero_pagine) WHERE id > 0;

#    - I titoli di tutti i libri di un genere a vostra scelta
SELECT * FROM Libri
WHERE genere = "romanzo";

#    - I titoli dei libri che sono di genere Horror e dell'autore King
SELECT * FROM Libri
WHERE genere = "horror" AND autore = "king";

#    - I libri che hanno più di 100 pagine
SELECT * FROM Libri
WHERE numero_pagine > 100;

#    - I libri che hanno un prezzo compreso tra 10 e 15 euro
SELECT * FROM Libri
WHERE prezzo >= 10 AND prezzo <= 15;

#    - I titoli in ordine alfabetico per genere e autore
SELECT * FROM Libri
ORDER BY genere, aUtore;