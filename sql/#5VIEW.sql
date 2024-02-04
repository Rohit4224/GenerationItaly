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