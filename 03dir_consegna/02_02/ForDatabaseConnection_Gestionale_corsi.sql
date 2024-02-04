-- Creazione del database
CREATE DATABASE IF NOT EXISTS GestionaleFormazione;

-- Utilizzo del database
USE GestionaleFormazione;

-- Creazione della tabella Corsi
CREATE TABLE Corsi (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    totale_ore INT,
    numero_lezioni INT,
    lingua VARCHAR(50),
    materiali BOOLEAN
);

-- Inserimento di alcuni dati di esempio nella tabella Corsi
INSERT INTO Corsi (nome, totale_ore, numero_lezioni, lingua, materiali) 
VALUES
    ('Corso di Programmazione Java', 50, 20, 'Italiano', true),
    ('Web Development with React', 60, 25, 'Inglese', true),
    ('Machine Learning Fundamentals', 45, 15, 'English', false),
    ('Corso di Sviluppo Mobile con Flutter', 55, 18, 'Italiano', true),
    ('Data Science with Python', 70, 30, 'English', false);

SELECT * FROM Corsi;
-- Creazione della tabella Utenti
CREATE TABLE Utenti (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    dob DATE,
    azienda VARCHAR(255),
    mansione VARCHAR(100),
    corsoFrequentato INT,
    FOREIGN KEY (corsoFrequentato) REFERENCES Corsi(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

-- Inserimento di alcuni dati di esempio nella tabella Utenti
INSERT INTO Utenti (nome, cognome, dob, azienda, mansione, corsoFrequentato) 
VALUES
    ('Mario', 'Rossi', '1990-01-01', 'Azienda1', 'Sviluppatore', 1),
    ('Luca', 'Verdi', '1985-05-15', 'Azienda2', 'Project Manager', 2),
    ('Anna', 'Bianchi', '1988-09-20', 'Azienda3', 'Analista', 3),
    ('Giovanni', 'Neri', '1992-04-12', 'Azienda4', 'Tester', 4),
    ('Elena', 'Giallo', '1987-07-07', 'Azienda5', 'Architetto del Software', 5);

SELECT * FROM Utenti;

SELECT	Corsi.* 
FROM	Corsi INNER JOIN Utenti
ON Utenti.corsoFrequentato = Corsi.id
WHERE	Utenti.corsoFrequentato = 1;

