# ESERCIZIO LAVORO AUTONOMO

# Creare il DB Negozio
# Creare la tabella Merci, che avrà id int PK AI, nome varchar, categoria varchar, dataScadenza date, quantità int, prezzo double
# Creare la tabella Ordini, che avrà id int PK AI, dataAcquisto date, pezzi int, idMerce int
# Che relazione c'è tra le due tabelle? Serve una colonna FK o esiste già tra quelle elencate?
# Voglio poi vedere:
# - Solo le merci in esaurimento (5 pezzi o meno in magazzino)
# - Solo le merci con il prezzo maggiore
# - Il prezzo medio delle merci per ogni categoria
# - Il prezzo medio degli ordini acquistati
# - Il prezzo medio degli ordini acquistati in base alla categoria
# - Gli ordini con una spesa totale superiore alla media
# - Il numero di ordini di merci scadute
# - Il nome dei prodotti scaduti
# - Il nome dei prodotti in scadenza (entro 3 giorni dalla data odierna)
# - Il numero di ordini effettuati per ogni mese

# Creare il DB Negozio
CREATE DATABASE Negozio;

USE Negozio;

# Creare la tabella Merci, che avrà id int PK AI, nome varchar, categoria varchar, dataScadenza date, quantità int, prezzo double

CREATE TABLE Merci
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80),
    categoria VARCHAR(80),
    dataScadenza DATE,
    quantita INT,
    prezzo DOUBLE
);

# Creare la tabella Ordini, che avrà id int PK AI, dataAcquisto date, pezzi int, idMerce int
CREATE TABLE Ordini
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    dataAcquisto DATE,
    pezzi INT,
    idMerce INT
);
ALTER TABLE Ordini
ADD CONSTRAINT fk_Ordini_Merci
FOREIGN KEY (idMerce) REFERENCES Merci(id)
ON DELETE SET NULL
ON UPDATE CASCADE;

# Inserting data into Merci table
INSERT INTO Merci (nome, categoria, dataScadenza, quantita, prezzo)
VALUES 
    ('Prodotto1', 'Elettronica', '2024-12-31', 10, 99.99),
    ('Prodotto2', 'Abbigliamento', '2024-10-15', 5, 49.99),
    ('Prodotto3', 'Alimentari', '2025-05-01', 20, 2.99),
    ('Prodotto4', 'Elettronica', '2024-08-20', 8, 199.99),
    ('Prodotto5', 'Abbigliamento', '2024-11-30', 15, 29.99);
    
INSERT INTO Merci (nome, categoria, dataScadenza, quantita, prezzo)
VALUES 
    ('Prodotto6', 'Alimentari', '2024-12-31', 20, 59.99);
    
INSERT INTO Merci (nome, categoria, dataScadenza, quantita, prezzo)
VALUES 
    ('Prodotto7', 'Alimentari', '2023-12-31', 18, 69.99);
#Inserting data into Ordini table
INSERT INTO Ordini (dataAcquisto, pezzi, idMerce)
VALUES 
    ('2024-01-15', 2, 1),
    ('2024-02-20', 3, 3),
    ('2024-03-10', 1, 2),
    ('2024-04-05', 5, 4),
    ('2024-05-18', 2, 5);

INSERT INTO Ordini (dataAcquisto, pezzi, idMerci)
VALUES 
    ('2023-01-15', 3, 7);
ALTER TABLE Ordini
CHANGE COLUMN idMerce idMerci INT;

# Che relazione c'è tra le due tabelle? Serve una colonna FK o esiste già tra quelle elencate?
# secondo me 1-n, e esiste gia'

# - Solo le merci in esaurimento (5 pezzi o meno in magazzino)
SELECT *
FROM Merci
Where quantita <= 5;

# - Solo le merci con il prezzo maggiore
Select *
FROM Merci
WHERE quantita = (SELECT MAX(quantita) FROM Merci);

# - Il prezzo medio delle merci per ogni categoria
SELECT categoria, AVG(prezzo) AS "Average Prezzo"
FROM Merci
GROUP BY categoria;

# - Il prezzo medio degli ordini acquistati
SELECT AVG(Merci.prezzo * Ordini.Pezzi) AS MediaPrezzo
FROM Merci, Ordini
Where Merci.id = Ordini.idmerci;

# - Il prezzo medio degli ordini acquistati in base alla categoria
SELECT Merci.categoria, AVG(Merci.prezzo * Ordini.Pezzi) AS MediaPrezzo
FROM Merci, Ordini
Where Merci.id = Ordini.idmerci
GROUP BY categoria;

# - Gli ordini con una spesa totale superiore alla media
SELECT Ordini.*, Merci.prezzo * Ordini.pezzi AS spesa_totale
FROM Ordini, Merci
WHERE Merci.id = Ordini.idmerci
AND (Merci.prezzo * Ordini.Pezzi) > (SELECT AVG(Merci.prezzo * Ordini.Pezzi)
										FROM Merci, Ordini
										Where Merci.id = Ordini.idmerci);

# - Il numero di ordini di merci scadute
SELECT COUNT(Merci.id) AS numero_ordini_scaduti
FROM Ordini, Merci
WHERE Merci.id = Ordini.idmerci AND Merci.dataScadenza < CURDATE();

# - Il nome dei prodotti scaduti
SELECT Merci.nome
FROM Ordini, Merci
WHERE Merci.id = Ordini.idmerci AND Merci.dataScadenza < CURDATE();

# - Il nome dei prodotti in scadenza (entro 3 giorni dalla data odierna)
SELECT Merci.nome AS nome_prodotto
FROM Merci
WHERE Merci.dataScadenza BETWEEN CURDATE() AND CURDATE() + INTERVAL 3 DAY;


# - Il numero di ordini effettuati per ogni mese
SELECT MONTHNAME(Ordini.dataAcquisto) AS mese, YEAR(Ordini.dataAcquisto), COUNT(*) AS numero_ordini
FROM Ordini
GROUP BY MONTH(Ordini.dataAcquisto), YEAR(Ordini.dataAcquisto);

