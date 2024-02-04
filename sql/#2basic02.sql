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