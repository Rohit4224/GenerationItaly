
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
