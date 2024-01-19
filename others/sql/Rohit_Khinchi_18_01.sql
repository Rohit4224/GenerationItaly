-- ESERCIZIO
-- creare un database videogiochi
-- creare la tabella videogames con: id int pk, titolo varchar, console varchar, genere varchar
	-- , anno rilascio int, sviluppatore varchar, voto utenti int, voto critica int, pegi int
-- inserire 10 videogiochi
-- QUERY
-- voglio vedere l'intera tabella
-- voglio vedere titolo, console, anno rilascio
-- voglio vedere titolo e sviluppatore dei giochi playstaton 5
-- voglio vedere titolo, console dei giochi con voto critica > 82
-- voglio vedere titolo dei giochi usciti nel 2020 con voto utenti maggiore di 90
-- voglio vedere il voto medio della critica
-- voglio vedere il voto medio degli utenti
-- voglio vedere tutto dei giochi con pegi 18
-- voglio vedere la media dei voti di critica e utente per ogni console
-- voglio vededere titolo e anno rilascio per i giochi sviluppati da ubisoft
-- voglio vedere il voto più alto, più basso, e la media dei voti utenza 
	-- e critica per ogni studio se il voto medio della critica è superiore a 80
    

-- creare un database videogiochi
-- creare la tabella videogames con: id int pk, titolo varchar, console varchar, genere varchar
	-- , anno rilascio int, sviluppatore varchar, voto utenti int, voto critica int, pegi int
CREATE DATABASE Videogiochi;
USE Videogiochi;

CREATE TABLE Videogames
(
	id int PRIMARY KEY AUTO_INCREMENT,
    titolo VARCHAR(80),
    console VARCHAR(80),
    genere VARCHAR(60),
    anno_rilascio INT,
    sviluppatore VARCHAR(60),
    voto_utenti INT,
    voto_critica INT,
    pegi INT
);

-- inserire 10 videogiochi
INSERT INTO Videogames
(titolo, console, genere, anno_rilascio, sviluppatore, voto_utenti, voto_critica, pegi)
VALUES
("The Witcher 3: Wild Hunt", "PlayStation 4", "RPG", 2015, "CD Projekt", 92, 93, 18),
("Super Mario Odyssey", "Nintendo Switch", "Platform", 2017, "Nintendo", 90, 97, 7),
("Grand Theft Auto V", "Xbox One", "Action-Adventure", 2014, "Rockstar North", 88, 97, 18),
("The Legend of Zelda: Breath of the Wild", "Wii U", "Action-Adventure", 2017, "Nintendo", 92, 97, 12),
("Red Dead Redemption 2", "PlayStation 4", "Action-Adventure", 2018, "Rockstar Games", 89, 97, 18),
("Overwatch", "PC", "First-Person Shooter", 2016, "Blizzard Entertainment", 84, 91, 12),
("Fortnite", "PlayStation 5", "Battle Royale", 2017, "Epic Games", 79, 78, 12),
("Minecraft", "Xbox Series X", "Sandbox", 2011, "Mojang", 91, 93, 7),
("Cyberpunk 2077", "Xbox Series X", "Action RPG", 2020, "CD Projekt", 70, 71, 18),
("Fallout 4", "PlayStation 4", "Action RPG", 2015, "Bethesda Game Studios", 78, 88, 18),
("Assassin's Creed Odyssey", "Xbox One", "Action RPG", 2018, "Ubisoft", 83, 83, 18),
("FIFA 22", "PlayStation 5", "Sports", 2021, "EA Sports", 82, 82, 3),
("Call of Duty: Warzone", "PC", "Battle Royale", 2020, "Infinity Ward", 77, 80, 18),
("The Elder Scrolls V: Skyrim", "Nintendo Switch", "Action RPG", 2011, "Bethesda Game Studios", 88, 94, 18),
("Animal Crossing: New Horizons", "Nintendo Switch", "Life Simulation", 2020, "Nintendo", 90, 90, 3),
("Spider-Man: Miles Morales", "PlayStation 5", "Action-Adventure", 2020, "Insomniac Games", 88, 85, 16),
("Dark Souls III", "Xbox One", "Action RPG", 2016, "FromSoftware", 87, 89, 18),
("Tom Clancy's Rainbow Six Siege", "PlayStation 4", "Tactical Shooter", 2015, "Ubisoft", 79, 79, 18),
("Rocket League", "Xbox Series X", "Sports", 2015, "Psyonix", 86, 86, 3),
("Persona 5", "PlayStation 4", "JRPG", 2016, "Atlus", 94, 93, 16);

INSERT INTO Videogames
(titolo, console, genere, anno_rilascio, sviluppatore, voto_utenti, voto_critica, pegi)
VALUES
("The Witcher 15: Wildo Hunto", "PlayStation 4", "RPG", 2020, "CD Projekt", 92, 93, 18);

-- voglio vedere l'intera tabella
SELECT * FROM Videogames;

-- voglio vedere titolo, console, anno rilascio
SELECT titolo, console, anno_rilascio
FROM Videogames;

-- voglio vedere titolo e sviluppatore dei giochi playstaton 5
SELECT titolo, sviluppatore
FROM Videogames
WHERE console = "playstation 5";

-- voglio vedere titolo, console dei giochi con voto critica > 82
SELECT titolo, console
FROM Videogames
WHERE voto_critica > 82;

-- voglio vedere titolo dei giochi usciti nel 2020 con voto utenti maggiore di 90
SELECT titolo
FROM Videogames
WHERE anno_rilascio = 2020 && voto_utenti > 90;

-- voglio vedere il voto medio della critica
SELECT AVG(voto_critica)
FROM Videogames;

-- voglio vedere il voto medio degli utenti
SELECT AVG(voto_utenti)
FROM Videogames;

-- voglio vedere tutto dei giochi con pegi 18
SELECT *
FROM Videogames
WHERE pegi = 18;

-- voglio vedere la media dei voti di critica e utente per ogni console
SELECT console,
       AVG(voto_utenti) AS media_voto_utenti,
       AVG(voto_critica) AS media_voto_critica
FROM Videogames
GROUP BY console;

-- voglio vedere titolo e anno rilascio per i giochi sviluppati da ubisoft
SELECT titolo, anno_rilascio
FROM Videogames
WHERE sviluppatore = 'Ubisoft';

-- voglio vedere il voto più alto, più basso, e la media dei voti utenza 
	-- e critica per ogni studio se il voto medio della critica è superiore a 80
SELECT sviluppatore, MAX(voto_utenti), MIN(voto_utenti), MAX(voto_critica), MIN(voto_critica),
		AVG(voto_utenti), AVG(voto_critica)
FROM Videogames
GROUP BY sviluppatore
HAVING AVG(voto_critica) > 80;


-- BONUS
-- voglio vedere per ogni anno di rilascio il numero di videogiochi rilasciato 
		-- per ogni studio di sviluppo
SELECT anno_rilascio, sviluppatore, COUNT(id) AS numero_videogiochi
FROM Videogames
GROUP BY anno_rilascio, sviluppatore
ORDER BY anno_rilascio, sviluppatore;

-- voglio vedere il pegi più presente
SELECT pegi, COUNT(*) AS conteggio
FROM Videogames
GROUP BY pegi
ORDER BY conteggio DESC
LIMIT 1;

-- voglio vedere i titoli dei videogiochi con un voto della critica superiore al voto medio 
		-- della critica complessiva
SELECT titolo, voto_critica
FROM Videogames
WHERE voto_critica > (SELECT AVG(voto_critica) FROM Videogames);




