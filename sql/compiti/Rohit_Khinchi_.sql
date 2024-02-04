
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
