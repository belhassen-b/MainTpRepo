CREATE DATABASE IF NOT EXISTS exercice2;

USE exercice2;

CREATE TABLE IF NOT EXISTS compte(
compte_id INT(11) NOT NULL AUTO_INCREMENT,
pseudo VARCHAR(50) NOT NULL,
mot_de_passe VARCHAR(50) NOT NULL,
email VARCHAR(255) NOT NULL,
date_creation DATETIME NOT NULL,
derniere_connexion VARCHAR(50) NOT NULL,
PRIMARY KEY (compte_id)
);

CREATE TABLE IF NOT EXISTS role(
role_id INT(11) NOT NULL AUTO_INCREMENT,
libelle VARCHAR(50) NOT NULL,
PRIMARY KEY (role_id)
);

CREATE TABLE IF NOT EXISTS compte_role(
compte_id INT(11) NOT NULL,
role_id INT(11) NOT NULL,
date_ajout DATETIME NOT NULL,
PRIMARY KEY (compte_id, role_id),
FOREIGN KEY (compte_id) REFERENCES compte(compte_id),
FOREIGN KEY (role_id) REFERENCES role(role_id)
);

