
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