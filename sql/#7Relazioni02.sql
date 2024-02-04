# vogliamo gestire una serie di album.
# sappiamo che ogni album formato da: id PK AI, nome, artista, genere
# sappiamo anche canzoni a disposizione: id PK AI, titolo, durata, album, gradimento
# sappiamo che ogni artista sarà formato da : id PK AI, nome_arte, dob, nazionalita

CREATE DATABASE ManagerMusica;
USE ManagerMusica;

CREATE TABLE Artista
(id INT PRIMARY KEY AUTO_INCREMENT,
nome_artista VARCHAR(250),
dob DATE,
nazionalita VARCHAR(100));

RENAME TABLE Artista TO Artisti;

SELECT * FROM Artisti;

INSERT INTO `ManagerMusica`.`Artisti` (`nome_artista`, `dob`, `nazionalita`) VALUES ('Adam Jensen', '1995-09-30', 'Americano');
INSERT INTO `ManagerMusica`.`Artisti` (`nome_artista`, `dob`, `nazionalita`) VALUES ('Vasco Rossi', '1958-03-26', 'Italiano');
INSERT INTO `ManagerMusica`.`Artisti` (`nome_artista`, `dob`, `nazionalita`) VALUES ('Beyonce', '1989-09-03', 'Americano');



CREATE TABLE Albums
(id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(250),
id_artista INT,
genere VARCHAR(200),
premiato BOOL,
FOREIGN KEY(id_artista) REFERENCES Artisti(id) ON DELETE SET NULL ON UPDATE CASCADE);

SELECT * FROM Albums;
INSERT INTO `ManagerMusica`.`Albums` (`nome`, `id_artista`, `genere`, `premiato`) VALUES ('Cocain Shame', '1', 'Pop', '0');
INSERT INTO `ManagerMusica`.`Albums` (`nome`, `id_artista`, `genere`, `premiato`) VALUES ('Bullet with your name', '1', 'Pop', '0');
INSERT INTO `ManagerMusica`.`Albums` (`nome`, `id_artista`, `genere`, `premiato`) VALUES ('Albachiara', '2', 'Rock', '1');

INSERT INTO `ManagerMusica`.`Albums` (`nome`, `id_artista`) VALUES ('Bugiardo', NULL);

CREATE TABLE Canzoni
(id INT PRIMARY KEY AUTO_INCREMENT,
titolo VARCHAR(300),
durata DOUBLE,
idAlbum INT,
idArtista INT,
gradimento DOUBLE, # da 1 a 5
FOREIGN KEY(idArtista) REFERENCES Artisti(id) ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY(idAlbum) REFERENCES Albums(id)
ON DELETE SET NULL
ON UPDATE CASCADE );

SELECT * FROM Canzoni;

INSERT INTO `ManagerMusica`.`Canzoni` (`titolo`, `durata`, `idAlbum`, `idArtista`, `gradimento`) VALUES ('Cocain Shame', '3.45', '1', '1', '2.5');
INSERT INTO `ManagerMusica`.`Canzoni` (`titolo`, `durata`, `idAlbum`, `idArtista`, `gradimento`) VALUES ('I have a bullet with your name', '4.20', '2', '1', '3.0');
INSERT INTO `ManagerMusica`.`Canzoni` (`titolo`, `durata`, `idAlbum`, `idArtista`, `gradimento`) VALUES ('Jenny', '3.50', '3', '2', '3.5');
INSERT INTO `ManagerMusica`.`Canzoni` (`titolo`, `durata`, `idAlbum`, `idArtista`, `gradimento`) VALUES ('Albachiara', '3.45', '3', '2', '3.5');
INSERT INTO `ManagerMusica`.`Canzoni` (`titolo`, `durata`, `idAlbum`, `idArtista`, `gradimento`) VALUES ('Cocacola', '4.00', '3', '2', '3.5');
INSERT INTO `ManagerMusica`.`Canzoni` (`titolo`, `durata`, `idAlbum`, `idArtista`, `gradimento`) VALUES ('Hello, Its me', '3.55', NULL, NULL, '3.6');

# voglio vedere per ogni canzone a che album appaartiene

# LA INNER mi fa vedere solo i record accopiati tra le due tabelle, ma non i record senza 
 # coppie (ES con FK settata a null) 
SELECT * 
FROM Canzoni INNER JOIN Albums
ON Albums.id = Canzoni.idAlbum;

# per vedere anche i record non accoppiati devo cambiare la JOIN che uso
SELECT * FROM Canzoni LEFT JOIN Albums ON Albums.id = Canzoni.idAlbum;

SELECT * FROM Albums LEFT JOIN Canzoni ON Albums.id = Canzoni.idAlbum;

# voglio vedere per ogni album il numero di canzoni presenti
SELECT Albums.nome AS Titolo_Album,
		COUNT(Canzoni.id) AS Numero_Canzoni
FROM Albums LEFT JOIN Canzoni ON Albums.id = Canzoni.idAlbum
GROUP BY Albums.id, Albums.nome;
# Sopratutto quando si fanno le LEFT JOIN mettere * o mettere PK nel COUNT cambia il risulatato
# * cerca l'esistenza del record, record che potrebbe anche essere interamente NULL e quindi non valore.
# PK invece cerca il valore nella colonna, se quel valore è null, non sarà contato

# voglio vedere per ogni artista il numero di canzoni prodotte
SELECT Artisti.id,Artisti.nome_artista Artista 
		, COUNT(Canzoni.id) Canzoni
FROM Artisti LEFT JOIN Canzoni ON Artisti.id = Canzoni.idArtista
GROUP BY Artisti.id;

# Voglio vedere l'artista con il maggior numero di canzoni prodotte
SELECT *
FROM (SELECT Artisti.id,Artisti.nome_artista Artista 
			, COUNT(Canzoni.id) Canzoni
			FROM Artisti LEFT JOIN Canzoni ON Artisti.id = Canzoni.idArtista
			GROUP BY Artisti.id) AS Produzione
WHERE Produzione.Canzoni = ( SELECT MAX(P.Canzoni)
							 FROM (
									SELECT Artisti.id,Artisti.nome_artista Artista 
									, COUNT(Canzoni.id) Canzoni
								    FROM Artisti LEFT JOIN Canzoni ON Artisti.id = Canzoni.idArtista
									GROUP BY Artisti.id
								   ) AS P
							);

# voglio vedere per ogni album il nome dell'artista
SELECT Albums.nome, Artisti.nome_artista
FROM Albums LEFT JOIN Artisti ON  Albums.id_artista = Artisti.id
GROUP BY Albums.id, Albums.nome;

# voglio vedere la durata totale di ogni album
SELECT Albums.id, Albums.nome, SUM(Canzoni.durata)
FROM Albums LEFT JOIN Canzoni ON Albums.id = Canzoni.idAlbum
GROUP BY Albums.id;


#	 RELAZIONE 1-1
# L'idea di base è di avere un record della tabella 1 che abbia uns sola corrispondenza con un solo 
	# record della tabella 2

CREATE DATABASE Azienda01;
USE Azienda01;

CREATE TABLE Persone
(id INT Primary Key AUTO_INCREMENT,
nome VARCHAR(100),
cognome VARCHAR(150),
dob DATE,
residenza VARCHAR(200),
codiceFiscale VARCHAR(17),
genere CHAR
);

SELECT * FROM Persone;
INSERT INTO `Azienda01`.`Persone` (`nome`, `cognome`, `dob`, `residenza`, `codiceFiscale`, `genere`) VALUES ('Pino', 'Pane', '1978-09-27', 'Milano', 'PPPN34H63K205Y', 'M');
INSERT INTO `Azienda01`.`Persone` (`nome`, `cognome`, `dob`, `residenza`, `codiceFiscale`, `genere`) VALUES ('Alice', 'Bensanelli', '1997-04-23', 'Milano', 'BNSLCA97D63FKZ', 'F');
INSERT INTO `Azienda01`.`Persone` (`nome`, `cognome`, `dob`, `residenza`, `codiceFiscale`, `genere`) VALUES ('Ugo', 'Tozzi', '1967-03-18', 'Bergamo', 'UGOTZZ67C18M202', 'M');
INSERT INTO `Azienda01`.`Persone` (`nome`, `cognome`, `dob`, `residenza`, `codiceFiscale`, `genere`) VALUES ('Pierangela', 'Divina', '1967-03-18', 'Brescia', 'PRNDVN67C38F209B', 'F');


CREATE TABLE Dipendenti
(id INT PRIMARY KEY,
mansione VARCHAR(150),
anniEsperienza INT,
stipendio DECIMAL(7,2),
reparto VARCHAR(150),
tipoContratto VARCHAR(100),
FOREIGN KEY (id) REFERENCES Persone(id)
ON DELETE CASCADE
ON UPDATE CASCADE);

SELECT * FROM Dipendenti;
INSERT INTO `Azienda01`.`Dipendenti` (`id`, `mansione`, `anniEsperienza`, `stipendio`, `reparto`, `tipoContratto`) VALUES ('4', 'CEO', '5', '2800', 'Amministrazione', 'Inderterminato');
INSERT INTO `Azienda01`.`Dipendenti` (`id`, `mansione`, `anniEsperienza`, `stipendio`, `reparto`, `tipoContratto`) VALUES ('6', 'Operaio', '15', '1350', 'Saldature', 'Inderterminato');
INSERT INTO `Azienda01`.`Dipendenti` (`id`, `mansione`, `anniEsperienza`, `stipendio`, `reparto`, `tipoContratto`) VALUES ('7', 'Operaio', '16', '1400', 'Piegatura', 'Determinato');

# voglio vedere tutti i dati complessivi di ogni persona
SELECT * FROM Persone LEFT JOIN Dipendenti ON Persone.id = Dipendenti.id;

# voglio vedere il nominativo della persona piu anziana
SELECT CONCAT(nome, " ", cognome) AS Nominativo,
		TRUNCATE(DATEDIFF(NOW(), dob)/365.25, 0) AS Età
FROM Persone
WHERE dob = (SELECT MIN(dob) FROM Persone);

# voglio vedere il nominativo della Persona con lo stipendio maggiore
SELECT CONCAT (Persone.nome," ", Persone.cognome) AS Nominativo, Dipendenti.stipendio
FROM Persone INNER JOIN Dipendenti ON Persone.id = Dipendenti.id
HAVING MAX(Dipendenti.stipendio);	

# voglio vedere lo stipendio medio in base alla mansione
SELECT Dipendenti.mansione, AVG(stipendio)
FROM Persone, Dipendenti
WHERE Persone.id = Dipendenti.id
GROUP BY Dipendenti.mansione; 

# voglio vedere il numero di persone in base al loro tipo di contratto
SELECT Dipendenti.tipoContratto, count(Dipendenti.id)
FROM Persone, Dipendenti
WHERE Persone.id = Dipendenti.id
GROUP BY Dipendenti.tipoContratto;

# voglio vedere il nominativo e il numero di anni che mancano alla pensione
		# (la pensione avviene a 70 anni compiuti o a 45 lavorati)
SELECT CONCAT(nome, " ", cognome) AS Nominativo,
		TRUNCATE(DATEDIFF(NOW(), dob)/365.25, 0) AS Eta,
        anniEsperienza AS Anni_Lavorati,
        (45 - anniEsperienza) AS Anni_alla_Pensione_Lavoro,
        (70 - TRUNCATE(DATEDIFF(NOW(), dob)/365.25, 0)) AS Anni_alla_Pensione_Eta,
        IF((45 - anniEsperienza) < (70 - TRUNCATE(DATEDIFF(NOW(), dob)/365.25, 0)), (45 - anniEsperienza), (70 - TRUNCATE(DATEDIFF(NOW(), dob)/365.25, 0))) AS Migliore
FROM Persone LEFT JOIN Dipendenti ON Persone.id = Dipendenti.id;

#IF (condizione, valoreSeVero, Valore se Falso)
# ATTENZIONE !! IF si usa solo nel SELECT e non toglie record! serve solo per decidere cosa stampare per ogni record
# CASE WHEN(condizione) THEN(valoreVero) ELSE(valore FAlso) END AS alias

#voglio vedere lo stipendio medio in base al genere
SELECT Persone.genere,AVG(stipendio)
FROM Dipendenti, Persone
WHERE Persone.id = Dipendenti.id
GROUP BY Persone.genere;

#voglio vedere il nominativo della persona che prende lo stipendio maggiore in base alla mansione
SELECT Dipendenti.mansione, CONCAT(Persone.nome, " ", Persone.cognome), MAX(stipendio)
FROM Persone LEFT JOIN Dipendenti ON Persone.id = Dipendenti.id
Group by mansione;

#voglio vedere quante persone prendono uno stipendio inferiore allo stipendio medio generale
SELECT count(Persone.id)
FROM Persone, Dipendenti
WHERE Persone.id = Dipendenti.id AND stipendio < (
					SELECT AVG(stipendio)
					FROM Dipendenti
				   );

#voglio vedere l'eta media in base alla tipologia di contratto
SELECT Dipendenti.tipoContratto,AVG(TRUNCATE(DATEDIFF(NOW(), Persone.dob)/365.25,0)) AS MediaEta
FROM Dipendenti, Persone
WHERE Persone.id = Dipendenti.id
GROUP BY tipoContratto;


#   RELAZIONE n-n
#¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
# La Realzione N-N in SQL non ESISTE nella realtà
# In SQL la relazione N-N viene solo simulata, spezzandola in due realzioni 1-N

# Quali realzioni esistono in SQL?  1-1 e 1-N (si pùo simulare la relazione N-N con due realzioni 1-N)
#Quali relazioni esistono? 1-1, 1-N, N-N

# IN una realzione N-N ogni record della tabella 1 si collega a N record della tabella 2 e viceversa.

CREATE DATABASE Universita;
USE Universita;


CREATE TABLE Studenti
(id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(150),
cognome VARCHAR(100),
dob DATE,
facolta VARCHAR(150));

SELECT * FROM Studenti;

INSERT INTO `Universita`.`Studenti` (`nome`, `cognome`, `dob`, `facolta`) VALUES ('Pino', 'Pane', '2003-12-25', 'Medicina');
INSERT INTO `Universita`.`Studenti` (`nome`, `cognome`, `dob`, `facolta`) VALUES ('Piero', 'Pelu', '1997-09-28', 'Musica');
INSERT INTO `Universita`.`Studenti` (`nome`, `cognome`, `dob`, `facolta`) VALUES ('Renzo', 'Piano', '2003-12-14', 'Architettura');
INSERT INTO `Universita`.`Studenti` (`nome`, `cognome`, `dob`, `facolta`) VALUES ('Tizio', 'Ciao', '1999-05-21', 'Medicina');
INSERT INTO `Universita`.`Studenti` (`nome`, `cognome`, `dob`, `facolta`) VALUES ('Julia', 'Ross', '2002-02-25', 'Musica');

CREATE TABLE Esami
(id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100),
crediti INT,
modalita VARCHAR(100));

SELECT * FROM Esami;
INSERT INTO `Universita`.`Esami` (`nome`, `crediti`, `modalita`) VALUES ('Costruzioni', '10', 'Pratico');
INSERT INTO `Universita`.`Esami` (`nome`, `crediti`, `modalita`) VALUES ('Anatomia', '15', 'Orale');
INSERT INTO `Universita`.`Esami` (`nome`, `crediti`, `modalita`) VALUES ('Analisi', '1', 'Scritto');
INSERT INTO `Universita`.`Esami` (`nome`, `crediti`, `modalita`) VALUES ('Istologia', '12', 'Scritto');
INSERT INTO `Universita`.`Esami` (`nome`, `crediti`, `modalita`) VALUES ('Medicina Generale', '8', 'Scritto');
INSERT INTO `Universita`.`Esami` (`nome`, `crediti`, `modalita`) VALUES ('Sinfonia', '5', 'Pratico');
INSERT INTO `Universita`.`Esami` (`nome`, `crediti`, `modalita`) VALUES ('Tirocinio Riparto', '20', 'Pratico');

DELETE FROM Esami WHERE id > 7;

# TABELLA Associativa: sarà la tabella che collegherà Studenti a Esami simulando la relazione N-N
CREATE TABLE EsamiSostenuti
(id INT PRIMARY KEY AUTO_INCREMENT,
idStudente INT, 
idEsame INT,
dataEsame DATE,
voto INT,
aula VARCHAR(100),
professore VARCHAR(150),
FOREIGN KEY (idStudente) REFERENCES Studenti(id)
ON DELETE SET NULL
ON UPDATE CASCADE,
FOREIGN KEY (idEsame) REFERENCES Esami(id)
ON DELETE SET NULL
ON UPDATE CASCADE);

SELECT * FROM EsamiSostenuti;
INSERT INTO `Universita`.`EsamiSostenuti` (`idStudente`, `idEsame`, `dataEsame`, `voto`, `aula`, `professore`) VALUES ('2', '6', '2023-01-09', '13', 'Sala 1', 'Mozart');
INSERT INTO `Universita`.`EsamiSostenuti` (`idStudente`, `idEsame`, `dataEsame`, `voto`, `aula`, `professore`) VALUES ('1', '2', '2024-01-20', '11', 'Aula 3', 'Altman');
INSERT INTO `Universita`.`EsamiSostenuti` (`idStudente`, `idEsame`, `dataEsame`, `voto`, `aula`, `professore`) VALUES ('2', '6', '2023-09-17', '19', 'Sala 1', 'Mozart');
INSERT INTO `Universita`.`EsamiSostenuti` (`idStudente`, `idEsame`, `dataEsame`, `voto`, `aula`, `professore`) VALUES ('4', '2', '2024-01-20', '27', 'Aula 3', 'Altman');
INSERT INTO `Universita`.`EsamiSostenuti` (`idStudente`, `idEsame`, `dataEsame`, `voto`, `aula`, `professore`) VALUES ('4', '4', '2024-01-10', '24', 'Aula 2', 'Hunt');
INSERT INTO `Universita`.`EsamiSostenuti` (`idStudente`, `idEsame`, `dataEsame`, `voto`, `aula`, `professore`) VALUES ('3', '1', '2023-12-10', '18', 'Sala 2', 'Scarpa');
INSERT INTO `Universita`.`EsamiSostenuti` (`idStudente`, `idEsame`, `dataEsame`, `voto`, `aula`, `professore`) VALUES ('1', '7', '2023-01-22', '28', 'Reparto Neurologia', 'Shepard');

# voglio vedere tutti i dati relazionati tra loro
SELECT *
FROM Studenti INNER JOIN EsamiSostenuti ON Studenti.id = EsamiSostenuti.idStudente
			  INNER JOIN Esami          ON Esami.id    = EsamiSostenuti.idEsame;
# OCCHIO Dalla seconda JOIN di fila in poi ricordatevi che farete la JOIN tra il risultato della 
			# prima e la seconda
            
# volgio vedere solo i nominativi degli studenti che hanno sostenuto l'esame di Anatomia
SELECT CONCAT(Studenti.nome, " ", Studenti.cognome) Nominativo, Esami.nome
FROM Studenti INNER JOIN EsamiSostenuti ON Studenti.id = EsamiSostenuti.idStudente
			  INNER JOIN Esami          ON Esami.id    = EsamiSostenuti.idEsame
WHERE Esami.nome = "Anatomia";

/*ESERCIZI
Voglio vedere nominativo, il nome dell'esame e la data di ogni esame non superato
Voglio vedere il voto medio di ogni studente (nella media i voti insufficienti(sotto il 18) non vengono calcolate)
Voglio vedere il nominativo degli studenti che hanno preso il voto maggiore
Voglio vedere il numero di studenti che hanno dato esami per ogni professore
Voglio vedere il voto maggiore e il nome dello studente che lo ha ottenuto per ogni esame
Voglio vedere per ogni studente il numero di esami sostenuti, il numero di esami superati e il numero di esami non superati
*/

#Voglio vedere nominativo, il nome dell'esame e la data di ogni esame non superato
SELECT CONCAT(Studenti.nome, " ", Studenti.cognome) Nominativo, Esami.nome, EsamiSostenuti.dataEsame
FROM Studenti INNER JOIN EsamiSostenuti ON Studenti.id = EsamiSostenuti.idStudente
			  INNER JOIN Esami          ON Esami.id    = EsamiSostenuti.idEsame
WHERE EsamiSostenuti.voto < 18;

# Voglio vedere il voto medio di ogni studente (nella media i voti insufficienti(sotto il 18) non vengono calcolate)
SELECT AVG(EsamiSostenuti.voto)
FROM Studenti INNER JOIN EsamiSostenuti ON Studenti.id = EsamiSostenuti.idStudente
			  INNER JOIN Esami          ON Esami.id    = EsamiSostenuti.idEsame
WHERE EsamiSostenuti.voto >= 18;

#Voglio vedere il nominativo degli studenti che hanno preso il voto maggiore
SELECT CONCAT(Studenti.nome, " ", Studenti.cognome), EsamiSostenuti.voto
FROM Studenti INNER JOIN EsamiSostenuti ON Studenti.id = EsamiSostenuti.idStudente
			  INNER JOIN Esami          ON Esami.id    = EsamiSostenuti.idEsame
WHERE EsamiSostenuti.voto = (SELECT MAX(EsamiSostenuti.voto)
					FROM Studenti INNER JOIN EsamiSostenuti ON Studenti.id = EsamiSostenuti.idStudente
					INNER JOIN Esami          ON Esami.id    = EsamiSostenuti.idEsame);
                    
#Voglio vedere il numero di studenti che hanno dato esami per ogni professore
SELECT EsamiSostenuti.professore, COUNT(Studenti.id)
FROM EsamiSostenuti LEFT JOIN Studenti ON Studenti.id = EsamiSostenuti.idStudente
				INNER JOIN Esami          ON Esami.id    = EsamiSostenuti.idEsame
GROUP BY EsamiSostenuti.professore;

#Voglio vedere il voto maggiore e il nome dello studente che lo ha ottenuto per ogni esame
SELECT CONCAT(Studenti.nome, " ", Studenti.cognome) Nominativo, Esami.nome, MAX(EsamiSostenuti.voto)
FROM Studenti INNER JOIN EsamiSostenuti ON Studenti.id = EsamiSostenuti.idStudente
			  INNER JOIN Esami          ON Esami.id    = EsamiSostenuti.idEsame
GROUP BY Esami.nome;

#Voglio vedere per ogni studente il numero di esami sostenuti
		#, il numero di esami superati e il numero di esami non superati
SELECT CONCAT(Studenti.nome, " ", Studenti.cognome) Nominativo, COUNT(Esami.id) AS esami_sostenuti
		, SUM(CASE WHEN EsamiSostenuti.voto >= 18 THEN 1 ELSE 0 END) AS NumeroEsamiSuperati
        , SUM(CASE WHEN EsamiSostenuti.voto < 18 THEN 1 ELSE 0 END) AS NumeroEsamiNonSuperati
FROM Studenti LEFT JOIN EsamiSostenuti ON Studenti.id = EsamiSostenuti.idStudente
			  INNER JOIN Esami          ON Esami.id    = EsamiSostenuti.idEsame
GROUP BY Esami.nome;

/*
Voglio vedere i crediti totali di ogni studente, immaginando che basti superare l'esame per prendere l'intero valore dei crediti
Aggiungere la tabella Facolta, che avrà id, nomeFacolta, citta e collegarla alla tabella studenti.
Riempire la tabella facolta
Voglio vedere per ogni facoltà il numero di studenti presenti
Voglio vedere solo i nominativi degli studenti senza crediti
Voglio vedere le facoltà senza studenti
Voglio vedere gli esami non sostenuti
Voglio vedere per ogni facoltà il numero totale di esami sostenuti e la percentuale di esami passati
Voglio vedere la facolta con il maggior numero di studenti
Voglio vedere l'età media per ogni facoltà
*/

#Voglio vedere i crediti totali di ogni studente
	#, immaginando che basti superare l'esame per prendere l'intero valore dei crediti
SELECT CONCAT(Studenti.nome, " ", Studenti.cognome) Nominativo, SUM(EsamiSostenuti.voto)
FROM Studenti LEFT JOIN EsamiSostenuti ON Studenti.id = EsamiSostenuti.idStudente
			  INNER JOIN Esami          ON Esami.id    = EsamiSostenuti.idEsame
WHERE EsamiSostenuti.voto >= 18
GROUP BY Studenti.nome;

#Aggiungere la tabella Facolta, che avrà id, nomeFacolta, citta e collegarla alla tabella studenti.

# in un facolta, ci sono tanti studenti
CREATE TABLE Facolta
(id INT PRIMARY KEY AUTO_INCREMENT,
nomeFacolta VARCHAR(80),
citta VARCHAR (80),
idStudente INT,
FOREIGN KEY (idStudente) REFERENCES Studenti(id)
ON DELETE SET NULL
ON UPDATE CASCADE);



# DA FARE cambia foreign key

SELECT * FROM Facolta;
-- Insert data into Facolta table
INSERT INTO `Universita`.`Facolta` (`nomeFacolta`, `citta`, `idStudente`) VALUES ('Medicina', 'Roma', 1);
INSERT INTO `Universita`.`Facolta` (`nomeFacolta`, `citta`, `idStudente`) VALUES ('Musica', 'Milano', 2);
INSERT INTO `Universita`.`Facolta` (`nomeFacolta`, `citta`, `idStudente`) VALUES ('Architettura', 'Firenze', 3);
INSERT INTO `Universita`.`Facolta` (`nomeFacolta`, `citta`, `idStudente`) VALUES ('Medicina', 'Roma', 4);
INSERT INTO `Universita`.`Facolta` (`nomeFacolta`, `citta`, `idStudente`) VALUES ('Musica', 'Milano', 5);
INSERT INTO `Universita`.`Facolta` (`nomeFacolta`, `citta`) VALUES ('something', 'BARI');

#Voglio vedere per ogni facoltà il numero di studenti presenti
SELECT nomeFacolta, COUNT(Studenti.id)
FROM Facolta LEFT JOIN Studenti ON Studenti.id = Facolta.idStudente
GROUP BY nomeFacolta;

#Voglio vedere solo i nominativi degli studenti senza crediti


#Voglio vedere le facoltà senza studenti
SELECT Facolta.*
FROM Facolta LEFT JOIN Studenti ON Studenti.id = Facolta.idStudente
WHERE Facolta.idStudente IS NULL;

#Voglio vedere gli esami non sostenuti
SELECT Esami.*
FROM Esami LEFT JOIN Studenti ON Studenti.id = Facolta.idStudente
WHERE Facolta.idStudente IS NULL;