#     STORED, TRIGGER, FUNCTION

CREATE DATABASE Azienda02;
USE Azienda02;

CREATE TABLE Dipendenti
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nominativo VARCHAR(350),
    mansione VARCHAR(100),
    stipendio DOUBLE
);

SELECT * FROM Dipendenti;
INSERT INTO `Azienda02`.`Dipendenti` (`nominativo`, `mansione`, `stipendio`) VALUES ('Mario Rossi', 'Programmatore', '2400');
INSERT INTO `Azienda02`.`Dipendenti` (`nominativo`, `mansione`, `stipendio`) VALUES ('Luigi Verde', 'IT ', '2000');
INSERT INTO `Azienda02`.`Dipendenti` (`nominativo`, `mansione`, `stipendio`) VALUES ('Mario Verdi', 'CEO', '1700');
INSERT INTO `Azienda02`.`Dipendenti` (`nominativo`, `mansione`, `stipendio`) VALUES ('Alice Turini', 'Programmatore', '1750');
INSERT INTO `Azienda02`.`Dipendenti` (`nominativo`, `mansione`, `stipendio`) VALUES ('Laura Bianchi', 'Programmatore', '1700');
INSERT INTO `Azienda02`.`Dipendenti` (`nominativo`, `mansione`, `stipendio`) VALUES ('Chiara Bruni', 'Docente', '1560');

#¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯STORED PROCEDURE¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯#
# è un blocco di codice che svolge operazioni di cui non ci interessa sapere un risultato in uscita
# Come le View, le STORED(o SP) vengono memorizzate nel DB, metadati compresi.

/*
	SINTASSI di una STORED PROCEDURE
    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
    DELIMETER $$ (indica che il simbolo che chiude il comando di SP non sarà più il ; ma diventa il $$)
														-- paramentri sotto sono opzionali
		CREATE PROCEDURE nomeStroredProcedure(nomeParametro1 TipoParametro1, nomeParametro2 TipoParametro2,...)
        BEGIN
			comando1;
            comando2;
            comando3;
            ....
		END $$ -> Indica la fine della SP
    DELIMETER ;  -> Riporta il ; come indicare di fine commando
    

*/

# Esempio pratico di SP
DELIMITER $$
	CREATE PROCEDURE statistica()
		BEGIN
			SELECT Mansione,
					COUNT(*) AS PerMansione,
                    ROUND(AVG(Stipendio), 2) AS Media,
                    MAX(Stipendio) AS Massimo,
                    MIN(Stipendio) AS Minimo
			FROM    Dipendenti
            GROUP BY Mansione;
        END $$
DELIMITER ; 

# Per eseguire una procedure, si deve lanciare tutto il codice, DELIMITER di Apertura e chiusura compresi
# cioè si deve lanciare da 44 a 55statisticastatistica

# per chiamare una SP già creata si usa:
CALL statistica();  -- passare parametri se necessario

# In SQL per creare un errore personalizzato si scrive:
SIGNAL SQLSTATE VALUE '45000'
SET MESSAGE_TEXT = 'Descrizione dell\'errore che si e\' verificato';

# possiamo usare questa nuova conoscenza per controllare i dati in ingresso e nel caso far uscire 
				# errore a DOC
# Da questi controlli avremo solo spunta verde o rossa in output

DELIMITER $$
		CREATE PROCEDURE verificaDipendente(n VARCHAR(350), m VARCHAR(100), s DOUBLE)
			BEGIN
				IF(n IS NULL OR n = "")
                THEN
					SIGNAL SQLSTATE VALUE '45000'
					SET MESSAGE_TEXT = 'Nominativo non valido perche\' nullo o vuoto';
				END IF;
                
                IF(m IS NULL OR m = "")
                THEN
					SIGNAL SQLSTATE VALUE '45000'
                    SET MESSAGE_TEXT = 'Mansione non valido perche\' nulla o vuoto';
				END IF;
                
                IF(s IS NULL OR s < 500 OR s > 10000)
                THEN
					SIGNAL SQLSTATE VALUE '45000'
                    SET MESSAGE_TEXT = "Stipendio non valido perche\' nullo, inferiore a 500 o
																			superiore a 10000";
				END IF;
			END $$
DELIMITER ;

CALL verificaDipendente("Rohit", "vsdv", 5300);

# ----------------------------- FUNCTION --------------------------------#
#Le FUNCTION sono molto simili all Stored procedure, con l'unica differenza che una FUNCTION
					#deve per forza restituire un valore in uscita.
/*
	Sintassi generale di una FUNCTION
    
    DELIMITER $$
	
		CREATE FUNCTION nomeFunziona(nomeParametro1 tipoParametro1, ..., ...)
			RETURNS tipoDiDatoCheVarràRestituito
            
            DETERMINISTIC --> Implica che saranno usate delle formule fisse 
								(ad esempio le formule geometriche o matematiche)
									con dei dati che arriveranno SOLAMENTE SOTTO FORMA DI PARAMETRI
            oppure
            READS SQL DATA --> implica che i dati necessari ai calcoli saranno presi dalle tabelle del DB
								(quindi li avremo tramite la scrittura di una query nel BEGIN)
			Esistono anche altre parole che possiamo usare oltre alle due scritte sopra, se vi servono 
            o se siete curiosi, le trovate nella documentazione ufficiale di SQL (OCCHIO a DBMS scelto,
            per esempio in Oracle o in base al dialetto del DBMS puo' cambiare termini)

			BEGIN
				comando1;
                comando2;
                .....
			END$$

	DELIMITER ;
*/

# Esempi Pratici
# voglio scrivere una funziona che calcoli lo stipendio annuo dei miei dipendenti
DELIMITER $$
	CREATE FUNCTION stipendioAnnuo(stipendioMensile DOUBLE)
		RETURNS DOUBLE
        DETERMINISTIC
        BEGIN
			RETURN stipendioMensile * 13;
		END $$
DELIMITER ;

DELIMITER $$
	CREATE FUNCTION stipendioAnnuo2(idDipendente INT)
	RETURNS DOUBLE
	READS SQL DATA
        BEGIN
			RETURN (
						SELECT Dipendenti.stipendio*13
                        FROM Dipendenti
                        WHERE Dipendenti.id = idDipendente
				   );
		END $$
DELIMITER ;

# per eseguire una FUNCTION possiamo inserirla in una query
# Se non ci interessa usare la function su nessuna tabella
	#  presente, possiamo usare la tabella DUAL, che e' una tabella fittizia che non esiste
SELECT stipendioAnnuo(1000) FROM Dual;

SELECT *, stipendioAnnuo(stipendio)
FROM Dipendenti;

SELECT stipendioAnnuo2(id)
FROM Dipendenti;

# per cancella una funzione
DROP FUNCTION nomeFunzione;

# per cancellare una STORED PROCEDURE
DROP PROCEDURE nomeProcedure;

# per modificare una FUNCTION o una PROCEDURE gia' esistenti vi conviene sempre cancellarle
		# e ricrearle



# --------------------------- Trigger ----------------------- #
# sono blocchi di codice ad attivamente automatica.
# si attivano automaticamente all'avvenivenire di un evento tra: INSERT, UPDATE, DELETE
# I trigger si possono attivare o prima che avvenga l'evento o dopo che l'evento e' avvenuto.
# I trigger in base alla versione su cui lavorate, lavoreranno in due modi:
	# -> FOR EACH ROW: significa che il trigger viene attivato (e quindi influenza) ogni record
							# collegato all'evento
    # -> FOR EACH STATEMENT: significa che il trigger viene attivato per ogni evento
							# (deprecato per le versione successive all'8)

/*
	SINTASSI di un TRIGGER
    
    DELIMITER $$
		CREATE DEFINER = CURRENT_USER TRIGGER nomeTrigger
				--> DEFINER E' il termine con cui si indica il creatore del trigger
                --> CURRENT_USER indica che l'autore del trigger e' l'utente attualmente 
						logato al db
				--> nomeTrigger: un trigger per convezione si nomina tabella_quando_evento
        BEFORE oppure AFTER nomeEvento ON nomeTabella
				--> BEFORE(prima) e AFTER(dopo) indicano quando si deve attivare il trigger.
					Ne serve solo uno alla volta.
				-->	nomeEvento : si puo' scegliere tra INSERT, UPDATE e DELETE
                --> nomeTabella: si sceglie una delle tabelle presenti nel DB
        FOR EACH ROW oppure FOR EACH STATEMENT
        
        BEGIN 
			comando1;
            comando2;
            ....
		END $$
    
    DELIMITER ;

*/

# Esempi pratici..
DELIMITER $$
	CREATE DEFINER = CURRENT_USER TRIGGER dipendenti_BEFORE_INSERT
    BEFORE INSERT ON Dipendenti
    FOR EACH ROW
    BEGIN
		IF(NEW.nominativo IS NULL OR NEW.nominativo = "" OR LENGTH(NEW.nominativo) > 349)
		THEN
			SIGNAL SQLSTATE VALUE '45000'
			SET MESSAGE_TEXT = 'Nominativo non valido perche\' nullo, vuoto o fuoriscala';
        END IF;
        IF(NEW.mansione IS NULL OR NEW.mansione = "" OR LENGTH(NEW.mansione) > 99)
		THEN
			SIGNAL SQLSTATE VALUE '45000'
			SET MESSAGE_TEXT = 'Mansione non valido perche\' nullo, vuoto o fuoriscala';
        END IF;
        IF(NEW.stipendio IS NULL OR NEW.stipendio < 500 OR NEW.stipendio > 10000)
		THEN
			SIGNAL SQLSTATE VALUE '45000'
			SET MESSAGE_TEXT = 'Stipendio non valido perche\' nullo o fuoriscala';
        END IF;
    END $$
DELIMITER ;

# Per vedere i TRIGGER creati su MYSQL dovete fare cosi:
# -> Click sulla chiave inglese accanto alla tabella in cui avete creato il trigger
		# (chiave inglese accanto dipendenti)
# -> Cerco in basso alla pagina che si apre la scritta TRIGGER e la clicco
# -> sulla Sinistra ci sono tutti i trigger creati: cliccandoli possiamo vedere il loro script
# I trigger si attivano da soli, voi non dovrete mai chiamarli direttamente
# per farli attivare basta scatenare l'evento che li interessa
INSERT INTO Dipendenti
(nominativo, mansione, stipendio)
VALUES
("Pino Pane", "Programmatore", 2300),
("Mara Maria", "Docente", 1300);

SELECT * FROM Dipendenti;

# Scrivere un trigger che controlli che i dati dell'update siano corretti
DELIMITER $$
	DROP TRIGGER IF EXISTS dipendenti_BEFORE_UPDATE$$
    
   # CREATE TRIGGER dipendenti_BEFORE_UPDATE
		CREATE DEFINER = CURRENT_USER TRIGGER dipendenti_BEFORE_INSERT
		BEFORE UPDATE ON Dipendenti
        FOR EACH ROW
        BEGIN
		IF(NEW.nominativo IS NULL OR NEW.nominativo = "" OR LENGTH(NEW.nominativo) > 349)
		THEN
			SIGNAL SQLSTATE VALUE '45000'
			SET MESSAGE_TEXT = 'Nominativo non valido perche\' nullo, vuoto o fuoriscala';
        END IF;
        IF(NEW.mansione IS NULL OR NEW.mansione = "" OR LENGTH(NEW.mansione) > 99
			OR NEW.mansione NOT IN("Programmatore", "Docente", "IT", "CEO"))
		THEN
			SIGNAL SQLSTATE VALUE '45000'
			SET MESSAGE_TEXT = 'Mansione non valido perche\' nullo, vuoto o fuoriscala';
        END IF;
        IF(NEW.stipendio IS NULL OR NEW.stipendio < 500 OR NEW.stipendio > 10000)
		THEN
			SIGNAL SQLSTATE VALUE '45000'
			SET MESSAGE_TEXT = 'Stipendio non valido perche\' nullo o fuoriscala';
        END IF;
    END $$
DELIMITER ;

/*
------------------------------    ESERCIZI    ------------------------------------------
Aggiungete una colonna chiamata stipendioAnnuale alla tabella dipendenti
Riempite la colonna calcolando lo stipendio annuale(ricordatevi che in un anno ci sono 13 stipendi)
Aggiungete una colonna con la data di nascita delle persone e riempitela
Voglio una funzione che sia in grado di indicare chi deve andare in pensione (fissata a 60 anni compiuti).
Applicate poi la funzione alla tabella e mostrate i nominativi e se devono andare in pensione o no
Voglio una funzione che sia in grado per ogni persona di calcolare quanti soldi hanno guadagnato, ipotizzando che
abbiano sempre preso lo stesso stipendio attuale e che abbiano tutti iniziato a lavorare a 18 anni
Applicatela poi alla tabella dipendenti
Scrivere una funzione che calcoli un bonus sullo stipendio legato alla mansione e agli anni lavorati:
Se la mansione è Programmatore e lavora da 5 a 10 anni, + 500, se lavora da 10 a 20 + 800, più di 20 + 10000
Se la mansione è Docente e lavora da 5 a 15 anni, + 550, se lavora da più di 15 + 1100
Se la mansione è CEO, aggiungere 100 per ogni anno lavorato
Applicare poi la funzione alla tabella dipendenti
Scrivere un trigger che blocchi l'eliminazione dei dipendenti non in età da pensione

*/

-- Aggiungete una colonna chiamata stipendioAnnuale alla tabella dipendenti
-- Riempite la colonna calcolando lo stipendio annuale(ricordatevi che in un anno ci sono 13 stipendi)
ALTER TABLE Dipendenti
ADD COLUMN stipendioAnnuale DOUBLE;

UPDATE Dipendenti
SET stipendioAnnuale = stipendio * 13
WHERE id > 0;

SELECT * FROM Dipendenti;

ALTER TABLE Dipendenti
ADD COLUMN dataNascita DATE;
UPDATE `Azienda02`.`Dipendenti` SET `dataNascita` = '1997-12-31' WHERE (`id` = '1');
UPDATE `Azienda02`.`Dipendenti` SET `dataNascita` = '1996-11-30' WHERE (`id` = '2');
UPDATE `Azienda02`.`Dipendenti` SET `dataNascita` = '1995-10-29' WHERE (`id` = '3');
UPDATE `Azienda02`.`Dipendenti` SET `dataNascita` = '1994-09-28' WHERE (`id` = '4');
UPDATE `Azienda02`.`Dipendenti` SET `dataNascita` = '1993-08-27' WHERE (`id` = '5');
UPDATE `Azienda02`.`Dipendenti` SET `dataNascita` = '1992-07-26' WHERE (`id` = '6');
UPDATE `Azienda02`.`Dipendenti` SET `dataNascita` = '1991-06-25' WHERE (`id` = '7');
UPDATE `Azienda02`.`Dipendenti` SET `dataNascita` = '1990-05-24' WHERE (`id` = '8');

-- Voglio una funzione che sia in grado di indicare chi deve andare in pensione (fissata a 60 anni compiuti).
-- TRUNCATE(DATEDIFF(NOW(), Dipendenti.dataNascita)/365.25,0) AS Età
DELIMITER $$

CREATE FUNCTION checkRetirementStatus(dataNascita DATE) 
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE eta INT;
	DECLARE status VARCHAR(20);
    -- Calcola l'età in anni
   -- SET eta = YEAR(CURDATE()) - YEAR(dataNascita) - (RIGHT(CURDATE(), 5) < RIGHT(dataNascita, 5));
	  SET eta = TRUNCATE(DATEDIFF(NOW(), dataNascita)/365.25,0);

    -- Verifica se l'età supera i 60 anni
    IF eta >= 60 THEN
        SET status = 'Andato in pensione';
    ELSE
        SET status = 'Non ancora in pensione';
    END IF;
    RETURN LEFT(status, 20);
END $$

DELIMITER ;

-- Applicate poi la funzione alla tabella e mostrate i nominativi e se devono andare in pensione o no
SELECT 
    nominativo, 
    checkRetirementStatus(Dipendenti.dataNascita) As Result
FROM Dipendenti;

/*
Voglio una funzione che sia in grado per ogni persona di calcolare quanti soldi hanno guadagnato, ipotizzando che
abbiano sempre preso lo stesso stipendio attuale e che abbiano tutti iniziato a lavorare a 18 anni
*/ 
DELIMITER $$

CREATE FUNCTION calculateTotalEarnings(dataNascita DATE, stipendioMensile DOUBLE) 
RETURNS DOUBLE
DETERMINISTIC
BEGIN
    DECLARE etaInizioLavoro INT;
    DECLARE totalEarnings DOUBLE;

    -- Calcola l'età in anni quando hanno iniziato a lavorare (assumendo a 18 anni)
    SET etaInizioLavoro = TRUNCATE(DATEDIFF(NOW(), dataNascita)/365.25, 0) - 18;

    -- Calcola gli guadagni totali assumendo stipendio fisso
    SET totalEarnings = stipendioMensile * 13 * etaInizioLavoro;

    RETURN totalEarnings;
END $$

DELIMITER ;

-- Applicatela poi alla tabella dipendenti
SELECT 
    nominativo, 
    calculateTotalEarnings(dataNascita, stipendio) AS TotalEarnings
FROM Dipendenti;

/*
Scrivere una funzione che calcoli un bonus sullo stipendio legato alla mansione e agli anni lavorati:
Se la mansione è Programmatore e lavora da 5 a 10 anni, + 500, se lavora da 10 a 20 + 800, più di 20 + 10000
Se la mansione è Docente e lavora da 5 a 15 anni, + 550, se lavora da più di 15 + 1100
Se la mansione è CEO, aggiungere 100 per ogni anno lavorato
*/

DELIMITER $$

CREATE FUNCTION calculateBonus(mansione VARCHAR(100), anniLavorati INT) 
RETURNS DOUBLE
DETERMINISTIC
BEGIN
    DECLARE bonus DOUBLE;

    -- Calcola il bonus in base alla mansione e agli anni lavorati
    CASE 
        WHEN mansione = 'Programmatore' AND anniLavorati BETWEEN 5 AND 10 THEN
            SET bonus = 500;
        WHEN mansione = 'Programmatore' AND anniLavorati > 10 AND anniLavorati <= 20 THEN
            SET bonus = 800;
        WHEN mansione = 'Programmatore' AND anniLavorati > 20 THEN
            SET bonus = 10000;
        WHEN mansione = 'Docente' AND anniLavorati BETWEEN 5 AND 15 THEN
            SET bonus = 550;
        WHEN mansione = 'Docente' AND anniLavorati > 15 THEN
            SET bonus = 1100;
        WHEN mansione = 'CEO' THEN
            SET bonus = anniLavorati * 100;
        ELSE
            SET bonus = 0;  -- No bonus for other cases
    END CASE;

    RETURN bonus;
END $$

DELIMITER ;


-- Applicare poi la funzione alla tabella dipendenti
SELECT 
    nominativo, 
    calculateBonus(mansione, (TRUNCATE(DATEDIFF(NOW(), dataNascita)/365.25,0) - 18)) AS Bonus
FROM Dipendenti;

-- Scrivere un trigger che blocchi l'eliminazione dei dipendenti non in età da pensione
DELIMITER $$

CREATE TRIGGER preventDeletion
BEFORE DELETE ON Dipendenti
FOR EACH ROW
BEGIN
    DECLARE eta INT;

    -- Calcola l'età in anni
    SET eta = TRUNCATE(DATEDIFF(NOW(), OLD.dataNascita)/365.25, 0);

    -- Verifica se l'età non è sufficiente per la pensione (supponiamo 60 anni)
    IF eta < 60 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Impossibile eliminare dipendente. Non ancora in età di pensione.';
    END IF;
END $$

DELIMITER ;
