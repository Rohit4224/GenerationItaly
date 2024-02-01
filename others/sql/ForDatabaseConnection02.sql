CREATE DATABASE fattoria;
USE fattoria;

CREATE TABLE animali
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    specie VARCHAR(100),
    nome VARCHAR (50),
    dob DATE,
    genere CHAR,
    peso DOUBLE,
    vaccinato BOOL,
    idAllevatore INT,
    FOREIGN KEY (idAllevatore) REFERENCES allevatori(id)
    ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE allevatori
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    cognome VARCHAR(150),
    dob DATE,
    esperienza INT
);

SELECT * FROM allevatori;
SELECT * FROM animali;

INSERT INTO `fattoria`.`allevatori` (`nome`, `cognome`, `dob`, `esperienza`) VALUES ('Pino', 'Pane', '1967-09-30', '35');
INSERT INTO `fattoria`.`allevatori` (`nome`, `cognome`, `dob`, `esperienza`) VALUES ('Mara', 'Maria', '1990-05-03', '10');
INSERT INTO `fattoria`.`allevatori` (`nome`, `cognome`, `dob`, `esperienza`) VALUES ('Luca', 'Raimondi', '1980-04-02', '3');


INSERT INTO `fattoria`.`animali` (`specie`, `nome`, `dob`, `genere`, `peso`, `vaccinato`, `idAllevatore`) VALUES ('Mucca', 'Guendalina', '2020-09-04', 'F', '250.50', '1', '1');
INSERT INTO `fattoria`.`animali` (`specie`, `nome`, `dob`, `genere`, `peso`, `vaccinato`, `idAllevatore`) VALUES ('Mucca', 'Adelina', '2020-04-09', 'F', '248.9', '1', '1');
INSERT INTO `fattoria`.`animali` (`specie`, `nome`, `dob`, `genere`, `peso`, `vaccinato`, `idAllevatore`) VALUES ('Oca', 'Bianco', '2022-04-25', 'M', '15.5', '0', '1');
INSERT INTO `fattoria`.`animali` (`specie`, `nome`, `dob`, `genere`, `peso`, `vaccinato`, `idAllevatore`) VALUES ('Gallina', 'Coco', '2024-01-04', 'F', '2.5', '0', '3');


SELECT animali.*
FROM allevatori INNER JOIN animali ON animali.idAllevatore = allevatori.id
WHERE allevatori.id = 1;


