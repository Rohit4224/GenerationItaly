# Le query hanno 6 parole chiave che le formano. 
# Queste 6 parole hanno un ordine di scrittura e un ordine di esecuzione.

# ORDINE SCRITTURA				ORDINE DI ESECUZIONE
# 	select							from
# 	from							where
# 	where							group by
# 	Group by						HAVING
# 	Having							order by
# 	order by						select

#voglio vedere solo le persone sposato in ordine alfabetico
SELECT ID, CONCAT(nome, " ", cognome) AS Nominativo, Sposato
FROM Persone
Where sposato = 1
ORDER BY Nominativo;

# DETTAGLI
# 	ORDER BY vuole di seguito il nome di una o piu colonne.
# 	Di base ordina sempre in modo crescente (A->Z, 1->9) -> ASC
# 	Se volete invertire l'ordine basta mettere dopo la colonna la parola DESC (Z->A, 9->1)

#¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯


#18/01
# HAVING e GRUOP BY
#¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
# GROUP BY -> è una parola chiave che serve a ragruppare in base ai dati della/e colonna/e passate.
#¯¯¯¯¯¯¯¯¯
CREATE DATABASE Motorizzazione;
USE Motorizzazione;

# PRIMARY KEY: le PK possono essere di due tipi: NATURALI o ARTIFICIALI
# id è la classica PK artificiale, mentre il codice fiscale è il classico esempio di PK naturale.
# Dato le PK naturali possono ripetersi, spesso sono usate in accostamento a una PK artificiale come l'id
# In quel caso per identificare un record serve usare la combo delle PK della tabella.

CREATE TABLE Macchine
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(100),
    modello VARCHAR(100),
    colore VARCHAR(200),
    cavalli INT,
    electtrico BOOL,
    costo DOUBLE,
    targa VARCHAR(7),
    porte INT,
    neopatentati BOOL,
    autonomia INT
);

INSERT INTO Macchine
(marca, modello, colore, cavalli, electtrico, costo, targa, porte, neopatentati, autonomia)
VALUES
('Honda', 'Civic', 'Rosso', 130, 0, 18000.00, 'ABC456', 4, 1, 480),
    ('Volkswagen', 'Golf', 'Blu', 110, 0, 20000.00, 'XYZ789', 5, 0, 400),
    ('Tesla', 'Model S', 'Nero', 400, 1, 80000.00, 'QWE123', 4, 0, 600),
    ('Ford', 'Focus', 'Grigio', 120, 0, 17000.00, 'LMN456', 5, 1, 450),
    ('Chevrolet', 'Malibu', 'Bianco', 150, 0, 22000.00, 'OPQ789', 4, 0, 420),
    ('Toyota', 'Camry', 'Verde', 140, 0, 19000.00, 'RST012', 4, 1, 450);

INSERT INTO Macchine
(marca, modello, colore, cavalli, electtrico, costo, targa, porte, neopatentati, autonomia)
VALUES
('Honda', 'City', 'Giallo', 140, 1, 20000.00, 'ABC457', 3, 0, 490),
    ('Volkswagen', 'POLO', 'verde', 110, 1, 20000.00, 'XYZ79', 4, 1, 470),
    ('Tesla', 'Model 3', 'Bianco', 400, 0, 90000.00, 'QWE124', 5, 1, 800);


SELECT * FROM Macchine;

# voglio vedere solo le marche senza ripetizioni
SELECT marca FROM Macchine
GROUP BY marca;

# voglio vedere le macchine raggrupate per marca a modello
SELECT marca, modello
FROM Macchine
GROUP BY marca, modello;

# voglio vedere tutti i colori disponibili nella tabella
SELECT colore
From Macchine
Group BY colore;

# Voglio vedere per ogni marca quante macchine ci sono
# nel COUNT voglio vedere solo * o PK !!
SELECT marca, COUNT(id) AS "Numeri di Macchine"
FROM Macchine
GROUP BY marca;

#HAVING#
#¯¯¯¯¯¯¯
# Voglio vedere solo i colori ripetuti 2 o piu volte
#STEP 1 : trovo l'insieme corretto e completo dei dati che mi servono
SELECT * FROM Macchine;
#STEP 2: vedo se devo togliere con un WHERE qualche record dalla tabella
# STEP 3: vedo se devo raggruppare per qualche valore
SELECT * 
FROM Macchine 
GROUP BY colore;
# STEP 4 :vedo se devo applicare delle funzioni di gruppo
SELECT *, COUNT(id)
FROM Macchine
GROUP BY colore;
#STEP 5: vedo se alla funzione di gruppo devo applicare una condizione
SELECT *, COUNT(id)
FROM Macchine
GROUP BY colore
HAVING COUNT(id) >= 2;

#STEP 6 : pulisco le colonne, tenendo nel select solo quelle che mi interessano
SELECT colore, COUNT(id) AS "Numero di macchine"
FROM Macchine
GROUP BY colore
HAVING COUNT(id) >= 2;