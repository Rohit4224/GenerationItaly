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

