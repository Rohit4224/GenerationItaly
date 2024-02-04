/*
 AZIENDA
Creare un database Azienda.
Creare una tabella Persona, strutturata così:
Primary Key(PK) int id, varchar nome, varchar cognome, int yob, varchar mansione, 
			double stipendio, int anniLavorati
Scrivere poi le seguenti query:
	-- visualizzare in ordine alfabetico in base al cognome, le persone la cui mansione è Operaio;
	-- visualizzare tutte le persone la cui mansione è Sicurezza;
	-- visualizzare tutte le persone che hanno più di 5 anniLavorati ma meno di 20
	-- aggiungere la colonna anniAllaPensione, e inserire per ogni persona quanto manca alla 
				pensione(pensione obbligatoria a 67 anni compiuti)
	-- eliminare tutte le persone che sono nate dal 2002 in poi
	-- visualizzare la media degli stipendi degli impiegati
	-- visualizzare la somma degli stipendi degli operai
	-- visualizzare la somma degli stipendi degli operai che lavorano da più di 10 anni
	-- visualizzare il numero dei dirigenti
	-- visualizzare il valore massimo degli stipendi di tutti
	-- visualizzare il nominativo a cui corrisponde lo stipendio maggiore
	-- visualizzare il nome, il cognome e l'anno di nascita della persona più giovane
*/

CREATE DATABASE Azienda;
USE Azienda;

CREATE TABLE Persone
(id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(80),
cognome VARCHAR(80),
yob INT,
mansione VARCHAR(80),
stipendio DOUBLE,
anniLavorati INT
);

INSERT INTO Persone (nome, cognome, yob, mansione, stipendio, anniLavorati) VALUES
('Mario', 'Rossi', 1985, 'Operaio', 30000.00, 7),
('Luca', 'Bianchi', 1990, 'Sicurezza', 35000.00, 10),
('Giulia', 'Verdi', 1988, 'Impiegato', 40000.00, 8),
('Paola', 'Neri', 1980, 'Dirigente', 60000.00, 15),
('Riccardo', 'Gialli', 1995, 'Operaio', 32000.00, 5);

INSERT INTO Persone (nome, cognome, yob, mansione, stipendio, anniLavorati) VALUES
('Laura', 'Ferrari', 1987, 'Sicurezza', 38000.00, 12),
('Giovanni', 'Ricci', 1992, 'Impiegato', 42000.00, 6),
('Martina', 'Moretti', 1983, 'Dirigente', 65000.00, 21),
('Andrea', 'Lombardi', 1998, 'Operaio', 31000.00, 25),
('Valentina', 'Gallo', 1989, 'Sicurezza', 36000.00, 15);

INSERT INTO Persone (nome, cognome, yob, mansione, stipendio, anniLavorati) VALUES
('Laura', 'Ferrari', 2010, 'Sicurezza', 38000.00, 12);

-- visualizzare in ordine alfabetico in base al cognome, le persone la cui mansione è Operaio;
SELECT *
FROM Persone
WHERE mansione = "Operaio"
ORDER BY cognome;

-- visualizzare tutte le persone la cui mansione è Sicurezza;
SELECT *
FROM Persone
WHERE mansione = "Sicurezza";

-- visualizzare tutte le persone che hanno più di 5 anniLavorati ma meno di 20
SELECT *
FROM Persone
WHERE anniLavorati > 5 AND anniLavorati < 20;

-- aggiungere la colonna anniAllaPensione, e inserire per ogni persona quanto manca alla 
				-- pensione(pensione obbligatoria a 67 anni compiuti)
ALTER TABLE Persone ADD COLUMN anniAllaPensione INT;
SELECT * FROM Persone;

UPDATE Persone SET anniAllaPensione = 67 - (YEAR(NOW()) - yob)
WHERE id > 0 AND anniAllaPensione IS NULL;

-- eliminare tutte le persone che sono nate dal 2002 in poi
DELETE FROM Persone WHERE id > 0 AND yob >= 2002;

-- visualizzare la media degli stipendi degli impiegati
SELECT AVG(stipendio) AS MEDIA
FROM Persone
WHERE mansione = "Impiegato";

-- visualizzare la somma degli stipendi degli operai
SELECT SUM(stipendio)
FROM Persone
WHERE mansione = "Operaio";

-- visualizzare la somma degli stipendi degli operai che lavorano da più di 10 anni
SELECT SUM(stipendio)
FROM Persone
WHERE mansione = "Operaio" AND anniLavorati > 10;

-- visualizzare il numero dei dirigenti
SELECT COUNT(*)
FROM Persone
WHERE mansione = "Dirigente";

-- visualizzare il valore massimo degli stipendi di tutti
SELECT *
FROM Persone
WHERE stipendio = (SELECT MAX(stipendio) FROM Persone);

-- visualizzare il nominativo a cui corrisponde lo stipendio maggiore
SELECT CONCAT (nome, " ", cognome) AS Nominativo, stipendio
FROM Persone
WHERE stipendio = (SELECT MAX(stipendio) FROM Persone);

-- visualizzare il nome, il cognome e l'anno di nascita della persona più giovane
SELECT nome, cognome, yob
FROM Persone
WHERE yob = (SELECT MAX(yob) FROM Persone);

SELECT * FROM Persone;
