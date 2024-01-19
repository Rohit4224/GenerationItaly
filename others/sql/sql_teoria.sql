-- commento monorigo (lo spazione deve esserci)
# commento monoriga
/*
commento multiriga
*/
# RICORDATEVI SEMPRE CHE E' IL DB SEMPRE AD AVERE RAGIONE, NON LO SCRIPT

# creazione di un database chiamato PrimoDataBase
CREATE DATABASE DB112;

# SQL non è casesensitive
# LA CONVENZIONE PERO' CI DICE DI SCRIVERE IN CAPS LE PAROLE CHE SONO COAMANDI
#IN SQL NON BASTA SCRIVERE LO SCRIPT, MA VA LANCIATO AFFINCHE' SIA ESEGUITO RELAMENTE DAL SERVER
#ATTENZIONE! DOPO LANCIATO COMMANDO, E' MOLTO MOLTO DIFFICILE TORNARE IN INDIETRO
#UNA VOLTA ESEGUITO LO SCRIPT, PER SQL QUELLO SCRIPT NON HA PIU VALORE.
#PER ESEGUIRE UNO SCRIPT SI DEVE EVIDENZIARE TUTTO IL COMANDO, FINO AL ; E CLICCARE SUL FULMINE "LIBERO"

# usa il database DB112
USE DB112;

# CREARE LA TABELLA PERSONE
CREATE TABLE Persone
(
	nome VARCHAR(60),
    cognome VARCHAR(80),
    citta_residenza VARCHAR(50),
    dob DATE,
    stipendio DOUBLE,
    #stipendio2 DECIMAL(7,2),
    numero_civico INT,
    sposato BOOL
);

# DETTAGLI
# 1) Le convenzioni ci dicono che i nomi delle tabelle devono essere al
 #plurale, perchè rappresentano
# molti record diversi allo stesso tempo (i record si possono anche
#chiamare righe o tuple)
# 2) Quando create una tabella dovete scrivere le colonne che la formeranno: le
#colonne si scrivono mettendo
# prima il nome della colonna e dopo il tipo di dato che ci vogliamo
#salvare dentro.
# Se ci sono caratterische ulteriori vanno posizionate dopo il tipo.
# 3) I nomi composti solitamente sono scritti con un underscore(_) tra le
#parole (ES. numero_civico), cioè in snake_case
# Sono accettati i nomi con gli accenti, ma poichè spesso le tabelle
#devono interagire con linguaggi come Java
# di prassi è sconsigliato usare nomi accettanti (perchè quando Java
#parlerà con MySQL gli accenti potrebbero dare fastidio)
# 4) I tipi in SQL sono i seguenti:
# - CHAR ------------> Identifica un singolo carattere (ES. M o F)
# - VARCHAR ---------> Identifica un insieme di caratteri.
# Se senza tonde possiamo inserire fino a
#65535 caratteri.
# Se le tonde sono presenti il numero
#massimo di caratteri sarà quello indicato
# nelle parentesi.
# - INT -------------> Identifica un numero intero che va da -2147483648
#a 2147483647
# - DOUBLE/FLOAT ----> Identifica un numero decimale che può avere fino a
#65 cifre totali
# - NUMERIC ---------> Identifica un numero decimale in cui la prima
#cifra tra le tonde indica il numero
# totale di cifre, mentre la seconda
#indica il numero totale di decimali tra quelli
# indicati (ES NUMERIC(5,2) comprende
#tutti i numeri tra -999,99 e 999,99)
# - BOOL/BOOLEAN ----> Identifica un valore TRUE/FALSE, dove 1
#rappresenta TRUE e 0 rappresenta FALSE
# - BIT -------------> Identifica i bit di un dato (saranno valori
#formati da 0 e 1).
# In altri DBMS come SQL Server, può
#rappresentare un valore booleano.
# - DATE ------------> Identifica una data, formattata con il pattern
#YYYY-MM-GG

#ALTER TABLE Persone
#DROP COLUMN stipendio2;
# 1 E' TRUE AND 0 E' FALSE


#PER DATABASE DB112
SELECT * FROM Persone;

INSERT INTO Persone
VALUES
("Pino","Pane","Milano","1999-09-25",1345.54,2,0),
("Alice","Bensanelli","Zelo","1997-04-23",1490.60,24,0),
("Ella","Cinder","Londra","1956-12-29",0.0,100,1);

#Dettagli


RENAME TABLE vecchio_nome TO nuovo_nome;

#Cancellare il table
DROP TABLE nome_tabella;

# aggiungere una colonna 
ALTER TABLE Persone
ADD COLUMN indirizzo VARCHAR(150) AFTER stipendio;

# Modificare una colonna (cambia solo la Tipologia)
ALTER TABLE Persone
MODIFY COLUMN indirizzo VARCHAR(100);

#Modificare una colonna (nome e tipologia)
ALTER TABLE Persone
CHANGE column indirizzo indirizzo_residenza VARCHAR(100);

#Cancellare una colonna e il suo contenuto
ALTER TABLE Persone
DROP COLUMN nome_colonna;

#Commando: giocare coi record(coi dati)
# Eliminare un record (ATTenzione!!)
DELETE FROM PERSONE WHERE ID = VALORE;

DELETE FROM Persone where id = 3;

ALTER TABLE Persone
ADD id INT PRIMARY KEY AUTO_INCREMENT FIRST;

INSERT INTO Persone
(nome, cognome, citta_residenza, dob, stipendio, indirizzo_residenza, numero_civico, sposato)
VALUES
("Ken","O'Conner","MILANO","1967-09-03",1234.09,"Via Dei matti",0,1),
("John","Smith","LONDRA","1999-01-31",234.0,null,null,1);

#modificare un ricord esistente
UPDATE Persone
SET indirizzo_residenza = "Piazza Plebiscito"
WHERE id = 1 or id = 2;

UPDATE Persone
SET indirizzo_residenza = "Piligram Street", numero_civico = 7
WHERE id = 5;

# DDL -> Data Definition Language (Operazioni sulla struttura(tabelle, DB, colonne))
# DML -> Data Manipulation Language (Operazioni sui dati(insert, delete, update))
# DQL -> Data Query Language (Interrogazione sui dati (select))
# DCL -> Data Control Language (Operazioni di controllo sui dati)

SELECT * FROM Persone;

# voglio vedere solo la colonno nome, cognome, citta
SELECT nome, cognome, citta_residenza
FROM Persone;


# voglio vedere solo i residenti a Milano
SELECT * 
FROM Persone
WHERE citta_residenza = "milano";

# voglio vedere solo le persone sposate e residenti a milano
SELECT *
FROM Persone
WHERE citta_residenza = "milano" AND sposato = 1;

SELECT CONCAT(nome," ", cognome) AS Nominativo,
		citta_residenza AS Residenza, sposato
FROM Persone
WHERE citta_residenza = "milano " AND sposato IS TRUE;


#voglio vedere per ogni persona il suo nominativo, la sua data di nascita e la sua eta
SELECT CONCAT(nome, " ", cognome) AS "Nominativo",
		dob AS "Data di Nascita",
		TRUNCATE(DATEDIFF(NOW(), dob)/365.25,0) AS Età
FROM Persone;

# voglio vedere solo le persone con un età superiore a 30 anni
SELECT CONCAT(nome, " ", cognome) AS "Nominativo",
		dob AS "Data di Nascita",
		TRUNCATE(DATEDIFF(NOW(), dob)/365.25,0) AS Eta
FROM Persone
WHERE TRUNCATE(DATEDIFF(NOW(), dob)/365.25,0) >= 30;

#Dettagli
# AS serve a creare un alias.
# Se messo nel SELECT cambia solo in stampa il nome della colonna
# Se messo nel FROM cambia il nome della tabella per tutta la durata della query
# AS ha 2 forma:
#	- AS nome ---> Non vuole gli spazi e quel nome puo essere richiamato nel codice se messo nel posto giusto
#	- AS "nome" -> Puo avere spazi ma non potra essere usato per richiamare l'elemento

# Funzioni scalari
# 	TRUNCATE --> Serve per 'troncare' senza arrotondamento un numero al decimale indicato come secondo parametro
#		Eempio:
#			TRUNCATE(1.2345,0) -> 1
#			TRUNCATE(1.2345,1) -> 1.2
#			TRUNCATE(1.2345,2) -> 1.23
# 	DATEDIFF --> Calcola la differenza in giorni tra il primo parametro e il secondo
#	NOW -------> Estrae dal sistema la data attuale
# 	YEAR ------> Estrapola unicamente l'anno della data messa tra parentesi
# 	CONCAT ----> Concatena due o piu parametri mettendoli nella stessa colonna temporanea


# Order by
#¯¯¯¯¯¯¯¯¯
SELECT *
FROM Persone
ORDER BY citta_residenza, numero_civico;

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

# FUNZIONE DI GRUPPO / Aggregate Functions
#¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
# Sono funzioni che di base tendono a compattare i record, restituendo di base un solo risultato totale
# LE funzioni di gruppo sono solo 5: COUNT(), SUM(), MAX(), MIN(), AVG()
# Tutte le funzioni di gruppo tranne COUNT vogliono un solo argomento
		#, che deve per forza essere una colonna di tipo numerico
# oltre 5 funzioni sopra, sono Funzioni scalare.	


# voglio vedere il prezzo piu alto
#SBAGLIATO
# MAI mettere una FUNZIONA DI GRUPPO direttemente nel WHERE perché 
/*esempio del SBAGLIO
SELECT costo
FROM Macchine
WHERE max(prezzo);
*/

#GIUSTO :
SELECT max(costo) "Costo del Macchine"
FROM Macchine;

#SUBQUERY
#¯¯¯¯¯¯¯¯
# voglio vedere la macchina con il prezzo maggiore
# ATTENZIONE, il risultato ci da, prezzo max però marca e modello sarà il primo row del database,
# NON è corretto:
-- SELECT MAX(costo) Prezzo
-- 		, marca, modello
-- FROM Macchine;

# corretto
SELECT *
FROM Macchine
WHERE costo = (SELECT MAX(costo) FROM Macchine);

# OR
SELECT *, (SELECT MAX(costo) FROM Macchine) Max
FROM Macchine
WHERE costo = (SELECT MAX(costo) FROM Macchine);

# or
SELECT *, Max(costo) MAX
FROM Macchine
WHERE costo = (SELECT MAX(costo) FROM Macchine);
# La query nelle tonde si chiama SUBQUERY, e di questa subquery io uso il valore risultante
	# ATTENZIONE, deve per forza essere un valore singolo, altrimenti ci darà errore, tonde è obbligatorio



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


# VIEW
#¯¯¯¯¯
# E' una tabella fittizia, perchè nel concreto non esiste come tabella fisica.
# Le tabella fisiche sono le classiche tabelle che vengono create usando il comando CREATE TABLE.
# vengono definite fisiche perchè esistono anche i loro metadati, cioè le informazioni legate
					#alla struttura della tabella
# (ES. i limiti di un intero sono metadati, il tipo di dato di una colonna è un metadato, mentre il
		# valore di una cella è semplicemente un dato)
#Le taballe fittizie vengono create con un comando diverso, mancheranno i metadati e il suo contenuto
		# si aggiornerà da solo in conseguenza alle modifiche effettuatate sulla tabella fisica originale
        # Inoltre non avendo metadati le taballe fittizie sono molto più leggere rispetto 
        # alle loro origianlli
# Le VIEW sono spesso chiamate "query salvate"

CREATE DATABASE Cinema;
USE Cinema;

CREATE TABLE Films
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    titolo VARCHAR(300),
    regista VARCHAR(150),
    genere VARCHAR(100),
    durata INT,
    oscar BOOL
);

SELECT * FROM Films;

# TRAMITE INTERFACCIA
INSERT INTO `Cinema`.`Films` (`titolo`, `regista`, `genere`, `durata`, `oscar`) VALUES ('the creator', 'John', 'SCI-FI', '140', '0');

# tramite CSV
# Bisogna avere un File.csv
# using import

# Modo per riempire velocemente la tabella: TRAMITE CSV
#     1) Bisogna avere un file .CSV riempito da caricare
#    2) Scegliere "import" o dal menù di sinistra o dal tastino nella tabella risultante
#    3) Scegliere il file .cvs da importare e fare Next
#    4) Scegliere se usare una tabella già pronta o se crearla (Solitamente si usa la prima) e fare NEXT
#    5) Controllare che ogni colonna del csv sia in linea con quella del DB e fare NEXT
#    6) Fare NEXT per importare e i dati e di nuovo NEXT per concludere, se non ci sono errori fare FINISH

CREATE VIEW Statistiche_Films AS
	SELECT COUNT(id) AS Numero_Film,
		MAX(durata) AS Durata_MAX,
        MIN(durata) AS Durata_MIN,
        AVG(durata) AS Durata_AVG,
        SUM(durata) AS Durata_Sum
	FROM Films;
    
SELECT * FROM Statistiche_Films;

SELECT 	titolo,
		durata,
		Statistiche_Films.Durata_avg AS MEDIA
FROM Films, Statistiche_Films
WHERE durata > Statistiche_Films.Durata_AVG;

INSERT INTO Films
(titolo, regista, durata, genere, oscar)
VALUES
("Intersteller", "Nolan", 250, "Fantasy", 1);

Select * FROM Films, Statistiche_Films;


#RELAZIONI
#¯¯¯¯¯¯¯¯¯

# USIAMO lo stesso DB Cinema Del file 03-View
USE Cinema;

# Ipotizziamo che ogni film sarà proiettato sempre e solo in una sala specifica
CREATE TABLE sale
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    alta_Risoluzione BOOL,
    posti INT,
    idFILM INT,
    FOREIGN KEY(idFilm) REFERENCES Films(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

# Se voglio far si che due tabelle possono collegarsi, quindi scambiarsi dati, devo fare 
     # in modo che si possano riconoscere in modo assolutamente certo i record interessati al dialogo.
# Devo gestire alcune situazioni : 
	# - quale record mi interessa legare alla sala (idFilm INT)
    # - quale ricord contiene il record (FOREIGN KEY(idFilm) REFERENCES Films(id))
    # - come mi comporto se il record interessato viene cancellato (ON DELETE SET NULL)
    # - come mi comporto se il record interessato viene modificato (ON UPDATE CASCADE)
    
# FOREIGN KEY: spesso abbreviata come FK, la chiave esterna serve per indicare quale tabella vogliamo
			# legare a SALE, e per quali colonne vogliamo avvenga questo legame.

# ** IMPORTANTE : che relazioni esistono in SQL ? 
		# Esistono 3 relazioni diverse : 1-1, 1-n, n-n
        # 1-1, uno principale - uno subordinato
			#ogni record della tabella 1 si collega a uno e un solo record della tabella 2
        # 1-n, uno principale - n numbers of subordinato
			# ogni record della tabella 1 si collega a tanti record della tabella 2
        # n-n, n numbers of principale - n numbers of subordinato
			# ogni record della tabella 1 si collega a tanti record della tabella 2 e viceverso

# ON UPDATE/ON DELETE: vogliono di seguito un comportamento da tenere nel caso in cui il valore 
		# legato tramite FK venga modificato o cancellato.
# I comportamenti : SET NULL -> metto null alla FK, CASCADE -> FK subisce la stessa cosa subito dal
		# record collegato, 
        # RESTRICTED o NO ACTION

#Here's a brief summary of the possible actions in ON UPDATE:

#CASCADE: Update the corresponding values in the child table.
#RESTRICT: Prevent the update in the parent table if it would cause a violation.
#SET NULL: Set the foreign key values in the child table to NULL if the corresponding values in the parent table are updated to NULL.
#SET DEFAULT: Set the foreign key values in the child table to their default values if the corresponding values in the parent table are updated.

SELECT * FROM sale;
SELECT * FROM Films;

INSERT INTO `Cinema`.`sale` (`nome`, `alta_Risoluzione`, `posti`, `idFILM`) VALUES ('Fuoco', '1', '380', '1');
INSERT INTO `Cinema`.`sale` (`nome`, `alta_Risoluzione`, `posti`, `idFILM`) VALUES ('Acqua', '0', '250', '1');
INSERT INTO `Cinema`.`sale` (`nome`, `alta_Risoluzione`, `posti`, `idFILM`) VALUES ('Terra', '0', '200', '3');
INSERT INTO `Cinema`.`sale` (`nome`, `alta_Risoluzione`, `posti`, `idFILM`) VALUES ('Aria', '0', '200', '4');
INSERT INTO `Cinema`.`sale` (`nome`, `alta_Risoluzione`, `posti`) VALUES ('Giallo', '0', '150');


# voglio vedere il titolo di ogni film proiettato e il nome della sala in cui viene proiettato
-- SBALIATO , ma query giu si chiama -- **CROSS JOIN**
-- SELECT * 
-- FROM Films, sale
#se nella query vedete scritto INNER JOIN si dice che si sta facendo una INNER JOIN ESPLICITA
SELECT *
FROM Films INNER JOIN sale ON Films.id = sale.idFilm;
# Nel FROM noi possiamo mettere tutte le tabelle che desideriamo. Se però non indichiamo il tipo
		# di collegamento (JOIN) che vogliamo fare, in autonomo il DB farà una cosa chiamata
		# CROSS JOIN, cioè un prodotto cartesiano

# INNER JOIN -> Tiene solo le combo di record che rispettano il predicato
# PREDICATO DI JOIN: è la regalo che detta l'esistenza delle combo nella join. per intenderci,
						# è il codice dopo ON.

# se nella query vedete scritta una CROSS JOIN con un WHERE in cui PK = FK, si dice INNER JOIN IMPLICITA
SELECT * 
FROM Films, sale
WHERE Films.id = sale.idfilm;

# D'ora in poi noi goicheremo con tante tabelle alla volta, quindi sarà comodo usare sempre 
        # tabella.colonna dentro alle query
        
# JOIN NON SIGNIFICA RELAZIONE !!!! (LINE 474)

# voglio vedere il titolo dei film che verrano proiettati in alta risoluzione
SELECT titolo
FROM Films, sale
WHERE Films.id = sale.idfilm AND sale.alta_Risoluzione = 1;

# voglio vedere il nome della sala che proietta il film piu lungo in proiezione
SELECT sale.nome
FROM sale INNER JOIN Films ON sale.idfilm = Films.id
WHERE Films.durata = (SELECT MAX(durata) FROM Films, sale WHERE Films.id = sale.idfilm);

#voglio vedere per ogni film proiettato, il numero di posti a sedere disponibili
SELECT Films.titolo, SUM(sale.posti)
FROM Films, sale
WHERE Films.id = sale.idfilm
GROUP BY Films.id, Films.titolo;


