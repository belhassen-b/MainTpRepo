CREATE DATABASE IF NOT EXISTS exercice_vue DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE exercice_vue;

CREATE TABLE eleve
(
    id_eleve INT         NOT NULL AUTO_INCREMENT,
    nom      VARCHAR(50) NOT NULL,
    prenom   VARCHAR(50) NOT NULL,
    age      INT         NOT NULL,
    PRIMARY KEY (id_eleve),
    CONSTRAINT age_eleve CHECK (age >= 17 AND age <= 23)
);

CREATE TABLE matiere
(
    code_matiere INT         NOT NULL,
    nom_matiere  VARCHAR(50) NOT NULL,
    coef_matiere INT         NOT NULL,
    PRIMARY KEY (code_matiere)
);


CREATE TABLE controle
(
    id_eleve      INT  NOT NULL,
    code_matiere  INT  NOT NULL,
    date_controle DATE NOT NULL,
    note          INT  NOT NULL,
    PRIMARY KEY (id_eleve, code_matiere, date_controle),
    FOREIGN KEY (id_eleve) REFERENCES eleve (id_eleve),
    FOREIGN KEY (code_matiere) REFERENCES matiere (code_matiere),
    CONSTRAINT note CHECK (note >= 0 AND note <= 20)
);


INSERT INTO eleve (id_eleve, nom, prenom, age)
VALUES (1, 'DUPONT', 'Jean', 20),
       (2, 'DURAND', 'Pierre', 21),
       (3, 'DUMONT', 'Pierrot', 17),
       (4, 'FERNAND', 'Toto', 19),
       (5, 'CHEVALIER', 'Maurice', 18);

INSERT INTO matiere (code_matiere, nom_matiere, coef_matiere)
VALUES (1, 'Mathématiques', 15),
       (2, 'Physique', 15),
       (3, 'Chimie', 12),
       (4, 'Informatique', 4),
       (5, 'Anglais', 2);

INSERT INTO controle (id_eleve, code_matiere, date_controle, note)
VALUES (1, 4, '2023-04-08', 14),
       (1, 5, '2023-04-09', 12),
       (2, 1, '2023-04-10', 10),
       (2, 1, '2023-04-08', 12),
       (2, 2, '2023-04-11', 11),
       (2, 3, '2023-04-12', 12),
       (3, 1, '2023-04-13', 13),
       (3, 1, '2023-02-22', 18),
       (3, 2, '2023-04-14', 14),
       (3, 3, '2023-04-15', 15),
       (4, 1, '2023-04-16', 16),
       (4, 2, '2023-04-17', 17),
       (4, 3, '2023-04-18', 18),
       (5, 1, '2023-04-19', 19),
       (5, 2, '2023-04-20', 20),
       (5, 3, '2023-04-21', 20);


SELECT id_eleve, COUNT(*) AS nb_controle
FROM controle
WHERE code_matiere = 1
GROUP BY id_eleve;

CREATE VIEW V_Moyenne_Matière AS
SELECT eleve.id_eleve, nom, prenom AS eleve,nom_matiere AS matiere,
       SUM(note)/COUNT(*) AS moyenne_matiere
FROM controle
INNER JOIN eleve ON controle.id_eleve = eleve.id_eleve
INNER JOIN matiere ON controle.code_matiere = matiere.code_matiere
GROUP BY id_eleve, matiere.code_matiere;


CREATE VIEW V_Moyenne_Générale AS
SELECT eleve.id_eleve, eleve.nom, prenom AS eleve,
(moyenne_matiere * SUM(coef_matiere)) /  SUM(coef_matiere)  AS moyenne_generale
       FROM controle
INNER JOIN eleve ON controle.id_eleve = eleve.id_eleve
INNER JOIN matiere ON controle.code_matiere = matiere.code_matiere
INNER JOIN V_Moyenne_Matière ON controle.id_eleve = V_Moyenne_Matière.id_eleve
GROUP BY id_eleve;