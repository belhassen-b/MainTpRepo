CREATE DATABASE IF NOT EXISTS exercices
    DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE exercices;

CREATE TABLE personne
(
    personne_id INT         NOT NULL AUTO_INCREMENT,
    titre       VARCHAR(3)  NOT NULL,
    prenom      VARCHAR(50) NOT NULL,
    nom         VARCHAR(50) NOT NULL,
    telephone   VARCHAR(10) NOT NULL,
    email       VARCHAR(50) NOT NULL,

    PRIMARY KEY (personne_id)
);

CREATE TABLE adresse
(
    adresse_id  INT         NOT NULL AUTO_INCREMENT,
    rue         VARCHAR(50) NOT NULL,
    ville       VARCHAR(50) NOT NULL,
    code_postal VARCHAR(5)  NOT NULL,
    PRIMARY KEY (adresse_id),
    CONSTRAINT fk_adresse_personne
        FOREIGN KEY (adresse_id)
            REFERENCES personne (personne_id)
);
