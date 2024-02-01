CREATE DATABASE anagrafe3;
USE anagrafe3;

CREATE TABLE Persone
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(150),
    cognome VARCHAR(150),
    dob DATE,
    residenza VARCHAR(200),
    genere CHAR,
    professione VARCHAR(250)
);
INSERT INTO `anagrafe3`.`Persone` (`nome`, `cognome`, `dob`, `residenza`, `genere`, `professione`) VALUES ('Pino', 'Pane', '1997-09-24', 'Milano', 'M', 'Docente');
INSERT INTO `anagrafe3`.`Persone` (`nome`, `cognome`, `dob`, `residenza`, `genere`, `professione`) VALUES ('Luca', 'Bianchi', '1994-02-21', 'Milano', 'M', 'Imbianchino');
INSERT INTO `anagrafe3`.`Persone` (`nome`, `cognome`, `dob`, `residenza`, `genere`, `professione`) VALUES ('Laura', 'Bianchi', '1995-07-15', 'Brescia', 'F', 'Docente');
INSERT INTO `anagrafe3`.`Persone` (`nome`, `cognome`, `dob`, `residenza`, `genere`, `professione`) VALUES ('Mara', 'Marini', '1968-09-03', 'Bergamo', 'F', 'Centralinista');
INSERT INTO `anagrafe3`.`Persone` (`nome`, `cognome`, `dob`, `residenza`, `genere`, `professione`) VALUES ('Giulia', 'Neri', '1968-09-03', 'Milano', 'F', 'Medico');

select  * from Persone;