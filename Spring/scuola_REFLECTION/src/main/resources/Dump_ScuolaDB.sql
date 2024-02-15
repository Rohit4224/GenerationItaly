-- create database scuola;
use scuola;

create table persone(
	id int primary key auto_increment,
    nome varchar(50),
    cognome varchar(50),
    data_nascita date,
    username varchar(50),
    password varchar(50)
);

create table classi(
	id int primary key auto_increment,
    sezione varchar(10)
);

create table docenti(
	id int,
    foreign key(id) references persone(id) on update cascade on delete cascade
);

create table classi_docenti(
	id_docente int,
    id_classe int,
    foreign key(id_docente) references docenti(id) on update cascade on delete cascade,
    foreign key(id_classe) references classi(id) on update cascade on delete cascade
);


create table studenti(
	id int,
    id_classe int,
    foreign key(id) references persone(id) on update cascade on delete cascade,
    foreign key(id_classe) references classi(id) on update cascade on delete cascade
);

create table materie(
	id int primary key auto_increment,
	nome varchar(20)
);

create table materie_studenti(
	id int primary key auto_increment,
	id_materia int,
    id_studente int,
    voto int,
    foreign key(id_materia) references materie(id) on update cascade on delete cascade,
    foreign key(id_studente) references persone(id) on update cascade on delete cascade
);



create table dirigenti(
	id int,
    foreign key(id) references persone(id) on update cascade on delete cascade
);

insert into classi(sezione) values("1A");
insert into classi(sezione) values("2A");

-- Docenti
insert into persone (nome, cognome, data_nascita) values ('Luigi', 'Russo', '1994-05-17');
insert into persone (nome, cognome, data_nascita) values ('Matteo', 'Colombo', '1973-10-30');
insert into persone (nome, cognome, data_nascita) values ('Francesca', 'Mancini', '1979-02-06');
insert into persone (nome, cognome, data_nascita) values ('Matteo', 'Colombo', '1970-11-27');
insert into persone (nome, cognome, data_nascita) values ('Giovanni', 'Ricci', '1989-06-24');
insert into persone (nome, cognome, data_nascita) values ('Giulia', 'Marino', '1984-09-23');
insert into persone (nome, cognome, data_nascita) values ('Giovanni', 'Esposito', '1989-07-26');
insert into persone (nome, cognome, data_nascita) values ('Matteo', 'Rossi', '1992-01-15');
insert into persone (nome, cognome, data_nascita) values ('Matteo', 'Costa', '1984-12-11');
insert into persone (nome, cognome, data_nascita) values ('Sofia', 'Greco', '1994-01-22');
insert into persone (nome, cognome, data_nascita) values ('Mario', 'Conti', '1977-04-17');
insert into persone (nome, cognome, data_nascita) values ('Matteo', 'Colombo', '1982-05-28');
insert into persone (nome, cognome, data_nascita) values ('Alessandro', 'Esposito', '1999-02-16');
insert into persone (nome, cognome, data_nascita) values ('Chiara', 'Mancini', '1976-09-13');
insert into persone (nome, cognome, data_nascita) values ('Alessandro', 'Giordano', '1980-07-21');
insert into docenti (id) values (1);
insert into docenti (id) values (2);
insert into docenti (id) values (3);
insert into docenti (id) values (4);
insert into docenti (id) values (5);
insert into docenti (id) values (6);
insert into docenti (id) values (7);
insert into docenti (id) values (8);
insert into docenti (id) values (9);
insert into docenti (id) values (10);
insert into docenti (id) values (11);
insert into docenti (id) values (12);
insert into docenti (id) values (13);
insert into docenti (id) values (14);
insert into docenti (id) values (15);


-- Classi_Docenti
insert into classi_docenti (id_docente, id_classe) values (1, 1);
insert into classi_docenti (id_docente, id_classe) values (2, 1);
insert into classi_docenti (id_docente, id_classe) values (3, 1);
insert into classi_docenti (id_docente, id_classe) values (4, 1);
insert into classi_docenti (id_docente, id_classe) values (5, 1);
insert into classi_docenti (id_docente, id_classe) values (6, 1);
insert into classi_docenti (id_docente, id_classe) values (7, 1);
insert into classi_docenti (id_docente, id_classe) values (8, 2);
insert into classi_docenti (id_docente, id_classe) values (9, 2);
insert into classi_docenti (id_docente, id_classe) values (10, 2);
insert into classi_docenti (id_docente, id_classe) values (11, 2);
insert into classi_docenti (id_docente, id_classe) values (12, 2);
insert into classi_docenti (id_docente, id_classe) values (13, 2);
insert into classi_docenti (id_docente, id_classe) values (14, 2);
insert into classi_docenti (id_docente, id_classe) values (15, 2);
insert into classi_docenti (id_docente, id_classe) values (15, 1);

-- Studenti
insert into persone (nome, cognome, data_nascita) values ('Alice', 'De Luca', '2009-04-26');
insert into persone (nome, cognome, data_nascita) values ('Davide', 'Caruso', '2007-10-20');
insert into persone (nome, cognome, data_nascita) values ('Nicola', 'Conti', '2007-01-30');
insert into persone (nome, cognome, data_nascita) values ('Riccardo', 'Barbieri', '2008-03-04');
insert into persone (nome, cognome, data_nascita) values ('Giovanni', 'De Luca', '2007-02-16');
insert into persone (nome, cognome, data_nascita) values ('Alessandro', 'Santoro', '2007-11-08');
insert into persone (nome, cognome, data_nascita) values ('Alessandro', 'Moretti', '2008-07-17');
insert into persone (nome, cognome, data_nascita) values ('Lorenzo', 'Fontana', '2007-05-24');
insert into persone (nome, cognome, data_nascita) values ('Giovanni', 'Moretti', '2009-08-07');
insert into persone (nome, cognome, data_nascita) values ('Alice', 'Fontana', '2006-06-02');
insert into persone (nome, cognome, data_nascita) values ('Martina', 'Colombo', '2008-09-15');
insert into persone (nome, cognome, data_nascita) values ('Camilla', 'Giordano', '2009-08-21');
insert into persone (nome, cognome, data_nascita) values ('Martina', 'Esposito', '2007-01-16');
insert into persone (nome, cognome, data_nascita) values ('Valentina', 'Bruno', '2007-12-18');
insert into persone (nome, cognome, data_nascita) values ('Marco', 'Mariani', '2007-01-06');
insert into persone (nome, cognome, data_nascita) values ('Mario', 'Ricci', '2007-02-14');
insert into persone (nome, cognome, data_nascita) values ('Elisa', 'Lombardi', '2007-03-29');
insert into persone (nome, cognome, data_nascita) values ('Davide', 'Conti', '2006-05-04');
insert into persone (nome, cognome, data_nascita) values ('Marco', 'Fontana', '2007-06-19');
insert into persone (nome, cognome, data_nascita) values ('Federico', 'Santoro', '2009-08-25');
insert into persone (nome, cognome, data_nascita) values ('Leonardo', 'Greco', '2006-08-01');
insert into persone (nome, cognome, data_nascita) values ('Francesca', 'Mancini', '2006-05-30');
insert into persone (nome, cognome, data_nascita) values ('Giulia', 'Lombardi', '2009-06-05');
insert into persone (nome, cognome, data_nascita) values ('Gabriele', 'Lombardi', '2006-02-17');
insert into persone (nome, cognome, data_nascita) values ('Camilla', 'De Luca', '2005-11-17');
insert into persone (nome, cognome, data_nascita) values ('Anna', 'Russo', '2006-11-22');
insert into persone (nome, cognome, data_nascita) values ('Luigi', 'Ricci', '2006-02-20');
insert into persone (nome, cognome, data_nascita) values ('Gabriele', 'Rizzo', '2008-01-07');
insert into persone (nome, cognome, data_nascita) values ('Riccardo', 'Santoro', '2007-03-18');
insert into persone (nome, cognome, data_nascita) values ('Alice', 'Marino', '2008-06-06');
insert into persone (nome, cognome, data_nascita) values ('Sofia', 'Colombo', '2005-09-30');
insert into persone (nome, cognome, data_nascita) values ('Chiara', 'Ferrari', '2009-09-10');
insert into persone (nome, cognome, data_nascita) values ('Mario', 'Bianchi', '2008-08-23');
insert into persone (nome, cognome, data_nascita) values ('Giovanni', 'Rizzo', '2005-11-23');
insert into persone (nome, cognome, data_nascita) values ('Mario', 'Ricci', '2008-07-05');
insert into persone (nome, cognome, data_nascita) values ('Luigi', 'Rossi', '2008-03-17');
insert into persone (nome, cognome, data_nascita) values ('Giulia', 'Ricci', '2009-05-12');
insert into persone (nome, cognome, data_nascita) values ('Chiara', 'Bruno', '2007-09-11');
insert into persone (nome, cognome, data_nascita) values ('Anna', 'Ricci', '2006-09-12');
insert into persone (nome, cognome, data_nascita) values ('Luigi', 'Costa', '2007-08-09');

insert into studenti (id, id_classe) values (16, 1);
insert into studenti (id, id_classe) values (17, 1);
insert into studenti (id, id_classe) values (18, 1);
insert into studenti (id, id_classe) values (19, 1);
insert into studenti (id, id_classe) values (20, 1);
insert into studenti (id, id_classe) values (21, 1);
insert into studenti (id, id_classe) values (22, 1);
insert into studenti (id, id_classe) values (23, 1);
insert into studenti (id, id_classe) values (24, 1);
insert into studenti (id, id_classe) values (25, 1);
insert into studenti (id, id_classe) values (26, 1);
insert into studenti (id, id_classe) values (27, 1);
insert into studenti (id, id_classe) values (28, 1);
insert into studenti (id, id_classe) values (29, 1);
insert into studenti (id, id_classe) values (30, 1);
insert into studenti (id, id_classe) values (31, 1);
insert into studenti (id, id_classe) values (32, 1);
insert into studenti (id, id_classe) values (33, 1);
insert into studenti (id, id_classe) values (34, 1);
insert into studenti (id, id_classe) values (35, 1);

insert into studenti (id, id_classe) values (36, 2);
insert into studenti (id, id_classe) values (37, 2);
insert into studenti (id, id_classe) values (38, 2);
insert into studenti (id, id_classe) values (39, 2);
insert into studenti (id, id_classe) values (40, 2);
insert into studenti (id, id_classe) values (41, 2);
insert into studenti (id, id_classe) values (42, 2);
insert into studenti (id, id_classe) values (43, 2);
insert into studenti (id, id_classe) values (44, 2);
insert into studenti (id, id_classe) values (45, 2);
insert into studenti (id, id_classe) values (46, 2);
insert into studenti (id, id_classe) values (47, 2);
insert into studenti (id, id_classe) values (48, 2);
insert into studenti (id, id_classe) values (49, 2);
insert into studenti (id, id_classe) values (50, 2);
insert into studenti (id, id_classe) values (51, 2);
insert into studenti (id, id_classe) values (52, 2);
insert into studenti (id, id_classe) values (53, 2);
insert into studenti (id, id_classe) values (54, 2);
insert into studenti (id, id_classe) values (55, 2);


-- Dirigenti
insert into persone (nome, cognome, data_nascita) values ('Francesca', 'Verdelli', '1960-09-13');
insert into dirigenti(id) values(56);




-- UTENZE
update persone set username='admin', password='admin' where id=56;



-- Materie
insert into materie(nome) values('Letteratura');
insert into materie(nome) values('Storia');
insert into materie(nome) values('Filosofia');
insert into materie(nome) values('Matematica');
insert into materie(nome) values('Chimica');
insert into materie(nome) values('Fisica');
insert into materie(nome) values('Informatica');

-- Materie studenti
insert into materie_studenti (id_studente, id_materia, voto) values (16, 1, 2);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 1, 10);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 2, 6);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 2, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 3, 10);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 3, 3);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 4, 4);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 4, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 5, 6);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 5, 6);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 6, 1);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 6, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 7, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (16, 7, 3);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 1, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 1, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 2, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 2, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 3, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 3, 4);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 4, 7);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 4, 6);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 5, 10);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 5, 1);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 6, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 6, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 7, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (17, 7, 2);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 1, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 1, 4);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 2, 7);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 2, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 3, 2);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 3, 7);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 4, 6);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 4, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 5, 2);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 5, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 6, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 6, 4);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 7, 3);
insert into materie_studenti (id_studente, id_materia, voto) values (18, 7, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 1, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 1, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 2, 6);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 2, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 3, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 3, 7);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 4, 10);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 4, 7);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 5, 1);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 5, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 6, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 6, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 7, 7);
insert into materie_studenti (id_studente, id_materia, voto) values (19, 7, 1);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 1, 10);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 1, 1);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 2, 2);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 2, 4);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 3, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 3, 7);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 4, 3);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 4, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 5, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 5, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 6, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 6, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 7, 1);
insert into materie_studenti (id_studente, id_materia, voto) values (20, 7, 4);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 1, 2);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 1, 6);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 2, 1);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 2, 3);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 3, 3);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 3, 3);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 4, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 4, 4);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 5, 6);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 5, 3);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 6, 3);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 6, 6);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 7, 4);
insert into materie_studenti (id_studente, id_materia, voto) values (21, 7, 3);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 1, 10);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 1, 10);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 2, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 2, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 3, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 3, 1);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 4, 1);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 4, 8);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 5, 5);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 5, 6);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 6, 9);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 6, 3);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 7, 1);
insert into materie_studenti (id_studente, id_materia, voto) values (22, 7, 3);