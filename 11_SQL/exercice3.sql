CREATE DATABASE IF NOT EXISTS exercice3;

USE exercice3;


CREATE TABLE IF NOT EXISTS professeur(
    id_professeur INT NOT NULL AUTO_INCREMENT,
    prenom_professeur VARCHAR(50) NOT NULL,
    nom_professeur VARCHAR(50) NOT NULL,
    id_classe INT NOT NULL,
    n_departement INT NOT NULL,
    email_professeur VARCHAR(50) NOT NULL,
    telephone_professeur VARCHAR(10) NOT NULL,
    PRIMARY KEY (id_professeur)
);

CREATE TABLE IF NOT EXISTS etudiant(
id_etudiant INT NOT NULL AUTO_INCREMENT,
nom_etudiant VARCHAR(50) NOT NULL,
prenom_etudiant VARCHAR(50) NOT NULL,
telephone_etudiant VARCHAR(10) NOT NULL,
id_classe INT NOT NULL,
date_diplome DATE NOT NULL,
PRIMARY KEY (id_etudiant)
);


CREATE TABLE IF NOT EXISTS classe(
id_classe INT NOT NULL AUTO_INCREMENT,
id_professeur INT NOT NULL,
id_etudiant INT NOT NULL,
PRIMARY KEY (id_classe),
FOREIGN KEY (id_professeur) REFERENCES professeur(id_professeur),
FOREIGN KEY (id_etudiant) REFERENCES etudiant(id_etudiant)
);

ALTER TABLE professeur ADD CONSTRAINT UC_telephone_professeur UNIQUE (telephone_professeur);
ALTER TABLE etudiant ADD CONSTRAINT  UC_telephone_etudiant UNIQUE (telephone_etudiant);

INSERT INTO professeur (prenom_professeur, nom_professeur, id_classe, n_departement, email_professeur, telephone_professeur)
VALUES ( 'Jean', 'Dupont', 1, 11, 'dupont@test.fr', '0123456789'), ('Paul', 'Martin', 2, 12, 'martin@test.fr', '0123456789');

INSERT INTO etudiant (nom_etudiant, prenom_etudiant, telephone_etudiant, id_classe, date_diplome)
VALUES ('John', 'John', '0212354589', 1, '2019-01-01'), ('Martins', 'Paulo', '0123456789', 2, '2019-01-01');

INSERT INTO classe (id_professeur, id_etudiant)
VALUES (1, 1), (2, 2), (3, 3), (4, 4);
